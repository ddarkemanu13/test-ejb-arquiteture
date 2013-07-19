package org.business.teste.service.product;

import java.util.List;

import org.business.teste.product.Product;

public interface IProductService {
	
	public static final String SERVICE_JNDI = "java:global/portal-app/business-teste/ProductService";
	
	Product findById(Long id);
	
	List<Product> findAll();

}
