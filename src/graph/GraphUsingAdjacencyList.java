package graph;

import list.List;

import java.util.Iterator;

/** Graph implementation using adjacency list */
public class GraphUsingAdjacencyList extends Graph
{
    /** Array of vertices with all the neighbors lists. */
    protected List<Edge>[] pro_adjacencyList;

    public GraphUsingAdjacencyList(int vertices)
    {
        super(vertices);
        pro_adjacencyList = new List[vertices];
        // Init all edge list of all the vertices.
        for(int i = 0; i < pro_vertices; i++)
        {
            pro_adjacencyList[i] = new List<>();
        }
    }

    @Override
    public void addEdge(int source, int destination, int weight)
    {
        pro_adjacencyList[source - 1].add(new Edge(destination, weight));
        pro_adjacencyList[destination - 1].add(new Edge(source, weight));
    }

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

    @Override
    public Iterator<Integer> getNeighbors(int vertex)
    {
        return null;//pro_adjacencyList[vertex - 1].iterator();
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

        public Edge(int destination, int weight)
        {
            pri_destination = destination;
            pri_weight = weight;
        }

        /** Give the destination of the edge. */
        public int getDestination()
        {
            return pri_destination;
        }

        /** Give the weight of the edge. */
        public int getWeight()
        {
            return pri_weight;
        }
    }
}
