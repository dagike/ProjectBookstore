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

public class MovieDB {
    // Attributes
    private final int CAPACITY;     // Max number of arrays
    private final Movie[] movies;   // Movie Array
    private int count;              // Current Array ocupied
   
    // Methods
    
    // Default Constructor set Capacity to 20
    public MovieDB(){
        this(20);
    }
    
    // Constructor with variable capacity    
    public MovieDB(int capacity){
        this.CAPACITY = capacity;
        this.movies = new Movie[CAPACITY];
        this.count = 0;
    }
    
    // Add Movie
    public boolean addMovie(Movie movie){
        boolean added = false;          // Set added to false
        if(count < CAPACITY){           // count can't be bigger than CAPACITY
            movies[count++] = movie;    // Add new movie and add one to count
            added = true;               // Set added flag to true
        }
        return added;                   // Return if movie was added
    }
    
    // Find Movie By Title
    public int findMovieByTitle(String title){
        int index = -1;                     // Set index to -1
        for(int i = 0; i < count; i++){     // Look in current Movie in array movies
            if(movies[i].getTitle().compareToIgnoreCase(title) == 0) // If title found
                return i;                   // Return i where title was found
        }
        return index;                       // Return index if title wasn't found
    }
    
    // Display Movie By Director search criteria
    public boolean displayMovieByDirector(String director){
        boolean displayed = false;              // Set displayed to false
        if(count > 0){
            for(int i = 0; i < count; i++){     // Look in movies arrays
                if(movies[i].getDirector().compareToIgnoreCase(director) == 0) { // If director found print movie
                    movies[i].displayMovie();   // Display movie with director found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if movie was deleted
    }
    
    // Display Movie By Genre search criteria
    public boolean displayMovieByGenre(String genre){
        boolean displayed = false;              // Set displayed to false
        if(count > 0){
            for(int i = 0; i < count; i++){     // Look in movies arrays
                if(movies[i].getGenre().compareToIgnoreCase(genre) == 0) { // If genre found print movie
                    movies[i].displayMovie();   // Display movie with genre found
                    displayed = true;           // Set displayed to true
                }
            }
        }
        return displayed;                       // Return if movie(s) were displayed
    }
    
    // Delete Movie searching by title
    public boolean deleteMovie(String title){
        boolean deleted = false;                // Set deleted to false
        int index = findMovieByTitle(title);    // Look for title in movies
        if(index >= 0){                         // If title was found
            for(int i = index; i < count - 1; i++)  // From the found title
                movies[i] = movies[i+1];        // Move movie from next to current movie
            deleted = true;                     // Set deleted to true
            count--;                            // Decrease count by one
        }
        return deleted;                         // Return if movie was deleted
    }
    
    // Update Movie searching by title
    public boolean updateMovie(String title, Movie newMovie){
        boolean updated = false;                // Set updated to false
        int index = findMovieByTitle(title);    // Look for title in movies
        if(index >= 0){                         // If title was found
            movies[index] = newMovie;           // change movie with new movie
            updated = true;                     // Set updated to true
        }
        return updated;                         // Return if movie was updated
    }
    
    // Display all the Movie objects
    public void displayMovieList(){
        for(int i = 0; i < count; i++)
            movies[i].displayMovie();
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
