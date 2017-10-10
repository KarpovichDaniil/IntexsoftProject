package by.intexsoft.adsboard.config;

import by.intexsoft.adsboard.security.filter.AuthenticationFilter;
import by.intexsoft.adsboard.security.filter.LoginFilter;
import by.intexsoft.adsboard.service.AuthenticationService;
import by.intexsoft.adsboard.service.impl.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Конфигурационный файл Spring Security.
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsServiceImpl.class)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;
	private final AuthenticationService authenticationService;

	@Autowired
	public WebSecurityConfiguration(UserDetailsService userDetailsService,
			AuthenticationService authenticationService) {
		this.userDetailsService = userDetailsService;
		this.authenticationService = authenticationService;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/*.html").antMatchers("/*.js").antMatchers("/assets/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().cacheControl();
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/api/goods/**").permitAll()
				.antMatchers(HttpMethod.POST, "/api/auth", "/api/register").permitAll()
				.antMatchers(HttpMethod.POST, "/api/user/current", "/api/user")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_USER").antMatchers(HttpMethod.POST, "/api/goods/**")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_MODERATOR")
				.antMatchers(HttpMethod.GET, "/api/users/false", "/api/users/true", "/api/users")
				.hasAuthority("ROLE_ADMIN").antMatchers(HttpMethod.POST, "/api/user/admin").hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated().and()
				.addFilterBefore(new LoginFilter("/api/auth", authenticationManager(), authenticationService),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new AuthenticationFilter(authenticationService),
						UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
}
