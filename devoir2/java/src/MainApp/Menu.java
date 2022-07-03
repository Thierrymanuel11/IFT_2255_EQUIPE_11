package MainApp;
import Controllers.ActivityController;
import Controllers.InterestController;
import Controllers.UserController;
import Entity.*;
import enums.AccountRole;
import enums.AccountStatus;
import enums.UserTitle;
import enums.ArticleStatus;

import java.lang.invoke.SwitchPoint;
import java.lang.reflect.Array;
import java.util.*;

public class Menu {

    User loggedUser;
    int pageIndex = 0;

    UserController userController;
    InterestController interestController;
    ActivityController activityController;

    public Menu(){


        this.loggedUser = new User(3, "Louis-Édouard", "Lafontant", null, null,
                "https://ceduni.github.io/udem-ift2255/devoirs/dm2.html", UserTitle.Master, "louis.edouard.lafontant@umontreal.ca");

        Professor michalis = new Professor(4, "Michalis", "Famelis", null, null,
                "https://geodes.iro.umontreal.ca/", UserTitle.Professor, "michalis.famelis@umontreal.ca");

        User eugene = new User(5, "Eugène", "Syriani", null, null,
                "https://geodes.iro.umontreal.ca/", UserTitle.Professor, "eugene.syriani@umontreal.ca");

        User houari = new User(6, "Houari", "Sahraoui", null, null,
                "https://geodes.iro.umontreal.ca/", UserTitle.Professor, "houari.sahraoui@umontreal.ca");

        User istvanUser = new User(7, "Istvan", "David", null, null,
                "https://geodes.iro.umontreal.ca/", UserTitle.PHD, "istvan.david@umontreal.ca");

        User louisUser = new User(8, "Louis-Edouard", "Lafontant", null, null,
                "https://geodes.iro.umontreal.ca/", UserTitle.PHD, "louis.edouard.lafontant@umontreal.ca");

        List<Account> accounts = new ArrayList<>(Arrays.asList(
                new Account("michalis.famelis@umontreal.ca","test", AccountStatus.VALID, michalis, AccountRole.Professor),
                new Account("eugene.syriani@umontreal.ca","test", AccountStatus.VALID, eugene, AccountRole.Professor),
                new Account("houari.sahraoui@umontreal.ca","test", AccountStatus.VALID, houari, AccountRole.Professor),
                new Account("louis.edouard.lafontant@umontreal.ca", "louis", AccountStatus.VALID, istvanUser, AccountRole.Admin),
                new Account("istvan.david@umontreal.ca", "istvan", AccountStatus.VALID, louisUser, AccountRole.Admin)
        ));

        List<User> users = new ArrayList (Arrays.asList(
                new User(0, "gabriel", "test", null, null, "goole.com", UserTitle.Master, "test@umontreal.ca"),
                new User(2, "simon", "levesque", null, null, "youtube.com", UserTitle.PHD, "tess@gmail.com"),
                new User(3, "Louis-Édouard", "Lafontant", null, null, "https://ceduni.github.io/udem-ift2255/devoirs/dm2.html", UserTitle.Master, "louis.edouard.lafontant@umontreal.ca"),
                michalis,
                eugene,
                houari,
                istvanUser,
                louisUser
        ));

        List<Interest> interests = new ArrayList(Arrays.asList(
                new Interest("programation", "Tout ce qui est lié à la programmation"),
                new Interest("innovation", "Tout ce qui est lié à l'innocation")
        ));

        List<Activity> activities = new ArrayList<>(Arrays.asList(
                new Article(
                        "Description test",
                        new Date(2017, 2 , 4),
                        "https://ceduni.github.io/udem-ift2255/devoirs/dm2.html",
                        ArticleStatus.Published,
                        new ArrayList<User>(Arrays.asList(
                                michalis,
                                eugene
                        )),
                        new ArrayList<User>(Arrays.asList(
                                istvanUser,
                                louisUser
                        )),
                        new ArrayList<String>(Arrays.asList(
                                "test",
                                "article 1"
                        )),
                        interests,
                        "Article 1",
                        0
                ),
                new Tool(
                        "test tool",
                        "2.1",
                        "https://github.com/geodes-sms/lowkey",
                        michalis,
                        null,
                        null,
                        new ArrayList<String>(Arrays.asList(
                                "test",
                                "article 1"
                        )),
                        interests,
                        "lowkey",
                        1

                ),
                new Project(
                        "test project",
                        new Date(2018, 1,2),
                        new Date(2020, 6,25),
                        (Professor) michalis,
                        new ArrayList<String>(Arrays.asList(
                                "test",
                                "article 1"
                        )),
                        interests,
                        "project 1",
                        2
                )
        ));

        userController = new UserController(users, accounts);
        interestController = new InterestController(interests);
        activityController = new ActivityController(activities);

    }

