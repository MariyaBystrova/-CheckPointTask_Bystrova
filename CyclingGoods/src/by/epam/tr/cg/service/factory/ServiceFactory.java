package by.epam.tr.cg.service.factory;

import by.epam.tr.cg.service.EditProductService;
import by.epam.tr.cg.service.FindProductService;
import by.epam.tr.cg.service.impl.EditProduct;
import by.epam.tr.cg.service.impl.FindProduct;

public class ServiceFactory {
private static final ServiceFactory instance = new ServiceFactory();
	
	private EditProductService editProductService = new EditProduct();
	private FindProductService findProductService = new FindProduct();
	
	private ServiceFactory(){}
	
	
	public static ServiceFactory getInstance(){
		return instance;
	}
	
	public EditProductService getEditProductService(){
		return editProductService;
	}
	
	public FindProductService getFindProductService(){
		return findProductService;
	}
}
