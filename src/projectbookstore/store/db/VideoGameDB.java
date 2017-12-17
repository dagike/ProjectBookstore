/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: VideoGameDB
 * Package: projectbookstore.store.db 
 *
 */

// Current Package
package projectbookstore.store.db;

// VideoGame Class
import projectbookstore.store.products.VideoGame;

public class VideoGameDB extends ProductDB{
    // Methods
    
    // Default Constructor set Capacity to 20
    public VideoGameDB(){
        this(20);
    }
    
    // Constructor with variable capacity    
    public VideoGameDB(int capacity){
        super(capacity);
    }
    
    // Display VideoGame By Developer search criteria
    public boolean displayVideoGameByDeveloper(String developer){
        boolean displayed = false;              // Set displayed to false
        if(super.getCount() > 0){
            for(int i = 0; i < super.getCount(); i++){     // Look in videoGames arrays
                if(((VideoGame)super.getProductByIndex(i)).getDeveloper().compareToIgnoreCase(developer) == 0) { // If developer found print videoGame
                    System.out.println(((VideoGame)super.getProductByIndex(i)));   // Display videoGame with developer found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if videoGame was deleted
    }
    
    // Display VideoGame By Genre search criteria
    public boolean displayVideoGameByGenre(String genre){
        boolean displayed = false;              // Set displayed to false
        if(super.getCount() > 0){
            for(int i = 0; i < super.getCount(); i++){     // Look in videoGames arrays
                if(((VideoGame)super.getProductByIndex(i)).getGenre().compareToIgnoreCase(genre) == 0) { // If genre found print videoGame
                    System.out.println(((VideoGame)super.getProductByIndex(i)));   // Display videoGame with genre found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if videoGame(s) were displayed
    }
    
    // Display VideoGame By Console search criteria
    public boolean displayVideoGameByConsole(String console){
        boolean displayed = false;              // Set displayed to false
        if(super.getCount() > 0){
            for(int i = 0; i < super.getCount(); i++){     // Look in videoGames arrays
                if(((VideoGame)super.getProductByIndex(i)).getConsole().compareToIgnoreCase(console) == 0) { // If console found print videoGame
                    System.out.println(((VideoGame)super.getProductByIndex(i)));  // Display videoGame with console found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if videoGame(s) were displayed
    }
}
