package by.epam.tr.cg.service;

import java.util.List;

import by.epam.tr.cg.entity.Product;
import by.epam.tr.cg.entity.ReportLine;
import by.epam.tr.cg.service.exception.ServiceException;

public interface FindProductService {

	List<Product> getAllProducts() throws ServiceException;
	List<Product> getCategoryProducts(String category) throws ServiceException;
	List<ReportLine> getReport() throws ServiceException;
}
