/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: BookDB
 * Package: projectbookstore.store.db 
 *
 */

// Current Package
package projectbookstore.store.db;

// Book Class
import projectbookstore.store.products.Book;

public class BookDB extends ProductDB {
    // Methods
    
    // Default Constructor set Capacity to 20
    public BookDB(){
        super(20);
    }
    
    // Constructor with variable capacity    
    public BookDB(int capacity){
        super(capacity);
    }
    
    // Display Book By Author search criteria
    public boolean displayBookByAuthor(String author){
        boolean displayed = false;              // Set displayed to false
        if(super.getCount() > 0){
            for(int i = 0; i < super.getCount(); i++){     // Look in books arrays
                if(((Book)super.getProductByIndex(i)).getAuthor().compareToIgnoreCase(author) == 0) { // If author found print book
                    System.out.println(((Book)super.getProductByIndex(i)));     // Display book with author found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if book was deleted
    }
    
    // Display Book By Genre search criteria
    public boolean displayBookByGenre(String genre){
        boolean displayed = false;              // Set displayed to false
        if(super.getCount() > 0){
            for(int i = 0; i < super.getCount(); i++){     // Look in books arrays
                if(((Book)super.getProductByIndex(i)).getGenre().compareToIgnoreCase(genre) == 0) { // If genre found print book
                    System.out.println(((Book)super.getProductByIndex(i))); // Display book with genre found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if book(s) were displayed
    }
}
