package application;

import java.io.Serializable;

public class ApplicationModel implements Serializable {

    private String description;
    private int id;
    private String name;
    private String owner;


    public ApplicationModel(String description, int id, String name, String owner) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

    public ApplicationModel(String description, String name, String owner) {
        this.description = description;
        this.name = name;
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
