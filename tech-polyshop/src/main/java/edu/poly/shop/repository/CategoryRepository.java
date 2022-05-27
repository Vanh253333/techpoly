package edu.poly.shop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	List<Category> findByNameContaining(@Param("name") String name);
	Page<Category> findByNameContaining(@Param("name") String name, Pageable pageable);

}
