package com.friends.utils.jwt;

import com.friends.dto.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.friends.utils.AdapterUtils.getStackTrace;

@Component
public class JwtUtil {
    private static final Logger logger = Logger.getLogger(JwtUtil.class.getName());

    @Value("${app.secret}")
    private String secret;

    public String generateToken(String userName){
        logger.info("Entry generateToken() ::");
        try {
            return Jwts.builder()
                    .setClaims(new HashMap<>())
                    .setSubject(userName)
                    .setIssuer(Constants.TOKEN_ISSUER)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                    .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                    .compact();
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }

        logger.info("Exit generateToken() ::");
        return null;
    }

    public Claims getClaims(String token){
        return Jwts.parser()
                .setSigningKey(secret.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }

    public Date getExpiryDate(String token){
        return  getClaims(token).getExpiration();
    }

    public String getUsername(String token){
        return getClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token){
        Date expDateOfToken = getExpiryDate(token);

        return expDateOfToken.before(new Date(System.currentTimeMillis()));
    }

    public boolean isTokenValidated(String token, String userNameFromDB){
        String tokenUser = getUsername(token);
        return (tokenUser.equalsIgnoreCase(userNameFromDB) && !isTokenExpired(token));
    }

    public String getIssuerName(String token){
        return getClaims(token).getIssuer();
    }

}
