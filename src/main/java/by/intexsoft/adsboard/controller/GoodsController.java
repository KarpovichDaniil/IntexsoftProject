package by.intexsoft.adsboard.controller;

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

import by.intexsoft.adsboard.model.Goods;
import by.intexsoft.adsboard.service.GoodsService;

@RestController
public class GoodsController {
	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(GoodsController.class.getName());

	private final GoodsService goodsService;

	@Autowired
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@RequestMapping(value = "/goods", method = RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<Goods>> findAll() {
	        LOGGER.info("Request was received to retrieve all users");
	        return new ResponseEntity<>(goodsService.findAll(), HttpStatus.OK);
	    }
	

	@RequestMapping(value = "/goods", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Goods> save(@RequestBody Goods goods) {
		LOGGER.info("Request was received to save goods {}", goods.getId());
		Goods oneGoods = goodsService.save(goods);
		if (oneGoods != null) {
			LOGGER.info("Single goods {} has been saved", oneGoods.getId());
			return new ResponseEntity<>(oneGoods, HttpStatus.CREATED);
		} else {
			LOGGER.info("Single goods {} hasn't been saved", goods.getId());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/goods/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        LOGGER.info("Request was received to delete a single goods {}", id);
        try {
            goodsService.deleteById(id);
            LOGGER.info("Success goods {} has been deleted", id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            LOGGER.warn("Error occurred while deleting a goods {}", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

	@RequestMapping(value = "/goods/{id}", method = RequestMethod.GET, produces = "application/json")
	public Goods findOne(@PathVariable("id") long id) {
		LOGGER.info("Request was received to find a single user {}", id);
		return goodsService.findOne(id);
	}
	
	@RequestMapping(value = "/goods/category/{categoryId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Goods>> findAll(@PathVariable("categoryId") long categoryId) {
		LOGGER.info("Request was received to retrieve goods");
		List<Goods> categoryGoods = goodsService.findByCategoryId(categoryId);

		if (categoryGoods != null) {
			LOGGER.info("Request to retrieve reviewed goods succeed");
			return new ResponseEntity<>(categoryGoods, HttpStatus.CREATED);
		} else {
			LOGGER.warn("Request to retrieve reviewed goods failed");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}	
}
