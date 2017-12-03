/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: Videogame
 * package: projectbookstore.store.products
 *
 */

//Current package
package projectbookstore.store.products;

public class VideoGame {
    //Attributes
    private String title, genre, console, publisher, developer, language, releaseDate;
    private double price;

    //Methods
    
    //Constructor
    public VideoGame() {
        title = "";
        genre = "";
        console = "";
        publisher = "";
        developer = "";
        language = "";
        releaseDate = "";
        price = 0.0;
    }
    
    //Accesor for title
    public String getTitle() {
        return title;
    }

    //Mutator for title
    public void setTitle(String title) {
        this.title = title;
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
    public String getReleaseDate() {
        return releaseDate;
    }

    //Mutator for releaseDate
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    //Accesor for price
    public double getPrice() {
        return price;
    }

    //Mutator for price
    public void setPrice(double price) {
        this.price = price;
    }
    
    //Display all the fields of the object
    public void displayVideoGame(){
        System.out.println( "Title: " + title +
                            "\nGenre: " + genre +
                            "\nConsole: " + console +
                            "\nPublisher: " + publisher +
                            "\nDeveloper: " + developer +
                            "\nLanguage: " + language +
                            "\nRelease Date: " + releaseDate +
                            "\nPrice: $" + price + "\n" );

    }
}
