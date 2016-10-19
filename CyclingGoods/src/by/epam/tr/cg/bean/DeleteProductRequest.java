package by.epam.tr.cg.bean;

public class DeleteProductRequest extends Request{
	private int id;

	public DeleteProductRequest() {
	}
	public DeleteProductRequest(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
