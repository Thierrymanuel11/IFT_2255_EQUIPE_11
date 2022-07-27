package main.java.Entity;

import main.java.enums.UserTitle;

public class Professor extends User{

    public Professor(int id, String fname, String lname, Interest[] interest, String[] notifications, String webPageURL,
                 UserTitle title, String email){
        super(id, fname, lname, interest, notifications, webPageURL, title, email);
    }


}
