package com.training.web;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.training.ProductAppApplication;
import com.training.dal.ProductDAO;
import com.training.domain.Product;

@AutoConfigureMockMvc
@SpringBootTest(classes = {ProductAppApplication.class},webEnvironment = WebEnvironment.MOCK)
@TestPropertySource("classpath:application-it.properties")
class ProductControllerIntegrationTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ProductDAO dao;
	
	@Test
	void testGetProductById() throws Exception  {
		//AAA
		//Arrange
		Product sampleRow = new Product("testCasePrd", 100001, 1);
		Product saved = dao.save(sampleRow);
		int id = saved.getId();
		//Act and Assert
		mockMvc
		.perform(MockMvcRequestBuilders.get("/products/{id}", id))
		.andExpect(MockMvcResultMatchers.status().is(200))
		.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(id)));
	}

}
