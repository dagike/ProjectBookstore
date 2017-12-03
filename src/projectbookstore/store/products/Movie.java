/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: Movie
 * Package: projectbookstore.store.products
 *
 */

//Current package
package projectbookstore.store.products;

public class Movie {
    //Attributes
    private String title, director, genre, rating, language, type, releaseDate;
    private int duration;
    private double price;

    //Method
    
    //Constructor   
    public Movie(){
        title= "";
        director= "";
        genre= "";
        rating= "";
        duration= 0;
        language= "";
        type= "";
        releaseDate= "";
        price= 0.0;

    }
    
    //Accesor for title
    public String getTitle() {
        return title;
    }

    //Mutator for title
    public void setTitle(String title) {
        this.title = title;
    }

    //Accesor for director
    public String getDirector() {
        return director;
    }

    //Mutator for director
    public void setDirector(String director) {
        this.director = director;
    }

    //Accesor for genre
    public String getGenre() {
        return genre;
    }

    //Mutator for genre
    public void setGenre(String genre) {
        this.genre = genre;
    }

    //Accesor for rating
    public String getRating() {
        return rating;
    }

    //Mutator for rating
    public void setRating(String rating) {
        this.rating = rating;
    }

    //Accesor for duration
    public int getDuration() {
        return duration;
    }

    //Mutator for duration
    public void setDuration(int duration) {
        this.duration = duration;
    }

    //Accesor for language
    public String getLanguage() {
        return language;
    }

    //Mutator for language
    public void setLanguage(String language) {
        this.language = language;
    }

    //Accesor for type
    public String getType() {
        return type;
    }

    //Mutator for type
    public void setType(String type) {
        this.type = type;
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
    public void displayMovie(){
        System.out.println( "Title: " + title +
               "\nDirector: " + director +
               "\nGenre: " + genre +
               "\nRating: " + rating +
               "\nDuration: " + duration +
               " min\nLanguage: " + language + 
               "\nType: " + type +
               "\nRelease Date: " + releaseDate +
               "\nPrice: $" + price + "\n" );
    }
}
