// Classe de la présentation d'un menu pour la gestion des articles
import java.util.Scanner;
public class MenuArticles {
    public static void main(String[] args) {
        int choix;
        Scanner scan = new Scanner(System.in);
        String menu = "[1] Articles publics récemment publiés\n" +
                "[2] Articles publics en cours\n" +
                "[3] Chercher un article\n" +
                "[0] Retourner au menu principal\n" +
                "> Entrez un numéro:";
        //* Lorsqu'on cherche un article/affiche une liste d'articles, on peut afficher la fiche complète d'un article *//
        System.out.println(menu);
        choix = scan.nextInt();
        while (choix<0 || choix>3){
            System.out.println("Veuiller entrer un nombre valide: ");
            choix = scan.nextInt();
        }

        if (choix == 1){
            System.out.println("Affichage des Articles publics récemment publiés...");
        }
        else if (choix == 2){
            System.out.println("Affichage des Articles publics en cours...");
        }
        else if (choix == 3){
            System.out.println("Entrer le nom de l'article que vous rechercher: ");
            String nom = scan.next();
            System.out.println("Recherche de l'article "+nom+"...");
        }
        else {
            System.out.println("Retour au menu principal");
        }

    }
}
