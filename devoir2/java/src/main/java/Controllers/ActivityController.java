package main.java.Controllers;

import main.java.Entity.*;
import main.java.enums.ArticleStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe pour le control des activites
 * @author Gabriel Menard
 * @version 1.0
 */
public class ActivityController {

    private List<Activity> activities;

    /**
     * Constructeur de la classe
     * @param activities Liste d'activite passee en argument dans le constructeur
     */

    public ActivityController(List<Activity> activities) {
        this.activities = activities;
    }

    /**
     * Methode pour creer un nouvel article
     * @param title Chaine de caractere contenant le titre de l'article a creer
     * @param summary Chaine de caractere contenant le resume de l'article en question
     * @param url Chaine de caractere contenant l'URL ou l'on peut retrouver l'article
     * @param publicationDate Instance de Date représentant la date de publication de l'article
     * @param collaborators Liste d'utilisateurs representant les collaborateurs sur les articles
     * @param authors Liste d'utilisateurs representant les auteurs de l'article
     * @param keywords Liste de mots clés par rappot aux articles
     * @param interests Liste des interets lies à l'article
     * @param status Statut de l'article
     * @param id Identifiant numérique representant l'article
     * @return Renvoit un booleen pour confirmer la creation de l'article
     */
    public boolean createArticle(String title, String summary, String url, Date publicationDate, List<User> collaborators, List<User> authors,
                                 List<String> keywords, List<Interest> interests, ArticleStatus status, int id) {
        this.activities.add(new Article(summary, publicationDate, url, status, authors, collaborators, keywords, interests, title, id));
        return true;
    }

    /**
     * Methode pour modifier un article
     * @param title Chaine de caractere contenant le titre de l'article a modifier
     * @param summary Chaine de caractere contenant le nouveau resume de l'article en question
     * @param url Chaine de caractere contenant la nouvelle URL ou l'on peut retrouver l'article
     * @param publicationDate Instance de Date représentant la date de publication de l'article
     * @param collaborators Liste d'utilisateurs representant les collaborateurs sur les articles
     * @param authors Liste d'utilisateurs representant les auteurs de l'article
     * @param keywords Liste de mots clés par rappot aux articles
     * @param interests Liste des interets lies à l'article
     * @param status Statut de l'article
     * @param id Identifiant numérique representant l'article
     * @return Renvoit un booleen pour confirmer la creation de l'article
     */

