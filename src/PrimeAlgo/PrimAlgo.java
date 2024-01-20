package PrimeAlgo;

import graph.Graph;

import java.util.*;

public class PrimAlgo {

    Graph graphToUse;
    static final int INF = Integer.MAX_VALUE;

    public PrimAlgo(Graph graphToPerform){
        this.graphToUse = graphToPerform;
    }

    public void primMST(int startVertex) {
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
                if (v > vertices || u >= vertices) {
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



    private static int minKey(int[] key, boolean[] mstSet) {
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

    private void printMST(int startVertex, int[] parent, int[] key) {
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
