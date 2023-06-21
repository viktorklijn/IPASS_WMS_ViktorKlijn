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
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static nl.hu.ipass.viktorklijn.utils.JwtUtil.verifyToken;

@Path("/login")
public class LoginResource {
    public static SecretKeySpec key = new SecretKeySpec("WMSKeyHU".getBytes(), SignatureAlgorithm.HS512.getJcaName());

    @POST
    @Path("/authenticate")
    @Produces("application/json")
    @Consumes("application/json")
    public Response checkLogin(LoginRequest loginRequest) {
        try {
            Role role = User.validateUser(loginRequest.getUsername(), loginRequest.getPassword());

            String token = createToken(loginRequest.getUsername(), role.getName());

            return Response.ok(new AbstractMap.SimpleEntry<>("JWT", token)).build();
        } catch (JwtException | NullPointerException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/verify")
    @Produces("application/json")
    @Consumes("application/json")
    public Response tokenVerification(VerificationToken verificationToken) {
        try {
            Map<String, String> response = verifyToken(verificationToken);
            return Response.ok(response).build();
        } catch (JwtException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
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
