/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: Book
 * Package: projectbookstore.store.products 
 *
 */

// Current package
package projectbookstore.store.products;

public class Book extends Product{
    // Attributes
    private String author, genre, publisher, language, ISBN;
    private int pages, publicationYear;

    // Methods
    
    // Constructor
    public Book() {
        super();
        author = "";
        genre = "";
        publisher = "";
        publicationYear = 0;
        language = "";
        ISBN = "";
        pages = 0;
    }

    // Accesor for author
    public String getAuthor() {
        return author;
    }

    // Mutator for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Accesor for genre
    public String getGenre() {
        return genre;
    }

    // Mutator for genre
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Accesor for publisher
    public String getPublisher() {
        return publisher;
    }

    // Mutator for publisher
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Accesor for publicationDate
    public int getPublicationYear() {
        return publicationYear;
    }

    // Mutator for publicationDate
    public void setPublicationYear(int publicationYear) {
        if(publicationYear > 0)
            this.publicationYear = publicationYear;
    }

    // Accesor for language
    public String getLanguage() {
        return language;
    }

    // Mutator for language
    public void setLanguage(String language) {
        this.language = language;
    }

    // Accesor for ISBN
    public String getISBN() {
        return ISBN;
    }

    // Mutator for ISBN
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    // Accesor for pages
    public int getPages() {
        return pages;
    }

    // Mutator for pages
    public void setPages(int pages) {
        if(pages > 0)
            this.pages = pages;
    }
    
    @Override
    // Override toString to format a Strirng with fields of the object
    public String toString(){
        return "Title: " + super.getTitle() +
               "\nAuthor: " + author +
               "\nGenre: " + genre +
               "\nPublisher: " + publisher +
               "\nPublication Year: " + publicationYear +
               "\nLanguage: " + language +
               "\nISBN: " + ISBN +
               "\nPages: " + pages +
               "\nPrice: $" + super.getPrice() + "\n";
    }
}
