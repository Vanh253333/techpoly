package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.poly.shop.domain.Category;

public interface CategoryService {

	Category getById(Long id);

	void deleteAll();

	void delete(Category entity);

	<S extends Category> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Category> List<S> saveAll(Iterable<S> entities);

	Optional<Category> findById(Long id);

	List<Category> findAllById(Iterable<Long> ids);
	
	List<Category> findAll();

	Page<Category> findAll(Pageable pageable);

	<S extends Category> S save(S entity);

	List<Category> findByNameContaining(String name);

	void deleteById(Long id);

	Page<Category> findByNameContaining(String name, Pageable pageable);

}
