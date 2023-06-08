package nl.hu.ipass.viktorklijn.system.auth;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class AuthSecurityContext implements SecurityContext {
    private Principal principal;

    public AuthSecurityContext(Principal principal) {
        this.principal = principal;
    }

    @Override
    public Principal getUserPrincipal() {
        return null;
    }

    @Override
    public boolean isUserInRole(String s) {
        return principal.getName().equals("bob");
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public String getAuthenticationScheme() {
        return null;
    }
}
