package PrimAlgo;

import graph.Graph;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Class to perform the Prim Algorithm.
 */
public class Prim {

    /** The representation of infinity. */
    public static final int INF = Graph.INF;

    /** The Graph that we apply the Prim algorithm. */
    private final Graph pri_graph;
    /** The vertex where we start the algorithm. */
    private int pri_startVertex;
    /** The number of vertices. */
    private int pri_nbVertices;
    /** The parents list for all the vertices. */
    private int[] pri_parents;
    /** The best weight list for all the vertices. */
    private int[] pri_bestWeight;
    /** The visited list for all the vertices. */
    private boolean[] pri_visitVertices;


    /** Instantiates a new Prim.
     *  @param graph The graph to perform.
     *  @param startVertex The vertex where we start the algorithm.
     */
    public Prim(Graph graph, int startVertex)
    {
        pri_graph = graph;
        pri_nbVertices = pri_graph.getVertices();
        pri_startVertex = startVertex;
        pri_parents = new int[pri_nbVertices];
        pri_bestWeight = new int[pri_nbVertices];
        pri_visitVertices = new boolean[pri_nbVertices];

        Arrays.fill(pri_parents, INF);
        Arrays.fill(pri_bestWeight, INF);
    }

    /** Perform the Prim algorithm. */
    public void performAlgo()
    {
        pri_bestWeight[pri_startVertex - 1] = 1;
        pri_parents[pri_startVertex - 1] = -1;

        for (int i = 0; i < pri_nbVertices - 1; i++) {
            int u = minKey();

            pri_visitVertices[u] = true;

            Iterator<Integer> iterator = pri_graph.getNeighbors(u + 1);
            while (iterator.hasNext()) {
                int v = iterator.next() - 1;

                int weight = pri_graph.getWeight(u + 1, v + 1);

                if (!pri_visitVertices[v] && weight < pri_bestWeight[v]) {
                    pri_parents[v] = u;
                    pri_bestWeight[v] = weight;
                }
            }
        }
    }

    /** Finds the vertex with the minimum weight in the vertices that we have not visited yet.
     *  @return The index of the vertex with the minimum weight.
     */
    private int minKey()
    {
        int min = INF;
        int minIndex = -1;

        for (int v = 0; v < pri_bestWeight.length; v++) {
            if (!pri_visitVertices[v] && pri_bestWeight[v] < min) {
                min = pri_bestWeight[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    /** Prints the constructed MST in a stream.
     *  @param ps The stream where we want the MST to be printed.
     */
    public void printMST(PrintStream ps)
    {
        boolean isConnexe = true;
        for(int i = 0; i < pri_nbVertices; i++){
            if(!pri_visitVertices[i]){
                isConnexe = false;
                break;
            }
        }
        if(isConnexe){
            ps.println("LE GRAPHE EST CONNEXE");
        }
        else{
            ps.println("LE GRAPHE N\'EST PAS CONNEXE");
        }

        int totalWeight = 0;
        for (int i = 0; i < pri_nbVertices; i++) {
            if (i != pri_startVertex - 1 && pri_parents[i] != INF) {
                totalWeight += pri_bestWeight[i];
            }
        }
        System.out.println("Coût de l'arbre recouvrant : " + totalWeight);

        for (int i = 0; i < pri_nbVertices; i++) {
            if(i == pri_startVertex - 1){
                ps.println("(" + (pri_startVertex) + " -> _ : _)");
            }
            else if (i != pri_startVertex - 1 && pri_parents[i] != INF) {
                ps.println("(" + (i + 1) + " -> " + (pri_parents[i] + 1) + " : " + pri_bestWeight[i] + ")");
            }
        }
    }

    /** Prints the constructed MST in the console. */
    public void printMST()
    {
        printMST(System.out);
    }
}
