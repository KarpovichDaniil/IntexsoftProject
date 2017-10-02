package by.intexsoft.adsboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import by.intexsoft.adsboard.service.impl.CategoriesServiceImpl;
import by.intexsoft.adsboard.service.impl.UsersServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan("by.intexsoft.adsboard.controller")
public class DispatcherServletContextConfig extends ApplicationDataConfig{

	/**
	 * @return instance of a UsersServiceImpl class
	 */
	@Bean
	public static UsersServiceImpl usersService() {
		return new UsersServiceImpl();
	}
	@Bean
	public static CategoriesServiceImpl categoryService() {
		return new CategoriesServiceImpl();
	}
	
	
}