    public void start(){

        switchMainMenu();

    }

    public void switchMainMenu(){
        displayMenuPage();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        switch (choice){
            case "1":
                switchProfilePage();
                //nextChoice();
                break;

            case "2":
                switchUserMenu();
                break;

            case "3":
                switchActivityMenu();
                //nextChoice();
                break;

            case "4":
                switchInterestMenu();

            case "5":
                displayLoginPage();
                //nextChoice();
                break;

            case "0":
                System.exit(0);
                break;

            default:
                System.out.println("Unexpected value: " + choice);
                switchMainMenu();
        }
    }

    private void switchInterestMenu() {

        displayInterestPage();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        switch (choice) {

            case "2":
                System.out.println("Entrez le nom de l'intétêt que vous voulez changer");
                String name  = scanner.next();
                System.out.println("Entrez la nouvelle description");
                String description = scanner.next();
                boolean modifyWorked = interestController.modifyInterest(name, description);
                while (!modifyWorked) {
                    System.out.println("L'intérêt n'a pas été trouvé\nVoici les intérêts disponible");
                    interestController.printInterest();
                    System.out.println("Entrez le nom de l'intétêt que vous voulez changer");
                    name  = scanner.next();
                    if (name.equals("0")) {
                        switchInterestMenu();
                    }
                    System.out.println("Entrez la nouvelle description");
                    description = scanner.next();
                    if (description.equals("0")) {
                        switchInterestMenu();
                    }
                    modifyWorked = interestController.modifyInterest(name, description);
                }
                switchInterestMenu();
                break;

            case "1":
                System.out.println("Entrez le nom de l'intétêt que vous voulez ajouter");
                name  = scanner.next();
                System.out.println("Entrez la description");
                description = scanner.next();
                interestController.addInterest(name, description);
                switchInterestMenu();
                break;

            case "3":
                System.out.println("Entrez le nom de l'intétêt que vous voulez supprimer");
                name  = scanner.next();
                boolean deleteWorked = interestController.deleteInterest(name);
                while (!deleteWorked) {
                    System.out.println("L'intérêt n'a pas été trouvé\nVoici les intérêts disponible");
                    interestController.printInterest();
                    System.out.println("Entrez le nom de l'intétêt que vous voulez supprimer");
                    name  = scanner.next();
                    if (name.equals("0")) {
                        switchInterestMenu();
                    }
                    deleteWorked = interestController.deleteInterest(name);
                }
                switchInterestMenu();
                break;

            case "4":
                switchMainMenu();
                break;

            case "0":
                System.exit(0);
                break;

            default:
                System.out.println("Unexpected value: " + choice);
                switchInterestMenu();

        }

    }

    private void switchProfilePage() {
        displayProfilePage();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        switch (choice) {

            case "1":
                System.out.println("Modificaion info perso");
                switchProfilePage();
                break;

            case "2":
                System.out.println("notification");
                switchProfilePage();
                break;

            case "3":
                switchMainMenu();
                break;

            case "0":
                System.exit(0);

            default:
                System.out.println("Unexpected value: " + choice);
                switchProfilePage();
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

            case "3":
                displayMenuPage();
                switchMainMenu();
                break;

            case "0":
                System.exit(0);
                break;

            default:
                System.out.println("Unexpected value: " + choice);
                switchUserMenu();
        }
    }

