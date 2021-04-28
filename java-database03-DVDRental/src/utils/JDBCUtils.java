package utils;

import java.sql.*;

public class JDBCUtils {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	public static final String URL = "jdbc:mysql://localhost:3306/sakila";

	public static final String USER = "root";

	public static final String PASSWORD = "wzy950505";
	static {
			try {
				//1. 加载驱动
				Class.forName(DRIVER);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();

			}
		}

	public static Connection getConnnection() {
		Connection conn = null;

		try {
		//2 获取数据
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * 释放连接
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		conn = null;
	}

	/**
	 * 释放 stateemne
	 * @param statement
	 * @throws Exception
	 */
	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		statement = null;
	}

	/**
	 * 释放 ResultSet
	 * @param resultSet
	 */
	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		resultSet = null;
	}

	/**
	 * 释放所有数据库资源
	 * @param conn
	 * @param resultSet
	 * @param statement
	 */
	public static void closeResource(Connection conn, ResultSet resultSet, Statement statement) {
		closeConnection(conn);
		closeResultSet(resultSet);
		closeStatement(statement);
	}
}
