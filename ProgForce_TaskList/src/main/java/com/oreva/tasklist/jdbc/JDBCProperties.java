package com.oreva.tasklist.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCProperties {
	private static final String defaultPropertyFile = "src/main/resources/jdbc.properties";

	public static final String JDBC_DRIVER = "JDBC_DRIVER";
	public static final String USER = "USER";
	public static final String PASSWORD = "PASSWORD";
	public static final String DRIVER_NAME = "DRIVER_NAME";
	public static final String HOST = "HOST";
	public static final String PORT = "PORT";
	public static final String DB_NAME = "DB_NAME";

	private Properties props;

	public JDBCProperties() throws IOException {
		this(defaultPropertyFile);
	}

	public JDBCProperties(String propertyFile) throws IOException {
        props = new Properties();
        FileReader in = new FileReader(propertyFile);
        props.load(in);
        in.close();
    }

	public String getProperty(String property) {
		return props.getProperty(property);
	}
}
