package by.intexsoft.adsboard.service;

import javax.transaction.Transactional;
import by.intexsoft.adsboard.model.User;

public interface UserService extends AbstractEntityService<User>{
	User findByUserName(String name);

    @Transactional
    User register(User user);
    
    @Transactional
    User obtainUser(String username);
    
    User findByEnabled(boolean enabled);
}
