package nl.hu.ipass.viktorklijn.system.webservices;

import io.jsonwebtoken.JwtException;
import nl.hu.ipass.viktorklijn.system.auth.VerificationToken;
import nl.hu.ipass.viktorklijn.system.models.Article;
import nl.hu.ipass.viktorklijn.system.models.ProductUpdate;
import nl.hu.ipass.viktorklijn.system.models.Shop;
import nl.hu.ipass.viktorklijn.system.models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

import static nl.hu.ipass.viktorklijn.utils.JwtUtil.verifyToken;

@Path("/article")
public class ArticleResource {

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

    @POST
    @Path("/stock/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
//    @RolesAllowed("admin")
    public Response updateStock(ProductUpdate productUpdate) {
        try {
            String username = verifyToken(new VerificationToken(productUpdate.token))
                    .get("username");
            Shop shop = Objects.requireNonNull(User.getUser(username)).getShop();

            Map<String, String> response = new HashMap<>();
            Article article = Objects.requireNonNull(shop.getArticle(productUpdate.articleNumber));

            if (article.getStock() != productUpdate.stock) {
                article.setStock(productUpdate.stock);
                response.put("response", "Stock changed");
                return Response.ok().build();
            } else {
                response.put("response", "No change made");
            }

            return Response.ok(response).build();
        } catch (JwtException | NullPointerException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

}


