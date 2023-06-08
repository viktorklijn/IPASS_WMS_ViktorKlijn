package nl.hu.ipass.viktorklijn.system.auth;

import java.security.Principal;

public class AuthPrincipal implements Principal {
    private String name;

    public AuthPrincipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
