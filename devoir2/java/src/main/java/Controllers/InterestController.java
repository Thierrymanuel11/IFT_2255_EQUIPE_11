package Controllers;

import Entity.Interest;
import Entity.User;

import java.util.List;

public class InterestController {

    List<Interest> interests;

    public InterestController(List<Interest> interests) {

        this.interests = interests;

    }

    public boolean addInterest(String name, String description){
        interests.add(new Interest(name, description));
        return true;
    }

    public boolean modifyInterest(String name, String description){
        for (Interest interest: interests){
            if (interest.getName().equals(name)){
                interest.setDescription(description);
                return true;
            }
        }

        return false;
    }

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

    public void printInterest() {
        for (Interest interest : interests) {
            System.out.println(interest.getName());
        }
    }
}
