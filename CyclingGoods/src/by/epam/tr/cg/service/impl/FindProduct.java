package by.epam.tr.cg.service.impl;

import java.util.Collections;
import java.util.List;

import by.epam.tr.cg.dao.FindCGDao;
import by.epam.tr.cg.dao.exception.DAOException;
import by.epam.tr.cg.dao.factory.DAOFactory;
import by.epam.tr.cg.entity.Product;
import by.epam.tr.cg.entity.ReportLine;
import by.epam.tr.cg.service.FindProductService;
import by.epam.tr.cg.service.exception.ServiceException;

public class FindProduct implements FindProductService {

	@Override
	public List<Product> getAllProducts() throws ServiceException {
		List<Product> list = null;
		DAOFactory factory = DAOFactory.getInstance();
		FindCGDao cyclingGoodsDao = factory.getFindCGDao();
		try {
			list = cyclingGoodsDao.getAllProducts();
		} catch (DAOException e) {
			throw new ServiceException("Get all products failed. ", e);
		}
		return list;
	}

	@Override
	public List<Product> getCategoryProducts(String category) throws ServiceException {
		if(!Validator.categoryValidation(category)){
			return Collections.emptyList();
		}
		List<Product> list = null;
		DAOFactory factory = DAOFactory.getInstance();
		FindCGDao cyclingGoodsDao = factory.getFindCGDao();
		try {
			list = cyclingGoodsDao.getCategoryProducts(category);
		} catch (DAOException e) {
			throw new ServiceException("Get products by category failed. ", e);
		}
		return list;
	}

	@Override
	public List<ReportLine> getReport() throws ServiceException {
		List<ReportLine> list = null;
		DAOFactory factory = DAOFactory.getInstance();
		FindCGDao cyclingGoodsDao = factory.getFindCGDao();
		try {
			list = cyclingGoodsDao.getReport();
		} catch (DAOException e) {
			throw new ServiceException("Get report failed. ", e);
		}
		return list;
	}
	
	

}
