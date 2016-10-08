package com.packput.tutorial.restaurant.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.packput.tutorial.restaurant.model.Entity;
import com.packput.tutorial.restaurant.model.Restaurant;

public interface RestaurantService {
	void add(Restaurant restaurant) throws Exception;
	void update(Restaurant restaurant) throws Exception;
	void delete(String id) throws Exception;
	Entity<String> findById(String restaurantId) throws Exception;
	Collection<Restaurant> findByName(String name) throws Exception;
	Collection<Restaurant> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
