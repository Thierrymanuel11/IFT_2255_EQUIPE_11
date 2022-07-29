package main.java.Entity;

/**
 * Classe pour la gestion des instances d'intéret
 * @author Gabriel Menard
 * @version 1.0
 */
public class Interest {

    String name;
    String description;

    /**
     * Contructeur de la classe
     * @param name Chaine de caractère contenant le nom de l'intéret
     * @param description Chaine de caractère contenant la description de l'intéret
     */

    public Interest(String name, String description){
        this.name = name;
        this.description = description;
    }

    /**
     * Getter pour le nom de l'intéret
     * @return Renvoit une chaine de caratère contenant le nom de l'intéret
     */
    public String getName() {
        return name;
    }

    /**
     * Setter pour la description de l'intéret
     * @param description Chaine de caractère contenant la nouvelle description de l'interet
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
