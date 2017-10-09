package by.intexsoft.adsboard.service.impl;

import by.intexsoft.adsboard.service.AuthenticationService;
import by.intexsoft.adsboard.service.UsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

/**
 * Provides authentication methods for JSON Web Token
 * creation and verification
 * 
 */
@Service
@PropertySource("classpath:security.properties")
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = HS256;
    private static final long REFRESH_TIME = 600000;
    private static final String SECRET_WORD = "hello";
    private static final String JWT_PREFIX = "Bearer";
    private static final String AUTH_HEADER = "Authorization";
    private static final String CONTENT_TYPE = "application/json";

    UsersService userService = new UsersServiceImpl();

    @Override
    public void provideTokenAuthentication(HttpServletResponse response, Authentication authentication) {
        String username = authentication.getName();
        Claims claims = Jwts.claims().setSubject(username);

        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        claims.put("scopes", authorities);

        String JWT = generateJWT(claims);
        response.addHeader(AUTH_HEADER, JWT_PREFIX + " " + JWT);
        response.setContentType(CONTENT_TYPE);

        attachJsonToResponseBody(response, convertObjectToJson(authorities));
    }

    private String convertObjectToJson(Set<String> authorities) {
        String jsonString = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonString = objectMapper.writeValueAsString(authorities);
        } catch (JsonProcessingException exception) {
            //TODO: insert logger here;
        }
        return jsonString;
    }

    @Override
    public Authentication verifyTokenAuthentication(HttpServletRequest request) {
        Authentication authentication = null;
        String token = request.getHeader(AUTH_HEADER);

        if (token != null) {
            try {
                authentication = new UsernamePasswordAuthenticationToken(getUsernameFromJWT(token), null,
                        AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", getAuthoritiesFromJWT(token))));
            } catch (NullPointerException exc) {
                System.out.print("A JSON Web Token verification error occurred.");
            }
        }
        return authentication;
    }

    private String generateJWT(Claims claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SIGNATURE_ALGORITHM, SECRET_WORD)
                .compact();
    }

    private List getAuthoritiesFromJWT(String token) {
        return Jwts.parser().setSigningKey(SECRET_WORD)
                .parseClaimsJws(token.replace(JWT_PREFIX, ""))
                .getBody().get("scopes", List.class);
    }

    private String getUsernameFromJWT(String token) {
        return Jwts.parser().setSigningKey(SECRET_WORD)
                .parseClaimsJws(token.replace(JWT_PREFIX, ""))
                .getBody().getSubject();
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + REFRESH_TIME);
    }

    private void attachJsonToResponseBody(HttpServletResponse response, String infoToAttach) {
        try {
            PrintWriter writer = response.getWriter();
            writer.print(infoToAttach);
            writer.flush();
        } catch (IOException exception) {
            //TODO: insert logger here;
        }
    }
}
