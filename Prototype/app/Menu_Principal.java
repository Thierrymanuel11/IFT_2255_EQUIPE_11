// Fichier correspondant à la vue du menu principal lors de l'ouverture de l'application

import java.util.ArrayList;
import java.util.Scanner;
public class Menu_Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choix;
        boolean validation = true;
        String nom = null;
        String prenom = null;
        String mdp = null;
        String mdpc = null;
        String courriel = null;
        long num =0 ;
        int choix2;
        String[] charPassword = {"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", "0123456789", "?§%£$ù!_/@=#&"};
        String menu_principal = "ROUNDTABLE - Bienvenu(e) sur la plateforme \"RoundTable\". Une plateforme pour les membres du GEODES afin de pouvoir gerer leurs activités.\n"+
                "Choisissez une des options suivantes:\n"+
                "[1] Authentification\n"+
                "[2] Inscription\n"+
                "[3] Quitter l'application\n"+"Entrer un numéro: ";
        String[] Prof = {"Michalis FAMELIS", "Eugène SYRIANI", "Houari SAHRAOUI"};


        // Tableaux contenant les membres déjà enregistrés au lancement de l'application
        // et qui pourront déjà directement se connecter
        // Ces tableaux sont constitués de tableaux comprennant les noms des membres en question,
        // leurs adresse mail ainsi que leurs mot de passe
        String[][] admin = {{"Louis-Edouard LAFONTANT", "louis.edouard.lafontant@umontreal.ca", "Louedo11?"}};
        Member michalis = new Member("Michalis FAMELIS","famelis@iro.umontreal.ca","Micfam55%");
        Member eugene = new Member("Eugène SYRIANI", "syriani@iro.umontreal.ca","Eugsyr23!");
        Member houari = new Member("Houari SAHRAOUI", "houari.sahraoui@umontreal.ca","Housah11?");
        Member david = new Member("Istvan DAVID", "istvan.david@umontreal.ca", "istdav45/");
        Member louisEdouard = new Member("Louis-Edouard LAFONTANT", "louis.edouard.lafontant@umontreal.ca","Louedo11?");
        ArrayList <Member> TabMember = new ArrayList<Member>();
        TabMember.add(michalis);
        TabMember.add(eugene);
        TabMember.add(houari);
        TabMember.add(david);
        TabMember.add(louisEdouard);

        System.out.println(menu_principal);
        choix = scan.nextInt();
        while (choix<1 && choix>3){
            System.out.println("Veuillez s'il vous plait inscrire un nombre valide:");
            choix = scan.nextInt();
        }
        if (choix == 2){
            System.out.println("Choix de superviseur:\n" +
                    "[1] Michalis FAMELIS\n"+
                    "[2] Eugène SYRIANI\n"+
                    "[3] Houari SAHRAOUI\n");
            choix2 = scan.nextInt();
            while(choix2<1 && choix2 >3){
                System.out.println("Entrer un chiffre valide:");
                choix2 = scan.nextInt();
            }
            while (validation){
                System.out.println("Nom:");
                nom = scan.next();
                System.out.println("Prénom:");
                prenom = scan.next();
                System.out.println("Adresse Courriel:");
                courriel = scan.next();
                System.out.println("Entrer votre numéro de téléphone(XXX-XXX-XXX): ");
                num = scan.nextLong();
                System.out.println("Mot de passe (au moins 8 caractères, 1 chiffre, 1 majuscule, 1 minuscule, 1 caractère spécial): ");
                mdp = scan.next();
                while (mdp.length() < 8 || verifPassword(mdp, charPassword)){
                    System.out.println("Veuiller entrer un mot de passe valide(au moins 8 caractères, 1 chiffre, 1 majuscule, 1 minuscule, 1 caractère spécial) :");
                    mdp = scan.next();
                }
                System.out.println("Confirmation de Mot de passe:");
                mdpc = scan.next();
                while (!(mdpc.equals(mdp))){
                    System.out.println("Veuiller entrer le meme mot de passe s'il vous plait:");
                    mdpc = scan.next();
                }
                System.out.println("Souhaitez vous modifier vos informations?\n"+
                        "Taper 1 pour oui et un autre chiffre pour non");
                int modif = scan.nextInt();
                if (modif != 1) validation = false;
            }
            System.out.println("Récapitulatif de la demande: \n"+
                    "Nom: "+nom+"\n"+
                    "Prénom: "+prenom+"\n"+
                    "Adresse Courriel: "+courriel+"\n"+
                    "Mot de passe: "+mdp+"\n"+
                    "Numéro de téléphone: "+num+"\n"+
                    "Merci. Votre demande d'inscription a été envoyé.\n"+
                    "Vous recevrer donc un mail de la part de "+Prof[choix2-1]+" pour confirmer votre adhésion. Veuiller deumeurer dans l'attente :)");

        }
        else if (choix == 1){
            Member Temp = null;
            System.out.println("Adresse Courriel:");
            courriel = scan.next();
            for(Member i : TabMember){
                if (i.getCourriel().equals(courriel)){
                    Temp = i;
                    break;
                }
            }
            System.out.println("Mot de passe: ");
            mdp = scan.next();
            while (!(Temp.getPassword().equals(mdp))){
                System.out.println("Erreur sur votre mot de passe. Veuiller entrer le bon Mot de passe: ");
                mdp = scan.next();
            }
            System.out.println("Bienvenu(e) "+ Temp.getUsername()+ " :)");
        }
        else {
            System.out.println("Merci d'avoir utilisé la plateforme. Bonne journée à vous :)");
        }

    }

    public static boolean verifPassword(String password, String [] TabVerif){
        for (int i =0; i<password.length(); i++){
            if (TabVerif[0].indexOf(password.charAt(i)) == -1 || TabVerif[1].indexOf(password.charAt(i)) == -1 || TabVerif[2].indexOf(password.charAt(i)) == -1){
              return false;
            }
        }
        return true;
    }
}
