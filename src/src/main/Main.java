package src.main;

import src.primAlgo.Prim;
import src.graph.Graph;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;

public class Main
{
    /** Run the Prim algorithm on a graph in a file with an adjacency list or adjacency matrix.
     *  @param args The arguments of the command line.
     *  @param graphType The type of the graph.
     *  @param mention The mention of the executable.
     * */
    public static <T extends Graph> void runProgram(String[] args, Class<T> graphType, String mention)
    {
        // We check if we have the right number of arguments.
        if (args.length != 2 && args.length != 3) {
            System.out.println("Usage: java -cp src/obj src.Prim" + mention + " <graph_file> <start_vertex> [<output_file>]");
            System.exit(1);
        }

        // We try to create a new graph with the class type 'graphType'.
        Graph graph = null;
        try {
            Constructor<T> constructor = graphType.getConstructor(String.class);
            graph = constructor.newInstance(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error runProgram : can't create the class " + graphType.getName());
        }

        // We perform the Prim algorithm on the graph.
        Prim algo = new Prim(graph, Integer.parseInt(args[1]));
        algo.performAlgo();

        // We print our result in the console or a file.
        if(args.length == 2){
            algo.printMST();
        }
        else{
            // We try to create or open the file with the name in the third argument.
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
                PrintStream outFile = new PrintStream(fileOutputStream);
                algo.printMST(outFile);
                outFile.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

}