package by.intexsoft.adsboard.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.adsboard.model.User;
import by.intexsoft.adsboard.service.UserService;
import ch.qos.logback.classic.Logger;

@RestController
public class UserController {
	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(UserController.class.getName());

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/users/all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<User>> findAll() {
		LOGGER.info("Request was received to retrieve all users");
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/user/admin", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> adminSave(@RequestBody User currentUser) {
		LOGGER.info("Admin request was received to save a new user");
		User obtainedUser = userService.obtainUser(currentUser.username);
		currentUser.setPassword(obtainedUser.password);
		User savedUser = userService.save(currentUser);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> save(@RequestBody User currentUser) {
		LOGGER.info("Request was received to save a new user");
		User obtainedUser = userService.obtainUser(currentUser.username);
		if (checkForPasswordEquality(obtainedUser, currentUser)) {
			LOGGER.info("Addition password comparison succeeded");
			obtainedUser = userService.save(currentUser);
			return new ResponseEntity<>(obtainedUser, HttpStatus.OK);
		} else {
			LOGGER.warn("Provided credentials were incorrect");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/users/{enabled}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<User> findAll(@PathVariable("enabled") boolean enabled) {
		LOGGER.info("Request was received to retrieve users starting from page {} with size {}");
		User enabledUser = userService.findByEnabled(enabled);
		// fix
		if (enabledUser != null) {
			LOGGER.info("Request to retrieve enabled users starting from page {} with size {} succeed");
			return new ResponseEntity<>(enabledUser, HttpStatus.CREATED);
		} else {
			LOGGER.warn("Request to retrieve enabled users starting from page {} with size {} failed");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	public User findOne(@PathVariable("id") Long id) {
		LOGGER.info("Request was received to find a single user {}", id);
		return userService.findOne(id);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		LOGGER.info("Request was received to delete a single user {}", id);
		try {
			userService.deleteById(id);
			LOGGER.info("User {} has been deleted successful", id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IllegalArgumentException ex) {
			LOGGER.warn("Error occurred while deleting a user {}", id);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/user/current", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> obtainUser(@RequestBody User currentUser) {
		LOGGER.info("Request was received to obtain user's personal information");
		User obtainedUser = userService.obtainUser(currentUser.username);
		if (checkForPasswordEquality(obtainedUser, currentUser)) {
			LOGGER.info("Personal information was obtained");
			return new ResponseEntity<>(obtainedUser, HttpStatus.OK);
		} else {
			LOGGER.warn("Provided credentials were incorrect");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	private boolean checkForPasswordEquality(User obtainedUser, User currentUser) {
		return obtainedUser.password.equals(currentUser.password);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> register(@RequestBody User user) {
		LOGGER.info("Request was received to create new user");
		User createdUser = userService.register(user);
		if (createdUser != null) {
			LOGGER.info("New user was successfully created");
			return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		} else {
			LOGGER.warn("Request to created a new user failed");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
