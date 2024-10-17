package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.training.dal.ProductRepository;
import com.training.domain.Product;
import com.training.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductAppApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer = 
					SpringApplication.run(ProductAppApplication.class, args);
		
		System.out.println("-------------- Creattion of ApplicationContext is now complete -------------");
		
		//ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class); //new ProductConsoleUI();
		//ProductConsoleUI ui2 = springContainer.getBean(ProductConsoleUI.class);
		
		//System.out.println("Are they same obj? "+(ui == ui2));
		
		//ui.createProductWithUI();
		
		//ui.deleteProductWithUI();
		
		//testRepository(springContainer);
	}

	private static void testRepository(ApplicationContext springContainer) {
		
		ProductRepository repo = springContainer.getBean(ProductRepository.class);
		
		Product sample = new Product("repo", 10000f, 10);
		
		Product saved = repo.save(sample);
		
		System.out.println("Saved using repo product with id: "+saved.getId());
		
		System.out.println("-------------- all products -------------");
		repo.findAll().forEach(p -> System.out.println(p.getName()));
	}

}
