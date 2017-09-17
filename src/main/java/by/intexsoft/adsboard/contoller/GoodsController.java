package main.java.by.intexsoft.adsboard.contoller;

import java.util.List;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.java.by.intexsoft.adsboard.entity.GoodsEntity;
import main.java.by.intexsoft.adsboard.service.GoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	private static Logger logger = (Logger) LoggerFactory.getLogger(CitiesController.class.getName());

	@Autowired
	GoodsService goodsService;

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody GoodsEntity entity) {
		logger.info("Creation of a new goods with title: " + entity.title + " ,description" + entity.description
				+ " ,city" + entity.city_id + " ,user" + entity.user_id + " ,price" + entity.price + " ,created_date"
				+ entity.created_date + " and category" + entity.category_id);
		try {
			return new ResponseEntity<GoodsEntity>(goodsService.save(entity), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error while saving new goods with title: " + entity.title + " ,description" + entity.description
					+ " ,city" + entity.city_id + " ,user" + entity.user_id + " ,price" + entity.price + " ,created_date"
					+ entity.created_date + " or category" + entity.category_id);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/del/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		logger.info("Delete goods with id= " + id);
		try {
			goodsService.deleteById(id);
		} catch (Exception e) {
			logger.error("Goods with id= " + id + " is not exist");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping("/all")
	public ResponseEntity<?> findAll() {
		logger.info("Getting all goods");
		List<GoodsEntity> resultList = goodsService.findAll();
		return new ResponseEntity<List<GoodsEntity>>(resultList, HttpStatus.OK);
	}
}
