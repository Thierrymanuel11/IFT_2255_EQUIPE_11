package main.java.MainApp;
import main.java.Controllers.ActivityController;
import main.java.Controllers.InterestController;
import main.java.Controllers.UserController;
import main.java.Entity.*;
import main.java.enums.AccountRole;
import main.java.enums.AccountStatus;
import main.java.enums.UserTitle;
import main.java.enums.ArticleStatus;

import java.lang.invoke.SwitchPoint;
import java.lang.reflect.Array;
import java.util.*;

public class Menu {

    User loggedUser;
    int pageIndex = 0;

    UserController userController;
    InterestController interestController;
    ActivityController activityController;

    List<Account> accounts;

    public Menu(){


        this.loggedUser = new User(3, "Louis-Édouard", "Lafontant", null, null,
                "https://ceduni.github.io/udem-ift2255/devoirs/dm2.html", UserTitle.Master, "louis.edouard.lafontant@umontreal.ca");

        List<Interest> interests = new ArrayList(Arrays.asList(
                new Interest("programation", "Tout ce qui est lié à la programmation"),
                new Interest("innovation", "Tout ce qui est lié à l'innocation")
        ));

        Interest interest1 = new Interest("programation", "Tout ce qui est lié à la programmation");
        Interest interest2 = new Interest("innovation", "Tout ce qui est lié à l'innocation");
        Interest interest3 = new Interest("recherche", "Anvencements technologique");
        Interest interest4 = new Interest("hardware", "relié au développement de nouveau hardware");
        Interest interest5 = new Interest("système", "focus sur le fonctionnement des système");

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

        User membre1 = new User(9,
                "Gabriel",
                "Ménard",
                new ArrayList<Interest>(Arrays.asList(
                        interest2,
                        interest3
                )),
                new ArrayList<String>(Arrays.asList(
                        "nouvel article disponible"
                )),
                "https://geodes.iro.umontreal.ca/",
                UserTitle.Master,
                "gabriel.menard@umontreal.ca");

        User membre2 = new User(10,
                "Thierry Manuel",
                "Tchoumken Djeumen",
                new ArrayList<Interest>(Arrays.asList(
                        interest2,
                        interest4
                )),
                new ArrayList<String>(Arrays.asList(
                        "Bienvenue sur RoundTable!",
                        "nouvel article disponible"
                )),
                "https://geodes.iro.umontreal.ca/",
                UserTitle.PostDoc,
                "thierry.manuel.tchoumkeu.djeumen@umontreal.ca");

        User membre3 = new User(11,
                "Patrick",
                "Lanoie",
                new ArrayList<Interest>(Arrays.asList(
                        interest2,
                        interest3
                )),
                new ArrayList<String>(Arrays.asList(
                        "nouvel article disponible"
                )),
                "https://geodes.iro.umontreal.ca/",
                UserTitle.PHD,
                "patrick.lanoie@umontreal.ca");

        User membre4 = new User(12,
                "Fannie",
                "Filion-Bienvenue",
                new ArrayList<Interest>(Arrays.asList(
                        interest2,
                        interest1
                )),
                new ArrayList<String>(Arrays.asList(
                        "nouvel article disponible"
                )),
                "https://geodes.iro.umontreal.ca/",
                UserTitle.Master,
                "fannie.filion-bienvenue@umontreal.ca");

        User membre5 = new User(13,
                "Luke",
                "Skywalker",
                new ArrayList<Interest>(Arrays.asList(
                        interest2,
                        interest3,
                        interest4,
                        interest1
                )),
                new ArrayList<String>(Arrays.asList(
                        "nouvel article disponible"
                )),
                "https://geodes.iro.umontreal.ca/",
                UserTitle.Master,
                "luke.skywalker@umontreal.ca");

        this.accounts = new ArrayList<>(Arrays.asList(
                new Account("michalis.famelis@umontreal.ca","test", AccountStatus.VALID, michalis, AccountRole.Professor),
                new Account("eugene.syriani@umontreal.ca","test", AccountStatus.VALID, eugene, AccountRole.Professor),
                new Account("houari.sahraoui@umontreal.ca","test", AccountStatus.VALID, houari, AccountRole.Professor),
                new Account("louis.edouard.lafontant@umontreal.ca", "louis", AccountStatus.VALID, istvanUser, AccountRole.Admin),
                new Account("istvan.david@umontreal.ca", "istvan", AccountStatus.VALID, louisUser, AccountRole.Admin),
                new Account("gabriel.menard@umontreal.ca", "gabriel", AccountStatus.SUSPENDED, membre1, AccountRole.Member),
                new Account("thierry.manuel.tchoumkeu.djeumen@umontreal.ca", "thierry", AccountStatus.PENDING, membre2, AccountRole.Member),
                new Account("patrick.lanoie@umontreal.ca", "patrick", AccountStatus.PENDING, membre3, AccountRole.Member),
                new Account("fannie.filion-bienvenue@umontreal.ca", "fannie", AccountStatus.VALID, membre4, AccountRole.Member),
                new Account("luke.skywalker@umontreal.ca", "luke", AccountStatus.VALID, membre5, AccountRole.Member)
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
                new Article(
                        "The objective of pre-trained language models is to learn contextual representations of textual data. Pre-trained language models have become mainstream in natural language processing and code modeling. Using probes, a technique to study the linguistic properties of hidden vector spaces, previous works have shown that these pre-trained language models encode simple linguistic properties in their hidden representations. However, none of the previous work assessed whether these models encode the whole grammatical structure of a programming language. In this paper, we prove the existence of a \\textit{syntactic subspace}, lying in the hidden representations of pre-trained language models, which contain the syntactic information of the programming language. We show that this subspace can be extracted from the models' representations and define a novel probing method, the AST-Probe, that enables recovering the whole abstract syntax tree (AST) of an input code snippet. In our experimentations, we show that this syntactic subspace exists in five state-of-the-art pre-trained language models. In addition, we highlight that the middle layers of the models are the ones that encode most of the AST information. Finally, we estimate the optimal size of this syntactic subspace and show that its dimension is substantially lower than those of the models' representation spaces. This suggests that pre-trained language models use a small part of their representation spaces to encode syntactic information of the programming languages.",
                        new Date(2022, 6 , 23),
                        "https://scholar.google.be/citations?view_op=view_citation&hl=en&user=6tBH8MAAAAAJ&sortby=pubdate&citation_for_view=6tBH8MAAAAAJ:wUn16MOA3RoC",
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
                                "language models",
                                "pre-trained"
                        )),
                        new ArrayList<Interest>(Arrays.asList(
                                interest2,
                                interest3
                        )),
                        "AST-Probe: Recovering abstract syntax trees from hidden representations of pre-trained language models",
                        1
                ),
                new Article(
                        "Software modeling activities typically involve a tedious and time-consuming effort by specially trained personnel. This lack of automation hampers the adoption of model-driven engineering (MDE). Nevertheless, in the recent years, much research work has been dedicated to learn executable MDE artifacts instead of writing them manually. In this context, mono- and multi-objective genetic programming (GP) has proven being an efficient and reliable method to derive automation knowledge by using, as training data, a set of examples representing the expected behavior of an artifact. Generally, conformance to the training example set is the main objective to lead the learning process. Yet, single fitness peak, or local optima deadlock, a common challenge in GP, hinders the application of GP to MDE. In this paper, we propose a strategy to promote populations’ social diversity during the GP learning process.",
                        new Date(2022, 6 , 1),
                        "https://scholar.google.be/citations?view_op=view_citation&hl=en&user=6tBH8MAAAAAJ&sortby=pubdate&citation_for_view=6tBH8MAAAAAJ:nqdriD65xNoC",
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
                                "article 3",
                                "software"
                        )),
                        new ArrayList<Interest>(Arrays.asList(
                                interest1,
                                interest4,
                                interest5
                        )),
                        "Promoting social diversity for the automated learning of complex MDE artifacts",
                        2
                ),
                new Article(
                        "The design of conceptually sound metamodels that embody proper semantics in relation to the application domain is particularly tedious in model-driven engineering. As metamodels define complex relationships between domain concepts, it is crucial for a modeler to define these concepts thoroughly while being consistent with respect to the application domain. We propose an approach to assist a modeler in the design of metamodel by recommending relevant domain concepts in several modeling scenarios. Our approach does not require knowledge from the domain or to hand-design completion rules. Instead, we design a fully data-driven approach using a deep learning model that is able to abstract domain concepts by learning from both structural and lexical metamodel properties in a corpus of thousands of independent metamodels.",
                        new Date(2022, 6 , 1),
                        "https://scholar.google.be/citations?view_op=view_citation&hl=en&user=6tBH8MAAAAAJ&sortby=pubdate&citation_for_view=6tBH8MAAAAAJ:NMlhSUseqAsC",
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
                                "design",
                                "article 4",
                                "metamodels"
                        )),
                        new ArrayList<Interest>(Arrays.asList(
                                interest1,
                                interest2,
                                interest3
                        )),
                        "Recommending metamodel concepts during modeling activities with pre-trained language models",
                        3
                ),
                new Article(
                        "Textual editors are omnipresent in all software tools. Editors provide basic features, such as copy-pasting and searching, or more advanced features, such as error checking and text completion. Current technologies in model-driven engineering can automatically generate textual editors to manipulate domain-specific languages (DSLs). However, the customization and addition of new features to these editors is often limited to changing the internal structure and behavior. In this paper, we explore a new generation of self-descriptive textual editors for DSLs, allowing full configuration of their structure and behavior in a convenient formalism, rather than in source code. We demonstrate the feasibility of the approach by providing a prototype implementation and applying it in two domain-specific modeling scenarios, including one in architecture modeling.",
                        new Date(2021, 11 , 6),
                        "https://scholar.google.be/citations?view_op=view_citation&hl=en&user=6tBH8MAAAAAJ&sortby=pubdate&citation_for_view=6tBH8MAAAAAJ:Og1tA8FjbJAC",
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
                                "generation",
                                "article 5",
                                "editors"
                        )),
                        interests,
                        "Generation of Custom Textual Model Editors",
                        4
                ),
                new Tool(
                        "lowkey is a low-level and transparent framework for real-time collaborative framework for multi-level and multi-view modeling. At the bottom layer of the architecture of lowkey, conflict-free replicated data types (CRDT) take care of preventing inconsistencies before they happen. The physical metamodel built on top of these data types allows for defining arbitrary numbers of linguistic models, which are in a type-instance relationship with each other. The framework is available as a Python implementation.",
                        "2.1",
                        "https://github.com/geodes-sms/lowkey",
                        michalis,
                        null,
                        null,
                        new ArrayList<String>(Arrays.asList(
                                "lowkey",
                                "tool 1"
                        )),
                        new ArrayList<Interest>(Arrays.asList(
                                interest1,
                                interest3,
                                interest4
                        )),
                        "lowkey",
                        5

                ),
                new Tool(
                        "AToMPM (A Tool for Multi-Paradigm Modeling) is the modeling tool we are developing at the University of Montreal in collaboration with McGill University, the University of Antwerp, and the University of Alabama. AToMPM provides facilities for generating web-based, domain-specific modeling tools tools that run on the cloud.",
                        "0.9.9",
                        "https://atompm.github.io/",
                        michalis,
                        null,
                        null,
                        new ArrayList<String>(Arrays.asList(
                                "atompm",
                                "tool 2"
                        )),
                        new ArrayList<Interest>(Arrays.asList(
                                interest1,
                                interest3,
                                interest2
                        )),
                        "AToMPM",
                        6

                ),
                new Tool(
                        "AToMPM (A Tool for Multi-Paradigm Modeling) is the modeling tool we are developing at the University of Montreal in collaboration with McGill University, the University of Antwerp, and the University of Alabama. AToMPM provides facilities for generating web-based, domain-specific modeling tools tools that run on the cloud.",
                        "1.5",
                        "https://github.com/geodes-sms/gentleman",
                        michalis,
                        null,
                        new ArrayList<User>(Arrays.asList(
                                louisUser
                        )),
                        new ArrayList<String>(Arrays.asList(
                                "gentlemant",
                                "tool 2"
                        )),
                        new ArrayList<Interest>(Arrays.asList(
                                interest1,
                                interest2
                        )),
                        "Gentleman",
                        7

                ),
                new Tool(
                        "Conducting a systematic review involves many steps over a long period of time, and it is typically repetitive and labor-intensive. ReLiS (Revue Littéraire Systématique - Systematic Literature Review) can considerably reduce the effort of many of these steps by providing essential software support to reviewers. ReLiS supports planning, conducting and reportig a review, while following a previously defined process, which can be automatically adapted as the project evolves.",
                        "1.7",
                        "http://relis.iro.umontreal.ca/auth.html",
                        michalis,
                        null,
                        new ArrayList<User>(Arrays.asList(
                                louisUser
                        )),
                        new ArrayList<String>(Arrays.asList(
                                "gentleman",
                                "tool 4"
                        )),
                        new ArrayList<Interest>(Arrays.asList(
                                interest1,
                                interest2
                        )),
                        "ReLis",
                        8

                ),
                new Tool(
                        "BiBler is a software for managing references to scientific articles using BibTeX. Not only is it a fully functional software, the tool has been entirely modeled and synthesized in Python. It is used for educational purposes in order to understand how to generate a complete application from UML models in an agile and test-driven environment.",
                        "1.4.3",
                        "https://github.com/geodes-sms/bibler",
                        michalis,
                        null,
                        new ArrayList<User>(Arrays.asList(
                                louisUser
                        )),
                        new ArrayList<String>(Arrays.asList(
                                "biblier",
                                "tool 5"
                        )),
                        new ArrayList<Interest>(Arrays.asList(
                                interest1,
                                interest2,
                                interest5
                        )),
                        "ReLis",
                        9

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
                        10
                ),
                new Project(
                        "Relations internationales et francophones Quebec-Bavaria\n" +
                                "In partnership with Fortiss.",
                        new Date(2018, 1,2),
                        new Date(2029, 6,25),
                        (Professor) michalis,
                        new ArrayList<String>(Arrays.asList(
                                "management",
                                "project 1",
                                "production"
                        )),
                        new ArrayList<Interest>(Arrays.asList(
                                interest1,
                                interest2,
                                interest3
                        )),
                        "Management of smart production lines",
                        11
                ),
                new Project(
                        "Private philanthropic fund",
                        new Date(2019, 1,1),
                        new Date(2024, 1,1),
                        (Professor) michalis,
                        new ArrayList<String>(Arrays.asList(
                                "ia",
                                "project 2"
                        )),
                        new ArrayList<Interest>(Arrays.asList(
                                interest1,
                                interest2,
                                interest5
                        )),
                        "\t\n" +
                                "Artificial intelligence for and by software engineering",
                        12
                ),
                new Project(
                        "IVADO Postdoctoral Research Funding",
                        new Date(2021, 1,1),
                        new Date(2024, 6,1),
                        (Professor) michalis,
                        new ArrayList<String>(Arrays.asList(
                                "test",
                                "project 3"
                        )),
                        new ArrayList<Interest>(Arrays.asList(
                                interest1
                        )),
                        "Inference of Simulation Models in Digital Twins by Reinforcement Learning",
                        13
                ),
                new Project(
                        "NSERC Discovery Grant",
                        new Date(2019, 1,2),
                        new Date(2025, 6,10),
                        (Professor) michalis,
                        new ArrayList<String>(Arrays.asList(
                                "knowledge",
                                "project 4"
                        )),
                        new ArrayList<Interest>(Arrays.asList(
                                interest1,
                                interest3
                        )),
                        "From examples to knowledge to software engineering support and automation",
                        14
                )
        ));

        userController = new UserController(users, accounts);
        interestController = new InterestController(interests);
        activityController = new ActivityController(activities);

    }

    public void start(){

        switchLoginMenu();

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
                switchLoginMenu();
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
                List<String> notifications = this.loggedUser.getNotifications();
                System.out.println("----- Notifications -----");
                for (String notification : notifications) {
                    System.out.println(notification);
                }
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
                AccountStatus status = null;
                for (Account account: this.accounts) {
                    if (account.getEmail().equals(email)) {
                         status = account.getStatus();
                    }
                }
                User validLogin = userController.login(email, password, status);
                if (validLogin != null) {
                    loggedUser = validLogin;
                    switchMainMenu();
                } else {
                    System.out.println("Email invalide, mot de passe invalide ou statut invalid");
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
