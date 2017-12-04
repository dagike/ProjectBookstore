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

public class GameConsoleDB {
    // Attributes
    private final int CAPACITY;                 // Max number of arrays
    private final GameConsole[] gameConsoles;   // GameConsole Array
    private int count;                          // Current Array ocupied
   
    // Methods
    
    // Default Constructor set Capacity to 20
    public GameConsoleDB(){
        this(20);
    }
    
    // Constructor with variable capacity    
    public GameConsoleDB(int capacity){
        this.CAPACITY = capacity;
        this.gameConsoles = new GameConsole[CAPACITY];
        this.count = 0;
    }
    
    // Add GameConsole
    public boolean addGameConsole(GameConsole gameConsole){
        boolean added = false;                      // Set added to false
        if(count < CAPACITY){                       // count can't be bigger than CAPACITY
            gameConsoles[count++] = gameConsole;    // Add new gameConsole and add one to count
            added = true;                           // Set added flag to true
        }
        return added;                               // Return if gameConsole was added
    }
    
    // Find GameConsole By Name
    public int findGameConsoleByName(String name){
        int index = -1;                             // Set index to -1
        for(int i = 0; i < count; i++){             // Look in current GameConsole in array gameConsoles
            if(gameConsoles[i].getName().compareToIgnoreCase(name) == 0) // If name found
                return i;                           // Return i where name was found
        }
        return index;                               // Return index if name wasn't found
    }
    
    // Display GameConsole By Company search criteria
    public boolean displayGameConsoleByCompany(String artist){
        boolean displayed = false;                          // Set displayed to false
        if(count > 0){
            for(int i = 0; i < count; i++){                 // Look in gameConsoles arrays
                if(gameConsoles[i].getCompany().compareToIgnoreCase(artist) == 0) { // If company found print gameConsole
                    gameConsoles[i].displayGameConsole();   // Display gameConsole with artist found
                    displayed = true;                       // Set displayed to true
                }
            }
        }
        return displayed;                                   // Return if gameConsole was deleted
    }
    
    // Delete GameConsole searching by name
    public boolean deleteGameConsole(String name){
        boolean deleted = false;                            // Set deleted to false
        int index = findGameConsoleByName(name);            // Look for name in gameConsoles
        if(index >= 0){                                     // If name was found
            for(int i = index; i < count - 1; i++)          // From the found name
                gameConsoles[i] = gameConsoles[i+1];        // Move gameConsole from next to current gameConsole
            deleted = true;                                 // Set deleted to true
            count--;                                        // Decrease count by one
        }
        return deleted;                                     // Return if gameConsole was deleted
    }
    
    // Update GameConsole searching by name
    public boolean updateGameConsole(String name, GameConsole newGameConsole){
        boolean updated = false;                            // Set updated to false
        int index = findGameConsoleByName(name);            // Look for name in gameConsoles
        if(index >= 0){                                     // If name was found
            gameConsoles[index] = newGameConsole;           // change gameConsole with new gameConsole
            updated = true;                                 // Set updated to true
        }
        return updated;                                     // Return if gameConsole was updated
    }
    
    // Display all the GameConsole objects
    public void displayGameConsoleList(){
        for(int i = 0; i < count; i++)
            gameConsoles[i].displayGameConsole();
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
