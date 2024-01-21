package PrimAlgo;

import graph.Graph;

import java.util.*;

/**
 * Class to perform the Prim Algorithm.
 */
public class Prim {

    /**
     * The Graph to use.
     */
    Graph graphToUse;
    /**
     * The Inf.
     */
    private static final int INF = Integer.MAX_VALUE;

    /**
     * Instantiates a new Prim.
     *
     * @param graphToPerform the graph to perform
     */
    public Prim(Graph graphToPerform){
        // Initializes a new instance of the Prim class with the specified graph.
        this.graphToUse = graphToPerform;
    }

    /**
     * Prim Minimum Spanning Tree (MST).
     *
     * @param startVertex the start vertex
     */
    public void primMST(int startVertex) {
        // Implements the Prim's algorithm to find the minimum spanning tree of the graph.
        // The algorithm starts from the specified start vertex.

        int vertices = graphToUse.getVertices();
        int[] parent = new int[vertices];
        int[] key = new int[vertices];
        boolean[] mstSet = new boolean[vertices];

        Arrays.fill(key, INF);
        Arrays.fill(parent, INF);

        key[startVertex - 1] = 1;
        parent[startVertex] = -1;

        for (int count = 0; count < vertices - 1; count++) {
            int u = minKey(key, mstSet);

            if (u == -1) {
                break;
            }

            mstSet[u] = true;

            Iterator<Integer> iterator = graphToUse.getNeighbors(u + 1);
            while (iterator.hasNext()) {
                int v = iterator.next() - 1;
                if (v > vertices) {
                    continue;
                }
                int weight = graphToUse.getWeight(u + 1, v + 1);

                if (!mstSet[v] && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                }
            }
        }

        printMST(startVertex, parent, key);
    }

    /**
     * Finds the vertex with the minimum key value, from the set of vertices not yet included in MST.
     *
     * @param key the key values of the vertices
     * @param mstSet the boolean array that represents the set of vertices included in MST
     * @return the index of the vertex with the minimum key value
     */
    private int minKey(int[] key, boolean[] mstSet) {
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
     * Prints the constructed MST.
     *
     * @param startVertex the start vertex
     * @param parent the parent array that represents the constructed MST
     * @param key the key values of the vertices
     */
    private void printMST(int startVertex, int[] parent, int[] key) {
        // Prints the edges of the minimum spanning tree and their weights.
        System.out.println("LE GRAPHE EST CONNEXE");
        int totalWeight = 0;

        for (int i = 0; i < graphToUse.getVertices(); i++) {
            if (i != startVertex) {
                totalWeight += key[i];
            }
        }
        System.out.println("Coût de l'arbre recouvrant : " + totalWeight);

        for (int i = 0; i < graphToUse.getVertices(); i++) {
            if (i != startVertex && parent[i] != INF) {
                System.out.println("(" + (i + 1) + " -> " + (parent[i] + 1) + " : " + key[i] + ")");
            }
        }
    }
}
