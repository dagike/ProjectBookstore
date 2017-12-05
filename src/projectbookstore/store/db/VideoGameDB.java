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

public class VideoGameDB {
    // Attributes
    private final int CAPACITY;     // Max number of arrays
    private final VideoGame[] videoGames;   // VideoGame Array
    private int count;              // Current Array ocupied
   
    // Methods
    
    // Default Constructor set Capacity to 20
    public VideoGameDB(){
        this(20);
    }
    
    // Constructor with variable capacity    
    public VideoGameDB(int capacity){
        this.CAPACITY = capacity;
        this.videoGames = new VideoGame[CAPACITY];
        this.count = 0;
    }
    
    // Add VideoGame
    public boolean addVideoGame(VideoGame videoGame){
        boolean added = false;          // Set added to false
        if(count < CAPACITY){           // count can't be bigger than CAPACITY
            videoGames[count++] = videoGame;    // Add new videoGame and add one to count
            added = true;               // Set added flag to true
        }
        return added;                   // Return if videoGame was added
    }
    
    // Find VideoGame By Title
    public int findVideoGameByTitle(String title){
        int index = -1;                     // Set index to -1
        for(int i = 0; i < count; i++){     // Look in current VideoGame in array videoGames
            if(videoGames[i].getTitle().compareToIgnoreCase(title) == 0) // If title found
                return i;                   // Return i where title was found
        }
        return index;                       // Return index if title wasn't found
    }
    
    // Display VideoGame By Developer search criteria
    public boolean displayVideoGameByDeveloper(String developer){
        boolean displayed = false;              // Set displayed to false
        if(count > 0){
            for(int i = 0; i < count; i++){     // Look in videoGames arrays
                if(videoGames[i].getDeveloper().compareToIgnoreCase(developer) == 0) { // If developer found print videoGame
                    videoGames[i].displayVideoGame();   // Display videoGame with developer found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if videoGame was deleted
    }
    
    // Display VideoGame By Genre search criteria
    public boolean displayVideoGameByGenre(String genre){
        boolean displayed = false;              // Set displayed to false
        if(count > 0){
            for(int i = 0; i < count; i++){     // Look in videoGames arrays
                if(videoGames[i].getGenre().compareToIgnoreCase(genre) == 0) { // If genre found print videoGame
                    videoGames[i].displayVideoGame();   // Display videoGame with genre found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if videoGame(s) were displayed
    }
    
    // Display VideoGame By Console search criteria
    public boolean displayVideoGameByConsole(String console){
        boolean displayed = false;              // Set displayed to false
        if(count > 0){
            for(int i = 0; i < count; i++){     // Look in videoGames arrays
                if(videoGames[i].getConsole().compareToIgnoreCase(console) == 0) { // If console found print videoGame
                    videoGames[i].displayVideoGame();   // Display videoGame with console found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if videoGame(s) were displayed
    }
    
    // Delete VideoGame searching by title
    public boolean deleteVideoGame(String title){
        boolean deleted = false;                // Set deleted to false
        int index = findVideoGameByTitle(title);    // Look for title in videoGames
        if(index >= 0){                         // If title was found
            for(int i = index; i < count - 1; i++)  // From the found title
                videoGames[i] = videoGames[i+1];        // Move videoGame from next to current videoGame
            deleted = true;                     // Set deleted to true
            count--;                            // Decrease count by one
        }
        return deleted;                         // Return if videoGame was deleted
    }
    
    // Update VideoGame searching by title
    public boolean updateVideoGame(String title, VideoGame newVideoGame){
        boolean updated = false;                // Set updated to false
        int index = findVideoGameByTitle(title);    // Look for title in videoGames
        if(index >= 0){                         // If title was found
            videoGames[index] = newVideoGame;           // change videoGame with new videoGame
            updated = true;                     // Set updated to true
        }
        return updated;                         // Return if videoGame was updated
    }
    
    // Display all the VideoGame objects
    public void displayVideoGameList(){
        for(int i = 0; i < count; i++)
            videoGames[i].displayVideoGame();
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
