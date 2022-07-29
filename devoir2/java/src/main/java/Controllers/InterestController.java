package main.java.Controllers;

import main.java.Entity.Interest;
import main.java.Entity.User;

import java.util.List;

/**
 * Classe pour le control des interets
 * @author Gabriel Menard
 * @version 1.0
 */

public class InterestController {

    List<Interest> interests;

    /**
     * Constructeur de la classe
     * @param interests Liste des interets devant etre geree par le controleur
     */
    public InterestController(List<Interest> interests) {

        this.interests = interests;

    }

    /**
     * Méthode pour l'ajout d'un interet
     * @param name Chaine de caractere contenant le nom de l'interet à ajouter
     * @param description Chaine de caractère contenant la description de l'interet à ajouter
     * @return Renvoit un booleen pour confirmer l'ajout de l'interet
     */

    public boolean addInterest(String name, String description){
        interests.add(new Interest(name, description));
        return true;
    }

    /**
     * Methode pour modifier un interet
     * @param name Chaine de caractere contenant le nom de l'interet à modifier
     * @param description Chaine de caractere contenant la nouvelle description à mettre pour l'interet à modifier
     * @return Renvoit un booleen pour confirmer la modification
     */

    public boolean modifyInterest(String name, String description){
        for (Interest interest: interests){
            if (interest.getName().equals(name)){
                interest.setDescription(description);
                return true;
            }
        }

        return false;
    }

    /**
     * Methode pour supprimer un interet
     * @param name Chaine de caractere contenant le nom de l'interet à supprimer
     * @return Renvoit un booleen pour confirmer ou pas la supression de l'interet
     */
    public boolean deleteInterest(String name) {

        int i = 0;

        for (Interest interest : interests) {
            if (interest.getName().equals(name)) {
                interests.remove(i);
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * Methode pour pouvoir afficher la liste des interets
     */

    public void printInterest() {
        for (Interest interest : interests) {
            System.out.println(interest.getName());
        }
    }
}
