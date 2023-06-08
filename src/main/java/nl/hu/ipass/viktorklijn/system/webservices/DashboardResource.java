package nl.hu.ipass.viktorklijn.system.webservices;

import nl.hu.ipass.viktorklijn.system.models.Article;
import nl.hu.ipass.viktorklijn.system.models.Shop;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/dashboard")
public class DashboardResource {

    @GET
    @Path("/articles")
    @Produces(MediaType.APPLICATION_JSON)
//    @RolesAllowed("admin")
    public Response loadDashboard() {
        List<Article> articles = Shop.getArticles();
        return Response.ok(articles).build();
    }
}


