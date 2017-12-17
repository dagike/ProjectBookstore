/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: MovieDB
 * Package: projectbookstore.store.db 
 *
 */

// Current Package
package projectbookstore.store.db;

// Movie Class
import projectbookstore.store.products.Movie;

public class MovieDB extends ProductDB{
    // Methods
    
    // Default Constructor set Capacity to 20
    public MovieDB(){
        this(20);
    }
    
    // Constructor with variable capacity    
    public MovieDB(int capacity){
        super(capacity);
    }
    
    // Display Movie By Director search criteria
    public boolean displayMovieByDirector(String director){
        boolean displayed = false;              // Set displayed to false
        if(super.getCount() > 0){
            for(int i = 0; i < super.getCount(); i++){     // Look in movies arrays
                if(((Movie)super.getProductByIndex(i)).getDirector().compareToIgnoreCase(director) == 0) { // If director found print movie
                    System.out.println(((Movie)super.getProductByIndex(i)));   // Display movie with director found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if movie was deleted
    }
    
    // Display Movie By Genre search criteria
    public boolean displayMovieByGenre(String genre){
        boolean displayed = false;              // Set displayed to false
        if(super.getCount() > 0){
            for(int i = 0; i < super.getCount(); i++){     // Look in movies arrays
                if(((Movie)super.getProductByIndex(i)).getGenre().compareToIgnoreCase(genre) == 0) { // If genre found print movie
                    System.out.println(((Movie)super.getProductByIndex(i)));   // Display movie with genre found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if movie(s) were displayed
    }    
}
