/*Uchenna Ilojiole
 * CEN 3024 - Software Development 1
 * September 3, 2023
 * Book.java
 * This is our Book Class. In this class we will be defining the book attributes that is within this program. 
 * In this class we will be able to retrieve the ID, the Authors Name, and Book Title. 
 */

import java.io.Serializable;

public class Book implements Serializable {

	// These Methods Will Assist Us In Defining Our Book Attributes
	private int id;
	private String title, author;

	public Book() {
		id = 0;
		title = null;
		author = null;
	}


	public Book(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;

	}
	
	// This Method Will Override The toString Method To Within Our Program 

	@Override
	public String toString() {
		return ("\n" + id + "," + "" + title + "," + "" + author);
	}

	// These Are The Methods That We Will Use To Retrieve Any Id's, Title's, and Author Names

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
}
