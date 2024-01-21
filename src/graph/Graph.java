package graph;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

/** Abstract class that is used to implement various graph. */
public abstract class Graph
{
    /** Number of the vertices in the graph. */
    protected final int pro_vertices;

    /** The representation of infinity in our graphs. */
    public static final int INF = Integer.MAX_VALUE;

    public Graph(int vertices)
    {
        pro_vertices = vertices;
        this.initGraph();
    }

    public Graph(String fileNameGraph)
    {
        File file = new File(fileNameGraph);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        }
        catch(Exception e) {
            System.out.printf("Error new Graph : \"%s\" doesn\'t exist.\n", fileNameGraph);
            e.getStackTrace();
            System.exit(1);
        }
        // If we can open the file.
        pro_vertices = sc.nextInt();

        this.initGraph();

        for(int i = 0; i < pro_vertices; ++i){
            int vertexNb = sc.nextInt();
            int neighbor = sc.nextInt();
            int weight = 0;
            while(neighbor != 0){
                weight = sc.nextInt();
                this.addEdge(vertexNb, neighbor, weight);
                neighbor = sc.nextInt();
            }
        }
        sc.close();
    }

    /** Initialize the graph structure. */
    protected abstract void initGraph();

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
