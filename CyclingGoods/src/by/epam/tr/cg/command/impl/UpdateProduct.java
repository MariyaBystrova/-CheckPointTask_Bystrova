package by.epam.tr.cg.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.tr.cg.bean.ProductRequest;
import by.epam.tr.cg.bean.Request;
import by.epam.tr.cg.bean.Response;
import by.epam.tr.cg.command.Command;
import by.epam.tr.cg.service.EditProductService;
import by.epam.tr.cg.service.exception.ServiceException;
import by.epam.tr.cg.service.factory.ServiceFactory;

public class UpdateProduct implements Command {
	private final static Logger rootLogger = LogManager.getRootLogger();

	private final static String PRODUCT_UPDATED = "Product was updated.";
	private final static String PRODUCT_NOT_UPDATED = "Product wasn't updated.";
	
	@Override
	public Response execute(Request request) {

		ProductRequest updateProductRequest = null;
		if (request instanceof ProductRequest) {
			updateProductRequest = (ProductRequest) request;
		}

		ServiceFactory factory = ServiceFactory.getInstance();
		EditProductService editService = factory.getEditProductService();

		Response response = new Response();
		try {
			editService.updateProduct(updateProductRequest.getProduct());
			response.setErrorStatus(false);
			response.setSimpleMessage(PRODUCT_UPDATED);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(PRODUCT_NOT_UPDATED);
			rootLogger.error(e.getMessage());
		}
		return response;
	}

}
