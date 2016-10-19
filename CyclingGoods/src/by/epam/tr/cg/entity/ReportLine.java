package by.epam.tr.cg.entity;

public class ReportLine {
	private String category;
	private int productsCount;
	private int minPrice;
	private int maxPrice;

	public ReportLine() {
	}

	public ReportLine(String category, int productsCount, int minPrice, int maxPrice) {
		this.category = category;
		this.productsCount = productsCount;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ReportLine.class.getSimpleName());
		sb.append(": <category = ");
		sb.append(category);
		sb.append(">, <productsCount = ");
		sb.append(productsCount);
		sb.append(">, <minPrice = ");
		sb.append(minPrice);
		sb.append(">, <maxPrice = ");
		sb.append(maxPrice);
		sb.append(">.");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return 7 * ((category == null) ? 0 : category.hashCode()) + 13 * productsCount + 17 * minPrice + 29 * maxPrice;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		ReportLine other = (ReportLine) obj;
		if (category == null) {
			if (other.category != null){
				return false;
			}
		} else if (!category.equals(other.category)){
			return false;
		}
		if (maxPrice != other.maxPrice){
			return false;
		}
		if (minPrice != other.minPrice){
			return false;
		}
		if (productsCount != other.productsCount){
			return false;
		}
		return true;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getProductsCount() {
		return productsCount;
	}

	public void setProductsCount(int productsCount) {
		this.productsCount = productsCount;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
}
