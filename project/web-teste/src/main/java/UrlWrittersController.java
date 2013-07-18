import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.business.teste.product.Product;
import org.business.teste.service.product.IProductService;

@ManagedBean(name = "urlWrittersController")
@SessionScoped
public class UrlWrittersController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Product> products;
	
	private Product productSelected;
	private String idUrlParam;
	
	@EJB
	private IProductService productService;
	
	@PostConstruct
	public void listAllproducts() {
		this.products = this.productService.findAll();
	}
	
	public void openProduct() {
		this.productSelected = this.productService.findById(Long.valueOf(this.idUrlParam));
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getProductSelected() {
		return productSelected;
	}

	public void setProductSelected(Product productSelected) {
		this.productSelected = productSelected;
	}

	public String getIdUrlParam() {
		return idUrlParam;
	}

	public void setIdUrlParam(String idUrlParam) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		this.idUrlParam = idUrlParam;
	}
}
