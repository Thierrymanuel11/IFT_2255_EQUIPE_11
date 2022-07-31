package main.java.Entity;

public class Notification {
    private String title;
    private String message;

    public Notification(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public void printNotifications() {
        System.out.println(this.title + ": " + this.message);
    }
}
