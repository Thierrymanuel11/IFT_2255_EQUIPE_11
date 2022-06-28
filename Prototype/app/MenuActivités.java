// Classe de la présentation d'un menu pour la gestion des activités
import java.util.Scanner;
public class MenuActivités {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String menu = "[1] Créer une activité\n" +
                "[2] Souscrire à une activité\n" +
                "[3] Modifier ma liste d'activités\n" +
                "[4] Supprimer une activité\n" +
                "[0] Retourner au menu principal\n" +
                "> Entrez un numéro:";
        int choix;
        System.out.println(menu);
        choix = scan.nextInt();
        while (choix<0 || choix>4){
            System.out.println("Veuiller entrer un nombre valide: ");
            choix = scan.nextInt();
        }
        if (choix == 1){
            System.out.println("Entrer le nom de l'activité: ");
            String nom = scan.next();
            System.out.println("Entrer le statut de visibilité de l'activité: ");
            String statut = scan.next();
            System.out.println("Création de l'activité "+nom+" avec le statut "+statut+"...");
        }
        else if (choix == 2){
            System.out.println("Entrer le nom de l'activité à laquelle vous voulez souscrire:");
            String nom = scan.next();
            System.out.println("Souscription à l'activité "+ nom+"...");
        }
        else if (choix == 3){
            System.out.println("Modification de la liste d'activité...");
        }
        else if(choix == 4){
            System.out.println("Entrer le nom de l'article à supprimer: ");
            String nom = scan.next();
            System.out.println("Supression de l'activité "+nom+"...");
        }
        else {
            System.out.println("Retour au menu principal...");
        }


    }

}
