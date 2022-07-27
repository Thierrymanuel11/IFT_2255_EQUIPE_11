package Entity;

import java.util.Date;
import java.util.List;

public class Project extends Activity {

    String description;
    Date startDate;
    Date finishDate;
    Professor responsable;

    public Project(String description, Date startDate, Date finishDate, Professor responsable,
                   List<String> keywords, List<Interest> interests, String title, int id) {

        super(interests, title, id, keywords);
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.responsable = responsable;

    }

    public void printProject() {
        System.out.println("----------");
        System.out.println("id: " + this.getId());
        System.out.println("Titre: " + this.getTitle());
        System.out.println("Description: " + this.description);
        System.out.println("Date de commencement: " + this.startDate);
        System.out.println("Date de fin: " + this.finishDate);
        System.out.println("Responsable: " + this.responsable.getFname() + " " + this.responsable.getLname());
    }

    public void setResponsable(Professor responsable) {
        this.responsable = responsable;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
