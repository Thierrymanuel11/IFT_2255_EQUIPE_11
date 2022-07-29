package main.java.Entity;

import java.util.List;

/**
 * Classe pour gérer les instances d'outils utilisées par les membres de la plateforme
 * @author Gabriel Menard
 * @version 1.0
 */

public class Tool extends Activity{

    String description;
    String version;
    String toolUrl;
    User responsable;
    List<Article> linkedArticle;
    List<User> collaborators;

    /**
     * Constructeur de la classe pour les outils
     * @param description Chaine de caractères contenant la description de l'outil
     * @param version Chaine de caractère contenant la version de l'outil utilisée
     * @param toolUrl Chaine de caractère contenant une URL via laquelle l'outil sera accéssible
     * @param responsable Utilisateur de la plateforme responsable de l'outil en question
     * @param linkedArticle Liste d'articles liés à cet Outil
     * @param collaborators Liste de collaborateur liés à l'outil
     * @param keywords Tableau de chaines de caractère avec des termes liés à l'outil
     * @param interests Liste d'intérets liés à l'outil
     * @param title Chaine de caractère contenant le nom de l'outil de l'outil
     * @param id Identifiant numérique de l'outil
     */

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

    /**
     * Méthode pour afficher la description complète d'un outil
     */
    public void printTool() {
        System.out.println("----------");
        System.out.println("id: " + this.getId());
        System.out.println("Titre: " + this.getTitle());
        System.out.println("Description: " + this.description);
        System.out.println("Version: " + this.version);
        System.out.println("URL: " + this.toolUrl);
    }

    /**
     * Setter pour la description de l'outil
     * @param description Chaine de caractère contenant la nouvelle description aue l'on veut donner à l'outil
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter pour la liste des collaborateur par rapport à l'outil
     * @param collaborators Liste d'utilisateurs liés à l'outil
     */

    public void setCollaborators(List<User> collaborators) {
        this.collaborators = collaborators;
    }

    /**
     * Setter pour assigner le responsable de l'outil en question
     * @param responsable Instance d'utilisateur responsable de l'outil en question
     */

    public void setResponsable(User responsable) {
        this.responsable = responsable;
    }

    /**
     * Setter pour assigner la liste des articles liés à l'outil en question
     * @param linkedArticle Liste contenant les articles liés à l'outil
     */

    public void setLinkedArticle(List<Article> linkedArticle) {
        this.linkedArticle = linkedArticle;
    }

    /**
     * Setter pour assigner l'URL du répertoire du code source de l'outil
     * @param toolUrl Chaine de caractère contenant l'URL du code source de l'outil en question
     */

    public void setToolUrl(String toolUrl) {
        this.toolUrl = toolUrl;
    }

    /**
     * Setter pour assigner la version de l'outil
     * @param version Chaine de caractère désignant la version de l'outil à assigner
     */

    public void setVersion(String version) {
        this.version = version;
    }
}
