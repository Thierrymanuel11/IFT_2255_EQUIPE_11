package Entity;

import java.util.ArrayList;
import java.util.List;

public class Activity {

    private List<Interest> interests;
    private String title;
    private int id;
    private List<User> subscribers;
    private List<String> keywords;

    public Activity(List<Interest> interests, String title, int id, List<User> subscribers, List<String> keywords) {

        this.interests = interests;
        this.title = title;
        this.id = id;
        this.subscribers = subscribers;
        this.keywords = keywords;

    }

    public Activity(List<Interest> interests, String title, int id, List<String> keywords) {

        this.interests = interests;
        this.title = title;
        this.id = id;
        this.subscribers = new ArrayList<>();
        this.keywords = keywords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addSub(User user) {
        this.subscribers.add(user);
    }

    public void removeSub(User user) {
        int i = 0;
        for (User sub: this.subscribers) {
            if (sub.equals(user)) {
                this.subscribers.remove(i);
            }
            i++;
        }
    }

    public String getTitle() {
        return title;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }


}
