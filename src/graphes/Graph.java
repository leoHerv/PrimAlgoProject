package graphes;

import java.util.Iterator;

public abstract class Graph
{
    // Number of the vertices in the graph.
    protected int p_vertices;

    public Graph(int vertices)
    {
        p_vertices = vertices;
    }

    // Add an edge to the graph.
    public abstract void addEdge();

    // Give the weight between two vertex.
    public abstract int getWeight(int source, int destination);

    // Give an iterator to iterate through all the neighbors of a vertex.
    public abstract Iterator<Integer> getNeighbors(int vertex);

    // Give the number of vertices.
    public int getVertices()
    {
        return p_vertices;
    }

}
