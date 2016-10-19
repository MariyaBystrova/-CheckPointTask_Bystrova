package by.epam.tr.cg.command.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.tr.cg.bean.Request;
import by.epam.tr.cg.bean.Response;
import by.epam.tr.cg.command.Command;
import by.epam.tr.cg.entity.Product;
import by.epam.tr.cg.service.FindProductService;
import by.epam.tr.cg.service.exception.ServiceException;
import by.epam.tr.cg.service.factory.ServiceFactory;

public class ShowAllProducts implements Command {
	private final static Logger rootLogger = LogManager.getRootLogger();
	
	private final static String PRODUCTS_READ = "Products were read.";
	private final static String PRODUCTS_NOT_READ = "Products were not read.";
	
	@Override
	public Response execute(Request request) {
		
		ServiceFactory factory = ServiceFactory.getInstance();
		FindProductService findService = factory.getFindProductService();

		Response response = new Response();
		try {
			List<Product> list = findService.getAllProducts();
			response.setProducts(list);
			response.setErrorStatus(false);
			response.setSimpleMessage(PRODUCTS_READ);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(PRODUCTS_NOT_READ);
			rootLogger.error(e.getMessage());
		}
		return response;
	}

}
