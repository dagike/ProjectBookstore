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

public class AlbumDB {
    // Attributes
    private final int CAPACITY;     // Max number of arrays
    private final Album[] albums;   // Album Array
    private int count;              // Current Array ocupied
   
    // Methods
    
    // Default Constructor set Capacity to 20
    public AlbumDB(){
        this(20);
    }
    
    // Constructor with variable capacity    
    public AlbumDB(int capacity){
        this.CAPACITY = capacity;
        this.albums = new Album[CAPACITY];
        this.count = 0;
    }
    
    // Add Album
    public boolean addAlbum(Album album){
        boolean added = false;          // Set added to false
        if(count < CAPACITY){           // count can't be bigger than CAPACITY
            albums[count++] = album;    // Add new album and add one to count
            added = true;               // Set added flag to true
        }
        return added;                   // Return if album was added
    }
    
    // Find Album By Title
    public int findAlbumByTitle(String title){
        int index = -1;                     // Set index to -1
        for(int i = 0; i < count; i++){     // Look in current Album in array albums
            if(albums[i].getTitle().compareToIgnoreCase(title) == 0) // If title found
                return i;                   // Return i where title was found
        }
        return index;                       // Return index if title wasn't found
    }
    
    // Display Album By Artist search criteria
    public boolean displayAlbumByArtist(String artist){
        boolean displayed = false;              // Set displayed to false
        if(count > 0){
            for(int i = 0; i < count; i++){     // Look in albums arrays
                if(albums[i].getArtist().compareToIgnoreCase(artist) == 0) { // If artist found print album
                    albums[i].displayAlbum();   // Display album with artist found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if album was deleted
    }
    
    // Display Album By Genre search criteria
    public boolean displayAlbumByGenre(String genre){
        boolean displayed = false;              // Set displayed to false
        if(count > 0){
            for(int i = 0; i < count; i++){     // Look in albums arrays
                if(albums[i].getGenre().compareToIgnoreCase(genre) == 0) { // If genre found print album
                    albums[i].displayAlbum();   // Display album with genre found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if album(s) were displayed
    }
    
    // Delete Album searching by title
    public boolean deleteAlbum(String title){
        boolean deleted = false;                // Set deleted to false
        int index = findAlbumByTitle(title);    // Look for title in albums
        if(index >= 0){                         // If title was found
            for(int i = index; i < count - 1; i++)  // From the found title
                albums[i] = albums[i+1];        // Move album from next to current album
            deleted = true;                     // Set deleted to true
            count--;                            // Decrease count by one
        }
        return deleted;                         // Return if album was deleted
    }
    
    // Update Album searching by title
    public boolean updateAlbum(String title, Album newAlbum){
        boolean updated = false;                // Set updated to false
        int index = findAlbumByTitle(title);    // Look for title in albums
        if(index >= 0){                         // If title was found
            albums[index] = newAlbum;           // change album with new album
            updated = true;                     // Set updated to true
        }
        return updated;                         // Return if album was updated
    }
    
    // Display all the Album objects
    public void displayAlbumList(){
        for(int i = 0; i < count; i++)
            albums[i].displayAlbum();
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
