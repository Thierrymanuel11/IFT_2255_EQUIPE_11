package main.java.Entity;

import main.java.enums.AccountRole;
import main.java.enums.AccountStatus;

/**
 * Classe pour gérer les instances de compte des utilisateurs
 * @author Gabriel Menard
 * @version 1.0
 */
public class Account {

    String email;
    String password;
    AccountStatus status;
    User user;
    AccountRole role;

    /**
     * Constructeur de la classe
     * @param email Chaine de caractère contenant l'adresse mail liée au compte
     * @param password Chaine de caractère contenant le mot de passe lié au compte
     * @param status Instance de statut du compte
     * @param user Instance d'utilisateur lié au compte
     * @param role Instance de role lié au compte
     */

    public Account(String email, String password, AccountStatus status, User user, AccountRole role){

        this.email = email;
        this.password = password;
        this.status = status;
        this.user = user;
        this.role = role;

    }

    /**
     * Getter pour l'adresse mail
     * @return Renvoit une chaine de caractère contenant l'adresse mail liée au compte
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter pour le mot de passe
     * @return Renvoit une chaine de caractère contenant le mot de passe lié au compte
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter pour l'utilisateur lié au compte
     * @return Renvoit l'instance d'utilisateur lié au compte en question
     */
    public User getUser() {
        return user;
    }
}
