package PrimeAlgo;

import graph.Graph;
import java.util.*;

/**
 * The type Prim algo.
 */
class PrimAlgo {

    /**
     * The Inf.
     */
    static final int INF = Integer.MAX_VALUE;

    /**
     * Prim mst.
     *
     * @param graph       the graph
     * @param startVertex the start vertex
     */
    public static void primMST(Graph graph, int startVertex) {
        int vertices = graph.getVertices();
        int[] parent = new int[vertices];
        int[] key = new int[vertices];
        boolean[] mstSet = new boolean[vertices];

        Arrays.fill(key, INF);

        key[startVertex] = 0;
        parent[startVertex] = -1;

        for (int count = 0; count < vertices - 1; count++) {
            int u = minKey(key, mstSet);

            mstSet[u] = true;

            Iterator<Integer> iterator = graph.getNeighbors(u);
            while (iterator.hasNext()) {
                int v = iterator.next();
                int weight = graph.getWeight(u, v);

                if (!mstSet[v] && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                }
            }
        }

        printMST(graph, startVertex, parent, key);
    }

    /**
     * Min key int.
     *
     * @param key    the key
     * @param mstSet the mst set
     * @return the int
     */
    public static int minKey(int[] key, boolean[] mstSet) {
        int min = INF;
        int minIndex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    /**
     * Print mst.
     *
     * @param graph       the graph
     * @param startVertex the start vertex
     * @param parent      the parent
     * @param key         the key
     */
    public static void printMST(Graph graph, int startVertex, int[] parent, int[] key) {
        System.out.println("LE GRAPHE EST CONNEXE");
        int totalWeight = 0;

        for (int i = 0; i < graph.getVertices(); i++) {
            if (i != startVertex) {
                totalWeight += key[i];
            }
        }
        System.out.println("Coût de l'arbre recouvrant : " + totalWeight);

        for (int i = 0; i < graph.getVertices(); i++) {
            if (i != startVertex) {
                System.out.println("(" + (i + 1) + " -> " + (parent[i] + 1) + " : " + key[i] + ")");
            }
        }
    }
}