    public void switchLoginMenu(){
        displayLoginPage();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        switch (choice) {
            case "1":
                System.out.println("Entrez votre email");
                String email = scanner.next();
                System.out.println("Entrez votre mot de passe");
                String password = scanner.next();
                User validLogin = userController.login(email, password);
                if (validLogin != null) {
                    loggedUser = validLogin;
                    switchMainMenu();
                } else {
                    System.out.println("Email ou mot de passe invalide");
                    switchLoginMenu();
                }
                break;

            case "2":

                System.out.println("Entrez le prénom de votre superviseur");
                String supervisor = scanner.next();
                User validSuper = userController.getUserByName(supervisor);

                while (validSuper == null || !validSuper.getTitle().equals(UserTitle.Professor)) {
                    System.out.println("Entrez un superviseur valide");
                    supervisor = scanner.next();
                    validSuper = userController.getUserByName(supervisor);
                }

                System.out.println("Entrez votre nom");
                String lname = scanner.next();
                System.out.println("Entrez votre Prénom");
                String fname = scanner.next();
                System.out.println("Entrez votre courriel");
                email = scanner.next();
                System.out.println("Entrez votre numéro de téléphone");
                String tel = scanner.next();
                System.out.println("Entrez votre mot de passe");
                password = scanner.next();
                System.out.println("Confirmez votre mot de passe");
                String confirmedPass = scanner.next();

                while (!confirmedPass.equals(password)){
                    System.out.println("Les mot de passe ne sont pas pareils");
                    System.out.println("Entrez votre mot de passe");
                    password = scanner.next();
                    System.out.println("Confirmez votre mot de passe");
                    confirmedPass = scanner.next();

                }

                userController.createAccount(fname,lname,email,tel,password, validSuper);
                System.out.println("Merci. Votre demande d'inscription a été envoyé. Vous recevrez sous peu une réponse à l'adresse courriel soumise.");
                switchLoginMenu();

                break;

            case "0":
                System.exit(0);

            default:
                System.out.println("Unexpected value: " + choice);
                switchLoginMenu();
        }
    }

    private void switchProjectMenu() {
        displayProjectPage();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        switch (choice) {

            case "1":
                System.out.println("Projects public");
                switchProjectMenu();
                break;

            case "2":
                System.out.println("Recherche de project");
                switchProjectMenu();
                break;

            case "3":
                switchMainMenu();
                break;

            default:
                System.out.println("Unexpected value: " + choice);
                switchProjectMenu();


        }
    }

    private void switchToolMenu() {
    }

