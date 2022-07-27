package main.java.Entity;

import java.util.List;

public class Tool extends Activity{

    String description;
    String version;
    String toolUrl;
    User responsable;
    List<Article> linkedArticle;
    List<User> collaborators;

    public Tool(String description, String version, String toolUrl, User responsable,
                List<Article> linkedArticle, List<User> collaborators,
                List<String> keywords, List<Interest> interests, String title, int id) {

        super(interests, title, id, keywords);
        this.description = description;
        this.version = version;
        this. toolUrl = toolUrl;
        this.responsable = responsable;
        this.linkedArticle = linkedArticle;
        this.collaborators = collaborators;
    }

    public void printTool() {
        System.out.println("----------");
        System.out.println("id: " + this.getId());
        System.out.println("Titre: " + this.getTitle());
        System.out.println("Description: " + this.description);
        System.out.println("Version: " + this.version);
        System.out.println("URL: " + this.toolUrl);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCollaborators(List<User> collaborators) {
        this.collaborators = collaborators;
    }

    public void setResponsable(User responsable) {
        this.responsable = responsable;
    }

    public void setLinkedArticle(List<Article> linkedArticle) {
        this.linkedArticle = linkedArticle;
    }

    public void setToolUrl(String toolUrl) {
        this.toolUrl = toolUrl;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
