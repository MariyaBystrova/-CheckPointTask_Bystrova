package by.epam.tr.cg.bean;

import java.util.List;

import by.epam.tr.cg.entity.Product;
import by.epam.tr.cg.entity.ReportLine;

public class Response {
	private boolean errorStatus;
	private String errorMessage;
	private String simpleMessage;
	private List<Product>  products;
	private List<ReportLine> report;
	
	public Response(){
	}
	
	public boolean isErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(boolean errorStatus) {
		this.errorStatus = errorStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getSimpleMessage() {
		return simpleMessage;
	}

	public void setSimpleMessage(String simpleMessage) {
		this.simpleMessage = simpleMessage;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<ReportLine> getReport() {
		return report;
	}

	public void setReport(List<ReportLine> report) {
		this.report = report;
	}
}
