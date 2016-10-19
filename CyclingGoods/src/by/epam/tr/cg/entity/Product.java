package by.epam.tr.cg.entity;

public class Product {
	private int id;
	private String category;
	private String name;
	private int price;

	public Product() {
	}

	public Product(String category, String name, int price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public Product(int id, String category, String name, int price) {
		this(category, name, price);
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Product.class.getSimpleName());
		sb.append(": <id = ");
		sb.append(id);
		sb.append(">, <category = ");
		sb.append(category);
		sb.append(">, <name = ");
		sb.append(name);
		sb.append(">, <price = ");
		sb.append(price);
		sb.append(">.");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return 7 * id + 13 * ((category == null) ? 0 : category.hashCode()) + 5 * ((name == null) ? 0 : name.hashCode())
				+ 19 * price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;

		if (id != other.id) {
			return false;
		}
		if (category == null) {
			if (other.category != null) {
				return false;
			}
		} else if (!category.equals(other.category)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (price != other.price) {
			return false;
		}
		return true;
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
