package com.training.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.domain.Product;
import com.training.service.ProductService;
import com.training.service.ProductServiceImpl;

@Component
public class ProductConsoleUI {

	ProductService service; // = new ProductServiceImpl();

	public ProductConsoleUI() {
		System.out.println("----->>>> ProductConsoleUI constructor");
	}

	@Autowired
	public void setService(ProductService service) {
		System.out.println("----->>>> Injecting service into ui");
		this.service = service;
	}

	public void createProductWithUI() {

		Scanner kb = new Scanner(System.in);

		System.out.println("Enter a name:");
		String name = kb.nextLine();
		System.out.println("Enter a price:");
		float price = Float.parseFloat(kb.nextLine());
		System.out.println("Enter a QoH:");
		int qoh = Integer.parseInt(kb.nextLine());

		Product p = new Product(name, price, qoh);
		int id = service.addProduct(p);

		System.out.println("Created Product with ID: " + id);

	}

	public void deleteProductWithUI() {

		Scanner kb = new Scanner(System.in);

		
		System.out.println("Enter an Id to delete :");
		int id = Integer.parseInt(kb.nextLine());

		
		service.removeExisting(id);

		System.out.println("Deleted Product with ID: " + id);

	}

}
