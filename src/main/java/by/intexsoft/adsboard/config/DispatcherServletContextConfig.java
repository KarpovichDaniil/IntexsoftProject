package by.intexsoft.adsboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import by.intexsoft.adsboard.model.User;
import by.intexsoft.adsboard.repository.UserRepository;
import by.intexsoft.adsboard.service.RoleService;
import by.intexsoft.adsboard.service.UserService;
import by.intexsoft.adsboard.service.impl.UserServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan("by.intexsoft.adsboard.controller")
public class DispatcherServletContextConfig{

	/**
	 * @return instance of a UserServiceImpl class
	 */
	 @Bean
	    public UserService userService(
	            JpaRepository<User, Long> jpaRepository,
	            UserRepository userRepository,
	            RoleService roleService) {
	        return new UserServiceImpl(jpaRepository, userRepository, roleService);
	    }
}