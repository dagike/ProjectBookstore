/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: Album
 * Package: projectbookstore.store.products
 *
 */

//Current package
package projectbookstore.store.products;

import java.util.Date;

public class Album {
    //Attributes
    private String artist, title, genre, language, releaseDate;
    private int duration;
    private double price;
    
    //Methods
    
    //Constructor
    public Album(){
        artist= "";
        title = "";
        genre = "";
        language = "";
        duration = 0;
        releaseDate = "";
        price = 0.0;
    }
    
    //Accesor for artist
    public String getArtist() {
        return artist;
    }
    
    //Mutator for artist
    public void setArtist(String artist) {
        this.artist = artist;
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
    
    //Accesor for language
    public String getLanguage() {
        return language;
    }

    //Mutator for language
    public void setLanguage(String language) {
        this.language = language;
    }
    
    //Accesor for duration
    public int getDuration() {
        return duration;
    }

    //Mutator for duration
    public void setDuration(int duration) {
        this.duration = duration > 0 ? duration : 1;
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
    public void displayAlbum(){
            System.out.println("Title: " + title + 
                               "\nArtist: " + artist +
                               "\nGenre: " + genre + 
                               "\nLanguage: " + language +
                               "\nDuration: " + duration +
                               " min\nRelease Date: " + releaseDate +
                               "\nPrice: $" + price + "\n" );
    }
}
