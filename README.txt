Projet AA, M1 Informatique.
Algorithme de Prim
- AL NATOUR Mazen
- HERVOUET Léo


===== Archive =====

	* Un dossier /src :
		Contenant les fichiers sources de notre projet.

	* rapport_Al Natour_Hervouet.pdf :
		Ceci est le rapport répondant aux questions posees ainsi que les explications de certaines classes.

	* Un Makefile :
		Il s'agit ici de plusieurs commandes afin de faciliter la compilation et l'exécution de notre programme, ainsi
	    vous avez à votre disposition les commandes suivantes :
		
		=> make comp :
			Permettant de compiler le programme dans le dossier src/obj.
		=> make run :
			Permettant de compiler le programme et donne deux exemples de commande pour executer les programmes.
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

1)  make run
2)  java -cp src/obj src.PrimM examples/graph.txt 1
    ou
    java -cp src/obj src.PrimL examples/graph.txt 1