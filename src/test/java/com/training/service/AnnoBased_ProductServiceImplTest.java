package com.training.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.training.dal.ProductDAO;
import com.training.domain.Product;

@ExtendWith(MockitoExtension.class)
class AnnoBased_ProductServiceImplTest {

	@Mock
	ProductDAO mockDAO;
	
	@Test
	void addProduct_Returns_Valid_Id_When_Value_GTEQ_MinValue() {
		//AAA
		//Arrange
		ProductServiceImpl objectUnderTest = new ProductServiceImpl();
		Product paramToTestMethod = new Product("test", ProductServiceImpl.MIN_VALUE, 1);
		
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
