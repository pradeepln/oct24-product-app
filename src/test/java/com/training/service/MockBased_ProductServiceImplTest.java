package com.training.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.training.dal.ProductDAO;
import com.training.domain.Product;

class MockBased_ProductServiceImplTest {

	//Fast Independent Repeatable Self-Validating Thorough
	@Test
	void addProduct_Returns_Valid_Id_When_Value_GTEQ_MinValue() {
		//AAA
		//Arrange
		ProductServiceImpl objectUnderTest = new ProductServiceImpl();
		Product paramToTestMethod = new Product("test", ProductServiceImpl.MIN_VALUE, 1);
		
		ProductDAO mockDAO = Mockito.mock(ProductDAO.class);
		
		Product mockAnswer = new Product("test", ProductServiceImpl.MIN_VALUE, 1);
		mockAnswer.setId(1);
		
		Mockito.when(mockDAO.save(paramToTestMethod)).thenReturn(mockAnswer);
		
		objectUnderTest.setDao(mockDAO);
		
		//Act
		int id = objectUnderTest.addProduct(paramToTestMethod);
		//Assert
		assertTrue(id > 0);
	}

}
