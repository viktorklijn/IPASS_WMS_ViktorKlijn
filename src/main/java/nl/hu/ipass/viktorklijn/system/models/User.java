package nl.hu.ipass.viktorklijn.system.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.hu.ipass.viktorklijn.system.webservices.DashboardResource;

import java.util.ArrayList;
import java.util.TreeMap;

public class User {
    private String username;
    private String email;
    private String password;
    private int id;
    private Role role;
    private static ArrayList<User> users = new ArrayList<>();
    private Shop shop;

    public User(String username, String email, String password, int id, Role role, Shop shop) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.id = id;
        this.role = role;
        this.shop = shop;
        users.add(this);
    }

    public String getUsername() {
        return username;
    }

    public static Role validateUser(String usernm, String pass) {
        for (User user : users) {
            if (user.username.equals(usernm)) {
                if (user.password.equals(pass)) {
                    return user.role;
                }
            }
        }

        return null;
    }

    public static User getUser(String usernm) {
        for (User user : users) {
            if (user.username.equals(usernm)) {
                System.out.println(user.username);
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof String usernm) {
            return usernm.equals(username);
        }
       return false;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public Shop getShop() {
        return shop;
    }
}
