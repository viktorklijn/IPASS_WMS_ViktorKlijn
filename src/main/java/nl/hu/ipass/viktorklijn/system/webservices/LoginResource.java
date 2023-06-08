package nl.hu.ipass.viktorklijn.system.webservices;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nl.hu.ipass.viktorklijn.system.auth.LoginRequest;
import nl.hu.ipass.viktorklijn.system.auth.VerificationToken;
import nl.hu.ipass.viktorklijn.system.models.Role;
import nl.hu.ipass.viktorklijn.system.models.User;

import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.Calendar;

@Path("/login")
public class LoginResource {
    public static SecretKeySpec key = new SecretKeySpec("dikkekey".getBytes(), SignatureAlgorithm.HS512.getJcaName());

    @POST
    @Path("/authenticate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response checkLogin(LoginRequest loginRequest) {
        try {
            Role role = User.validateUser(loginRequest.username, loginRequest.password);

            if (role == null) throw new IllegalArgumentException("No user found!");

            String token = createToken(loginRequest.username, role.getName());
            System.out.println(token);

            return Response.ok(new AbstractMap.SimpleEntry<>("JWT", token)).build();
        } catch (JwtException | IllegalArgumentException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/verify")
    @Produces("application/json")
    @Consumes("application/json")
    public Response verifyToken(VerificationToken verificationToken) {
        try {
            var jwt = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(verificationToken.token);

            String username = jwt.getBody().getSubject();

            User user = User.getUser(username);
            if (user != null) {
                return Response.ok(User.getUser(username)).build();

            }
        } catch (JwtException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();

        }
        return Response.status(Response.Status.FORBIDDEN).build();
    }

    private String createToken(String username, String role) {
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MINUTE, 30);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration.getTime())
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }
}
