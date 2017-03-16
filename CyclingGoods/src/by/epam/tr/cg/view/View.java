package by.epam.tr.cg.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.tr.cg.bean.DeleteProductRequest;
import by.epam.tr.cg.bean.ProductRequest;
import by.epam.tr.cg.bean.Request;
import by.epam.tr.cg.bean.Response;
import by.epam.tr.cg.bean.ShowCategoryRequest;
import by.epam.tr.cg.command.CommandName;
import by.epam.tr.cg.controller.Controller;
import by.epam.tr.cg.entity.Product;

public class View {
	private final static Logger rootLogger = LogManager.getRootLogger();

	public static void main(String[] args) {

		Controller controller = new Controller();

		///////////////////////////////////////////////////////////
		//SHOW ALL PRODUCTS
		Request showAllRequest = new Request();
		showAllRequest.setCommandName(CommandName.SHOW_ALL_PRODUCTS);

		Response response = controller.doAction(showAllRequest);

		if (!response.isErrorStatus()) {
			rootLogger.info(response.getSimpleMessage());
		} else {
			rootLogger.info(response.getErrorMessage());
		}
		ViewHelper.printProductsList(response.getProducts());
		//////////////////////////////////////////////////////////////
		//ADD PRODUCT
		ProductRequest addProductReq = new ProductRequest();
		addProductReq.setCommandName(CommandName.ADD_PRODUCT);
		addProductReq.setProduct(new Product("Equipment","Arms protector", 55));

		response = controller.doAction(addProductReq);

		if (!response.isErrorStatus()) {
			rootLogger.info(response.getSimpleMessage());
		} else {
			rootLogger.info(response.getErrorMessage());
		}
		/////////////////////////////////////////////////////////////
		//DELETE PRODUCT
		DeleteProductRequest deleteProductRequest = new DeleteProductRequest();
		deleteProductRequest.setCommandName(CommandName.DELETE_PRODUCT_BY_ID);
		deleteProductRequest.setId(16);

		response = controller.doAction(deleteProductRequest);

		if (!response.isErrorStatus()) {
			rootLogger.info(response.getSimpleMessage());
		} else {
			rootLogger.info(response.getErrorMessage());
		}
		////////////////////////////////////////////////////////////
		//UPDATE PRODUCT
		ProductRequest updateProductReq = new ProductRequest();
		updateProductReq.setCommandName(CommandName.UPDATE_PRODUCT_BY_ID);
		updateProductReq.setProduct(new Product(12, "Equipment","Arms protector", 55));

		response = controller.doAction(updateProductReq);

		if (!response.isErrorStatus()) {
			rootLogger.info(response.getSimpleMessage());
		} else {
			rootLogger.info(response.getErrorMessage());
		}

		///////////////////////////////////////////////////////////
		//SHOW ALL PRODUCTS
		showAllRequest.setCommandName(CommandName.SHOW_ALL_PRODUCTS);

		response = controller.doAction(showAllRequest);

		if (!response.isErrorStatus()) {
			rootLogger.info(response.getSimpleMessage());
		} else {
			rootLogger.info(response.getErrorMessage());
		}

		ViewHelper.printProductsList(response.getProducts());

		///////////////////////////////////////////////////////////
		//SHOW PRODUCTS IN CATEGORY
		ShowCategoryRequest showCategoryRequest = new ShowCategoryRequest();
		showCategoryRequest.setCommandName(CommandName.SHOW_PRODUCTS_BY_CATEGORY);
		showCategoryRequest.setCategory("Equipment");
		response = controller.doAction(showCategoryRequest);

		if (!response.isErrorStatus()) {
			rootLogger.info(response.getSimpleMessage());
		} else {
			rootLogger.info(response.getErrorMessage());
		}
		ViewHelper.printProductsList(response.getProducts());

		///////////////////////////////////////////////////////////
		//SHOW REPORT
		Request showReportRequest = new Request();
		showReportRequest.setCommandName(CommandName.SHOW_COUNT_MIN_MAX_PRICE_FOR_CATEGORY);
		response = controller.doAction(showReportRequest);

		if (!response.isErrorStatus()) {
			rootLogger.info(response.getSimpleMessage());
		} else {
			rootLogger.info(response.getErrorMessage());
		}

		ViewHelper.printReport(response.getReport());

	}

}
