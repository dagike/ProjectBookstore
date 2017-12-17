/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: AlbumDB
 * Package: projectbookstore.store.db 
 *
 */

// Current Package
package projectbookstore.store.db;

// Album Class
import projectbookstore.store.products.Album;

public class AlbumDB extends ProductDB{
    // Methods
    
    // Default Constructor set Capacity to 20
    public AlbumDB(){
        this(20);
    }
    
    // Constructor with variable capacity    
    public AlbumDB(int capacity){
        super(capacity);
    }
    
    // Display Album By Artist search criteria
    public boolean displayAlbumByArtist(String artist){
        boolean displayed = false;                          // Set displayed to false
        if(super.getCount() > 0){
            for(int i = 0; i < super.getCount(); i++){      // Look in albums arrays
                if(((Album)super.getProductByIndex(i)).getArtist().compareToIgnoreCase(artist) == 0) { // If artist found print album
                    System.out.println((Album)super.getProductByIndex(i));  // Display album with artist found
                    displayed = true;                       // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if album was deleted
    }
    
    // Display Album By Genre search criteria
    public boolean displayAlbumByGenre(String genre){
        boolean displayed = false;              // Set displayed to false
        if(super.getCount() > 0){
            for(int i = 0; i < super.getCount(); i++){     // Look in albums arrays
                if(((Album)super.getProductByIndex(i)).getGenre().compareToIgnoreCase(genre) == 0) { // If genre found print album
                    System.out.println((Album)super.getProductByIndex(i));   // Display album with genre found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if album(s) were displayed
    }
}
