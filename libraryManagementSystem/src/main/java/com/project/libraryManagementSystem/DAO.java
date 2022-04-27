package com.project.libraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	public Connection conn = DBConnection.getInstance();

	public int add(Book book) throws Exception {

		String sql = "INSERT INTO books (bookId, bookName, authorName) VALUES (?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, book.getBookId());
		statement.setString(2, book.getBookName());
		statement.setString(3, book.getAuthorName());

		int rowsInserted = statement.executeUpdate();
		return rowsInserted;
	}

	public int delete(Book book) throws Exception {

		String sql = "delete from books where bookId = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, book.getBookId());
		int rowsDeleted = statement.executeUpdate();
		return rowsDeleted;

	}

	public int issue(Book book) throws Exception {

		String sql = "update books set status = 'Yes'  where bookId = ? and status = 'No' ";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, book.getBookId());
		int issuedBook = statement.executeUpdate();
		return issuedBook;

	}

	public int returned(Book book) throws Exception {

		String sql = "update books set status = 'No'  where bookId = ? and status = 'Yes' ";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, book.getBookId());
		int returnedBook = statement.executeUpdate();
		return returnedBook;
	}

	public List<Book> view() throws Exception {

		String sql = "select * from books where status = 'No' ";

		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		List<Book> listOfBooks = new ArrayList<>();

		while (rs.next()) {
			Book book = new Book();
			book.setBookId(rs.getString("bookId"));
			book.setBookName(rs.getString("bookName"));
			book.setAuthorName(rs.getString("authorName"));
			listOfBooks.add(book);
		}
		return listOfBooks;

	}
}
