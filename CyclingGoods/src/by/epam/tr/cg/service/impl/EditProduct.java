package by.epam.tr.cg.service.impl;

import by.epam.tr.cg.dao.EditCGDao;
import by.epam.tr.cg.dao.exception.DAOException;
import by.epam.tr.cg.dao.factory.DAOFactory;
import by.epam.tr.cg.entity.Product;
import by.epam.tr.cg.service.EditProductService;
import by.epam.tr.cg.service.exception.ServiceException;

public class EditProduct implements EditProductService {

	@Override
	public boolean addProduct(Product product) throws ServiceException {
		if (!Validator.nameValidation(product.getName())) {
			throw new ServiceException("Invalid data.");
		}
		DAOFactory factory = DAOFactory.getInstance();
		EditCGDao cyclingGoodsDao = factory.getEditCGDao();
		try {
			if (!cyclingGoodsDao.addProduct(product)) {
				return false;
			}
		} catch (DAOException e) {
			throw new ServiceException("Add product failed. ", e);
		}
		return true;
	}

	@Override
	public boolean deleteProduct(int id) throws ServiceException {
		if (!Validator.idValidation(id)) {
			throw new ServiceException("Invalid data.");
		}
		DAOFactory factory = DAOFactory.getInstance();
		EditCGDao cyclingGoodsDao = factory.getEditCGDao();
		try {
			if (!cyclingGoodsDao.deleteProduct(id)) {
				return false;
			}
		} catch (DAOException e) {
			throw new ServiceException("Delete product failed. ", e);
		}
		return true;
	}

	@Override
	public boolean updateProduct(Product product) throws ServiceException {
		if (!Validator.idValidation(product.getId())) {
			throw new ServiceException("Invalid data.");
		}
		DAOFactory factory = DAOFactory.getInstance();
		EditCGDao cyclingGoodsDao = factory.getEditCGDao();
		try {
			// если поле не null или не пустое - то его надо изменить
			if (Validator.nameValidation(product.getName())) {
				if (!cyclingGoodsDao.updateNameProduct(product)) {
					return false;
				}
			}
			if (Validator.categoryValidation(product.getCategory())) {
				if (!cyclingGoodsDao.updateCategoryProduct(product)) {
					return false;
				}
			}
			if (Validator.priceValidation(product.getPrice())) {
				if (!cyclingGoodsDao.updatePriceProduct(product)) {
					return false;
				}
			}
		} catch (DAOException e) {
			throw new ServiceException("Update product failed. ", e);
		}
		return true;
	}

	

}
