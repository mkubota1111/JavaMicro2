package com.packput.tutorial.restaurant.service;

import com.packput.tutorial.restaurant.repository.Repository;

public abstract class ReadOnlyBaseService<TE, T> {
	private Repository<TE, T> repository;
	
	public ReadOnlyBaseService(Repository<TE, T> repository) {
		this.repository = repository;
	}
}
