package com.project.libraryManagementSystem;

import java.util.Scanner;
import java.sql.*;

public class Service {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * This function is used to add the books to admin page and library page.
	 */

	public void addNewBook() {
		Connection conn = null;

		try {
			String dbURL = "jdbc:mysql://localhost:3306/libraryManagementSystem?useSSL=false";
			String username = "root";
			String password = "1234";
			System.out.print("Enter Book Id: ");

			String bookId = scanner.nextLine();

			System.out.print("Enter Book Name: ");
			String bookName = scanner.nextLine();

			System.out.print("Enter Author Name: ");
			String authorName = scanner.nextLine();

			conn = DriverManager.getConnection(dbURL, username, password);

			String sql = "INSERT INTO books (bookId, bookName, authorName) VALUES (?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, bookId);
			statement.setString(2, bookName);
			statement.setString(3, authorName);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Book added Successfully");
			}
			
		} catch (Exception ex) {
			System.out.println("Sorry!!Book is already there");
		}

		finally {
			// It's important to close the statement when you are done with it
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * This function is used to delete the books from admin page and library page.
	 */
	public void deleteBook() {

		Connection conn = null;

		try {
			boolean found = false;
			String dbURL = "jdbc:mysql://localhost:3306/libraryManagementSystem?useSSL=false";
			String username = "root";
			String password = "1234";
			System.out.print("Enter Book Id: ");

			String BookId = scanner.nextLine();
			conn = DriverManager.getConnection(dbURL, username, password);

			String sql = "delete from books where bookId = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, BookId);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Book deleted Successfully");
				found = true;

			}
			if (!found) {
				System.out.println("Sorry!!Thre is No Book with this Id");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// It's important to close the statement when you are done with it
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void issueBook() {
		Connection conn = null;

		try {
			boolean found = true;
			String dbURL = "jdbc:mysql://localhost:3306/libraryManagementSystem?useSSL=false";
			String username = "root";
			String password = "1234";
			System.out.print("Enter Book Id: ");

			String BookId = scanner.nextLine();
			conn = DriverManager.getConnection(dbURL, username, password);

			String sql = "update books set status = 'Yes'  where bookId = ? and status = 'No' ";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, BookId);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Book added in issued list Successfully");
				found = true;
			}
			if (!found) {
				System.out.println("Sorry!!Thre is No Book with this Id");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// It's important to close the statement when you are done with it
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * This function is used to view available Books in Admin Page.
	 */
	public void adminViewBooks() {
		Connection conn = null;

		try {

			String dbURL = "jdbc:mysql://localhost:3306/libraryManagementSystem?useSSL=false";
			String username = "root";
			String password = "1234";
			conn = DriverManager.getConnection(dbURL, username, password);

			String sql = "select * from books where status = 'No' ";

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			int i = 0;
			if(!rs.isBeforeFirst() && rs.getRow() == 0) {
				System.out.println("Sorry!!!No more books available");
			}
				else {
			while (rs.next()) {
				
				

				String bookId = rs.getString("bookId");
				String bookName = rs.getString("bookName");
				String authorName = rs.getString("authorName");
				System.out.println("\n" + ++i + ".  \n" + "BookId: " + bookId + "\nBookName: " + bookName
						+ "\nAuthorName: " + authorName + "\n"
						+ "-----------------------------------------------------------------------------------------------");

			}}
			

		

				}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// It's important to close the statement when you are done with it
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * This function is used to view available Books in Librarian Page.
	 */
	public void libraryViewBooks() {
		Connection conn = null;
		System.out.println("********************************************");

		try {

			String dbURL = "jdbc:mysql://localhost:3306/libraryManagementSystem?useSSL=false";
			String username = "root";
			String password = "1234";
			conn = DriverManager.getConnection(dbURL, username, password);

			String sql = "select * from books where status = 'No' ";

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			int i = 0;
			if(!rs.isBeforeFirst() && rs.getRow() == 0) {
				System.out.println("Sorry!!!No more books available");
			}
				else {
			while (rs.next()) {

				String bookId = rs.getString("bookId");
				String bookName = rs.getString("bookName");
				String authorName = rs.getString("authorName");
				System.out.println("\n" + ++i + ".  \n" + "BookId: " + bookId + "\nBookName: " + bookName
						+ "\nAuthorName: " + authorName + "\n"
						+ "-----------------------------------------------------------------------------------------------");

			}

		} }catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// It's important to close the statement when you are done with it
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * This function is used to return the book(add the list again to adminbook and
	 * librarianbook)..
	 */
	public void returnedBook() {
		Connection conn = null;
		try {
			boolean found = false;
			String dbURL = "jdbc:mysql://localhost:3306/libraryManagementSystem?useSSL=false";
			String username = "root";
			String password = "1234";
			System.out.print("Enter Book Id: ");

			String BookId = scanner.nextLine();
			conn = DriverManager.getConnection(dbURL, username, password);

			String sql = "update books set status = 'No'  where bookId = ? and status = 'Yes' ";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, BookId);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Book added in issued list Successfully");
				found = true;
			}
			if (!found) {
				System.out.println("Sorry!!Thre is No Book with this Id");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// It's important to close the statement when you are done with it
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
