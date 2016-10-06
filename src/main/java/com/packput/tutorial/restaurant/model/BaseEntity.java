package com.packput.tutorial.restaurant.model;

public abstract class BaseEntity<T> extends Entity<T> {
	public BaseEntity(T id, String name) {
		super.id = id;
		super.name = name;
	}
	
	public T getId() {
		return super.id;
	}
	
	public void setId(T id) {
		super.id = id;
	}
	
	public String getName() {
		return super.name;
	}
	
	public void setName(String name) {
		super.name = name;
	}
}
