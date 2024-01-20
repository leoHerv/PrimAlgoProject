package graph;

import java.util.Iterator;

/** Graph implementation using adjacency matrix */
public class GraphUsingAdjacencyMatrix extends Graph
{
    /** Matrix for all the weight. */
    protected int[] pro_adjacencyMatrix;

    /** Instantiate a AdjacencyMatrix with x vertices.
     * @param vertices The numbers of vertices of the graph.
     */
    public GraphUsingAdjacencyMatrix(int vertices)
    {
        super(vertices);
        pro_adjacencyMatrix = new int[pro_vertices * pro_vertices];
        for(int i = 0; i < pro_vertices * pro_vertices; i++)
        {
            pro_adjacencyMatrix[i] = INF;
        }
    }

    /** Add an edge to the matrix.
     * @param source The vertex where the edge start.
     * @param destination The vertex where the edge ends.
     * @param weight The weight of the edge.
     */
    @Override
    public void addEdge(int source, int destination, int weight)
    {
        pro_adjacencyMatrix[(source - 1) * pro_vertices + (destination - 1)] = weight;
        pro_adjacencyMatrix[(destination - 1) * pro_vertices + (source - 1)] = weight;
    }

    /** Give the weight between two vertex.
     * @param source The first vertex.
     * @param destination The second vertex.
     * @return The weight of the edge.
     */
    @Override
    public int getWeight(int source, int destination)
    {
        return pro_adjacencyMatrix[(source - 1) * pro_vertices + (destination - 1)];
    }

    /** Give an iterator to iterate through all the neighbors of a vertex in the matrix.
     * @param vertex The vertex that we need the neighbors.
     * @return All the neighbors of the vertex.
     */
    @Override
    public Iterator<Integer> getNeighbors(int vertex)
    {
        return new MatrixIterator(vertex);
    }

    //========================//
    //===   Intern Class   ===//
    //========================//

    /** Iterator to iterate through all neighbors the vertices of a vertex. */
    private class MatrixIterator implements Iterator<Integer>
    {
        /** We look at the neighbors of this vertex. */
        private final int pri_vertex;
        /** The current neighbor. */
        private int pri_currentNeighbor;

        /** Instantiation of an iterator for a vertex.
         * @param vertex The vertex that we need the neighbors.
         */
        public MatrixIterator(int vertex)
        {
            this.pri_vertex = vertex;
            this.pri_currentNeighbor = 1;
            while (pri_currentNeighbor < pro_vertices && pro_adjacencyMatrix[(pri_vertex - 1) * pro_vertices + (pri_currentNeighbor - 1)] == INF) {
                pri_currentNeighbor++;
            }
        }

        /** Tell if we have another neighbor.
         * @return If we have another neighbor.
         */
        @Override
        public boolean hasNext()
        {
            return pri_currentNeighbor < pro_vertices;
        }

        /** Give the next neighbor.
         * @return The neighbor number.
         */
        @Override
        public Integer next()
        {
            if(hasNext())
            {
                while (pri_currentNeighbor < pro_vertices && pro_adjacencyMatrix[(pri_vertex - 1) * pro_vertices + (pri_currentNeighbor - 1)] == INF) {
                    pri_currentNeighbor++;
                }
                return pri_currentNeighbor++;
            }
            return null;
        }
    }
}
