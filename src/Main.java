import PrimAlgo.Prim;
import graph.Graph;
import graph.GraphUsingAdjacencyList;
import graph.GraphUsingAdjacencyMatrix;

public class Main
{
    public static void main(String[] args) {
       /* if (args.length < 2) {
            System.out.println("Usage: java PrimM <graph_file> <start_vertex> [<output_file>]");
            System.exit(1);
        }*/
        System.out.println("GraphUsingAdjacencyList");

        Graph graph = new GraphUsingAdjacencyList("graph.txt");

        long startTime = System.nanoTime();
        Prim algo = new Prim(graph, 1);
        algo.performAlgo();
        algo.printMST();
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1e6; // Convert to milliseconds
        System.out.println("Temps CPU : " + duration + " ms");


        System.out.println("GraphUsingAdjacencyMatrix");

        Graph graph2 = new GraphUsingAdjacencyMatrix("graph.txt");

        long startTime2 = System.nanoTime();
        Prim algo2 = new Prim(graph2, 1);
        algo2.performAlgo();
        algo2.printMST();
        long endTime2 = System.nanoTime();

        double duration2 = (endTime2 - startTime2) / 1e6; // Convert to milliseconds
        System.out.println("Temps CPU : " + duration2 + " ms");
    }

}