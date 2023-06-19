package nl.hu.ipass.viktorklijn.system.webservices;

import io.jsonwebtoken.JwtException;
import nl.hu.ipass.viktorklijn.system.auth.LoginRequest;
import nl.hu.ipass.viktorklijn.system.auth.VerificationToken;
import nl.hu.ipass.viktorklijn.system.models.Article;
import nl.hu.ipass.viktorklijn.system.models.Shop;
import nl.hu.ipass.viktorklijn.system.models.User;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

import static nl.hu.ipass.viktorklijn.utils.JwtUtil.verifyToken;

@Path("/dashboard")
public class DashboardResource {

    @POST
    @Path("/articles")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
//    @RolesAllowed("admin")
    public Response getArticles(VerificationToken verificationToken) {
        try {
            Map<String, String> verificationResponse = verifyToken(verificationToken);

            List<Article> articles = User.getUser(verificationResponse.get("username")).getShop().getArticles();
            return Response.ok(articles).build();
        } catch (JwtException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

}


