package com.packput.tutorial.restaurant.model;

public abstract class BaseEntity<T> extends Entity<T> {
	private T id;
	private boolean isModified;
	private String name;
	
	public BaseEntity(T id, String name) {
		super.id = id;
		super.name = name;
	}
	
	@Override
	public T getId() {
		return id;
	}
	
	@Override
	public void setId(T id) {
		this.id = id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isIsModified() {
		return isModified;
	}
	
	public void setIsModified(boolean isModified) {
		this.isModified = isModified;
	}
}
