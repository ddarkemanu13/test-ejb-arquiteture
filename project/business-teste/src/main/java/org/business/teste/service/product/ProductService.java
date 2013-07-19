package org.business.teste.service.product;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.business.teste.dao.product.IProductDAO;
import org.business.teste.product.Product;

@Stateless(name = "ProductService")
@Remote(IProductService.class)
public class ProductService implements IProductService{

	@EJB
	IProductDAO productDAO;
	
	@Override
	public Product findById(Long id) {
		return this.productDAO.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return this.productDAO.findAll();
	}

}
