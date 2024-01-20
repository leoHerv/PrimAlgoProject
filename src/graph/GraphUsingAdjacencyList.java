package graph;

import list.List;

import java.util.Iterator;

/** Graph implementation using adjacency list */
public class GraphUsingAdjacencyList extends Graph
{
    /** Array of vertices with all the neighbors lists. */
    protected List<Edge>[] pro_adjacencyList;

    /** Instantiate a AdjacencyList with x vertices.
     * @param vertices The numbers of vertices of the graph.
     */
    public GraphUsingAdjacencyList(int vertices)
    {
        super(vertices);
        pro_adjacencyList = new List[vertices];
        // Init all edge list of all the vertices.
        for(int i = 0; i < pro_vertices; i++)
        {
            pro_adjacencyList[i] = new List<Edge>();
        }
    }

    /** Add an edge to the list.
     * @param source The vertex where the edge start.
     * @param destination The vertex where the edge ends.
     * @param weight The weight of the edge.
     */
    @Override
    public void addEdge(int source, int destination, int weight)
    {
        pro_adjacencyList[source - 1].add(new Edge(destination, weight));
        pro_adjacencyList[destination - 1].add(new Edge(source, weight));
    }

    /** Give the weight between two vertex.
     * @param source The first vertex.
     * @param destination The second vertex.
     * @return The weight of the edge.
     */
    @Override
    public int getWeight(int source, int destination)
    {
        for(Edge edge : pro_adjacencyList[source - 1])
        {
            if(edge.getDestination() == destination)
            {
                return edge.getWeight();
            }
        }
        return INF;
    }

    /** Give an iterator to iterate through all the neighbors of a vertex in the list.
     * @param vertex The vertex that we need the neighbors.
     * @return All the neighbors of the vertex.
     */
    @Override
    public Iterator<Integer> getNeighbors(int vertex)
    {
        return new AdListIterator(vertex);
    }

    //========================//
    //===   Intern Class   ===//
    //========================//

    /** Represent the edge between two vertices. */
    private class Edge
    {
        /** The destination of the edge. */
        private final int pri_destination;

        /** The weight of the edge. */
        private final int pri_weight;

        /** Instantiate an edge.
         * @param destination The end of the edge.
         * @param weight The weight of the edge.
         */
        public Edge(int destination, int weight)
        {
            pri_destination = destination;
            pri_weight = weight;
        }

        /** Give the destination of the edge.
         * @return The end of the edge.
         */
        public int getDestination()
        {
            return pri_destination;
        }

        /** Give the weight of the edge.
         * @return The weight.
         */
        public int getWeight()
        {
            return pri_weight;
        }
    }

    /** Iterator to iterate through all neighbors the vertices of a vertex.*/
    private class AdListIterator implements Iterator<Integer>
    {
        /** The current neighbor.*/
        private final Iterator<Edge> pri_edgeIterator;

        /** Instantiate an iterator for the adjacency list.
         * @param vertex The vertex that we need the neighbors.
         */
        public AdListIterator(int vertex)
        {
            this.pri_edgeIterator = pro_adjacencyList[vertex - 1].iterator();
        }

        /** Tell if we have another neighbor.
         * @return If we have another neighbor.
         */
        @Override
        public boolean hasNext()
        {
            return pri_edgeIterator.hasNext();
        }

        /** Give the next neighbor.
         * @return The neighbor number.
         */
        @Override
        public Integer next()
        {
            if(hasNext())
            {
                Edge edge = pri_edgeIterator.next();
                return edge.getDestination();
            }
            return null;
        }


    }
}
