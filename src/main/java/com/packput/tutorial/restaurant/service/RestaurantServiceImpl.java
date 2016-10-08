package com.packput.tutorial.restaurant.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packput.tutorial.restaurant.model.Entity;
import com.packput.tutorial.restaurant.model.Restaurant;
import com.packput.tutorial.restaurant.repository.RestaurantRepository;

@Service("restaurantService")
public class RestaurantServiceImpl extends BaseService<Restaurant, String> implements RestaurantService {
	private RestaurantRepository<Restaurant, String> restaurantRepository;
	
	@Autowired
	public RestaurantServiceImpl(RestaurantRepository<Restaurant, String> restaurantRepository) {
		super(restaurantRepository);
		this.restaurantRepository = restaurantRepository;
	}
	
	@Override
	public void add(Restaurant restaurant) throws Exception {
		if (restaurant.getName() == null || "".equals(restaurant.getName())) {
			throw new Exception("Restaurant name cannot be null or empty string");
		}
		
		if (restaurantRepository.containsName(restaurant.getName())) {
			throw new Exception(String.format("There is already a product with the name %s", restaurant.getName()));
		}
		
		super.add(restaurant);
	}
	
	@Override
	public Collection<Restaurant> findByName(String name) throws Exception {
		return restaurantRepository.findByName(name);
	}

	@Override
	public void update(Restaurant restaurant) throws Exception {
		restaurantRepository.update(restaurant);
	}

	@Override
	public void delete(String id) throws Exception {
		restaurantRepository.remove(id);
	}

	@Override
	public Entity<String> findById(String restaurantId) throws Exception {
		return restaurantRepository.get(restaurantId);
	}

	@Override
	public Collection<Restaurant> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
