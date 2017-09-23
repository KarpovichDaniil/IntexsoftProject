package by.intexsoft.adsboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import by.intexsoft.adsboard.service.impl.UsersServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan("by.intexsoft.adsboard.controller")
public class DispatcherServletContextConfig {

	/**
	 * @return instance of a UsersServiceImpl class
	 */
	@Bean
	public UsersServiceImpl usersService() {
		return new UsersServiceImpl();
	}
}