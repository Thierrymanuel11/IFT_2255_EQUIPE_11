package main.java.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe pour la gestion des instances d'activité
 * @author Gabriel Menard
 * @version 1.0
 */

public class Activity {

    private List<Interest> interests;
    private String title;
    private int id;
    private List<User> subscribers;
    private List<String> keywords;

    /**
     * Constructeur de la classe
     * @param interests Liste d'intérets liés à 'activité
     * @param title Chaine de caractère contenant le titre de l'activité
     * @param id Identifiant numérique de l'activité
     * @param subscribers Liste d'utilisateur ayant souscris à l'activité
     * @param keywords Liste de termes clés par rapport à l'activité
     */
    public Activity(List<Interest> interests, String title, int id, List<User> subscribers, List<String> keywords) {

        this.interests = interests;
        this.title = title;
        this.id = id;
        this.subscribers = subscribers;
        this.keywords = keywords;

    }

    /**
     * Autre constructeur de la classe
     * @param interests Liste d'intérets liés à 'activité
     * @param title Chaine de caractère contenant le titre de l'activité
     * @param id Identifiant numérique de l'activité
     * @param keywords Liste de termes clés par rapport à l'activité
     */

    public Activity(List<Interest> interests, String title, int id, List<String> keywords) {

        this.interests = interests;
        this.title = title;
        this.id = id;
        this.subscribers = new ArrayList<>();
        this.keywords = keywords;
    }

    /**
     * Getter pour l'ID
     * @return Renvoit l'identifint numérique de l'activité
     */

    public int getId() {
        return id;
    }

    /**
     * Setter pour l'ID
     * @param id Identifiant numérique pour l'activité à instancier
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter pour la liste d'intéret
     * @param interests Liste des intérerts à lier à l'activité
     */

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    /**
     * Setter pour le titre de l'activité
     * @param title Chaine de caractère à assigner pour le titre
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Me=éthode pour ajouter un utilisateur à la liste des souscripteurs à une activité
     * @param user Utilisateur à ajouter à la liste des souscripteurs
     */

    public void addSub(User user) {
        this.subscribers.add(user);
    }

    /**
     * Méthode pour retirer un utilisateur de la liste des souscripteurs à une activité
     * @param user Utilisateur à retirer de la liste des souscripteurs
     */

    public void removeSub(User user) {
        int i = 0;
        for (User sub: this.subscribers) {
            if (sub.equals(user)) {
                this.subscribers.remove(i);
            }
            i++;
        }
    }

    /**
     * Getter pour le titre de l'activité
     * @return Renvoit une chaine de caractère contenant le titre de l'activité
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter pour la liste d'intérets
     * @return Renvoit une liste des intérets liés à l'activité
     */
    public List<Interest> getInterests() {
        return interests;
    }

    /**
     * Getter pour les mots clés
     * @return Renvoit la liste des termes clés liés à l'activité
     */
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * Setter pour les mots clés
     * @param keywords Liste de chaines de caractères contenant les mots clés liés à l'activité
     */
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }


}
