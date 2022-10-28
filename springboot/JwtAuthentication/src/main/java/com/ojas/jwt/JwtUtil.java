package com.ojas.jwt;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private String secret = "sivaleela1233";
	
	public String generateToken(String userName) {
		
		return Jwts.builder()
				.setSubject(userName)
				.setIssuer("LachiAsula")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(20)))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	
	public Claims getClaims(String token) {
		
		return Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();
	}
	
	public String getUserName(String token) {
		
		return getClaims(token).getSubject();
	}
	
	public Date getExpiry(String token) {
		
		return getClaims(token).getExpiration();
	}
	
	public boolean isExpiry(String token) {
		Date date = getExpiry(token);
		
		return date.before(new Date(System.currentTimeMillis()));
	}
	
	public boolean validateToken(String token, String userName) {
		String uname = getUserName(token);
		
		return (uname.equalsIgnoreCase(userName) && !isExpiry(token));
	}
}
