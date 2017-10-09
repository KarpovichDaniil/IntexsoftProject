package by.intexsoft.adsboard.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthenticationService {

    void provideTokenAuthentication(HttpServletResponse response, Authentication authentication);

    Authentication verifyTokenAuthentication(HttpServletRequest request);
}
