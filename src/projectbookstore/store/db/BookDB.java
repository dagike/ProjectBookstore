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

public class BookDB {
    // Attributes
    private final int CAPACITY;     // Max number of arrays
    private final Book[] books;     // Book Array
    private int count;              // Current Array ocupied
   
    // Methods
    
    // Default Constructor set Capacity to 20
    public BookDB(){
        this(20);
    }
    
    // Constructor with variable capacity    
    public BookDB(int capacity){
        this.CAPACITY = capacity;
        this.books = new Book[CAPACITY];
        this.count = 0;
    }
    
    // Add Book
    public boolean addBook(Book book){
        boolean added = false;          // Set added to false
        if(count < CAPACITY){           // count can't be bigger than CAPACITY
            books[count++] = book;      // Add new book and add one to count
            added = true;               // Set added flag to true
        }
        return added;                   // Return if book was added
    }
    
    // Find Book By Title
    public int findBookByTitle(String title){
        int index = -1;                     // Set index to -1
        for(int i = 0; i < count; i++){     // Look in current Book in array books
            if(books[i].getTitle().compareToIgnoreCase(title) == 0) // If title found
                return i;                   // Return i where title was found
        }
        return index;                       // Return index if title wasn't found
    }
    
    // Display Book By Author search criteria
    public boolean displayBookByAuthor(String artist){
        boolean displayed = false;              // Set displayed to false
        if(count > 0){
            for(int i = 0; i < count; i++){     // Look in books arrays
                if(books[i].getAuthor().compareToIgnoreCase(artist) == 0) { // If artist found print book
                    books[i].displayBook();     // Display book with artist found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if book was deleted
    }
    
    // Display Book By Genre search criteria
    public boolean displayBookByGenre(String genre){
        boolean displayed = false;              // Set displayed to false
        if(count > 0){
            for(int i = 0; i < count; i++){     // Look in books arrays
                if(books[i].getGenre().compareToIgnoreCase(genre) == 0) { // If genre found print book
                    books[i].displayBook();     // Display book with genre found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if book(s) were displayed
    }
    
    // Delete Book searching by title
    public boolean deleteBook(String title){
        boolean deleted = false;                // Set deleted to false
        int index = findBookByTitle(title);     // Look for title in books
        if(index >= 0){                         // If title was found
            for(int i = index; i < count - 1; i++)  // From the found title
                books[i] = books[i+1];          // Move book from next to current book
            deleted = true;                     // Set deleted to true
            count--;                            // Decrease count by one
        }
        return deleted;                         // Return if book was deleted
    }
    
    // Update Book searching by title
    public boolean updateBook(String title, Book newBook){
        boolean updated = false;                // Set updated to false
        int index = findBookByTitle(title);     // Look for title in books
        if(index >= 0){                         // If title was found
            books[index] = newBook;             // change book with new book
            updated = true;                     // Set updated to true
        }
        return updated;                         // Return if book was updated
    }
    
    // Display all the Book objects
    public void displayBookList(){
        for(int i = 0; i < count; i++)
            books[i].displayBook();
    }
    
    // Accesor for CAPACITY
    public int getCAPACITY() {
        return CAPACITY;
    }

    // Accesor for count
    public int getCount() {
        return count;
    }
}
