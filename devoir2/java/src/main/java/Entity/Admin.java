package main.java.Entity;

import main.java.enums.UserTitle;

/**
 * Classe pour gérer les instances d'administrateur de la plateforme
 * @author Gabriel Menard
 * @version 1.0
 */
public class Admin extends User {

    /**
     * Constructeur de la classe
     * @param id Identifiant numérique de l'instance de l'administrateur
     * @param fname Chaine de caractère contenant le premier nom de l'administrateur
     * @param lname Chaine de caractère contenant le dernier nom du professeur
     * @param interest Liste regroupant les intérets auquels sont liés l'administrateur
     * @param notifications Liste de chaine de caractères des notifications de l'administrateur
     * @param webPageURL Chaine de caractère contenant un site lié à l'administrateur
     * @param title Chaine de caractère contenant le Titre de l'administrateur
     * @param email Chaine de caractère contenant l'adresse mail de l'administrateur
     */
    public Admin(int id, String fname, String lname, Interest[] interest, String[] notifications, String webPageURL,
                 UserTitle title, String email){
        super(id, fname, lname, interest, notifications, webPageURL, title, email);
    }
}
