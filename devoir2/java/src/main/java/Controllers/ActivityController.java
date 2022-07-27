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

    public boolean modifyArticle(String title, String summary, String url, Date publicationDate, List<User> collaborators, List<User> authors,
                                 List<String> keywords, List<Interest> interests, ArticleStatus status, int id) {

        for (Activity activity: this.activities) {
            if (activity instanceof Article && activity.getId() == id ) {
                if (!title.equals("")) {
                    activity.setTitle(title);
                }
                if (!summary.equals("")) {
                    ((Article) activity).setSummary(summary);
                }
                if (!url.equals("")) {
                    ((Article) activity).setArticleUrl(url);
                }
                if (publicationDate != null) {
                    ((Article) activity).setPublicationDate(publicationDate);
                }
                if (collaborators != null) {
                    ((Article) activity).setCollaborators(collaborators);
                }
                if (authors != null) {
                    ((Article) activity).setAuthors(authors);
                }
                if (keywords != null) {
                    ((Article) activity).setKeywords(keywords);
                }
                if (interests != null) {
                    activity.setInterests(interests);
                }
                if (interests != null) {
                    ((Article) activity).setStatus(status);
                }
                return true;
            }
        }
        return false;
    }

    public boolean modifyTool(String title, String description, String url, User responsable, List<User> collaborators, List<Article> linkedArticle,
                                 List<String> keywords, List<Interest> interests, int id) {

        for (Activity activity: this.activities) {
            if (activity instanceof Tool && activity.getId() == id ) {
                if (!title.equals("")) {
                    activity.setTitle(title);
                }
                if (!description.equals("")) {
                    ((Tool) activity).setDescription(description);
                }
                if (!url.equals("")) {
                    ((Tool) activity).setToolUrl(url);
                }
                if (responsable != null) {
                    ((Tool) activity).setResponsable(responsable);
                }
                if (collaborators != null) {
                    ((Tool) activity).setCollaborators(collaborators);
                }
                if (linkedArticle != null) {
                    ((Tool) activity).setLinkedArticle(linkedArticle);
                }
                if (keywords != null) {
                    ((Tool) activity).setKeywords(keywords);
                }
                if (interests != null) {
                    activity.setInterests(interests);
                }
                return true;
            }
        }
        return false;
    }

    public boolean modifyProject(String title, String description, Professor responsable, Date startDate, Date finishDate,
                              List<String> keywords, List<Interest> interests, int id) {

        for (Activity activity: this.activities) {
            if (activity instanceof Project && activity.getId() == id ) {
                if (!title.equals("")) {
                    activity.setTitle(title);
                }
                if (!description.equals("")) {
                    ((Project) activity).setDescription(description);
                }
                if (responsable != null) {
                    ((Project) activity).setResponsable(responsable);
                }
                if (startDate != null) {
                    ((Project) activity).setStartDate(startDate);
                }
                if (finishDate != null) {
                    ((Project) activity).setFinishDate(finishDate);
                }
                if (keywords != null) {
                    ((Project) activity).setKeywords(keywords);
                }
                if (interests != null) {
                    activity.setInterests(interests);
                }
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

    public List<Article> getAllArticle() {
        List<Article> result = new ArrayList<>();
        for (Activity activity: this.activities) {
            if (activity instanceof Article) {
                result.add((Article) activity);
            }
        }
        return result;
    }

    public List<Tool> getAllTool() {
        List<Tool> result = new ArrayList<>();
        for (Activity activity: this.activities) {
            if (activity instanceof Tool) {
                result.add((Tool) activity);
            }
        }
        return result;
    }

    public List<Project> getAllProject() {
        List<Project> result = new ArrayList<>();
        for (Activity activity: this.activities) {
            if (activity instanceof Project) {
                result.add((Project) activity);
            }
        }
        return result;
    }


}
