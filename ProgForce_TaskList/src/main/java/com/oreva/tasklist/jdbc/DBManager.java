package com.oreva.tasklist.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private JDBCProperties properties;
	private static DBManager instance;

	private DBManager() {
		try {
			properties = new JDBCProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static DBManager instance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				url(),
				properties.getProperty(JDBCProperties.USER),
				properties.getProperty(JDBCProperties.PASSWORD)
		);
	}

	private String url() {
		String host = properties.getProperty(JDBCProperties.HOST);
		if (!host.isEmpty()) {
			host = "//" + host;
		}
		String port = properties.getProperty(JDBCProperties.PORT);
		if (!port.isEmpty()) {
			port = ":" + port + "/";
		}
		return "jdbc:" +
				properties.getProperty(JDBCProperties.DRIVER_NAME) + ":" +
				host +
				port +
				properties.getProperty(JDBCProperties.DB_NAME);
	}
}
