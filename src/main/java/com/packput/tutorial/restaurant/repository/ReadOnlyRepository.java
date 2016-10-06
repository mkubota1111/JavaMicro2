package com.packput.tutorial.restaurant.repository;

import java.util.Collection;

import com.packput.tutorial.restaurant.model.Entity;

public interface ReadOnlyRepository<TE, T> {
	boolean contains(T id);
	Entity<T> get(T id);
	Collection<TE> getAll();
}
