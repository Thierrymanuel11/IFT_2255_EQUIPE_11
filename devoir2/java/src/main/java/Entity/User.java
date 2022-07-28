package main.java.Entity;

import main.java.enums.UserTitle;

/** Cette classe est celle pour les instances d'utilisateurs que l'on va créer dans l'application
 * @author Gabriel Menard
 * @version 1.0
 */
public class User {

    private int id;
    String fname;
    String lname;
    Interest[] interest;
    String[] notifications;
    String webPageURL;
    UserTitle title;
    String email;

    /**
     * Constructeur de la classe des utilisateurs
     * @author Gabriel Menard
     * @param id Contien l'identifiant de l'utilisateur
     * @param fname Contient le premier nom de l'utilisateur
     * @param lname Contient le dernier nom de l'utilisateur
     * @param interest Tableau contenant les intérets liés à cet utilisateur
     * @param notifications Tableau contenant les norifications que peut avoir cet utilisateur
     * @param webPageURL Contient l'URL d'un site de l'utilisateur en question
     * @param title Contient le titre de l'utilisateur
     * @param email Contient l'adresse mail de l'utilisateur
     */
    public User(int id, String fname, String lname, Interest[] interest, String[] notifications, String webPageURL,
                UserTitle title, String email){

        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.interest = interest;
        this.notifications = notifications;
        this.webPageURL = webPageURL;
        this.title = title;
        this.email = email;

    }

    /**
     * Permet de récupérer le tableau des notifications de l'utilisateur
     * @return Retourne un tableau contenant l'ensemble des notifications de l'utilisateur
     */

    public String[] getNotifications() {
        return notifications;
    }

    /**
     * Méthode permettant de renvoyer un "prettyPrinter" des informations de l'utilisateur
     * @return Retourne une chaine de caractères contenant les informations de l'utilisateur
     */
    public String print(){
        return "-----\nPrénom: " + this.fname +"\nNom: " + this.lname + "\nURL: " + this.webPageURL
                + "\nTitre: " + this.title + "\n-----";
    }

    /**
     * Getter pour le premier nom de l'utilisateur
     * @return Renvoit un String contenant le premier nom de l'utilisateur
     */
    public String getFname() {
        return fname;
    }

    /**
     * Getter pour le dernier nom de l'utilisateur
     * @return Renvoit un String contenant le dernier nom de l'utilisateur
     */
    public String getLname() {
        return lname;
    }

    /**
     * Getter pour l'adresse mail de l'utilisateur
     * @return Renvoit un String contenant l'adresse Mail de l'utilisateur
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Getter pour la liste des intérets de l'utilisateur
     * @return Renvoit une liste contenant les intérets liés à un utilisateur
     */
    public Interest[] getInterest() {
        return interest;
    }

    /**
     * Getter pour le titre de l'utilisateur
     * @return Renvoit l'instance de Titre conrrespondant à l'utilisateur
     */
    public UserTitle getTitle() {
        return title;
    }
}
