package main;

import primAlgo.Prim;
import graph.Graph;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;

public class Main
{
    public static <T extends Graph> void runProgram(String[] args, Class<T> graphType, String mention)
    {
        // We check if we have the right number of arguments.
        if (args.length != 2 && args.length != 3) {
            System.out.println("Usage: java Prim" + mention + " <graph_file> <start_vertex> [<output_file>]");
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

        if(args.length == 2){
            algo.printMST();
        }
        else{
            // We try to create or open the file in the third argument.
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