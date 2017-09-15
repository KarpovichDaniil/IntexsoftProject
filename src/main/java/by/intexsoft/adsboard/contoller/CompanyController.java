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

import main.java.by.intexsoft.adsboard.entity.CompanyEntity;
import main.java.by.intexsoft.adsboard.service.CompanyService;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/company")
public class CompanyController {
	private static Logger logger = (Logger) LoggerFactory.getLogger(CompanyController.class.getName());

	@Autowired
	CompanyService companyService;

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody CompanyEntity entity) {
		logger.info("Creation of a new company with name: " + entity.company_name + " and main country"
				+ entity.main_country_id);
		try {
			return new ResponseEntity<CompanyEntity>(companyService.save(entity), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error while saving new company with name: " + entity.company_name + " and main country"
					+ entity.main_country_id);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/del/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		logger.info("Delete company with id= " + id);
		try {
			companyService.deleteById(id);
		} catch (Exception e) {
			logger.error("Company with id= " + id + " is not exist");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping("/all")
	public ResponseEntity<?> findAll() {
		logger.info("Getting all company");
		List<CompanyEntity> resultList = companyService.findAll();
		return new ResponseEntity<List<CompanyEntity>>(resultList, HttpStatus.OK);
	}
}
