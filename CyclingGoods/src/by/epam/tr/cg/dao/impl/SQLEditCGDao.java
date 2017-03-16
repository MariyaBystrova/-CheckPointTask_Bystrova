package by.epam.tr.cg.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.epam.tr.cg.dao.EditCGDao;
import by.epam.tr.cg.dao.exception.DAOException;
import by.epam.tr.cg.entity.Product;

public class SQLEditCGDao implements EditCGDao {
	private final static String DRIVER = "org.gjt.mm.mysql.Driver";
	private final static String CONNECTION_URL = "jdbc:mysql://localhost:3306/cycling_products?useSSL=false";
	private final static String CONNECTION_USER = "root";
	private final static String CONNECTION_PASSWORD = "marusya";
	
	private final static String INSERT_INTO_PRODUCT = "INSERT INTO `product`(`product_category`,`product_name`,`product_price`) VALUES(?,?,?);";
	private final static String DELETE_FROM_PRODUCT = "DELETE FROM `product` WHERE `product`.`product_id` = ?;";
	private final static String UPDATE_PRODUCT_NAME_BY_ID = "UPDATE `product` SET `product_name` = ? WHERE `product_id` = ?;";
	private final static String UPDATE_PRODUCT_CATEGORY_BY_ID = "UPDATE `product` SET `product_category` = ? WHERE `product_id` = ?;";
	private final static String UPDATE_PRODUCT_PRICE_BY_ID = "UPDATE `product` SET `product_price` = ? WHERE `product_id` = ?;";

	@Override
	public boolean addProduct(Product p) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
			ps = con.prepareStatement(INSERT_INTO_PRODUCT);
			ps.setString(1, p.getCategory());
			ps.setString(2, p.getName());
			ps.setInt(3, p.getPrice());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new DAOException("No driver found.", e);
		} catch (SQLException e) {
			throw new DAOException("Database access error.", e);
		} finally {
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

		return true;
	}

	@Override
	public boolean deleteProduct(int id) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
			ps = con.prepareStatement(DELETE_FROM_PRODUCT);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new DAOException("No driver found.", e);
		} catch (SQLException e) {
			throw new DAOException("Database access error.", e);
		} finally {
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

		return true;
	}

	@Override
	public boolean updateNameProduct(Product p) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
			ps = con.prepareStatement(UPDATE_PRODUCT_NAME_BY_ID);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getId());
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new DAOException("No driver found.", e);
		} catch (SQLException e) {
			throw new DAOException("Database access error.", e);
		} finally {
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

		return true;
	}

	@Override
	public boolean updateCategoryProduct(Product p) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
			ps = con.prepareStatement(UPDATE_PRODUCT_CATEGORY_BY_ID);
			ps.setString(1, p.getCategory());
			ps.setInt(2, p.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new DAOException("No driver found.", e);
		} catch (SQLException e) {
			throw new DAOException("Database access error.", e);
		} finally {
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

		return true;
	}

	@Override
	public boolean updatePriceProduct(Product p) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
			ps = con.prepareStatement(UPDATE_PRODUCT_PRICE_BY_ID);
			ps.setInt(1, p.getPrice());
			ps.setInt(2, p.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new DAOException("No driver found.", e);
		} catch (SQLException e) {
			throw new DAOException("Database access error.", e);
		} finally {
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

		return true;
	}

}
