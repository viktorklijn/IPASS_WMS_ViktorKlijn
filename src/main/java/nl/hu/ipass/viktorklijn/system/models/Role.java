package nl.hu.ipass.viktorklijn.system.models;

import java.io.Serializable;

public class Role implements Serializable {
    private String name;
    private int id;

    public Role(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
