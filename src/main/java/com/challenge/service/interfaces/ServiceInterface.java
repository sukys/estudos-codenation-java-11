package com.challenge.service.interfaces;

import java.util.List;

public interface ServiceInterface<T, J> {
	
	T save(T entity);

	List<T> findAll();
	
	void delete(J id);
}
