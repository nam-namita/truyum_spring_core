package com.cognizant.truyum.dao;

import java.util.*;
import java.sql.*;
import java.io.*;

public class ConnectionHandler {

	public static Connection con = null;
	public static Properties prop = new Properties();

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		try {
			FileInputStream fis = null;
			fis = new FileInputStream("connection.properties");
			// "truYum/src/connection.properties"
			// "C:\\GenC_877602\\truYum\\src\\connection.properties"
			prop.load(fis);

			Class.forName(prop.getProperty("driver"));// loading Driver Class
			con = DriverManager.getConnection(prop.getProperty("connection-url"), prop.getProperty("user"),
					prop.getProperty("password"));
		}

		catch (IOException e) {
			System.out.println("Connection not established");
			System.out.println(e);
		}
		return con;
	}
}