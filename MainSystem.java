/*Uchenna Ilojiole
 * CEN 3024 - Software Development 1
 * September 3, 2023
 * MainSystem.java
 * This is our Main System Class. In this class we will be able to define the users options.
 * In This class we will also be able to retrieve our users input as well. This is also the class
 * where we will be able to save and update our library file based on the previous selections made
 * by our users.
 */

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.File;
import java.io.*;

public class MainSystem {

	static String fileName = null;
	static Library lib = new Library();
	static Scanner in = new Scanner(System.in);
	static Boolean running = true;

	public static void main(String[] args) throws IOException {
		
		
		while (running) {
			// This Method Is to Display Our Menu Options To Our Users.
			System.out.println("\nEnter 0 To Load A Library" 
					+ "\nEnter 1 To Add Books To Library"
					+ "\nEnter 2 To Remove A Book From The Library"
					+ "\nEnter 3 To List All Books In The Library"
					+ "\nEnter 4 To For Save And Quit" );
			
			// This Method Will Allow Us To Access The Users Options That They Select
			int answer = in.nextInt();
			
			// This Method Will Perform The Actions Based On The Selection Made By The User
			switch (answer) {

			case 0:
				System.out.println("Enter the file name to load");
				LoadScript(in.next());

				break;

			case 1:
				addBook();

				break;

			case 2:
				
				System.out.print("Enter Book ID to Remove: ");
				int removeId = in.nextInt();

				lib.removeBookFromCollection(removeId);

				break;

			case 3:
				
				BufferedReader reader = new BufferedReader(
						new FileReader("C:\\Users\\14076\\Desktop\\LibraryManagementSystem.txt"));
				String line;
				while ((line = reader.readLine()) != null)
					System.out.println(line);
				reader.close();

				break;

				// This Is The Last Method For Our Case Options That Will Assist Us In Saving And Closing The Application
			case 4:
				saveAndQuit();

				break;
			}
		}

		// This Method Will Exit The Program
		System.exit(0);
	}

	// These Are Our Methods For Our Case Options

	// This Method Will Assist Us In Loading Our Current Library That Was Previously Saved
	
	private static void LoadScript(String name) {
		
		FileInputStream fis = null;
		ObjectInputStream in = null;

		File file = new File(name + ".txt");
		if (file.exists()) {
			try {
				fis = new FileInputStream(file);
				in = new ObjectInputStream(fis);
				lib = (Library) in.readObject();
				fis.close();
				in.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("\nThe File Does Not Exist");
		}

	}

	// This Method Will Assist Us In Saving, Updating, and Exiting Our Program
	private static void saveAndQuit() {
		// TODO Auto-generated method stub
		System.out.println("Enter A File Name: ");
		fileName = in.next() + ".txt";
		running = false;
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(lib);
			fos.close();
			out.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void addBook() {
		// TODO Auto-generated method stub
		int id;
		String title, author;

		System.out.println("\nEnter Title: ");
		title = in.next();

		System.out.println("\nEnter Author: ");
		author = in.next();

		System.out.println("\nEnter ID: ");
		id = in.nextInt();

		Book b = new Book(id, title, author);
		lib.addBook(b);

	}
}