package main.java.Entity;

import main.java.enums.UserTitle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private int id;
    String fname;
    String lname;
    List<Interest> interest;
    List<Notification> notifications;
    String webPageURL;
    UserTitle title;
    String email;

    public User(int id, String fname, String lname, List<Interest> interest, List<Notification> notifications, String webPageURL,
                UserTitle title, String email){

        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.interest = interest;
        this.notifications = notifications;
        this.webPageURL = webPageURL;
        this.title = title;
        this.email = email;

    }

    public List<Notification> getNotifications() {
        if (this.notifications == null) {
            return new ArrayList<Notification>(Arrays.asList(
                    new Notification("Alerte", "Pas de notifications")
            ));
        }
        return this.notifications;
    }

    public String print(){
        return "-----\nPrénom: " + this.fname +"\nNom: " + this.lname + "\nURL: " + this.webPageURL
                + "\nTitre: " + this.title + "\n-----";
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail(){
        return this.email;
    }

    public List<Interest> getInterest() {
        return interest;
    }

    public UserTitle getTitle() {
        return title;
    }
}
