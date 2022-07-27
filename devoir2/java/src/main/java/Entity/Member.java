package Entity;

import enums.UserTitle;

public class Member extends User {

    Professor supervisor;

    public Member(int id, String fname, String lname, Interest[] interest, String[] notifications, String webPageURL,
                 UserTitle title, String email, Professor supervisor){
        super(id, fname, lname, interest, notifications, webPageURL, title, email);
        this.supervisor = supervisor;
    }
}
