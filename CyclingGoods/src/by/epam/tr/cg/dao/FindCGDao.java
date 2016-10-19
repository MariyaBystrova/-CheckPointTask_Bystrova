package by.epam.tr.cg.dao;

import java.util.List;

import by.epam.tr.cg.dao.exception.DAOException;
import by.epam.tr.cg.entity.Product;
import by.epam.tr.cg.entity.ReportLine;

public interface FindCGDao {
	List<Product> getAllProducts() throws DAOException;
	List<Product> getCategoryProducts(String category) throws DAOException;
	List<ReportLine> getReport() throws DAOException;
}
