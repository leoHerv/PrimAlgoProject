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
		=> make clean :
			Permettant de supprimer le dossier /src/obj ou sont les fichiers .class.
	
		Ainsi, pour utiliser ces commandes vous devez vous placer dans le répertoire "alnatour_hervouet" pour avoir acces.
			
	 * Un dossier /examples avec un fichier graph.txt :
	    C'est un exemple de graphe pour faire fonctionner le programme.


===== Programme =====

Deux programmes : PrimM et PrimL

Arguments :
    1) (obligatoire) Le nom du fichier ou se trouve le graphe sur lequel nous voulons appliquer l'algorithme de Prim.
    2) (obligatoire) Le sommet par lequel nous voulons commencer l'algorithme.
    3) (optionel)    Le fichier dans lequel nous voulons le resultat du programme.


===== Compilation et execution =====

1)  make comp
2)  make PrimL ARGS="examples/graph.txt 1"
    ou
    make PrimM ARGS="examples/graph.txt 1 outputFile.txt"