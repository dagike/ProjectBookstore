/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: GameConsoleDB
 * Package: projectbookstore.store.db 
 *
 */

// Current Package
package projectbookstore.store.db;

// GameConsole Class
import projectbookstore.store.products.GameConsole;

public class GameConsoleDB extends ProductDB {
    // Methods
    
    // Default Constructor set Capacity to 20
    public GameConsoleDB(){
        this(20);
    }
    
    // Constructor with variable capacity    
    public GameConsoleDB(int capacity){
        super(capacity);
    }
    
    // Display GameConsole By Company search criteria
    public boolean displayGameConsoleByCompany(String artist){
        boolean displayed = false;                          // Set displayed to false
        if(super.getCount() > 0){
            for(int i = 0; i < super.getCount(); i++){                 // Look in gameConsoles arrays
                if(((GameConsole)super.getProductByIndex(i)).getCompany().compareToIgnoreCase(artist) == 0) { // If company found print gameConsole
                    System.out.println(((GameConsole)super.getProductByIndex(i)));   // Display gameConsole with artist found
                    displayed = true;                       // Set displayed to true
                }
            }
        }
        return displayed;                                   // Return if gameConsole was deleted
    }                           
}
