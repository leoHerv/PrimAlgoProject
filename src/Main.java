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
        /*
        graph.addEdge(2, 1, 61);
        graph.addEdge(3, 1, 50);
        graph.addEdge(3, 2, 1);
        graph.addEdge(4, 3, 68);
        graph.addEdge(5, 4, 84);
        graph.addEdge(6, 1, 28);
        graph.addEdge(6, 5, 34);*/



        long startTime = System.nanoTime();
        Prim algo = new Prim(graph);
        algo.primMST(1);
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1e6; // Convert to milliseconds
        System.out.println("Temps CPU : " + duration + " ms");


        System.out.println("GraphUsingAdjacencyMatrix");

        Graph graph2 = new GraphUsingAdjacencyMatrix("graph.txt");
        /*
        graph2.addEdge(2, 1, 61);
        graph2.addEdge(3, 1, 50);
        graph2.addEdge(3, 2, 1);
        graph2.addEdge(4, 3, 68);
        graph2.addEdge(5, 4, 84);
        graph2.addEdge(6, 1, 28);
        graph2.addEdge(6, 5, 34);*/



        long startTime2 = System.nanoTime();
        Prim algo2 = new Prim(graph2);
        algo2.primMST(1);
        long endTime2 = System.nanoTime();

        double duration2 = (endTime2 - startTime2) / 1e6; // Convert to milliseconds
        System.out.println("Temps CPU : " + duration2 + " ms");

        /*

        String graphFile = args[0];
        int startVertex = Integer.parseInt(args[1]);

        try (Scanner scanner = new Scanner(new File(graphFile))) {
            int vertices = scanner.nextInt();
            Graph graph = new GraphUsingAdjacectyMatrix(vertices);

            while (scanner.hasNext()) {
                int src = scanner.nextInt() - 1;

                while (true) {
                    int dest = scanner.nextInt() - 1;
                    if (dest == -1)
                        break;

                    int weight = scanner.nextInt();
                    graph.addEdge(src, dest, weight);
                }
            }

            long startTime = System.nanoTime();
            PrimAlgo algo = new PrimAlgo(graph);
            algo.primMST(startVertex - 1);
            long endTime = System.nanoTime();

            double duration = (endTime - startTime) / 1e6; // Convert to milliseconds
            System.out.println("Temps CPU : " + duration + " ms");

        } catch (FileNotFoundException e) {
            System.err.println("Fichier introuvable : " + graphFile);
        }
    }
    */
    }

}