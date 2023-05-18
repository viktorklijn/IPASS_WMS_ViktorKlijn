package models;

public class Role {
    private String name;
    private int id;

    public Role(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
