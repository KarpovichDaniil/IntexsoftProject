package by.intexsoft.adsboard.security.filter;

import by.intexsoft.adsboard.model.AccountAuthorities;
import by.intexsoft.adsboard.service.AuthenticationService;
import by.intexsoft.adsboard.service.impl.AuthenticationServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * Filters invalid login requests
 */
public class LoginFilter extends AbstractAuthenticationProcessingFilter {

	AuthenticationService authenticationService = new AuthenticationServiceImpl();

	public LoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authManager) {

		super(defaultFilterProcessesUrl);
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		AccountAuthorities credentials = new ObjectMapper().readValue(request.getInputStream(),
				AccountAuthorities.class);

		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
				credentials.getUsername(), credentials.getPassword(), Collections.emptyList()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		authenticationService.provideTokenAuthentication(response, authResult);
	}
}
