package com.janani.restapiapp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	public static Connection getConnection() throws Exception {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://35.154.162.204:3337/rev_tasks_db", "root",
					"RevPass123");

		} catch (Exception e) {
			throw new Exception(e);

		}
		return connection;
	}

}
