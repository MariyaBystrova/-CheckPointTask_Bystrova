package by.epam.tr.cg.service;


import by.epam.tr.cg.entity.Product;
import by.epam.tr.cg.service.exception.ServiceException;

public interface EditProductService {
	
	boolean addProduct(Product product) throws ServiceException;
	boolean deleteProduct(int id) throws ServiceException;
	boolean updateProduct(Product product) throws ServiceException;
}
