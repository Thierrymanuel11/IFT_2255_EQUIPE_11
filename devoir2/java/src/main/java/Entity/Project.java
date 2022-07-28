package main.java.Entity;

import java.util.Date;
import java.util.List;

/**
 * Classe pour gérer les instances de projet de la plateforme
 * @author Gabriel Menard
 * @version 1.0
 */

public class Project extends Activity {

    String description;
    Date startDate;
    Date finishDate;
    Professor responsable;

    /**
     * Constructeur de la classe
     * @param description Chaine de caractère contenant la description du projet
     * @param startDate Instance de Date contenant la date de début du projet
     * @param finishDate Instance de Date contenant la date de fin du projet
     * @param responsable Utilisateur (en l'occurence un Professeur ici) responsable du projet
     * @param keywords Liste de Mots clés pour le projet
     * @param interests Liste d'intérets associés au projetù
     * @param title Chaine de caractère contenant le titre du projet
     * @param id Identifiant numérique du projet
     */

    public Project(String description, Date startDate, Date finishDate, Professor responsable,
                   List<String> keywords, List<Interest> interests, String title, int id) {

        super(interests, title, id, keywords);
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.responsable = responsable;

    }

    /**
     * Méthode pour afficher une description du projet en question sous forme de chaines de caractères
     */

    public void printProject() {
        System.out.println("----------");
        System.out.println("id: " + this.getId());
        System.out.println("Titre: " + this.getTitle());
        System.out.println("Description: " + this.description);
        System.out.println("Date de commencement: " + this.startDate);
        System.out.println("Date de fin: " + this.finishDate);
        System.out.println("Responsable: " + this.responsable.getFname() + " " + this.responsable.getLname());
    }

    /**
     * Setter pour assigner le responsable du projet
     * @param responsable Instance de Professeur responsable du projet
     */

    public void setResponsable(Professor responsable) {
        this.responsable = responsable;
    }

    /**
     * Setter pour assigner la description du projet
     * @param description Chaine de caractère contenant la nouvelle description du projet à assigner
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter pour assigner la date de fin du projet
     * @param finishDate Instance de Date pour la date de fin du projet
     */

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * Setter pour assigner la date de début du projet
     * @param startDate Instance de Date pour la date de début de projet
     */

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
