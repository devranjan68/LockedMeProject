package simplilearnFinalProject;

import java.util.Scanner;

/**
 * 
 * @author DEV RANJAN
 *
 */
public class ClientApp {
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int ch;

		do {
			LockedMe.displayMenu();
			System.out.println("Enter your choice");
			ch = Integer.parseInt(obj.nextLine());

			switch (ch) {

			case 1:
				LockedMe.getAllFiles();
				break;

			case 2:
				LockedMe.createFiles(obj);
				break;

			case 3:
				LockedMe.deleteFiles(obj);
				break;

			case 4:
				LockedMe.searchFiles(obj);
				break;

			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid option");
				break;
			}
		} while (ch > 0);

		obj.next();
		obj.close();
	}

}
