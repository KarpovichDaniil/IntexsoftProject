package main.java.by.intexsoft.adsboard.contoller;

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

import main.java.by.intexsoft.adsboard.model.Categories;
import main.java.by.intexsoft.adsboard.service.CategoriesService;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
	private static Logger logger = (Logger) LoggerFactory.getLogger(CategoriesController.class.getName());

	@Autowired
	CategoriesService categoryService;

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Categories entity) {
		logger.info("Creation of a new category with name: " + entity.name);
		try {
			return new ResponseEntity<Categories>(categoryService.save(entity), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error while saving new company with name: " + entity.name);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/del/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		logger.info("Delete category with id= " + id);
		try {
			categoryService.deleteById(id);
		} catch (Exception e) {
			logger.error("Category with id= " + id + " is not exist");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping("/all")
	public ResponseEntity<?> findAll() {
		logger.info("Getting all categories");
		List<Categories> resultList = categoryService.findAll();
		return new ResponseEntity<List<Categories>>(resultList, HttpStatus.OK);
	}
}
