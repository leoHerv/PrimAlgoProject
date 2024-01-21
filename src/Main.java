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

        Prim algo = new Prim(graph, 1);
        algo.performAlgo();
        algo.printMST();

        System.out.println("GraphUsingAdjacencyMatrix");
        Graph graph2 = new GraphUsingAdjacencyMatrix("graph.txt");

        Prim algo2 = new Prim(graph2, 1);
        algo2.performAlgo();
        algo2.printMST();
    }

}