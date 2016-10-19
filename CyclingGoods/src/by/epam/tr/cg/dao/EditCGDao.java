package by.epam.tr.cg.dao;


import by.epam.tr.cg.dao.exception.DAOException;
import by.epam.tr.cg.entity.Product;

public interface EditCGDao {
	
	boolean addProduct(Product p) throws DAOException;
	boolean deleteProduct(int id) throws DAOException;
	boolean updateNameProduct(Product p) throws DAOException;
	boolean updateCategoryProduct(Product p) throws DAOException;
	boolean updatePriceProduct(Product p) throws DAOException;
}
