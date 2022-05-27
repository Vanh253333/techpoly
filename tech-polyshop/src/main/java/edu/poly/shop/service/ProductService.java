package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import edu.poly.shop.domain.Product;

public interface ProductService {

	Product getById(Long id);

	void delete(Product entity);

	void deleteById(Long id);

	long count();

	Optional<Product> findById(Long id);

	List<Product> findAllById(Iterable<Long> ids);

	List<Product> findAll(Sort sort);

	List<Product> findAll();

	<S extends Product> S save(S entity);

}
