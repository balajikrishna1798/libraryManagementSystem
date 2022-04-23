package com.project.libraryManagementSystem;

import java.util.Scanner;

public class Controller {
	private static Scanner scanner = new Scanner(System.in);
	private static Service service = new Service();

	public static void main(String[] args) {
		output();
	}

	// TODO Auto-generated method stub
	public static void output() {
		System.out.print("Enter 1 for Admin or ");
		System.out.print("2 for Librarian: ");

		int Management = scanner.nextInt();
		if (Management == 1) {
			System.out.println("Welcome Admin");
			System.out.println("-----------------------------------------------------------------");
			boolean flag = false;
			while (!flag) {
				showAdmin();
				int action = scanner.nextInt();
				switch (action) {
				case 0:
					flag = true;
					break;
				case 1:
					service.addNewBook();
					break;
				case 2:
					service.deleteBook();
					break;
				case 3:
					service.adminViewBooks();
					break;
				case 4:
					output();
					break;
				}
			}

		} else if (Management == 2) {
			System.out.println("Welcome Librarian");
			System.out.println("------------------------------------------------------------------");
			boolean flag = false;
			while (!flag) {
				showLibrarian();
				int action = scanner.nextInt();
				switch (action) {
				case 0:
					flag = true;
					break;
				case 1:
					service.libraryViewBooks();
					break;
				case 2:
					service.issueBook();
					break;
				case 3:
					service.returnedBook();
					break;
				case 4:
					output();
					break;

				}
			}
		}
	}

	private static void showAdmin() {
		System.out.println("Enter 0 to Terminate \n" + "Enter 1 to add new Book \n" + "Enter 2 to delete the Book \n"
				+ "Enter 3 to view the Books \n" + "Enter 4 for MainPage \n"
				+ "--------------------------------------------------------------------");
	}

	private static void showLibrarian() {
		System.out.println("Enter 0 to terminate \n" + "Enter 1 to view available Books \n"
				+ "Enter 2 for issued Book \n" + "Enter 3 for returned the Books \n" + "Enter 4 for MainPage \n"
				+ "------------------------------------------------------------------------------");
	}
}
