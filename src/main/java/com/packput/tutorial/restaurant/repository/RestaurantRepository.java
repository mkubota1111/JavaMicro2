package com.packput.tutorial.restaurant.repository;

public interface RestaurantRepository<Restaurant, String> extends Repository<Restaurant, String> {
	boolean containsName(String name);
}
