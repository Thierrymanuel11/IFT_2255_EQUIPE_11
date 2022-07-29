package main.java.Controllers;

import main.java.Entity.Account;
import main.java.Entity.Interest;
import main.java.Entity.Professor;
import main.java.Entity.User;
import main.java.enums.AccountRole;
import main.java.enums.AccountStatus;
import main.java.enums.UserTitle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe de controle des utilisateurs
 * @author Gabriel Menard
 * @version 1.0
 */
public class UserController {

    List<User> users;
    List<Account> accounts;

    /**
     * Constructeur de la classe
     * @param users Liste d'utilisisateur
     * @param accounts Liste des comptes liés aux utilisateurs
     */
    public UserController(List<User> users, List<Account> accounts) {

        this.users = users;
        this.accounts = accounts;

    }

    /**
     * Getter pour la liste de tous les utilisateurs
     * @return Renvoit une liste contenant toutes les instances d'utilisateur
     */
    public List<User> getAllUsers(){
        return users;
    }

    /**
     * Méthode permettant d'ajouter un utilisateur à la liste d'utilisateur
     * @param user Instance d'utilisateur à ajouter
     * @return Renvoie un booleen pour bien confirmer l'ajout de l'utilisateur
     */
    public boolean addUser(User user){
        users.add(user);
        return true;
    }

    /**
     * Getter pour pouvoir rechercher un Utilisateur par son nom
     * @param name Chaine de caractère contenant le nom de l'utilisateur à rechercher
     * @return Renvoit une instance de l'utilisateur correspondant au nom passé en argument
     */
    public User getUserByName(String name) {
        for (User x : users) {
            if (name.equals(x.getFname())) return x;
        }
        return null;
    }

    /**
     * Méthode pour trouver la liste des utilisateurs liés à un interet
     * @param interest Interet à partir duquel on veut retrouver les utilisateurs
     * @return Renvoit une liste d'instance d'utilisateur liés à l'interet passe en argument
     */
    public List<User> getUsersByInterest(Interest interest) {

        List<User> result = new ArrayList<>();

        for (User user: this.users) {
            for (Interest userInterest: user.getInterest()) {
                if (userInterest.equals(interest)) {
                    result.add(user);
                }
            }
        }

        return result;
    }

    /**
     *  Méthode pour permettre à un utilisateur de se connecter à son compte
     * @param email Chaine de caractère contenant l'adresse mail entree par l'utilisateur
     * @param passord Chaine de caractère contenant le mot de passe entre par l'utilisateur
     * @return Renvoit L'instance d'utilisateur correspondant à l'adresse mail et au mot de passe entre ou sinon renvoit null
     */
    public User login(String email, String passord) {

        for (Account account: this.accounts) {
            if (account.getEmail().equals(email)) {
                if (account.getPassword().equals(passord)) {
                    return account.getUser();
                }
            }
        }

        return null;

    }

    /**
     * Méthode pour pouvoir creer un compte
     * @param fname Chaine de caractere contenant le premier nom de l'utilisateur
     * @param lname Chaine de caractere contenant le dernier nom de l'utilisateur
     * @param email Chaine de caractere contenant l'adresse mail de l'utilisateur
     * @param tel Chaine de caractre contenant le numero de telephone de l'utilisateur
     * @param password Chaine de caractre contenant le mot de passe de l'utilisateur
     * @param professor Instance de professeur qui sera charge de valider le compte cree
     * @return Renvoit un booleen pour confirmer la creation du compte
     */
    public boolean createAccount(String fname, String lname, String email, String tel, String password,
                                 User professor) {
        User newUser = new User(users.size(), fname, lname, null, null, null,
                UserTitle.Master, email);

        this.users.add(newUser);
        this.accounts.add(new Account(email, password, AccountStatus.PENDING, newUser, AccountRole.Member));
        return true;
    }

}
