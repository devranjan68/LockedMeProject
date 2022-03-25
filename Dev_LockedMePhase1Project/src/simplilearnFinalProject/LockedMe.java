package simplilearnFinalProject;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author DEV RANJAN
 *
 */
public class LockedMe {
	static final String projectFilesPath = "E:\\ANUPAM\\BOOKS\\SOFTWARE DEVELOPMENT\\LockedMeFiles";

	/**
	 * This method will display the available options to the end user
	 */
	public static void displayMenu() {
		System.out.println("************************************************");
		System.out.println("\tWelcome to LockedMe.com secure app");
		System.out.println("\tDeveloped by : Dev Ranjan");
		System.out.println("************************************************");
		System.out.println("\t1. Display all files");
		System.out.println("\t2. Add a new file");
		System.out.println("\t3. Delete a file");
		System.out.println("\t4. Search file");
		System.out.println("\t5. Exit");
		System.out.println("************************************************");
	}

	/**
	 * This method will retrieve all the files present in the project folder
	 */
	public static void getAllFiles() {

		// Finding the number of files in the given folder
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();

		// Displaying the files one by one
		if (listOfFiles.length > 0) {
			System.out.println("FILES LIST IS BELOW :\n");
			for (var l : listOfFiles)
				System.out.println(l.getName());
		} else
			System.out.println("The folder is empty");
	}

	/**
	 * This method will receive file details from the user and create the file
	 * inside the project folder
	 * 
	 * @param obj
	 */
	public static void createFiles(Scanner obj) {
		try {
			// Taking from the user the name of the file to be created
			String fileName;
			System.out.println("Enter the name of the file to be created:");
			fileName = obj.nextLine();

			// Taking the number of lines present in the file
			int linesCount;
			System.out.println("Enter the number of lines in the file");
			linesCount = Integer.parseInt(obj.nextLine());

			// Creating the file with the given name in the destination folder
			FileWriter fw = new FileWriter(projectFilesPath + "\\" + fileName);

			// Read line by line from user
			for (int i = 1; i <= linesCount; i++) {
				System.out.println("Enter line number " + i + " of file");
				fw.write(obj.nextLine() + "\n");
			}

			System.out.println("File Created Successfully");
			fw.close();
		} catch (Exception ex) {
			System.out.println("Unable to create the file. Kindly contact the admin" + ex.getMessage());
		}

	}

	/**
	 * This method will delete a particular file from the project folder
	 * 
	 * @param obj
	 */
	public static void deleteFiles(Scanner obj) {
		try {
			// Taking from the user the name of the file to be deleted
			String fileName;
			System.out.println("Enter the name of the file to be deleted:");
			fileName = obj.nextLine();

			// Get the name of all files in a list
			ArrayList<String> allFilesNames = new ArrayList<String>();
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();

			if (listOfFiles.length > 0) {
				for (var l : listOfFiles)
					allFilesNames.add(l.getName());
			}

			// Deleting the required file
			File f = new File(projectFilesPath + "\\" + fileName);
			if (allFilesNames.contains(fileName)) {
				f.delete();
				System.out.println("File Deleted Successfully");
			} else {
				System.out.println("File doesn't exist");
			}
		} catch (Exception ex) {
			System.out.println("Unable to delete the file. Kindly contact the admin" + ex.getMessage());
		}

	}

	/**
	 * This method will search for a particular file in the project folder
	 * 
	 * @param obj
	 */
	public static void searchFiles(Scanner obj) {
		try {
			// Taking from the user the name of the file to be searched
			String fileName;
			System.out.println("Enter the name of the file to be searched:");
			fileName = obj.nextLine();

			// Get the name of all files in a list
			ArrayList<String> allFilesNames = new ArrayList<String>();
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();

			if (listOfFiles.length > 0) {
				for (var l : listOfFiles)
					allFilesNames.add(l.getName().toLowerCase());
			}

			// Searching the required file
			if (allFilesNames.contains(fileName.toLowerCase())) {
				System.out.println("File is available");
			} else {
				System.out.println("File doesn't exist");
			}
		} catch (Exception ex) {
			System.out.println("Unable to search the file. Kindly contact the admin" + ex.getMessage());
		}

	}

}
