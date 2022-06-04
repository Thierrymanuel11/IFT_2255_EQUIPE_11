// Classe de la présentation d'un menu pour la gestion des membres

import java.util.Scanner;
import java.util.ArrayList;

public class MenuMembre {
    public static void main(String[] args) {
        int choix ;
        Scanner scan = new Scanner(System.in);
        String menu = "[1] Liste des membres\n" +
                "[2] Chercher un membre\n" +
                "[3] Assigner un rôle à un membre\n" +
                "[4] Modifier le rôle d'un membre\n" +
                "[5] Réactiver le compte d'un membre\n" +
                "[6] Susprendre le compte d'un membre\n" +
                "[0] Retourner au menu principal\n"+
                "Entrer un numéro: ";
        //* Lorsqu'on cherche un membre/affiche la liste des membres, on peut afficher le profil d'un membre *//

        Member michalis = new Member("Michalis FAMELIS","famelis@iro.umontreal.ca","Micfam55%");
        Member eugene = new Member("Eugène SYRIANI", "syriani@iro.umontreal.ca","Eugsyr23!");
        Member houari = new Member("Houari SAHRAOUI", "houari.sahraoui@umontreal.ca","Housah11?");
        Member david = new Member("Istvan DAVID", "istvan.david@umontreal.ca", "istdav45/");
        Member louisEdouard = new Member("Louis-Edouard LAFONTANT", "louis.edouard.lafontant@umontreal.ca","Louedo11?");
        ArrayList<Member> TabMember = new ArrayList<Member>();
        TabMember.add(michalis);
        TabMember.add(eugene);
        TabMember.add(houari);
        TabMember.add(david);
        TabMember.add(louisEdouard);

        System.out.println(menu);
        choix = scan.nextInt();
        while (choix<0 || choix>6){
            System.out.println("Veuiller entrer un nombre valide: ");
            choix = scan.nextInt();
        }

        if (choix == 1){
            String membre = "Liste des membres de l'application:\n";
            for (Member i : TabMember){
                membre += i.toString()+"\n";
            }
            System.out.println(membre);
        }
        else if (choix == 2){
            System.out.println("Entrer le nom d'utilisateur du membre à rechercher: ");
            String nom = scan.next();
            System.out.println("Recherche de "+nom+"...");
        }
        else if (choix == 3 || choix == 4){
            System.out.println("Entrer le nom d'utilisateur d'un membre: ");
            String nom = scan.next();
            System.out.println("Entrer le role que vous voulez lui attribuer: ");
            String role = scan.next();
            System.out.println(nom+" a désormais le role de "+role);
        }
        else if (choix == 5){
            System.out.println("Entrer le nom d'utilisateur d'un membre: ");
            String nom = scan.next();
            System.out.println("Réactivation du compte de "+nom+"...");
        }
        else if (choix == 6){
            System.out.println("Entrer le nom d'utilisateur d'un membre: ");
            String nom = scan.next();
            System.out.println("Suspension du compte de "+nom+"...");
        }
        else {
            System.out.println("Retour au menu principal...");
        }

    }
}
