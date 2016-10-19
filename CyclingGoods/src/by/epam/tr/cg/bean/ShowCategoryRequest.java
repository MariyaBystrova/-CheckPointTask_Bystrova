package by.epam.tr.cg.bean;

public class ShowCategoryRequest extends Request {
	private String category;
	
	public ShowCategoryRequest() {
	}
	public ShowCategoryRequest(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
