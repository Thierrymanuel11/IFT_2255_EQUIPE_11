package main.java.Entity;

import main.java.enums.ArticleStatus;

import java.util.Date;
import java.util.List;

/**
 * Classe pour gérer les instances d'article
 * @author Gabriel Menard
 * @version 1.0
 */

public class Article extends Activity{

    String summary;
    Date publicationDate;
    String articleUrl;
    ArticleStatus status;
    List<User> authors;
    List<User> collaborators;

    /**
     * Contructeur de la classe
     * @param summary Chaine de caractère contenant le résumé de l'article
     * @param publicationDate Instance de Date présnetant la date de publication de l'article
     * @param articleUrl Chaine de caractère contenant l'URL sur lequel on peut retrouver l'aticle
     * @param status Instance définissant le statut de l'article
     * @param authors Liste d'utilisateurs étants les auteurs de l'article
     * @param collaborators Liste des uttilisateurs étants des collaborateurs sur l'aticle
     * @param keywords Liste de caractère étants des mots-clés par rapport à l'article
     * @param interests Liste des intérets liés à l'article
     * @param title Chaine de caractère contenant le titre de l'article
     * @param id Identifiant numérique de l'article
     */
    public Article(String summary, Date publicationDate, String articleUrl, ArticleStatus status,
                   List<User> authors, List<User> collaborators, List<String> keywords,
                   List<Interest> interests, String title, int id) {
        super(interests, title, id, keywords);
        this.summary = summary;
        this.publicationDate = publicationDate;
        this.articleUrl = articleUrl;
        this.status = status;
        this.authors = authors;
        this.collaborators = collaborators;

    }

    /**
     * Setter pour l'URL de l'article
     * @param articleUrl Chaine de caractère contenant la nouvelle URL à désigner
     */

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    /**
     * Setter pour le résumé de l'article
     * @param summary Chaine de caractère contenant le résumé de l'article
     */

    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Setter pour la date de publication de l'article
     * @param publicationDate Instance de Date représentant la date de publication à assigner
     */
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * Setter pour le statut de l'article
     * @param status Instance à assigner pour le statut de l'article
     */

    public void setStatus(ArticleStatus status) {
        this.status = status;
    }

    /**
     * Setter pour la liste des auteurs de l'article
     * @param authors Liste d'utilisateur à assigner représentant les auteurs de l'article
     */
    public void setAuthors(List<User> authors) {
        this.authors = authors;
    }

    /**
     * Setter pour la liste des collaborateurs sur l'article
     * @param collaborators Liste d'utilisateurs représentant les collaborateurs sur l'article
     */
    public void setCollaborators(List<User> collaborators) {
        this.collaborators = collaborators;
    }

    /**
     * Méthode pour afficher la description détaillée d'un article
     */
    public void printArticle() {
        System.out.println("----------");
        System.out.println("id: " + this.getId());
        System.out.println("Titre: " + this.getTitle());
        System.out.println("Résumé: " + this.summary);
        System.out.println("URL: " + this.articleUrl);
        System.out.println("Date de publication: " + this.publicationDate);
        System.out.println("Status: " + this.status);
    }

}
