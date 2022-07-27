package main.java.Entity;

import main.java.enums.ArticleStatus;

import java.util.Date;
import java.util.List;

public class Article extends Activity{

    String summary;
    Date publicationDate;
    String articleUrl;
    ArticleStatus status;
    List<User> authors;
    List<User> collaborators;

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

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setStatus(ArticleStatus status) {
        this.status = status;
    }

    public void setAuthors(List<User> authors) {
        this.authors = authors;
    }

    public void setCollaborators(List<User> collaborators) {
        this.collaborators = collaborators;
    }

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
