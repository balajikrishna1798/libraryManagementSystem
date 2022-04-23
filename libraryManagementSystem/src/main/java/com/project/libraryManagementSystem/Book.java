package com.project.libraryManagementSystem;

public class Book {

	private String BookId;
	private String BookName;
	private String AuthorName;

	public String getBookId() {
		return BookId;
	}

	public void setBookId(String bookId) {
		BookId = bookId;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getAuthorName() {
		return AuthorName;
	}

	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}

	@Override
	public String toString() {
		return BookId + " " + BookName + " " + AuthorName;
	}

}
