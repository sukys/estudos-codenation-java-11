package com.challenge.service.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface ServiceInterface<T, J> {
	
	T save(T entity);

	List<T> findAll(Pageable pageable);
	
	void delete(J id);
}
