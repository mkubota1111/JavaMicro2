package com.packput.tutorial.restaurant.service;

import com.packput.tutorial.restaurant.model.Restaurant;
import com.packput.tutorial.restaurant.repository.RestaurantRepository;

public class RestaurantService extends BaseService<Restaurant, String> {
	private RestaurantRepository<Restaurant, String> restaurantRepository;
	
	public RestaurantService(RestaurantRepository<Restaurant, String> repository) {
		super(repository);
		restaurantRepository = repository;
	}
	
	public void add(Restaurant restaurant) throws Exception {
		if (restaurantRepository.containsName(restaurant.getName())) {
			throw new Exception(String.format("There is already a product with the name - %s", 
					restaurant.getName()));
		}
		
		if (restaurant.getName() == null || "".equals(restaurant.getName())) {
			throw new Exception("Restaurant name cannot be null or empty string");
		}
		
		super.add(restaurant);
	}
}
