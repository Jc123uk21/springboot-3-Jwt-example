package com.jCatchpole.CoffeesToGo.Config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	//Secret signing key, during production  this should be stored in a secure location and access accordingly! 
	private static final String SECRET_KEY = "50645267556B58703273357638792F423F4528482B4D6251655468566D597133";

	//Extract username held within a String token
	public String extractUsername(String token) {
		
		return extractClaim(token, Claims::getSubject);
	}
	
	//public method to extract claim from token
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims  claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	// Private method to extract all Claims from token
	private Claims extractAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getSignInKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

	//Decode and Retrieve Secret signing key
	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	
	//Generate token method using UserDetails
	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}
	
	
	//Generate token method using extra claims and UserDetails
	public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *24))
				.signWith(getSignInKey(), SignatureAlgorithm.HS256)
				.compact();			
	}
	
	//Method to check if a token is valid
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}

	//Method to check if a token is expired
	private boolean isTokenExpired(String token) {
		return extractTokenExpiration(token).before(new Date(System.currentTimeMillis()));
	}

	//Method to extract token expiration date 
	private Date extractTokenExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

}
