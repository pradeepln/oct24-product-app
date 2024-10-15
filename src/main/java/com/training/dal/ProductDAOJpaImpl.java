package com.training.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.domain.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

@Primary
@Transactional
@Repository
public class ProductDAOJpaImpl implements ProductDAO{

	@Autowired
	EntityManager em;
	
	@Override
	public Product save(Product toBeSaved) {
		
		em.persist(toBeSaved);
		return toBeSaved;
		
	}

	@Override
	public Product findById(int id) {
		Product p = em.find(Product.class, id);
	
		return p;
	}

	@Override
	public List<Product> findAll() {
		//Query q = em.createQuery("select p from Product as p");
		//return q.getResultList();
		return
				em.createQuery("select p from Product as p")
				.getResultList();
	}

	@Override
	public void deleteById(int id) {
//		Product p = em.find(Product.class, id);
//		em.remove(p);
		
		em
			.createQuery("delete from Product p where p.id=:idParam")
			.setParameter("idParam", id)
			.executeUpdate();
	}

}