    private void switchActivityMenu() {
        displayActivityPage();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {

            case "1":
                System.out.println("Que voulez-vous créer?\n" +
                        "[1] Article\n" +
                        "[2] Outils\n" +
                        "[3] Project");
                String choice2 = scanner.nextLine();
                switch (choice2) {
                    case "1" :
                        System.out.println("Entrez le titre");
                        String titre = scanner.nextLine();
                        System.out.println("Entrez un résumé");
                        String summary = scanner.nextLine();
                        System.out.println("Entrez un URL");
                        String url = scanner.nextLine();
                        System.out.println("Entrez l'année en chiffre");
                        int year = Integer.parseInt(scanner.nextLine());
                        System.out.println("Entrez le mois en chiffre");
                        int month = Integer.parseInt(scanner.nextLine());
                        System.out.println("Entrez le mois en chiffre");
                        int day = Integer.parseInt(scanner.nextLine());
                        Date date = new Date(year, month, day);
                        int id = this.activityController.getSize();
                        this.activityController.createArticle(titre,summary,url,date,null,null,
                                null,null,ArticleStatus.Draft,id);
                        System.out.println("Article Créé avec succès");
                        switchActivityMenu();
                        break;

                    case "2":
                        System.out.println("Ce menu créerait un outil");
                        switchActivityMenu();
                        break;

                    case "3":
                        System.out.println("Ce menu créerait un Project");
                        switchActivityMenu();
                        break;
                }

                //switchActivityMenu();

                break;

            case "2":
                System.out.println("Que voulez-vous créer?\n" +
                        "[1] Article\n" +
                        "[2] Outils\n" +
                        "[3] Project");
                choice2 = scanner.nextLine();
                switch (choice2) {
                    case "1":
                        List<Article> articles = this.activityController.getAllArticle();
                        for (Article article: articles) {
                            System.out.println(article.getId() + ": " + article.getTitle());
                        }
                        System.out.println("Choisisez un article à changer en utilisant le id");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.println("Vous allez vous faire demander d'entrer de nouvelles valeurs dans l'article" +
                                ". S'il y a une valeur que vous ne voulez pas changer, appuyer simplement sur 'Enter' ou " +
                                "entrez 0 pour les chiffre");
                        System.out.println("Entrez le titre");
                        String titre = scanner.nextLine();
                        System.out.println("Entrez un résumé");
                        String summary = scanner.nextLine();
                        System.out.println("Entrez un URL");
                        String url = scanner.nextLine();

                        this.activityController.modifyArticle(titre,summary,url,null,null,null,null,null,null,id);
                        System.out.println("Modification éffectuée");
                        switchActivityMenu();

                        break;

                    case "2":
                        List<Tool> tools = this.activityController.getAllTool();
                        for (Tool tool: tools) {
                            System.out.println(tool.getId() + ": " + tool.getTitle());
                        }
                        System.out.println("Choisisez un article à changer en utilisant le id");
                        id = Integer.parseInt(scanner.nextLine());
                        System.out.println("Vous allez vous faire demander d'entrer de nouvelles valeurs dans l'article" +
                                ". S'il y a une valeur que vous ne voulez pas changer, appuyer simplement sur 'Enter' ou " +
                                "entrez 0 pour les chiffre");
                        System.out.println("Entrez le titre");
                        titre = scanner.nextLine();
                        System.out.println("Entrez un résumé");
                        String description = scanner.nextLine();
                        System.out.println("Entrez un URL");
                        url = scanner.nextLine();
                        this.activityController.modifyTool(titre,description,url,null,null,null,null,null,id);
                        System.out.println("Modification éffectuée");
                        switchActivityMenu();
                        break;

                    case "3":
                        List<Project> projects = this.activityController.getAllProject();
                        for (Project project: projects) {
                            System.out.println(project.getId() + ": " + project.getTitle());
                        }
                        System.out.println("Choisisez un article à changer en utilisant le id");
                        id = Integer.parseInt(scanner.nextLine());
                        System.out.println("Vous allez vous faire demander d'entrer de nouvelles valeurs dans l'article" +
                                ". S'il y a une valeur que vous ne voulez pas changer, appuyer simplement sur 'Enter' ou " +
                                "entrez 0 pour les chiffre");
                        System.out.println("Entrez le titre");
                        titre = scanner.nextLine();
                        System.out.println("Entrez un résumé");
                        description = scanner.nextLine();
                        this.activityController.modifyProject(titre,description,null,null,null,null,null,id);
                        System.out.println("Modification éffectuée");
                        switchActivityMenu();
                        break;

                }
                switchActivityMenu();
                break;

            case "3":
                System.out.println("Selectionné une activité que vous voulez vous inscrire");
                activityController.printActivities();
                int id = Integer.parseInt(scanner.nextLine());
                activityController.addSub(id, loggedUser);
                System.out.println("Vous êtes maintenant abonné!");
                switchActivityMenu();
                break;

            case "4":
                System.out.println("Que voulez-vous chercher?\n" +
                        "[1] Article\n" +
                        "[2] Outils\n" +
                        "[3] Project");
                choice2 = scanner.nextLine();
                switch (choice2) {
                    case "1":
                        System.out.printf("Entrez le mot clé désiré");
                        String keyword = scanner.nextLine();
                        List<Article> resultArticle = this.activityController.findArticle(keyword);
                        for (Article article: resultArticle) {
                            article.printArticle();
                        }
                        break;

                    case "2":
                        System.out.printf("Entrez le mot clé désiré");
                        keyword = scanner.nextLine();
                        List<Tool> resultTool = this.activityController.findTool(keyword);
                        for (Tool tool: resultTool) {
                            tool.printTool();
                        }
                        break;
                    case "3":
                        System.out.printf("Entrez le mot clé désiré");
                        keyword = scanner.nextLine();
                        List<Project> resultProject = this.activityController.findProject(keyword);
                        for (Project project: resultProject) {
                            project.printProject();
                        }
                        break;

                }
                switchActivityMenu();
                break;

            case "5":
                switchMainMenu();
                break;

            case "0":
                System.exit(0);
                break;

            default:
                System.out.println("Unexpected value: " + choice);
                switchActivityMenu();


        }
    }

