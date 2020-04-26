package com.bean;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		System.out.println("====== Climate Change Analysis Application ======");

		int select;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("\nPlease select the query");
			System.out
					.println("\n1-for all data that matches the specified month, get the lowest temperature reading ");
			System.out.println("2-for all data that matches the specified month, get the highest temperature reading");

			System.out.print("\nChoice =");
			select = scanner.nextInt();

			switch (select) {

			case 1:

				System.out.print("Enter a string: ");
				String str = scanner.nextLine(); // reads string
				System.out.print("You have entered: " + str);

				break;
			case 2:

				break;
			case 3:

				break;
			}

		} while (select != 4);
	}

}
