package nl.hu.ipass.viktorklijn.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/v1")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("nl.hu.ipass.viktorklijn.system.webservices",
                "nl.hu.ipass.viktorklijn.system.auth");
        register(RolesAllowedDynamicFeature.class);
    }
}

