package nl.hu.ipass.viktorklijn.system.models;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveModel implements Serializable {
    ArrayList<Shop> shops;
    ArrayList<User> users;

    public SaveModel(ArrayList<Shop> shops, ArrayList<User> users) {
        this.shops = shops;
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Shop> getShops() {
        return shops;
    }
}
