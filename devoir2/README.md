# Prototype Roundtable

## Rouler l'application

une fois que vous êtes dans le fichier nommé java: 
    cd out/artifact/s/java_jar
    java -jar java.jar

Sinon, pour pouvex toujours importer le project dans Intellij et le rouler à partir le là. La Main classe est Main.

## Utilisation

* Le prototype est une application en ligne de commande. Elle contient plusiseurs vues qui accomplissent différentes fonctions.
Pour chacune de cest vues, il y a des choix à faire . Pour faire ces choix, il fait entrer un chiffre selon les options qui
sont affichés et appuyer sur "Enter".

* Pour les fonctions de modification, l'usage vas se faire demander de changer plusieur valeurs, par contre si il ne veut pas
changer une de ses valeur, il faut simplement qu'il appuis sur "Enter" en entrant aucune valeur (ou qu'il entre la valeur
0 si il se fait de demander d'entrer un chiffre) 

* Chaque vues qui découlent de la vue du menu principal contienent une option de revenir au menu principal ou de quitter l'application

## Interface de départ

L'application commence au menu principal après la connexion. Il est possible de se déconnecter pour voir la page de connexion,
mais cette décision a été prise pour simplifier le test, puisque l'application est seulement un prototype.

## À noter

* Nous n'avons pas de base de données pour l'instant, donc l'implémentation est un peu différente que si nous en avions une.

* Le prototype donne la vue qu'un membre normal aurait, il manque donc des vues qui sont pour les administrateur et les professeurs.

* Le protoype est un "proof of concept", donc il y a des foncitons qui sont un peu moins complète. Le prototype sert à montrer au client
ce que l'application est capable de faire. Il y aura des modifications à faire si jamais le client décide d'aller plus loin avec le 
projet. Ceci veut donc dire que la plupart des fonctions sont dans le prototype (sauf les fonctions pour les professeurs et les administrateurs),
mais qu'elles changeraient probablement un peu avec le feedback du client. 