    private void displayActivityPage() {

        System.out.println("----------Activité----------\n" +
                "[1] Créer un activité\n" +
                "[2] Modification d'une de mes activités\n" +
                "[3] Se souscrire à une activité\n" +
                "[4] Chercher une activité\n" +
                "[5] Retour au menu principal\n" +
                "[0] Quitter l'application");

    }


    public void displayMenuPage(){
        System.out.println(" .----------------.  .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------. \n" +
                "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n" +
                "| |  _______     | || |     ____     | || | _____  _____ | || | ____  _____  | || |  ________    | || |  _________   | || |      __      | || |   ______     | || |   _____      | || |  _________   | |\n" +
                "| | |_   __ \\    | || |   .'    `.   | || ||_   _||_   _|| || ||_   \\|_   _| | || | |_   ___ `.  | || | |  _   _  |  | || |     /  \\     | || |  |_   _ \\    | || |  |_   _|     | || | |_   ___  |  | |\n" +
                "| |   | |__) |   | || |  /  .--.  \\  | || |  | |    | |  | || |  |   \\ | |   | || |   | |   `. \\ | || | |_/ | | \\_|  | || |    / /\\ \\    | || |    | |_) |   | || |    | |       | || |   | |_  \\_|  | |\n" +
                "| |   |  __ /    | || |  | |    | |  | || |  | '    ' |  | || |  | |\\ \\| |   | || |   | |    | | | || |     | |      | || |   / ____ \\   | || |    |  __'.   | || |    | |   _   | || |   |  _|  _   | |\n" +
                "| |  _| |  \\ \\_  | || |  \\  `--'  /  | || |   \\ `--' /   | || | _| |_\\   |_  | || |  _| |___.' / | || |    _| |_     | || | _/ /    \\ \\_ | || |   _| |__) |  | || |   _| |__/ |  | || |  _| |___/ |  | |\n" +
                "| | |____| |___| | || |   `.____.'   | || |    `.__.'    | || ||_____|\\____| | || | |________.'  | || |   |_____|    | || ||____|  |____|| || |  |_______/   | || |  |________|  | || | |_________|  | |\n" +
                "| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |\n" +
                "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n" +
                " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' ");
        System.out.println(
                "[1] Mon profil\n" +
                "[2] Membre\n" +
                "[3] Activité\n" +
                "[4] Intérêt\n" +
                "[5] Déconnexion\n" +
                "[0] Quitter l'application" +
                "\nVeuillez choisir une option\n");
    }

    public void displayLoginPage(){
        System.out.println("----------Login----------\n[1] Authentication\n[2] Inscription\n[0] Quitter l'application");
    }

    public void displayInterestPage(){
        System.out.println("----------Interêts----------\n" +
                "[1] Ajouté un intérêt\n" +
                "[2] Modifier un intérêt\n" +
                "[3] Supprimer un intérêt\n" +
                "[4] Retourner au menu principal\n" +
                "[0] Quitter l'application");
    }

    public void displayProjectPage(){
        System.out.println("----------Projets----------\n" +
                "[1] Projets publics\n" +
                "[2] Chercher un projet\n" +
                "[3] Retourner au menu principal\n" +
                "[0] Quitter l'application");
    }

    public void displayUserPage(){
        System.out.println("----------Membres----------\n" +
                "Veuillez choisir une option\n" +
                "[1] Afficher la liste des membre\n" +
                "[2] Chercher un membre\n" +
                "[3] Retourner au menu principal\n" +
                "[0] Quitter l'application");

    }

    public void displayProfilePage(){
        System.out.println("----------Profile----------\nNom et Prénom: " + this.loggedUser.getFname() + " " +
            this.loggedUser.getLname()+"\nCourriel: " + this.loggedUser.getEmail() + "" +
                "\n[1] Modifier mes informations personnelles\n" +
                "[2] Voir mes notifications\n" +
                "[3] Retourner au menu principal\n" +
                "\n[0] Quitter l'application");
    }



}
