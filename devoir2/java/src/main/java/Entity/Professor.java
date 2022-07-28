package main.java.Entity;

import main.java.enums.UserTitle;

/**
 * Classe pour les instances de professeur et qui est une sous classe de la classe des utilisateurs User
 * @author Gabriel Menard
 * @version 1.0
 */
public class Professor extends User{

    /**
     * Contructeur de la classe
     * @param id Identifiant numérique de l'instance de Professeur
     * @param fname Chaine de caractère contenant le premier nom du Professeur
     * @param lname Chaine de caractère contenant le dernier nom du professeur
     * @param interest Liste regroupant les intérets auquels sont liés le profésseur
     * @param notifications Liste de chaine de caractères des notifications du Professeur
     * @param webPageURL Chaine de caractère contenant un site lié au Professeur
     * @param title Chaine de caractère contenant le Titre du professeur
     * @param email Chaine de caractère contenant l'adresse mail du Professeur
     */
    public Professor(int id, String fname, String lname, Interest[] interest, String[] notifications, String webPageURL,
                 UserTitle title, String email){
        super(id, fname, lname, interest, notifications, webPageURL, title, email);
    }


}
