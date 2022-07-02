package Controllers;

import Entity.*;
import enums.ArticleStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityController {

    private List<Activity> activities;

    public ActivityController(List<Activity> activities) {
        this.activities = activities;
    }

    public boolean createArticle(String title, String summary, String url, Date publicationDate, List<User> collaborators, List<User> authors,
                                 List<String> keywords, List<Interest> interests, ArticleStatus status, int id) {
        this.activities.add(new Article(summary, publicationDate, url, status, authors, collaborators, keywords, interests, title, id));
        return true;
    }

    public boolean modifyArticle(Article article, String title, String summary, String url, Date publicationDate, List<User> collaborators, List<User> authors,
                                 List<String> keywords, List<Interest> interests, ArticleStatus status, int id) {

        for (Activity activity: this.activities) {
            if (activity instanceof Article && activity.getId() == id ) {
                activity.setTitle(title);
                ((Article) activity).setSummary(summary);
                ((Article) activity).setArticleUrl(url);
                ((Article) activity).setPublicationDate(publicationDate);
                ((Article) activity).setCollaborators(collaborators);
                ((Article) activity).setAuthors(authors);
                ((Article) activity).setKeywords(keywords);
                activity.setInterests(interests);
                ((Article) activity).setStatus(status);
                return true;
            }
        }
        return false;
    }

    public boolean addSub(int id, User sub) {
        for (Activity activity: this. activities) {
            if (id == activity.getId()) {
                activity.addSub(sub);
                return true;
            }
        }
        return false;
    }

    public boolean removeSub(int id, User sub) {
        for (Activity activity: this. activities) {
            if (id == activity.getId()) {
                activity.removeSub(sub);
                return true;
            }
        }
        return false;
    }

    public List<Activity> getActiviesByInterest(Interest interest) {

        List<Activity> result = new ArrayList<>();

        for (Activity activity: this.activities) {
            for (Interest interest1: activity.getInterests()) {
                if (interest1.equals(interest)) {
                    result.add(activity);
                }
            }
        }
        return result;
    }

    public List<Article> findArticle(String searchWord) {
        List<Article> result = new ArrayList<>();
        for (Activity activity: this.activities) {
            if (activity instanceof Article) {
                for (String word: activity.getKeywords()) {
                    if (searchWord.equals(word)) {
                        result.add((Article) activity);
                    }
                }
            }
        }
        return result;
    }

    public List<Project> findProject(String searchWord) {
        List<Project> result = new ArrayList<>();
        for (Activity activity: this.activities) {
            if (activity instanceof Project) {
                for (String word: activity.getKeywords()) {
                    if (searchWord.equals(word)) {
                        result.add((Project) activity);
                    }
                }
            }
        }
        return result;
    }

    public List<Tool> findTool(String searchWord) {
        List<Tool> result = new ArrayList<>();
        for (Activity activity: this.activities) {
            if (activity instanceof Tool) {
                for (String word: activity.getKeywords()) {
                    if (searchWord.equals(word)) {
                        result.add((Tool) activity);
                    }
                }
            }
        }
        return result;
    }

    public int getSize() {
        return this.activities.size();
    }

    public void printActivities() {
        for (Activity activity: this.activities) {
            System.out.println(activity.getId() + ": "+ activity.getTitle());
        }
    }



}
