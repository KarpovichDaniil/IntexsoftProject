package by.intexsoft.adsboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import by.intexsoft.adsboard.service.UsersService;
import by.intexsoft.adsboard.service.impl.UsersServiceImpl;

/**
 * Java-based configuration class for a dispatcher servlet context.
 * {@link @EnableWebMvc} configures a list of special bean types the
 * DispatcherServlet relies on
 */
@Configuration
@EnableWebMvc
@ComponentScan("by.intexsoft.adsboard.controller")
public class DispatcherServletContextConfig {

	/**
	 * @return instance of a UserServiceImpl class
	 */
	@Bean
	public UsersService usersService() {
		return new UsersServiceImpl();
	}
}