package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
/**
 *
 * @author abergey
 */
public class GraphGenerator {
    public static final int NB_SOMMETS_DEFAUT = 10 ;
    public static final int POURCENTAGE_ARCS_DEFAULT = 40 ;
    public static final int POIDS_MAX_DEFAUT = 10 ;
    public static final int POIDS_MIN_DEFAUT = 1 ;


    public static void main(String[] args) {

        // initialisation des paramètres du graphe
        int nbSommets = NB_SOMMETS_DEFAUT ;
        int pourArcs = POURCENTAGE_ARCS_DEFAULT ;
        int poidsMax = POIDS_MAX_DEFAUT ;
        int poidsMin = POIDS_MIN_DEFAUT ;
        String outputFile = "inputFiles/DefaultOutputFile.txt"; // default output file
        switch (args.length){
            case 5 : poidsMax = Integer.parseInt(args[4]) ;
            case 4 : poidsMin = Integer.parseInt(args[3]) ;
            case 3 : pourArcs = Integer.parseInt(args[2]) ;
            case 2 : nbSommets = Integer.parseInt(args[1]) ;
            case 1 :
                outputFile = "inputFiles/" + args[0];
                if (!outputFile.endsWith(".txt")) {
                    System.out.println("\nError: Output file extension must be .txt! \n");
                    System.exit(1);
                }
                break;
        }
        // Génération du graphe
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            writer.println("" + nbSommets);
            Random r = new Random();
            for (int x = 1 ; x <= nbSommets ; x++ ){
                writer.print ("" + x + " " );
                for (int y = 1 ; y < x ; y++){
                    boolean existeArc = (r.nextInt(100)<pourArcs);
                    if (existeArc){ // Il y a un arc entre x et y
                        writer.print("" +y+ " ");
                        int poids = r.nextInt(poidsMax-poidsMin+1)+poidsMin ;
                        writer.print(""+poids+ " ");
                    }
                }
                writer.println (""+0);
            }
        } catch (IOException e) {
            System.out.println("Error: An error occurred while writing to the file.");
            System.exit(1);
        }
    }
}