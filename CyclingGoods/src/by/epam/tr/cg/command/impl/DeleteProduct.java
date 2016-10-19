package by.epam.tr.cg.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.tr.cg.bean.DeleteProductRequest;
import by.epam.tr.cg.bean.Request;
import by.epam.tr.cg.bean.Response;
import by.epam.tr.cg.command.Command;
import by.epam.tr.cg.service.EditProductService;
import by.epam.tr.cg.service.exception.ServiceException;
import by.epam.tr.cg.service.factory.ServiceFactory;

public class DeleteProduct implements Command {
	private final static Logger rootLogger = LogManager.getRootLogger();
	
	private final static String PRODUCT_DELETED = "Product was deleted.";
	private final static String PRODUCT_NOT_DELETED = "Product wasn't deleted.";

	@Override
	public Response execute(Request request) {
		
		DeleteProductRequest deleteProductRequest = null;
		if(request instanceof DeleteProductRequest){
			deleteProductRequest = (DeleteProductRequest)request;
		}
		
		ServiceFactory factory = ServiceFactory.getInstance();
		EditProductService editService = factory.getEditProductService();
		
		Response response= new Response();
		try {
			editService.deleteProduct(deleteProductRequest.getId());
			response.setErrorStatus(false);
			response.setSimpleMessage(PRODUCT_DELETED);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(PRODUCT_NOT_DELETED);
			rootLogger.error(e.getMessage());
		}
		return response;
	}

}
