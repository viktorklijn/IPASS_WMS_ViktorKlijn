package nl.hu.ipass.viktorklijn.utils;

import io.jsonwebtoken.*;
import nl.hu.ipass.viktorklijn.system.auth.VerificationToken;

import javax.crypto.spec.SecretKeySpec;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    public static SecretKeySpec key = new SecretKeySpec("WMSKeyHU".getBytes(), SignatureAlgorithm.HS512.getJcaName());

    public static Map<String, String> verifyToken(VerificationToken verificationToken)  {
        Map<String, String> response = new HashMap<>();

        var jwt = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(verificationToken.token)
                .getBody();

        String username = jwt.getSubject();


        response.put("username", username);

        return response;
    }
}
