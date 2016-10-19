package by.epam.tr.cg.dao.factory;

import by.epam.tr.cg.dao.EditCGDao;
import by.epam.tr.cg.dao.FindCGDao;
import by.epam.tr.cg.dao.impl.SQLEditCGDao;
import by.epam.tr.cg.dao.impl.SQLFindCGDao;

public class DAOFactory {
	private static final DAOFactory INSTANCE = new DAOFactory();
	
	private EditCGDao editCGDao = new SQLEditCGDao();
	private FindCGDao findCGDao = new SQLFindCGDao();
	
	private DAOFactory(){}
	
	public static DAOFactory getInstance(){
		return INSTANCE;
	}

	public EditCGDao getEditCGDao() {
		return editCGDao;
	}

	public FindCGDao getFindCGDao() {
		return findCGDao;
	}
}
