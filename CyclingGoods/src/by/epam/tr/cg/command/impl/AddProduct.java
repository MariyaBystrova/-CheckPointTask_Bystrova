package by.epam.tr.cg.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.tr.cg.bean.ProductRequest;
import by.epam.tr.cg.bean.Request;
import by.epam.tr.cg.bean.Response;
import by.epam.tr.cg.command.Command;
import by.epam.tr.cg.entity.Product;
import by.epam.tr.cg.service.EditProductService;
import by.epam.tr.cg.service.exception.ServiceException;
import by.epam.tr.cg.service.factory.ServiceFactory;

public class AddProduct implements Command {
	
	private final static Logger rootLogger = LogManager.getRootLogger();
	
	private final static String PRODUCT_ADED = "Product was added.";
	private final static String PRODUCT_NOT_ADED = "Product wasn't added.";

	@Override
	public Response execute(Request request) {
		
		ProductRequest addProductRequest = null;
		if(request instanceof ProductRequest){
			addProductRequest = (ProductRequest)request;
		}
		
		Product product = new Product(addProductRequest.getCategory(), addProductRequest.getName(), addProductRequest.getPrice());
		
		ServiceFactory factory = ServiceFactory.getInstance();
		EditProductService editService = factory.getEditProductService();
		
		Response response= new Response();
		try {
			editService.addProduct(product);
			response.setErrorStatus(false);
			response.setSimpleMessage(PRODUCT_ADED);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(PRODUCT_NOT_ADED);
			rootLogger.error(e.getMessage());
		}
		return response;
	}

}
