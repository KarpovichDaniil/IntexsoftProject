package by.intexsoft.adsboard.service.impl;

import by.intexsoft.adsboard.model.CustomUserDetails;
import by.intexsoft.adsboard.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Предоставляет детальную информацию об необходимом пользователе которая
 * позднее используется для аутентификационных целей
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	private final UsersService userService;
	
	@Autowired
    public CustomUserDetailsServiceImpl(UsersService userService) {
        this.userService = userService;
    }

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return new CustomUserDetails(userService.findByUserName(userName));
	}
}
