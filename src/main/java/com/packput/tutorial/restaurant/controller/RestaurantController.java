package com.packput.tutorial.restaurant.controller;

import java.util.Collection;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packput.tutorial.restaurant.model.Entity;
import com.packput.tutorial.restaurant.model.Restaurant;
import com.packput.tutorial.restaurant.service.RestaurantService;
import com.packput.tutorial.restaurant.vo.RestaurantVO;

@RestController
@RequestMapping("/v1/restaurants")
public class RestaurantController {
	protected Logger logger = Logger.getLogger(RestaurantController.class.getName());
	
	protected RestaurantService restaurantService;
	
	@Autowired
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	/**
	 * Fetch restaurants with the specified name. A partial case-insensitive
	 * match is supported.
	 * @param name
	 * @return A non-null, non-empty collection of restaurants.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Collection<Restaurant>> findByName(@RequestParam("name") String name) {
		logger.info(String.format("restaurant-service findByName() invoked: {} for {}", 
				restaurantService.getClass().getName(),
				name));
		Collection<Restaurant> restaurants;
		try {
			restaurants = restaurantService.findByName(name);
		}
		catch(Exception e) {
			logger.warn("Exception raised findByName REST call", e);
			return new ResponseEntity<Collection<Restaurant>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return !restaurants.isEmpty() ? new ResponseEntity<Collection<Restaurant>>(restaurants, HttpStatus.OK)
				: new ResponseEntity<Collection<Restaurant>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Fetch restaurants with the given id
	 * @param restaurant_id
	 * @return A restaurant
	 */
	@RequestMapping(value="/{restaurant_id}", method=RequestMethod.GET)
	public ResponseEntity<Entity<String>> findById(@PathVariable("restaurant_id") String id) {
		logger.info(String.format("restaurant-service findById() invoked: {} for {}",
				restaurantService.getClass().getName(),
				id));
		id = id.trim();
		Entity<String> restaurant;
		try {
			restaurant = restaurantService.findById(id);
		}
		catch(Exception e) {
			logger.error("Exception raised findById REST Call", e);
			return new ResponseEntity<Entity<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return restaurant != null ? new ResponseEntity<Entity<String>>(restaurant, HttpStatus.OK) :
			new ResponseEntity<Entity<String>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Add restaurant with the specified information
	 * @param Restaurant
	 * @return a non-null restaurant
	 * @throws RestaurantNotFoundException if there are no matches at all
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Restaurant> add(@RequestBody RestaurantVO restaurantVO) {
		logger.info(String.format("restaurant-service add() invoked: %s for %s", 
				restaurantService.getClass().getName(), 
				restaurantVO.getName()));
		Restaurant restaurant = new Restaurant(null, null, null);
		BeanUtils.copyProperties(restaurantVO, restaurant);
		try {
			restaurantService.add(restaurant);
		}
		catch (Exception e) {
			logger.warn("Exception raised add restaurant REST call", e);
			return new ResponseEntity<Restaurant>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<Restaurant>(HttpStatus.CREATED);
	}
}
