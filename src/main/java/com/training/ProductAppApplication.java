package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.training.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductAppApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer = 
					SpringApplication.run(ProductAppApplication.class, args);
		
		System.out.println("-------------- Creattion of ApplicationContext is now complete -------------");
		
		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class); //new ProductConsoleUI();
		//ProductConsoleUI ui2 = springContainer.getBean(ProductConsoleUI.class);
		
		//System.out.println("Are they same obj? "+(ui == ui2));
		
		ui.createProductWithUI();
		
		ui.deleteProductWithUI();
	}

}
