package main.java.Entity;

import main.java.enums.UserTitle;

import java.util.List;
/**
 * Classe membre pour les membres de la plateforme qui est une sous classe de User
 * @author Gabriel Menard
 * @version 1.0
 */

public class Member extends User {

    Professor supervisor;

       /**
     * Constructeur de la classe
     * @param id Identifiant numérique de l'instance de Membre
     * @param fname Chaine de caractère contenant le premier nom du Membre
     * @param lname Chaine de caractère contenant le dernier nom du Membre
     * @param interest Liste regroupant les intérets auquels sont liés le membre
     * @param notifications Liste de chaine de caractères des notifications du membre
     * @param webPageURL Chaine de caractère contenant un site lié au membre
     * @param title Chaine de caractère contenant le Titre du membre
     * @param email Chaine de caractère contenant l'adresse mail du membre
     * @param supervisor Instance de Professeur jouant le role de superviseur du membre
     */
    public Member(int id, String fname, String lname, List<Interest> interest, List<Notification> notifications, String webPageURL,
                  UserTitle title, String email, Professor supervisor){

        super(id, fname, lname, interest, notifications, webPageURL, title, email);
        this.supervisor = supervisor;
    }
}
