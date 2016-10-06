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
			entities.put(entity.getName(), entity);
		}
	}

	@Override
	public boolean contains(String id) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Entity<String> get(String id) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Collection<Restaurant> getAll() {
		return entities.values();
	}
}
