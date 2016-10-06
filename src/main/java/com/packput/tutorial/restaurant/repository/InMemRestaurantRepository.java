package com.packput.tutorial.restaurant.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.packput.tutorial.restaurant.model.Entity;
import com.packput.tutorial.restaurant.model.Restaurant;

public class InMemRestaurantRepository implements RestaurantRepository<Restaurant, String> {
	private Map<String, Restaurant> entities;
	
	public InMemRestaurantRepository() {
		entities = new HashMap<>();
	}
	
	@Override
	public boolean containsName(String name) {
		return entities.containsKey(name);
	}

	@Override
	public void add(Restaurant entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Restaurant entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Entity<String> get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Restaurant> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
