package main.java.Entity;

public class Interest {

    String name;
    String description;

    public Interest(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
