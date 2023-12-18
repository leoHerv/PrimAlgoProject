package graph;

import java.util.Iterator;

/** Abstract class that is used to implement various graph. */
public abstract class Graph
{
    /** Number of the vertices in the graph. */
    protected final int pro_vertices;

    /** The representation of infinity in our graphs. */
    static final int INF = Integer.MAX_VALUE;

    public Graph(int vertices)
    {
        pro_vertices = vertices;
    }

    /** Add an edge to the graph. */
    public abstract void addEdge(int source, int destination, int weight);

    /** Give the weight between two vertex. */
    public abstract int getWeight(int source, int destination);

    /** Give an iterator to iterate through all the neighbors of a vertex. */
    public abstract Iterator<Integer> getNeighbors(int vertex);

    /** Give the number of vertices. */
    public int getVertices()
    {
        return pro_vertices;
    }

}
