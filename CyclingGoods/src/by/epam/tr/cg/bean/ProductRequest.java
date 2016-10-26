package by.epam.tr.cg.bean;

public class ProductRequest extends Request {
	private int id;// Мария, а создать класс Product никак нельзя было?
	private String category;
	private String name;
	private int price;

	public ProductRequest() {
	}

	public ProductRequest(String category, String name, int price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public ProductRequest(int id, String category, String name, int price) {
		this(category, name, price);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
