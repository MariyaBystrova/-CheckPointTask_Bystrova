package by.epam.tr.cg.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.epam.tr.cg.dao.FindCGDao;
import by.epam.tr.cg.dao.exception.DAOException;
import by.epam.tr.cg.entity.Product;
import by.epam.tr.cg.entity.ReportLine;

public class SQLFindCGDao implements FindCGDao {
	private final static String DRIVER = "org.gjt.mm.mysql.Driver";
	private final static String CONNECTION_URL = "jdbc:mysql://localhost:3306/cycling_products?useSSL=false";
	private final static String CONNECTION_USER = "root";
	private final static String CONNECTION_PASSWORD = "marusya";
	
	private final static String SELECT_ALL_FROM_PRODUCT = "SELECT `product`.`product_id`,`product`.`product_category`,`product`.`product_name`,`product`.`product_price`FROM `product`;";
	private final static String SELECT_FROM_PRODUCT_WHERE_CATEGORY = "SELECT `product`.`product_id`, `product`.`product_category`, `product`.`product_name`,  `product`.`product_price` FROM `product` WHERE `product`.`product_category` = ?;";
	private final static String SELECT_CATEGORY_PRODUCTCOUNT_MIN_MAX_PRICE_FROM_PRODUCT = "SELECT `product`.`product_category`, COUNT(*),  MIN(`product_price`),  MAX(`product_price`) FROM `product` GROUP BY `product`.`product_category`;";

	@Override
	public List<Product> getAllProducts() throws DAOException {
		Connection con = null;
		Statement s = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
			s = con.createStatement();
			rs = s.executeQuery(SELECT_ALL_FROM_PRODUCT);
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (ClassNotFoundException e) {
			throw new DAOException("No driver found.", e);
		} catch (SQLException e) {
			throw new DAOException("Database access error.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new DAOException("Database access error.", e);
			}
			try {
				if (s != null) {
					s.close();
				}
			} catch (SQLException e) {
				throw new DAOException("Database access error.", e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException("Database access error.", e);
			}

		}

		return list;
	}

	@Override
	public List<Product> getCategoryProducts(String category) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
			ps = con.prepareStatement(SELECT_FROM_PRODUCT_WHERE_CATEGORY);
			ps.setString(1, category);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (ClassNotFoundException e) {
			throw new DAOException("No driver found.", e);
		} catch (SQLException e) {
			throw new DAOException("Database access error.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new DAOException("Database access error.", e);
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				throw new DAOException("Database access error.", e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException("Database access error.", e);
			}

		}

		return list;
	}

	@Override
	public List<ReportLine> getReport() throws DAOException {
		Connection con = null;
		Statement s = null;
		ResultSet rs = null;
		List<ReportLine> list = new ArrayList<>();
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
			s = con.createStatement();
			rs = s.executeQuery(SELECT_CATEGORY_PRODUCTCOUNT_MIN_MAX_PRICE_FROM_PRODUCT);
			while (rs.next()) {
				list.add(new ReportLine(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (ClassNotFoundException e) {
			throw new DAOException("No driver found.", e);
		} catch (SQLException e) {
			throw new DAOException("Database access error.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new DAOException("Database access error.", e);
			}
			try {
				if (s != null) {
					s.close();
				}
			} catch (SQLException e) {
				throw new DAOException("Database access error.", e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException("Database access error.", e);
			}

		}

		return list;
	}
}
