// Classe de la présentation d'un menu d'administrateur
//L'administrateur est déjà connecté dans cette simulation
// L'adminisatrateur connecté par défaut pour cette simulation est Louis-Edouard Lafontant

import java.util.ArrayList;
import java.util.Scanner;
public class MenuAdministrateur {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choix ;
        String Menu = "[1] Mon profil\n"+
                "[2] Membres\n"+
                "[3] Articles\n"+
                "[4] Activités\n"+
                "[5] Intérêts\n"+
                "[6] Outils\n"+
                "[7] Projets\n"+
                "[0] Quitter l'application\n"+
                "Entrer un numéro: ";


        Member louisEdouard = new Member("Louis-Edouard LAFONTANT", "louis.edouard.lafontant@umontreal.ca","Louedo11?");


        String menuProfile = "Nom et Prénom: "+ louisEdouard.getUsername()+"\n" +
                "Courriel: "+louisEdouard.getCourriel()+"\n"+
                "Numéro de téléphone: XXX-XXX-XXXX\n" +
                "Derniers articles:\n" +
                "    (...)\n" +
                "    (...)\n" +
                "    (...)\n" +
                "    (...)\n" +
                "    (...)\n" +
                "\n" +
                "[1] Modifier mes informations personnelles\n" +
                "[2] Voir mes notifications\n" +
                "[0] Retourner au menu principal";

        System.out.println(Menu);
        choix = scan.nextInt();
        while (choix<0 || choix>7){
            System.out.println("Veuiller entrer un nombre valide: ");
            choix = scan.nextInt();
        }
        if (choix == 1){
            System.out.println(menuProfile);
        }
        else if (choix == 2){
            System.out.println("Redirection vers le menu Membres...");
        }
        else if (choix == 3){
            System.out.println("Redirection vers le menu d'articles...");
        }
        else if (choix == 4){
            System.out.println("Redirection vers le menu des activités...");
        }
        else if (choix == 5){
            System.out.println("Redirection vers le menu des intérets...");
        }
        else if (choix == 6){
            System.out.println("Redirection vers le menu des Outils...");
        }
        else if (choix == 7){
            System.out.println("Redirection vers le menu des projets...");
        }
        else {
            System.out.println("Deconnexion....\n"+ "Merci et à bientot "+ louisEdouard.getUsername());
        }



    }
}
