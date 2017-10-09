package by.intexsoft.adsboard.security;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.WebApplicationInitializer;

import by.intexsoft.adsboard.config.WebSecurityConfiguration;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
}