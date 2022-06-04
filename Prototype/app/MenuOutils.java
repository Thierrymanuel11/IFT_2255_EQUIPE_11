// Classe de la présentation d'un menu pour la gestion des Outils
import java.util.Scanner;

public class MenuOutils {
    public static void main(String[] args) {
        int choix;
        Scanner scan = new Scanner(System.in);
        String menu = "[1] Outils publics\n" +
                "[0] Retourner au menu principal\n" +
                "> Entrez un numéro:";
        //* Lorsqu'on affiche la liste des outils, on peut afficher la fiche complète d'un outil *//
        System.out.println(menu);
        choix = scan.nextInt();
        while (choix<0 || choix>1){
            System.out.println("Veuiller entrer un nombre valide: ");
            choix = scan.nextInt();
        }

        if (choix == 1){
            System.out.println("Affichage des outils publics de la plateforme...");
        }
        else {
            System.out.println("Retour au menu principal...");
        }
    }
}
