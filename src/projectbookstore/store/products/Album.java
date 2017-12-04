/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: Album
 * Package: projectbookstore.store.products
 *
 */

// Current package
package projectbookstore.store.products;

// Calendar and GregorianCalendar for dates in the class
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Album {
    // Attributes
    private String artist, title, genre, language;
    private Calendar releaseDate;
    private int duration;
    private double price;
    // Formatter for dates
    private final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    
    // Methods
    
    // Constructor
    public Album(){
        artist= "";
        title = "";
        genre = "";
        language = "";
        duration = 0;
        releaseDate = new GregorianCalendar(1900, 0, 1); // Set Date to 1900-01-01
        price = 0.0;
    }
    
    // Accesor for artist
    public String getArtist() {
        return artist;
    }
    
    // Mutator for artist
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    // Accesor for title
    public String getTitle() {
        return title;
    }

    // Mutator for title
    public void setTitle(String title) {
        this.title = title;
    }
    
    // Accesor for genre
    public String getGenre() {
        return genre;
    }

    // Mutator for genre
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    // Accesor for language
    public String getLanguage() {
        return language;
    }

    // Mutator for language
    public void setLanguage(String language) {
        this.language = language;
    }
    
    // Accesor for duration
    public int getDuration() {
        return duration;
    }

    // Mutator for duration
    public void setDuration(int duration) {
        if(duration > 0)
            this.duration = duration;
    }
    
    // Accesor for releaseDate
    public Calendar getReleaseDate() {
        return releaseDate;
    }

    // Mutator for releaseDate
    public void setReleaseDate(GregorianCalendar releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    // Mutator for releaseDate with 3 int
    public void setReleaseDate(int year, int month, int day) {
        if(year > 0 && month >= 0 && month <= 11 && day > 0 && day <= 31)
            this.releaseDate.set(year, month-1, day);       // Month - 1 Calendar object 0 first month
    }
    
    // Accesor for price
    public double getPrice() {
        return price;
    }

    // Mutator for price
    public void setPrice(double price) {
        if(price >= 0)
            this.price = price;
    }
    
    // Display all the fields of the object
    public void displayAlbum(){
            System.out.println("Title: " + title + 
                               "\nArtist: " + artist +
                               "\nGenre: " + genre + 
                               "\nLanguage: " + language +
                               "\nDuration: " + duration + " min" +
                               "\nRelease Date: " + 
                                date.format(releaseDate.getTime()) +    // Using date formatter to display as yyyy-MM-dd
                               "\nPrice: $" + price + "\n" );
    }
}