    public boolean modifyArticle(String title, String summary, String url, Date publicationDate, List<User> collaborators, List<User> authors,
                                 List<String> keywords, List<Interest> interests, ArticleStatus status, int id) {

        for (Activity activity: this.activities) {
            if (activity instanceof Article && activity.getId() == id ) {
                if (!title.equals("")) {
                    activity.setTitle(title);
                }
                if (!summary.equals("")) {
                    ((Article) activity).setSummary(summary);
                }
                if (!url.equals("")) {
                    ((Article) activity).setArticleUrl(url);
                }
                if (publicationDate != null) {
                    ((Article) activity).setPublicationDate(publicationDate);
                }
                if (collaborators != null) {
                    ((Article) activity).setCollaborators(collaborators);
                }
                if (authors != null) {
                    ((Article) activity).setAuthors(authors);
                }
                if (keywords != null) {
                    ((Article) activity).setKeywords(keywords);
                }
                if (interests != null) {
                    activity.setInterests(interests);
                }
                if (interests != null) {
                    ((Article) activity).setStatus(status);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode pour modifier un outil
     * @param title Chaine de caractere contenant le titre de l'outil a modifier
     * @param description Chaine de caractere contenant la description de l'outil a modifier
     * @param url Chaine de caractère contenant l'URL de l'outil à modifier
     * @param responsable Instance d'utilisateur responsable de l'outil
     * @param collaborators Liste d'utilisateurs etant des collaborateurs par rapport à l'outil
     * @param linkedArticle Liste d'articles lies à l'outil
     * @param keywords Liste de chaines de caractères liees à l'outil
     * @param interests Liste d'intérets lies à l'outil
     * @param id Identifiant numérique par rapport à l'outil
     * @return Retourne un booleen confirmant ou non la modification
     */

    public boolean modifyTool(String title, String description, String url, User responsable, List<User> collaborators, List<Article> linkedArticle,
                                 List<String> keywords, List<Interest> interests, int id) {

        for (Activity activity: this.activities) {
            if (activity instanceof Tool && activity.getId() == id ) {
                if (!title.equals("")) {
                    activity.setTitle(title);
                }
                if (!description.equals("")) {
                    ((Tool) activity).setDescription(description);
                }
                if (!url.equals("")) {
                    ((Tool) activity).setToolUrl(url);
                }
                if (responsable != null) {
                    ((Tool) activity).setResponsable(responsable);
                }
                if (collaborators != null) {
                    ((Tool) activity).setCollaborators(collaborators);
                }
                if (linkedArticle != null) {
                    ((Tool) activity).setLinkedArticle(linkedArticle);
                }
                if (keywords != null) {
                    ((Tool) activity).setKeywords(keywords);
                }
                if (interests != null) {
                    activity.setInterests(interests);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode pour modifier un projet
     * @param title Chaine de caractere contenant le titre du projet a modifier
     * @param description Chaine de caractere contenant la description du projet a modifier
     * @param responsable Instance d'utilisateur responsable du projet
     * @param startDate Instance de Date représentant le début du projet
     * @param finishDate Instance de Date representant la fin du projet
     * @param keywords Liste de chaines de caractères liees au projet
     * @param interests Liste d'intérets lies au projet
     * @param id Identifiant numérique par rapport au projet
     * @return Retourne un booleen confirmant ou non la modification
     */

    public boolean modifyProject(String title, String description, Professor responsable, Date startDate, Date finishDate,
                              List<String> keywords, List<Interest> interests, int id) {

        for (Activity activity: this.activities) {
            if (activity instanceof Project && activity.getId() == id ) {
                if (!title.equals("")) {
                    activity.setTitle(title);
                }
                if (!description.equals("")) {
                    ((Project) activity).setDescription(description);
                }
                if (responsable != null) {
                    ((Project) activity).setResponsable(responsable);
                }
                if (startDate != null) {
                    ((Project) activity).setStartDate(startDate);
                }
                if (finishDate != null) {
                    ((Project) activity).setFinishDate(finishDate);
                }
                if (keywords != null) {
                    ((Project) activity).setKeywords(keywords);
                }
                if (interests != null) {
                    activity.setInterests(interests);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode pour ajouter un souscripteur à une activité
     * @param id Identifiant utilisé pour la vérification
     * @param sub Instance d'utilisateur à souscrire
     * @return Renvoit un booleen pour la vérification
     */
    public boolean addSub(int id, User sub) {
        for (Activity activity: this. activities) {
            if (id == activity.getId()) {
                activity.addSub(sub);
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode pour supprimer un souscripteur à une activité
     * @param id Identifiant utilisé pour la vérification
     * @param sub Instance d'utilisateur à désouscrire
     * @return Renvoit un booleen pour la vérification
     */
    public boolean removeSub(int id, User sub) {
        for (Activity activity: this. activities) {
            if (id == activity.getId()) {
                activity.removeSub(sub);
                return true;
            }
        }
        return false;
    }

    /**
     * Getter pour ressortir la liste des activites lies à un interet
     * @param interest Instance d'interet à partir duquel on veut ressortir les interets
     * @return Renvoit la liste des activites lies à l'interet en parametre
     */
    public List<Activity> getActiviesByInterest(Interest interest) {

        List<Activity> result = new ArrayList<>();

        for (Activity activity: this.activities) {
            for (Interest interest1: activity.getInterests()) {
                if (interest1.equals(interest)) {
                    result.add(activity);
                }
            }
        }
        return result;
    }

    /**
     * Methode pour rechercher une liste d'article par rapport aux mots clés
     * @param searchWord Chaine de caractère représentant le mot clé sur la base de la recherche
     * @return Renvoit un tableau contenant la liste d'article
     */
    public List<Article> findArticle(String searchWord) {
        List<Article> result = new ArrayList<>();
        for (Activity activity: this.activities) {
            if (activity instanceof Article) {
                for (String word: activity.getKeywords()) {
                    if (searchWord.equals(word)) {
                        result.add((Article) activity);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Methode pour rechercher une liste de projet par rapport aux mots clés
     * @param searchWord Chaine de caractère représentant le mot clé sur la base de la recherche
     * @return Renvoit un tableau contenant la liste de projets
     */
    public List<Project> findProject(String searchWord) {
        List<Project> result = new ArrayList<>();
        for (Activity activity: this.activities) {
            if (activity instanceof Project) {
                for (String word: activity.getKeywords()) {
                    if (searchWord.equals(word)) {
                        result.add((Project) activity);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Methode pour rechercher une liste d'outil par rapport aux mots clés
     * @param searchWord Chaine de caractère représentant le mot clé sur la base de la recherche
     * @return Renvoit un tableau contenant la liste d'outils
     */
    public List<Tool> findTool(String searchWord) {
        List<Tool> result = new ArrayList<>();
        for (Activity activity: this.activities) {
            if (activity instanceof Tool) {
                for (String word: activity.getKeywords()) {
                    if (searchWord.equals(word)) {
                        result.add((Tool) activity);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Getter pour renvoyer le nombre d'activites
     * @return Retourne un entier contenant le nombre d'activités
     */
    public int getSize() {
        return this.activities.size();
    }

    /**
     * Méthode pour afficher l'ensemble des activités
     */
    public void printActivities() {
        for (Activity activity: this.activities) {
            System.out.println(activity.getId() + ": "+ activity.getTitle());
        }
    }

    /**
     * Getter pour renvoyer la liste de tous les articles
     * @return Renvoit une liste contenant toutes les instances d'article
     */
    public List<Article> getAllArticle() {
        List<Article> result = new ArrayList<>();
        for (Activity activity: this.activities) {
            if (activity instanceof Article) {
                result.add((Article) activity);
            }
        }
        return result;
    }

    /**
     * Getter pour renvoyer la liste de tous les outils
     * @return Renvoit une liste contenant toutes les instances d'outil
     */
    public List<Tool> getAllTool() {
        List<Tool> result = new ArrayList<>();
        for (Activity activity: this.activities) {
            if (activity instanceof Tool) {
                result.add((Tool) activity);
            }
        }
        return result;
    }

    /**
     * Getter pour renvoyer la liste de tous les projets
     * @return Renvoit une liste contenant toutes les instances de projet
     */
    public List<Project> getAllProject() {
        List<Project> result = new ArrayList<>();
        for (Activity activity: this.activities) {
            if (activity instanceof Project) {
                result.add((Project) activity);
            }
        }
        return result;
    }


}
