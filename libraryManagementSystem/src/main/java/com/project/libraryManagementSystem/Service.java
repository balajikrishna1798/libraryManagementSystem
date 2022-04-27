package com.project.libraryManagementSystem;

import java.util.List;
import java.util.Scanner;

public class Service {
	private static Scanner scanner = new Scanner(System.in);
	private DAO query = new DAO();
	private Book book = new Book();


	/**
	 * This function is used to add the books to admin page and library page.
	 */

	public void addNewBook() {

		try {
			System.out.print("Enter Book Id: ");

			String bookId = scanner.nextLine();

			System.out.print("Enter Book Name: ");
			String bookName = scanner.nextLine();

			System.out.print("Enter Author Name: ");
			String authorName = scanner.nextLine();

			book.setBookId(bookId);
			book.setBookName(bookName);
			book.setAuthorName(authorName);
			if (query.add(book) > 0) {
				System.out.println("Book added Successfully");
			}

		} catch (Exception e) {
			System.out.println("Sorry!!!This Book is already there");
		}

	}

	/**
	 * This function is used to delete the books from admin page and library page.
	 */
	public void deleteBook() {

		try {
			boolean found = false;

			System.out.print("Enter Book Id: ");

			String bookId = scanner.nextLine();
			book.setBookId(bookId);
			if (query.delete(book) > 0) {
				System.out.println("Book deleted Successfully");
				found = true;

			}
			if (!found) {
				System.out.println("Sorry!!Thre is No Book with this Id");

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void issueBook() {

		try {
			boolean found = false;


			System.out.print("Enter Book Id: ");

			String bookId = scanner.nextLine();
			book.setBookId(bookId);
			if (query.issue(book) > 0) {
				System.out.println("Book added in issued list Successfully");
				found = true;
			}
			if (!found) {
				System.out.println("Sorry!!Thre is No Book with this Id");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This function is used to view available Books in Admin Page.
	 * 
	 * @throws Exception
	 */
	public void adminViewBooks() {

		try {

			int i = 0;
			List<Book> listOfBooks = query.view();
			
			for (Book allBooks : listOfBooks) {
				
				System.out.println("\n" + ++i + ".  \n" + "BookId: " + allBooks.getBookId() + "\nBookName: "
						+ allBooks.getBookName() + "\nAuthorName: " + allBooks.getAuthorName() + "\n"
						+ "-----------------------------------------------------------------------------------------------");
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This function is used to view available Books in Librarian Page.
	 */
	public void libraryViewBooks() {

		try {
			int i = 0;

			List<Book> listOfBooks = query.view();

			for (Book allBooks : listOfBooks) {
				System.out.println("\n" + ++i + ".  \n" + "BookId: " + allBooks.getBookId() + "\nBookName: "
						+ allBooks.getBookName() + "\nAuthorName: " + allBooks.getAuthorName() + "\n"
						+ "-----------------------------------------------------------------------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is used to return the book(add the list again to adminbook and
	 * librarianbook)..
	 */
	public void returnedBook() {
		try {
			boolean found = false;


			System.out.print("Enter Book Id: ");

			String bookId = scanner.nextLine();

			book.setBookId(bookId);
			if (query.returned(book) > 0) {
				System.out.println("Book added in issued list Successfully");
				found = true;
			}
			if (!found) {
				System.out.println("Sorry!!Thre is No Book with this Id");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
