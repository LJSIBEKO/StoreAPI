package store.api.storeapi.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Slf4j
public class JwtService
{
    private static final String SECRET_KEY ="Owe4mNZ2RU0GCFjvPzFt7MEic+jhHmzbOTSszEF0cz2V266zupDDSbL/" +
            "YHePi5PzZ+ZQIQjWeQHMKxiIDrGHpN+wBKINsWeLnrlFchWNeAnu1oes9YMSs4uDWdeTX/wx3GI2JWSMTjGzzd+E/" +
            "RoIBiltSuEuwhg9mLyJH6doJ8QH4mIYkEu9bLVldnQ43wDKEOfOlI0j7VQJtmKTX289jnzHZcMHn2RdGzB3zPWTza2qOQ+" +
            "5adwLsahlyNAPLBIQR3Gcld03wUAHhN0+zzG9rKQWyA4/+DOFGydaCf52ci9jO" +
            "c0mGvRbmlcK4N3AcMRe6YxzNGd9DBH8IUIv0Q9nptX0MRVicuPGryHqZAUgDOQ=";

    public String extractUsername(String token){
        return extractClaims(token,Claims::getSubject);
    }
    public String generateToken(UserDetails userDetails){
        return buildToken(new HashMap<>(),userDetails);
    }
    public String buildToken(Map<String,Object> claims, UserDetails userDetails)
    {
        return Jwts.
                builder().
                setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token)
    {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token)
    {
        return extractClaims(token,Claims::getExpiration);
    }


    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims= extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
   private Claims extractAllClaims(String token){
       return Jwts
               .parserBuilder()
               .setSigningKey(getSignInKey())
               .build()
               .parseClaimsJws(token)
               .getBody();
   }

    private Key getSignInKey() {
       byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
