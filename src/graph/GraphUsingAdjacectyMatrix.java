package graph;

import java.util.Iterator;

public class GraphUsingAdjacectyMatrix extends Graph
{
    protected int[] pro_adjacencyMatrix;

    public GraphUsingAdjacectyMatrix(int vertices)
    {
        super(vertices);
        pro_adjacencyMatrix = new int[pro_vertices * pro_vertices];
        for(int i = 0; i < pro_vertices * pro_vertices; i++)
        {
            pro_adjacencyMatrix[i] = INF;
        }
    }

    @Override
    public void addEdge(int source, int destination, int weight)
    {
        pro_adjacencyMatrix[source * pro_vertices + destination] = weight;
        pro_adjacencyMatrix[destination * pro_vertices + source] = weight;
    }

    @Override
    public int getWeight(int source, int destination)
    {
        return pro_adjacencyMatrix[source * pro_vertices + destination];
    }

    @Override
    public Iterator<Integer> getNeighbors(int vertex)
    {
        return new MatrixIterator(vertex);
    }

    // Iterator to iterate through all neighbors the vertices of a vertex.
    private class MatrixIterator implements Iterator<Integer>
    {
        private final int pri_vertex;
        private int pri_currentNeighbor;

        public MatrixIterator(int vertex)
        {
            this.pri_vertex = vertex;
            this.pri_currentNeighbor = 0;
        }

        @Override
        public boolean hasNext()
        {
            return pri_currentNeighbor < pro_vertices;
        }

        @Override
        public Integer next()
        {
            if(hasNext())
            {
                return pro_adjacencyMatrix[pri_vertex * pro_vertices + pri_currentNeighbor++];
            }
            return null;
        }
    }
}
