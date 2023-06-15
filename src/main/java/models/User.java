package models;

import nl.hu.ipass.viktorklijn.system.models.Role;

public class User {
    private String username;
    private String email;
    private String password;
    private int id;
    private Role role;

    public User(String username, String email, String password, int id, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.id = id;
        this.role = role;
    }

    public String getUsername() {
        return username;
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
}
