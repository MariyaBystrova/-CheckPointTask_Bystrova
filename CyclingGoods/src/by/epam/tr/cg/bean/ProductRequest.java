package by.epam.tr.cg.bean;

import by.epam.tr.cg.entity.Product;

public class ProductRequest extends Request {

	private Product product;

	public ProductRequest() {
	}

	public ProductRequest(Product product) {
		this.product = product;
	}

	public ProductRequest(String category, String name, int price) {
		this.product = new Product(category, name, price);
	}

	public ProductRequest(int id, String category, String name, int price) {
		this.product = new Product(id, category, name, price);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
