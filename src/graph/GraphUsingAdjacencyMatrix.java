package graph;

import java.util.Iterator;

public class GraphUsingAdjacencyMatrix extends Graph
{
    protected int[] pro_adjacencyMatrix;

    public GraphUsingAdjacencyMatrix(int vertices)
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
        pro_adjacencyMatrix[(source - 1) * pro_vertices + (destination - 1)] = weight;
        pro_adjacencyMatrix[(destination - 1) * pro_vertices + (source - 1)] = weight;
    }

    @Override
    public int getWeight(int source, int destination)
    {
        return pro_adjacencyMatrix[(source - 1) * pro_vertices + (destination - 1)];
    }

    @Override
    public Iterator<Integer> getNeighbors(int vertex)
    {
        return new MatrixIterator(vertex);
    }

    //========================//
    //===   Intern Class   ===//
    //========================//

    // Iterator to iterate through all neighbors the vertices of a vertex.
    private class MatrixIterator implements Iterator<Integer>
    {
        private final int pri_vertex;
        private int pri_currentNeighbor;

        public MatrixIterator(int vertex)
        {
            this.pri_vertex = vertex;
            this.pri_currentNeighbor = 1;
            while (pri_currentNeighbor < pro_vertices && pro_adjacencyMatrix[(pri_vertex - 1) * pro_vertices + (pri_currentNeighbor - 1)] == INF) {
                pri_currentNeighbor++;
            }
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
                while (pri_currentNeighbor < pro_vertices && pro_adjacencyMatrix[(pri_vertex - 1) * pro_vertices + (pri_currentNeighbor - 1)] == INF) {
                    pri_currentNeighbor++;
                }
                return pri_currentNeighbor++;
            }
            return null;
        }
    }
}
