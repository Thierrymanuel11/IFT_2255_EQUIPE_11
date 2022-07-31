package main.java.Entity;

/**
 * Classe pour gerer les notifications
 */
public class Notification {
    private String title;
    private String message;

    /**
     * Constructeur de la classe
     * @param title Chaine de caractère contenant le titre de la Notification
     * @param message Chaine de caractère contenant le contenu de la notification
     */
    public Notification(String title, String message) {
        this.title = title;
        this.message = message;
    }

    /**
     * Getter pour le titre de la notification
     * @return Renvoit une chaine de caractère contenant le titre de la notification
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter pour le méssage
     * @return Renvoit une chaine de caractère contenant le méssage de la notification
     */
    public String getMessage() {
        return message;
    }

    /**
     * Méthode pour pouvoir afficher la notification
     */
    public void printNotifications() {
        System.out.println(this.title + ": " + this.message);
    }
}
