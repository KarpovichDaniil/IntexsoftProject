package by.intexsoft.adsboard.service.impl;

import by.intexsoft.adsboard.controller.UserController;
import by.intexsoft.adsboard.service.AuthenticationService;
import by.intexsoft.adsboard.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
 */
@Service
@PropertySource("classpath:security.properties")
public class AuthenticationServiceImpl implements AuthenticationService {

	private static final SignatureAlgorithm SIGNATURE_ALGORITHM = HS256;
    private static Logger LOGGER = (Logger) LoggerFactory.getLogger(UserController.class);

    @Value("${jwt.refresh_time}")
    private long REFRESH_TIME;
    @Value("${jwt.secret_word}")
    private String SECRET_WORD;
    @Value("${jwt.prefix}")
    private String JWT_PREFIX;
    @Value("${jwt.auth_header}")
    private String AUTH_HEADER;
    @Value("${jwt.content_type}")
    private String CONTENT_TYPE;

    private final UserService userService;

    @Autowired
    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }
    
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
        	 LOGGER.error("Error occurred while processing JSON!");
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
            	LOGGER.error("A JSON Web Token verification error occurred");
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
        	LOGGER.error("An error occurred while writing authority information into response object");
        }
    }
}
