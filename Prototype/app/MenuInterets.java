// Classe de la présentation d'un menu pour la gestion des articles
import java.util.Scanner;
public class MenuInterets {
    public static void main(String[] args) {
        int choix;
        Scanner scan = new Scanner(System.in);
        String menu = "[1] Modifier ma liste d'intérêts\n" +
                "[0] Retourner au menu principal\n" +
                "> Entrez un numéro:";

        System.out.println(menu);
        choix = scan.nextInt();
        while (choix<0 || choix>1){
            System.out.println("Veuiller entrer un nombre valide: ");
            choix = scan.nextInt();
        }

        if (choix == 1){
            System.out.println("Modification de la liste d'interet...");
        }
        else {
            System.out.println("Retour au menu principal...");
        }
    }
}
