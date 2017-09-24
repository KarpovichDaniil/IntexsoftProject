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

import by.intexsoft.adsboard.model.Cities;
import by.intexsoft.adsboard.service.CitiesService;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/cities")
public class CitiesController {
	private static Logger logger = (Logger) LoggerFactory.getLogger(CitiesController.class.getName());

	@Autowired
	private final CitiesService citiesService;

	@Autowired
	public CitiesController(CitiesService citiesService) {
		this.citiesService = citiesService;
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Cities entity) {
		logger.info("Creation of a new city with name: " + entity.name);
		try {
			return new ResponseEntity<Cities>(citiesService.save(entity), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error while saving new city with name: " + entity.name);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/del/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		logger.info("Delete city with id= " + id);
		try {
			citiesService.deleteById(id);
		} catch (Exception e) {
			logger.error("City with id= " + id + " is not exist");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping("/all")
	public ResponseEntity<?> findAll() {
		logger.info("Getting all cities");
		List<Cities> resultList = citiesService.findAll();
		return new ResponseEntity<List<Cities>>(resultList, HttpStatus.OK);
	}
}
