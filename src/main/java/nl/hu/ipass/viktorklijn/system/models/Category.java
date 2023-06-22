package nl.hu.ipass.viktorklijn.system.models;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Category implements Serializable {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}