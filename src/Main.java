import PrimeAlgo.PrimAlgo;
import graph.Graph;
import graph.GraphUsingAdjacencyMatrix;

public class Main
{
    public static void main(String[] args) {
       /* if (args.length < 2) {
            System.out.println("Usage: java PrimM <graph_file> <start_vertex> [<output_file>]");
            System.exit(1);
        }*/
        Graph graph = new GraphUsingAdjacencyMatrix(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 3);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);



        long startTime = System.nanoTime();
        PrimAlgo algo = new PrimAlgo(graph);
        algo.primMST(0);
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1e6; // Convert to milliseconds
        System.out.println("Temps CPU : " + duration + " ms");

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