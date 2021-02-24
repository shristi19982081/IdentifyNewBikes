package Common;

import java.util.Scanner;

public class SelectBrowser {

	public static String browser = null;

	public static String selectBrowser() {

		Scanner sc = new Scanner(System.in);
		System.out.println("1. Chrome");
		System.out.println("2. Firefox");
		System.out.println("3. Edge");
		System.out.println("Select any browser: ");
		int choice = sc.nextInt();
		sc.close();
		switch (choice) {
		case 1:
			browser = "Chrome";
			break;
		case 2:
			browser = "Firefox";
			break;
		case 3:
			browser = "Edge";
			break;
		default:
			System.out.println("Wrong Choice! Please select among 1, 2 and 3!");
		}

		return browser;

	}
}
