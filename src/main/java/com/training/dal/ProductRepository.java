package com.training.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	public List<Product> findByPrice(float price);
	public List<Product> findByPriceLessThan(float price);
	public List<Product> findByNameLike(float price);
	
	@Query("select p from Product as p where p.qoh>:qParam")
	public List<Product> myComplexQuery(@Param("qParam") int num);
}
