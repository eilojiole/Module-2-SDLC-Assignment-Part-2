/*Uchenna Ilojiole
 * CEN 3024 - Software Development 1
 * September 3, 2023
 * Library.java
 * This is the Library Class. In this class we will be able to not only direct our program to retrieve our 
 * Text File from where it is located but it will also assist us in implementing our Library Class to 
 * the rest of our program.
 * This class is also where we will store our present book collection along with adding any new 
 * book titles to our collection. Within this class we will also be able to remove and modify
 * our existing collection as well.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library extends Object implements Serializable {

	// This Method Is Our File Path For The Library Collection.
	
	private final String collectionFile = ("C:\\Users\\14076\\Desktop\\LibraryManagementSystem.txt");
	
	// This Method Will Store Our Book Collection.
	
	private List<Book> collection;

	// This Method Will Assist Us In Creating And Implementing Our Library Class

	public Library() {
		collection = new ArrayList<Book>();
	}

	// This Method Will Assist Us In Adding A Book To The User's Collection And Also Updating The Collection Once The Book Has Been Added.
	
	public void addBook(Book book) {
		collection.add(book);
		System.out.println("Book added to your collection: " + book);

		// This Method Is To Make Any Modifications To Our Collection File.
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(collectionFile, true))) {
			writer.write(book.toString());
			writer.newLine();
		} catch (IOException e) {
			System.out.println("Error writing to user collection file: " + e.getMessage());
		}
	}

	// This Method Is For Us To Create And Add A Book To The User's Collection.

	private void addTocollection(Book newBook) {
		int id = 0;
		String title = null;
		String author = null;
		{
			Book book = new Book(id, title, author);
			addTocollection(newBook);
			{
				// TODO Auto-generated method stub
			}
		}
	}
	

	// This Method Is For Us To Remove A Book From The User's Collection. 
	
	public void removeBookFromCollection(int id) {
		Iterator<Book> iterator = collection.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getId() == id) {
				iterator.remove();
				System.out.println("Book removed from your collection: " + book);
				updateCollectionFile(); // Update the user collection file
				return;
			}
		}
		System.out.println("Book with ID " + id + " not found in your collection.");
	}

	// This Method Will Provide The Update To Our Collection Once Any Modification Has Been Made.
	private void updateCollectionFile() {
		// Overwrite the user collection file with the updated userCollection list
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(collectionFile))) {
			for (Book book : collection) {
				writer.write(book.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error updating user collection file: " + e.getMessage());
		}
	}

	// This Method Is To Return The Value Back To Us In The Original String Format Which Will Assist Us In Looping Any Object That Is Present Within The Class.
	
	@Override
	public String toString() {
		String total = "\n";
		
		Iterator<Book> i = collection.iterator();
		while (i.hasNext()) {
			Book b = (Book) i.next();
			total = total + b.toString();
		}
		return total;
	}

}
