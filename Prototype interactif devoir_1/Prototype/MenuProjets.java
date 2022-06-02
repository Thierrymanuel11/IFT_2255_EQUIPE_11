// Classe de la présentation d'un menu pour la gestion des projets


import java.util.Scanner;

public class MenuProjets {
    public static void main(String[] args) {
        int choix;
        Scanner scan = new Scanner(System.in);
        String menu = "[1] Projets publics\n" +
                "[2] Chercher un projet\n" +
                "[0] Retourner au menu principal\n" +
                "> Entrez un numéro:";
        //* Lorsquon cherche un projet/affiche la liste des projets, on peut afficher la fiche complète d'un projet *//

        System.out.println(menu);
        choix = scan.nextInt();
        while (choix<0 || choix>2){
            System.out.println("Veuiller entrer un nombre valide: ");
            choix = scan.nextInt();
        }
        if (choix == 1){
            System.out.println("Affichage des projets publics...");
        }
        else if (choix == 2){
            System.out.println("Entrer le nom du projet à rechercher: ");
            String nom = scan.next();
            System.out.println("Recherche du projet "+nom+"...");
        }
        else {
            System.out.println("Retour au menu principal...");
        }
    }
}
