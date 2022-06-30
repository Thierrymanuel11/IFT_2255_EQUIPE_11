package MainApp;
import Controllers.UserController;
import Entity.User;
import MainApp.Menu;
import enums.UserTitle;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    User loggedUser;
    int pageIndex = 0;

    UserController userController;

    public Menu(){

        List<User> users = Arrays.asList(new User(0, "gabriel", "test", null, null, "goole.com", UserTitle.Master),
                new User(0, "simon", "levesque", null, null, "youtube.com", UserTitle.PHD));
        userController = new UserController(users);

    }

    public void start(){

        displayMenuPage();
        switchMainMenu();

    }

//    public void nextChoice(){
//        Scanner scanner = new Scanner(System.in);
//        String choice = scanner.next();
//        switchMenu(choice);
//    }




    public void switchMainMenu(){
        displayMenuPage();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        switch (choice){
            case "1":
                displayProfilePage();
                //nextChoice();
                break;

            case "2":
                switchUserMenu();
                break;

            case "3":
                displayActivityPage();
                //nextChoice();
                break;

            case "4":
                displayInterestPage();
                //nextChoice();
                break;

            case "5":
                switchLoginMenu();
                break;

            case "0":
                System.exit(0);
                break;

            default:
                System.out.println("Unexpected value: " + choice);
                //nextChoice();
        }
    }

    public void switchUserMenu(){
        displayUserPage();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        switch (choice) {
            case "1":
                userController.getAllUsers().forEach(
                        x -> System.out.println(x.print())
                );
                switchUserMenu();
                break;

            case "2":
                System.out.println("Entrez le prénom");
                String name = scanner.next();
                User user = userController.getUserByName(name);

                if (user != null){
                    System.out.println(user.print());
                } else {
                    System.out.println("Aucun utilisateur trouvé");
                }

                switchUserMenu();
                break;

            case "0":
                displayMenuPage();
                switchMainMenu();
                break;
        }
    }

    public void switchLoginMenu(){
        displayLoginPage();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        switch (choice) {
            case "1":
                switchMainMenu();
                break;

            case "2":
                //displayUserPage();
                break;

            case "0":
                System.exit(0);
        }
    }

    public void displayMenuPage(){
        System.out.println("----------Menu----------\nVeuillez choisir une option\n[1] Mon profil\n[2] Membre\n[3]" +
                " Activité\n[4] Intérêt\n[5] Déconnexion\n[0] Quitter l'application");
    }

    public void displayLoginPage(){
        System.out.println("----------Login----------\n[1] Authentication\n[2] Inscription\n[0] Quitter l'application");
    }

    public void displayActivityPage(){
        System.out.println("activity");
    }

    public void displayInterestPage(){
        System.out.println("interest");
    }

    public void displayUserPage(){
        System.out.println("----------Membres----------\nVeuillez choisir une option\n[1] Afficher la liste des membre" +
                "\n[2] Chercher un membre\n[0] Retourner au menu principal");

    }

    public void displayProfilePage(){
        System.out.println("profile");
    }



}
