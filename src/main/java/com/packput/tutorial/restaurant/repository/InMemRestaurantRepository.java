package com.packput.tutorial.restaurant.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.packput.tutorial.restaurant.model.Entity;
import com.packput.tutorial.restaurant.model.Restaurant;

@Repository("restaurantRepository")
public class InMemRestaurantRepository implements RestaurantRepository<Restaurant, String> {
	private static final Logger logger = Logger.getLogger(InMemRestaurantRepository.class.getName());
	
	private Map<String, Restaurant> entities;
	
	public InMemRestaurantRepository() {
		entities = new HashMap<>();
		Restaurant restaurant = new Restaurant("Big-O Restaurant", "1", null);
		entities.put("1", restaurant);
		restaurant = new Restaurant("O Restaurant", "2", null);
		entities.put("2", restaurant);
	}
	
	@Override
	public boolean containsName(String name) {
		try {
			return !this.findByName(name).isEmpty();
		}
		catch (Exception e) {
			logger.error("Contains name error ", e);
		}
		return false;
	}

	@Override
	public void add(Restaurant entity) {
		entities.put(entity.getName(), entity);
	}

	@Override
	public void remove(String id) {
		if (entities.containsKey(id)) {
			entities.remove(id);
		}
	}

	@Override
	public void update(Restaurant entity) {
		if (entities.containsKey(entity.getName())) {
			entities.put(entity.getId(), entity);
		}
	}
	
	@Override
	public Collection<Restaurant> findByName(String name) throws Exception {
		Collection<Restaurant> restaurants = new ArrayList<>();
		int noOfChars = name.length();
		entities.forEach((k, v) -> {
			if (v.getName().toLowerCase().contains(name.subSequence(0, noOfChars))) {
				restaurants.add(v);
			}
		});
		
		return restaurants;
	}

	@Override
	public boolean contains(String id) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Entity<String> get(String id) {
		return entities.get(id);
	}

	@Override
	public Collection<Restaurant> getAll() {
		return entities.values();
	}
}
