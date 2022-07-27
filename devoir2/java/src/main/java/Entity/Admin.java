package Entity;

import enums.UserTitle;

public class Admin extends User {

    public Admin(int id, String fname, String lname, Interest[] interest, String[] notifications, String webPageURL,
                 UserTitle title, String email){
        super(id, fname, lname, interest, notifications, webPageURL, title, email);
    }
}
