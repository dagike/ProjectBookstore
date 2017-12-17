/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: Videogame
 * package: projectbookstore.store.products
 *
 */

//Current package
package projectbookstore.store.products;

// Calendar and GregorianCalendar for dates in the class
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class VideoGame extends Product{
    //Attributes
    private String genre, console, publisher, developer, language;
    private Calendar releaseDate;
    // Formatter for dates
    private final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

    //Methods
    
    //Constructor
    public VideoGame() {
        super();
        genre = "";
        console = "";
        publisher = "";
        developer = "";
        language = "";
        releaseDate = new GregorianCalendar(1900, 0, 1); // Set Date to 1900-01-01
    }

    //Accesor for genre
    public String getGenre() {
        return genre;
    }

    //Mutator for genre
    public void setGenre(String genre) {
        this.genre = genre;
    }

    //Accesor for console
    public String getConsole() {
        return console;
    }

    //Mutator for console
    public void setConsole(String console) {
        this.console = console;
    }

    //Accesor for publisher
    public String getPublisher() {
        return publisher;
    }

    //Mutator for publisher
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    //Accesor for developer
    public String getDeveloper() {
        return developer;
    }

    //Mutator for developer
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    //Accesor for language
    public String getLanguage() {
        return language;
    }

    //Mutator for language
    public void setLanguage(String language) {
        this.language = language;
    }

    //Accesor for releaseDate
    public Calendar getReleaseDate() {
        return releaseDate;
    }

    //Mutator for releaseDate
    public void setReleaseDate(Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    // Mutator for releaseDate with 3 int
    public void setReleaseDate(int year, int month, int day) {
        if(year > 0 && month >= 0 && month <= 11 && day > 0 && day <= 31)
            this.releaseDate.set(year, month-1, day);       // Month - 1 Calendar object 0 first month
    }

    @Override
    // Override toString to format a Strirng with fields of the object
    public String toString(){
        return "Title: " + super.getTitle() +
               "\nGenre: " + genre +
               "\nConsole: " + console +
               "\nPublisher: " + publisher +
               "\nDeveloper: " + developer +
               "\nLanguage: " + language +
               "\nRelease Date: " + 
               date.format(releaseDate.getTime()) +    // Using date formatter to display as yyyy-MM-dd
               "\nPrice: $" + super.getPrice() + "\n";

    }
}
