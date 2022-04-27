package com.project.libraryManagementSystem;
import java.sql.DriverManager;
import java.sql.*;
public class DBConnection {

		private static Connection conn = null;

		public static Connection getInstance() {
			String dbURL = "jdbc:mysql://localhost:3306/libraryManagementSystem?useSSL=false";
			String username = "root";
			String password = "1234";

			try {
				if (conn == null) {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(dbURL, username, password);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

			return conn;
		}
	}

