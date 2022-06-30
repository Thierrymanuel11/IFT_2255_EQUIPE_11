package Entity;

import enums.AccountRole;
import enums.AccountStatus;

public class Account {

    String email;
    String password;
    AccountStatus status;
    User user;
    AccountRole role;

    public Account(String email, String password, AccountStatus status, User user, AccountRole role){

        this.email = email;
        this.password = password;
        this.status = status;
        this.user = user;
        this.role = role;

    }

}
