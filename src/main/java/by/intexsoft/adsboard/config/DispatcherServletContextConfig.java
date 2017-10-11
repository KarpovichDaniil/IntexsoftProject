package by.intexsoft.adsboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import by.intexsoft.adsboard.model.Users;
import by.intexsoft.adsboard.repository.UsersRepository;
import by.intexsoft.adsboard.service.RolesService;
import by.intexsoft.adsboard.service.UsersService;
import by.intexsoft.adsboard.service.impl.UsersServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan("by.intexsoft.adsboard.controller")
public class DispatcherServletContextConfig{

	/**
	 * @return instance of a UsersServiceImpl class
	 */
	 @Bean
	    public UsersService userService(
	            JpaRepository<Users, Long> jpaRepository,
	            UsersRepository userRepository,
	            RolesService roleService) {
	        return new UsersServiceImpl(jpaRepository, userRepository, roleService);
	    }
}