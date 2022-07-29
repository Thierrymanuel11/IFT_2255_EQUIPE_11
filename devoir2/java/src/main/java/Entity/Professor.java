package main.java.Entity;

import main.java.enums.UserTitle;

import java.util.List;

public class Professor extends User{

    public Professor(int id, String fname, String lname, List<Interest> interest, List<Notification> notifications, String webPageURL,
                     UserTitle title, String email){
        super(id, fname, lname, interest, notifications, webPageURL, title, email);
    }


}
