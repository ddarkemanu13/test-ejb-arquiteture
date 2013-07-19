package org.business.teste.dao.product;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.business.teste.product.Product;
import org.business.teste.utils.dao.DefaultDAO;

@Stateless(name = "ProductDAO")
@Local(IProductDAO.class)
public class ProductDAO extends DefaultDAO<Product> implements IProductDAO {
	
}
