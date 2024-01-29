Projet AA, M1 Informatique.
Algorithme de Prim
- AL NATOUR Mazen
- HERVOUET Léo


===== Archive =====

	* Un dossier /src :
		Contenant les fichiers sources de notre projet.

	* rapport_al_natour_hervouet.pdf :
		Ceci est le rapport répondant aux questions posees ainsi que les explications de certaines classes.

	* Un Makefile :
		Il s'agit ici de plusieurs commandes afin de faciliter la compilation et l'exécution de notre programme, ainsi
	    vous avez à votre disposition les commandes suivantes :
		
		=> make comp :
			Permettant de compiler le programme dans le dossier src/obj.

		=> make PrimM ARGS="arg1 arg2 arg3" :
			Permet d'executer le programme PrimM avec trois arguments.

        	=> make PrimL ARGS="arg1 arg2 arg3" :
            		Permet d'executer le programme PrimL avec trois arguments.

		=> make GraphGenerator ARGSGraphG="arg1 arg2 arg3 arg4 arg5 "
            		Permet de générer un graphe aléatoirement dans un fichier dont le nom est passé en argument 1.

		=> make clean :
			Permettant de supprimer le dossier /src/obj ou sont les fichiers .class.
	
		Ainsi, pour utiliser ces commandes vous devez vous placer dans le répertoire "alnatour_hervouet" pour avoir acces.
			
	* Un dossier /inputFiles avec les fichiers graph.txt et graph2.txt:
	    Exemples de graphes pour faire fonctionner le programme.

	* Un dossier /outputFiles avec un fichier otputfile.txt :
        C'est un exemple d'un fichier de sortie.


===== Programmes =====

=> Deux programmes : PrimM et PrimL

Arguments :

    1) Le fichier d'entrée (obligatoire) : Le nom du fichier ou se trouve le graphe sur lequel nous voulons appliquer l'algorithme de Prim.
    2) Le somment de départ (obligatoire) : Le sommet par lequel nous voulons commencer l'algorithme.
    3) Le fichier de sortie (optionel) :    Le fichier dans lequel nous voulons le resultat du programme.

=> Un programme : GraphGenerator

Arguments :

   1) Nom du fichier (obligatoire) : C’est le nom du fichier dans lequel le graphe généré sera enregistré. Le fichier sera enregistré dans le répertoire “inputFiles/” et doit avoir l’extension “.txt”. Si un autre type d’extension est fourni, le programme affichera une erreur et se terminera.

   2) Nombre de sommets (optionnel) : C’est le nombre de sommets que le graphe généré aura. Si cet argument n’est pas fourni, le programme utilisera une valeur par défaut de 10.

   3) Pourcentage d’arcs (optionnel) : C’est le pourcentage d’arcs que le graphe généré aura. Si cet argument n’est pas fourni, le programme utilisera une valeur par défaut de 40.

   4) Poids minimum (optionnel) : C’est le poids minimum que les arcs du graphe généré peuvent avoir. Si cet argument n’est pas fourni, le programme utilisera une valeur par défaut de 1.

   5) Poids maximum (optionnel) : C’est le poids maximum que les arcs du graphe généré peuvent avoir. Si cet argument n’est pas fourni, le programme utilisera une valeur par défaut de 10.

   /!\ Veuillez noter que ces arguments doivent être fournis dans l’ordre indiqué ci-dessus. Si un argument optionnel n’est pas fourni, tous les arguments qui le suivent ne doivent pas non plus être fournis /!\


===== Compilation et execution =====

1)  make comp
2)  make GraphGenerator ARGSGraphG="graph.txt 50"
3)  make PrimL ARGS="inputFiles/graph.txt 1" [même chose avec PrimM]
    ou
    make PrimL ARGS="inputFiles/graph.txt 1 outputFile.txt" [même chose avec PrimM]

	
