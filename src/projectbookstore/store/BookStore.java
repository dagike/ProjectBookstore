/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: BookStore
 * Package: projectbookstore.store 
 *
 */

// Current package
package projectbookstore.store;

// Import java libraries and other libraries
import projectbookstore.store.products.*;   // Product Classes
import projectbookstore.store.db.*;         // DB Classes
import java.util.List;                      // List object
import java.util.ArrayList;                 // ArrayList object
import java.util.Scanner;                   // Scanner object

public class BookStore {
    // Attributes
    private final AlbumDB albumList;
    private final BookDB bookList;
    private final GameConsoleDB gameConsoleList;
    private final GiftCardDB giftCardList;
    private final MovieDB movieList;
    private final VideoGameDB videoGameList;
    
    // Methods
    
    // Constructor
    public BookStore(){
        albumList = new AlbumDB();
        bookList = new BookDB();
        gameConsoleList = new GameConsoleDB();
        giftCardList = new GiftCardDB();
        movieList = new MovieDB();
        videoGameList = new VideoGameDB();
    }
    
    // Constructor with variable capacity
    public BookStore(int capacity){
        albumList = new AlbumDB(capacity);
        bookList = new BookDB(capacity);
        gameConsoleList = new GameConsoleDB(capacity);
        giftCardList = new GiftCardDB(capacity);
        movieList = new MovieDB(capacity);
        videoGameList = new VideoGameDB(capacity);
    }
       
    // Ask for an album and return as a Album object
    public Album askAlbum(String title){
        // new Album object
        Album album = new Album();
        // int Array for date {year, month, day}
        int intDate[] = {0, 0, 0};
        // Scanner object for user input
        Scanner input = new Scanner(System.in);
        
        // Ask for all the other fields
        album.setTitle(title);
        System.out.print("Artist: ");
        album.setArtist(input.nextLine());
        System.out.print("Genre: ");
        album.setGenre(input.nextLine());
        System.out.print("Language: ");
        album.setLanguage(input.nextLine());
        // Ask for the Release Date until is a valid date
        while(true){
            System.out.print("Release Date: ");
            String date = input.nextLine();
            if(checkDate(date, intDate)){           // Check date string
                                 // ( year,      month       day) changed by checkDate method
                album.setReleaseDate(intDate[0], intDate[1], intDate[2]); 
                break;
            }
        }
        // Validate if duration is just a number without decimals
        while(true){
            try{
                System.out.print("Duration: ");
                album.setDuration(input.nextInt());
                if(album.getDuration() > 0)     // Check if duration is not negative
                    break;
                else
                    System.out.println("Only positive numbers");
            }catch(Exception e){
                //Display error message
                System.out.println("Only numbers without decimal allowed, try again");
                input.next();
            }
        }
        // Validate if price is just a number
        while(true){
            try{
                System.out.print("Price: ");
                album.setPrice(input.nextDouble());
                if(album.getPrice() > 0)    // Check if price is not negative
                    break; 
                else
                    System.out.println("Only positive numbers");
            }catch(Exception e){
                //Display error message
                System.out.println("Only numbers allowed, try again");
                input.next();
            }
        }
        return album;
    }
    
    // Add an album to albumList 
    public void addAlbum(){
        String title = askTitle();                      // Ask for a title to user
        if(albumList.findAlbumByTitle(title) >= 0)      // If title already exist in albumList
            System.out.println("Title already exists"); // Title must be unique
        else
            // Display message if the object was added or list is Full
            System.out.println(albumList.addAlbum(askAlbum(title)) ? "New Album Added" : "Album List Full");
        waitUser();        
    }
    
    // Delete an album from the albumList by searching the title 
    public void deleteAlbum(){
        if(albumList.getCount() > 0){                        // Check if albumList is not empty
            String title = askTitle();                      // Ask for a title to user
            // Display message if the object was deleted or title was not found
            System.out.println(albumList.deleteAlbum(title) ? "Album Deleted" : "Title not found");
        } else
            System.out.println("List is Empty");
        waitUser();
    }
    
    // Modify an album from the albumList by searching the title
    public void modifyAlbum(){
        if(albumList.getCount() > 0){                    // Check if albumList is not empty
            String title = askTitle();                      // Ask for a title to user
            if(albumList.findAlbumByTitle(title) < 0)       // If title doesn't exist in albumList
                System.out.println("Title not found");      
            else
                // Display message if the object was added or there was an error
                System.out.println(albumList.updateAlbum(title, askAlbum(title)) ? "Album Changed" : "Error updating");
        } else
            System.out.println("List is Empty");
        waitUser();
    }
    
    // Display album with search criteria Artist or Genre
    public void searchAlbum(){
        Scanner input = new Scanner(System.in);     // Scanner input
        String searchOption;                        // Choose which type of search 
        String searchCriteria;                      // Type what to search
        
        // Choose between Artist search or Genre search
        if(albumList.getCount() > 0)                // If albumList is not empty
            while(true){    // While the user choose an invalid option
                System.out.println("Choose criteria searching\n1. Artist\n2. Genre");
                searchOption = input.nextLine();                // User choice
                if(searchOption.compareTo("1") == 0){           // Artist Search
                    System.out.print("Enter Artist: ");
                    searchCriteria = input.nextLine();          // Which Artist to Search
                    if(!albumList.displayAlbumByArtist(searchCriteria)) // Search
                        System.out.println("Artist not found"); // Search failed
                    break;
                } else if(searchOption.compareTo("2") == 0){    // Genre Search
                    System.out.print("Enter Genre: ");      
                    searchCriteria = input.nextLine();          // Which Artist to Search
                    if(!albumList.displayAlbumByGenre(searchCriteria)) // Search
                        System.out.println("Genre not found");  // Search failed
                    break;
                } else 
                    System.out.println("Invalid option");       // Not a valid option  
            }
        else
            System.out.println("List is empty");
        waitUser();
    }
    
    // Display an album or all the objects from the albumList
    public void displayAlbum(){
        if(albumList.getCount() > 0)             // Check if albumList is not empty
            albumList.displayAlbumList();
        else 
            System.out.println("List is Empty");
        waitUser();
    }
    
    // Ask for a book and return as a Book object
    public Book askBook(String title){
        //new Book object
        Book book = new Book();
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        
        //Set title with argument
        book.setTitle(title);
        //Ask for all the other fields
        System.out.print("Author: ");
        book.setAuthor(input.nextLine());
        System.out.print("Genre: ");
        book.setGenre(input.nextLine());
        System.out.print("Publisher: ");
        book.setPublisher(input.nextLine());
        System.out.print("Language: ");
        book.setLanguage(input.nextLine());
        System.out.print("ISBN: ");
        book.setISBN(input.nextLine());
        //Validate if Pages is just a number without decimals
        while(true){
            try{
                System.out.print("Pages: ");
                book.setPages(input.nextInt());
                if(book.getPages() > 0)                 // Check pages is not negative
                    break;
                else
                    System.out.println("Only positive numbers");
            }catch(Exception e){
                //Display error message
                System.out.println("Only numbers without decimal allowed, try again");
                input.next();
            }
        }
        //Validate if Publication Year is just a number without decimals
        while(true){
            try{
                System.out.print("Publication Year: ");
                book.setPublicationYear(input.nextInt());
                if(book.getPublicationYear() > 0)       // Check year is not negative
                    break;
                else
                    System.out.println("Only positive numbers");
            }catch(Exception e){
                //Display error message
                System.out.println("Only numbers without decimal allowed, try again");
                input.next();
            }
        }
        //Validate if Price is just a number
        while(true){
            try{
                System.out.print("Price: ");
                book.setPrice(input.nextDouble());
                if(book.getPrice() > 0)                 // Check price is not negative
                    break;
                else
                    System.out.println("Only positive numbers");
            }catch(Exception e){
                //Display error message
                System.out.println("Only numbers allowed, try again");
                input.next();
            }
        }
        return book;
    }
    
    // Add a book to bookList
    public void addBook(){
        String title = askTitle();                      // Ask for a title to user
        if(bookList.findBookByTitle(title) >= 0)        // If title already exist in bookList
            System.out.println("Title already exists"); // Title must be unique
        else
            // Display message if the object was added or list is Full
            System.out.println(bookList.addBook(askBook(title)) ? "New Book Added" : "Book List Full");
        waitUser();        
    }
    
    // Delete a book from the bookList by searching the title 
    public void deleteBook(){
        if(bookList.getCount() > 0){                    // Check if bookList is not empty
            String title = askTitle();                  // Ask for a title to user
            // Display message if the object was deleted or title was not found
            System.out.println(bookList.deleteBook(title) ? "Book Deleted" : "Title not found");
        } else
            System.out.println("List is Empty");
        waitUser();
    }
    
    // Modify a book from the bookList by searching the title
    public void modifyBook(){
        if(bookList.getCount() > 0){                    // Check if bookList is not empty
            String title = askTitle();                  // Ask for a title to user
            if(albumList.findAlbumByTitle(title) < 0)   // If title doesn't exist in bookList
                System.out.println("Title not found");      
            else
                // Display message if the object was added or there was an error
                System.out.println(bookList.updateBook(title, askBook(title)) ? "Album Changed" : "Error updating");
        } else 
            System.out.println("List is Empty"); 
        waitUser();
    }
    
    // Display book with search criteria Author or Genre
    public void searchBook(){
        Scanner input = new Scanner(System.in);         // Scanner input
        String searchOption;                            // Choose which type of search 
        String searchCriteria;                          // Type what to search
        
        // Choose between Artist search or Genre search
        if(albumList.getCount() > 0)                    // If albumList is not empty
            while(true){    // While the user choose an invalid option
                System.out.println("Choose criteria searching\n1. Author\n2. Genre");
                searchOption = input.nextLine();                // User choice
                if(searchOption.compareTo("1") == 0){           // Author Search
                    System.out.print("Enter Artist: ");
                    searchCriteria = input.nextLine();          // Which Author to Search
                    if(!bookList.displayBookByAuthor(searchCriteria)) // Search
                        System.out.println("Artist not found"); // Search failed
                    break;
                } else if(searchOption.compareTo("2") == 0){    // Genre Search
                    System.out.print("Enter Genre: ");      
                    searchCriteria = input.nextLine();          // Which Artist to Search
                    if(!bookList.displayBookByGenre(searchCriteria)) // Search
                        System.out.println("Genre not found");  // Search failed
                    break;
                } else 
                    System.out.println("Invalid option");       // Not a valid option  
            }
        else
            System.out.println("List is empty");
        waitUser();
    }
    
    // Display a book or all the objects from the bookList
    public void displayBook(){
        if(bookList.getCount() > 0)                       // Check if bookList is not empty
            bookList.displayBookList();
        else
            System.out.println("List is Empty");
        waitUser();
    }
    
    //Create a new object GameConsole to add to the list gameConsoles with user inputs
    public GameConsole askGameConsole(String title){
        //new GameConsole object
        GameConsole gameConsole = new GameConsole();
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        // int Array for date {year, month, day}
        int intDate[] = {0, 0, 0};
        
        gameConsole.setName(title);

        //Ask for all the other fields
        System.out.print("Company: ");
        gameConsole.setCompany(input.nextLine());
        //Ask for the releaseDate until is a valid date
        while(true){
            System.out.print("Release Date: ");
            String date = input.nextLine();
            if(checkDate(date, intDate)){           // Check date string
                                 // ( year,      month       day) changed by checkDate method
                gameConsole.setReleaseDate(intDate[0], intDate[1], intDate[2]); 
                break;
            }
        }
        //Validate if memory is just a number without decimals
        while(true){
            try{
                System.out.print("Memory: ");
                gameConsole.setMemory(input.nextInt());
                if(gameConsole.getMemory() > 0)             // Check memory is not negative
                    break;
                else
                    System.out.println("Only positive numbers");
                    
            }catch(Exception e){
                //Display error message
                System.out.println("Only numbers without decimal allowed, try again");
                input.next();
            }
        }
        //Validate if weight is just a number
        while(true){
            try{
                System.out.print("Weight: ");
                gameConsole.setWeight(input.nextDouble());
                if(gameConsole.getWeight() > 0)             // Check weight is not negative
                    break;
                else
                    System.out.println("Only positive numbers");
                break;
            }catch(Exception e){
                //Display error message
                System.out.println("Only numbers allowed, try again");
                input.next();
            }
        }
        //Validate if price is just a number
        while(true){
            try{
                System.out.print("Price: ");
                gameConsole.setPrice(input.nextDouble());
                if(gameConsole.getPrice() > 0)             // Check price is not negative
                    break;
                else
                    System.out.println("Only positive numbers");
                break;
            }catch(Exception e){
                //Display error message
                System.out.println("Only numbers allowed, try again");
                input.next();
            }
        }
        //Add the object with all the inputs to the list gameConsoles
        return gameConsole;
    }
    
    // Add a book to gameConsoleList
    public void addGameConsole(){
        String name = askName();                            // Ask for a name to user
        if(gameConsoleList.findGameConsoleByName(name) >= 0)// If title already exist in gameConsoleList
            System.out.println("Name already exists");      // Name must be unique
        else
            // Display message if the object was added or list is Full
            System.out.println(gameConsoleList.addGameConsole(askGameConsole(name)) ? "New Game Console Added" : "Game Console List Full");
        waitUser();        
    }
    
    // Delete a Game Console from the gameConsoleList by searching the name 
    public void deleteGameConsole(){
        if(gameConsoleList.getCount() > 0){                 // Check if gameConsoleList is not empty
            String name = askName();                        // Ask for a name to user
            // Display message if the object was deleted or name was not found
            System.out.println(gameConsoleList.deleteGameConsole(name) ? "Game Console Deleted" : "Name not found");
        } else
            System.out.println("List is Empty");
        waitUser();
    }
    
    // Modify a Game Console from the bookList by searching the title
    public void modifyGameConsole(){
        if(gameConsoleList.getCount() > 0){                     // Check if gameConsoleList is not empty
            String name = askName();                            // Ask for a name to user
            if(gameConsoleList.findGameConsoleByName(name) < 0) // If name doesn't exist in gameConsoleList
                System.out.println("Name not found");      
            else
                // Display message if the object was added or there was an error
                System.out.println(gameConsoleList.updateGameConsole(name, askGameConsole(name)) ? "Game Console Changed" : "Error updating");
        } else 
            System.out.println("List is Empty"); 
        waitUser();
    }
    
    // Display Game Console with search criteria Company
    public void searchGameConsole(){
        Scanner input = new Scanner(System.in);                 // Scanner input
        String searchOption;                                    // Choose which type of search 
        String searchCriteria;                                  // Type what to search
        
        // Choose between Artist search or Genre search
        if(gameConsoleList.getCount() > 0)                      // If gameConsoleList is not empty
            while(true){    // While the user choose an invalid option
                System.out.println("Choose criteria searching\n1. Company\n2. Company");
                searchOption = input.nextLine();                // User choice
                if(searchOption.compareTo("1") == 0){           // Author Search
                    System.out.print("Enter Company: ");
                    searchCriteria = input.nextLine();          // Which Company to Search
                    if(!gameConsoleList.displayGameConsoleByCompany(searchCriteria)) // Search
                        System.out.println("Company not found");// Search failed
                    break;
                } else if(searchOption.compareTo("2") == 0){    // Genre Search
                    System.out.print("Enter Company: ");      
                    searchCriteria = input.nextLine();          // Which Company to Search
                    if(!gameConsoleList.displayGameConsoleByCompany(searchCriteria)) // Search
                        System.out.println("Company not found");// Search failed
                    break;
                } else 
                    System.out.println("Invalid option");       // Not a valid option  
            }
        else
            System.out.println("List is empty");
        waitUser();
    }
    
    // Display a Game Console or all the objects from the bookList
    public void displayGameConsole(){
        if(gameConsoleList.getCount() > 0)                      // Check if gameConsoleList is not empty
            gameConsoleList.displayGameConsoleList();
        else
            System.out.println("List is Empty");
        waitUser();
    }
    
//Create a new object GiftCard to add to the list gifs with user inputs
    public GiftCard askGiftCard(String title){
        //new GiftCard object
        GiftCard giftCard = new GiftCard();
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
                
        giftCard.setName(title);
        //Ask for all the other fields
        System.out.print("Company: ");
        giftCard.setCompany(input.nextLine());
        System.out.print("Region: ");
        giftCard.setRegion(input.nextLine());
        //Validate if amount is just a number without decimals
        while(true){
            try{
                System.out.print("Amount: ");
                giftCard.setAmount(input.nextInt());
                if(giftCard.getAmount() > 0)             // Check amount is not negative
                    break;
                else
                    System.out.println("Only positive numbers");
                break;
            }catch(Exception e){
                //Display error message
                System.out.println("Only numbers without decimal allowed, try again");
                input.next();
            }
        }
        //Validate if price is just a number
        while(true){
            try{
                System.out.print("Price: ");
                giftCard.setPrice(input.nextDouble());
                if(giftCard.getPrice() > 0)             // Check price is not negative
                    break;
                else
                    System.out.println("Only positive numbers");
                break;
            }catch(Exception e){
                //Display error message
                System.out.println("Only numbers allowed, try again");
                input.next();
            }
        }
        //Add the object with all the inputs to the list giftCards
        return giftCard;
    }
    
    // Add a giftCard to giftCardList 
    public void addGiftCard(){
        String name = askName();                            // Ask for a name to user
        if(giftCardList.findGiftCardByName(name) >= 0)      // If name already exist in giftCardList
            System.out.println("Name already exists");      // Name must be unique
        else
            // Display message if the object was added or list is Full
            System.out.println(giftCardList.addGiftCard(askGiftCard(name)) ? "New GiftCard Added" : "GiftCard List Full");
        waitUser();        
    }

    // Delete a giftCard from the giftCardList by searching the name 
    public void deleteGiftCard(){
        if(giftCardList.getCount() > 0){                  // Check if giftCardList is not empty
            String name = askName();                      // Ask for a name to user
            // Display message if the object was deleted or name was not found
            System.out.println(giftCardList.deleteGiftCard(name) ? "GiftCard Deleted" : "Name not found");
        } else 
            System.out.println("List is Empty");
        waitUser();
    }

    // Modify a giftCard from the giftCardList by searching the name
    public void modifyGiftCard(){
        if(giftCardList.getCount() > 0){                    // Check if giftCardList is not empty
            String name = askName();                        // Ask for a name to user
            if(giftCardList.findGiftCardByName(name) < 0)   // If name doesn't exist in giftCardList
                System.out.println("Name not found");      
            else
                // Display message if the object was added or there was an error
                System.out.println(giftCardList.updateGiftCard(name, askGiftCard(name)) ? "GiftCard Changed" : "Error updating");
        } else
            System.out.println("List is Empty");
        waitUser();
    }

    // Display giftCard with search criteria Company or Genre
    public void searchGiftCard(){
        Scanner input = new Scanner(System.in);     // Scanner input
        String searchOption;                        // Choose which type of search 
        String searchCriteria;                      // Type what to search

        // Choose between Company search or Genre search
        if(giftCardList.getCount() > 0)             // If giftCardList is not empty
            while(true){    // While the user choose an invalid option
                System.out.println("Choose criteria searching\n1. Company\n2. Region");
                searchOption = input.nextLine();                // User choice
                if(searchOption.compareTo("1") == 0){           // Company Search
                    System.out.print("Enter Company: ");
                    searchCriteria = input.nextLine();          // Which Company to Search
                    if(!giftCardList.displayGiftCardByCompany(searchCriteria)) // Search
                        System.out.println("Company not found");// Search failed
                    break;
                } else if(searchOption.compareTo("2") == 0){    // Region Search
                    System.out.print("Enter Region: ");      
                    searchCriteria = input.nextLine();          // Which Region to Search
                    if(!giftCardList.displayGiftCardByRegion(searchCriteria)) // Search
                        System.out.println("Region not found"); // Search failed
                    break;
                } else 
                    System.out.println("Invalid option");       // Not a valid option  
            }
        else
            System.out.println("List is empty");
        waitUser();
    }

    // Display a giftCard or all the objects from the giftCardList
    public void displayGiftCard(){
        if(giftCardList.getCount() > 0)             // Check if giftCardList is not empty
            giftCardList.displayGiftCardList();
        else 
            System.out.println("List is Empty");
        waitUser();
    }
    
    //Create a new object Movie to add to the list movies with user inputs
    public Movie askMovie(String title){
        //new Movie object
        Movie movie = new Movie();
        // int Array for date {year, month, day}
        int intDate[] = {0, 0, 0};
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
                
        movie.setTitle(title);
        //Ask for all the other fields
        System.out.print("Director: ");
        movie.setDirector(input.nextLine());
        System.out.print("Genre: ");
        movie.setGenre(input.nextLine());
        System.out.print("Rating: ");
        movie.setRating(input.nextLine());
        System.out.print("Language: ");
        movie.setLanguage(input.nextLine());
        System.out.print("Type: ");
        movie.setType(input.nextLine());
        //Ask for the releaseDate until is a valid date
        while(true){
            System.out.print("Release Date: ");
            String date = input.nextLine();
            if(checkDate(date, intDate)){           // Check date string
                                 // ( year,      month       day) changed by checkDate method
                movie.setReleaseDate(intDate[0], intDate[1], intDate[2]); 
                break;
            }
        }
        //Validate if duration is just a number without decimals
        while(true){
            try{
                System.out.print("Duration: ");
                movie.setDuration(input.nextInt());
                if(movie.getDuration() > 0)               // Check duration is not negative
                    break;
                else
                    System.out.println("Only positive numbers");
            }catch(Exception e){
                //Display error message
                System.out.println("Only numbers without decimal allowed, try again");
                input.next();
            }
        }
        //Validate if price is just a number
        while(true){
            try{
                System.out.print("Price: ");
                movie.setPrice(input.nextDouble());
                if(movie.getPrice() > 0)                 // Check price is not negative
                    break;
                else
                    System.out.println("Only positive numbers");
            }catch(Exception e){
                //Display error message
                System.out.println("Only numbers allowed, try again");
                input.next();
            }
        }
        //Add the object with all the inputs to the list movies
        return movie;
    }
    
        // Add an movie to movieList 
    public void addMovie(){
        String title = askTitle();                      // Ask for a title to user
        if(movieList.findMovieByTitle(title) >= 0)      // If title already exist in movieList
            System.out.println("Title already exists"); // Title must be unique
        else
            // Display message if the object was added or list is Full
            System.out.println(movieList.addMovie(askMovie(title)) ? "New Movie Added" : "Movie List Full");
        waitUser();        
    }
    
    // Delete an movie from the movieList by searching the title 
    public void deleteMovie(){
        if(movieList.getCount() > 0){                        // Check if movieList is not empty
            String title = askTitle();                      // Ask for a title to user
            // Display message if the object was deleted or title was not found
            System.out.println(movieList.deleteMovie(title) ? "Movie Deleted" : "Title not found");
        } else
            System.out.println("List is Empty");
        waitUser();
    }
    
    // Modify an movie from the movieList by searching the title
    public void modifyMovie(){
        if(movieList.getCount() > 0){                    // Check if movieList is not empty
            String title = askTitle();                      // Ask for a title to user
            if(movieList.findMovieByTitle(title) < 0)       // If title doesn't exist in movieList
                System.out.println("Title not found");      
            else
                // Display message if the object was added or there was an error
                System.out.println(movieList.updateMovie(title, askMovie(title)) ? "Movie Changed" : "Error updating");
        } else
            System.out.println("List is Empty");
        waitUser();
    }
    
    // Display movie with search criteria Director or Genre
    public void searchMovie(){
        Scanner input = new Scanner(System.in);     // Scanner input
        String searchOption;                        // Choose which type of search 
        String searchCriteria;                      // Type what to search
        
        // Choose between Director search or Genre search
        if(movieList.getCount() > 0)                // If movieList is not empty
            while(true){    // While the user choose an invalid option
                System.out.println("Choose criteria searching\n1. Director\n2. Genre");
                searchOption = input.nextLine();                // User choice
                if(searchOption.compareTo("1") == 0){           // Director Search
                    System.out.print("Enter Director: ");
                    searchCriteria = input.nextLine();          // Which Director to Search
                    if(!movieList.displayMovieByDirector(searchCriteria)) // Search
                        System.out.println("Director not found"); // Search failed
                    break;
                } else if(searchOption.compareTo("2") == 0){    // Genre Search
                    System.out.print("Enter Genre: ");      
                    searchCriteria = input.nextLine();          // Which Director to Search
                    if(!movieList.displayMovieByGenre(searchCriteria)) // Search
                        System.out.println("Genre not found");  // Search failed
                    break;
                } else 
                    System.out.println("Invalid option");       // Not a valid option  
            }
        else
            System.out.println("List is empty");
        waitUser();
    }
    
    // Display an movie or all the objects from the movieList
    public void displayMovie(){
        if(movieList.getCount() > 0)             // Check if movieList is not empty
            movieList.displayMovieList();
        else 
            System.out.println("List is Empty");
        waitUser();
    }
    
    //Create a new object VideoGame with user inputs
    public VideoGame askVideoGame(String title){
        //new VideoGame object
        VideoGame videoGame = new VideoGame();
        // int Array for date {year, month, day}
        int intDate[] = {0, 0, 0};
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
                
        videoGame.setTitle(title);
        //Ask for all the other fields
        System.out.print("Genre: ");
        videoGame.setGenre(input.nextLine());
        System.out.print("Console: ");
        videoGame.setConsole(input.nextLine());
        System.out.print("Publisher: ");
        videoGame.setPublisher(input.nextLine());
        System.out.print("Developer: ");
        videoGame.setDeveloper(input.nextLine());
        System.out.print("Language: ");
        videoGame.setLanguage(input.nextLine());
        //Ask for the releaseDate until is a valid date
        //Ask for the releaseDate until is a valid date
        while(true){
            System.out.print("Release Date: ");
            String date = input.nextLine();
            if(checkDate(date, intDate)){           // Check date string
                                 // ( year,      month       day) changed by checkDate method
                videoGame.setReleaseDate(intDate[0], intDate[1], intDate[2]); 
                break;
            }
        }
        //Validate if price is just a number
        while(true){
            try{
                System.out.print("Price: ");
                videoGame.setPrice(input.nextDouble());
                if(videoGame.getPrice() > 0)        // Check price is not negative
                    break;
                else
                    System.out.println("Only positive numbers");
            }catch(Exception e){
                //Display error message
                System.out.println("Only numbers allowed, try again");
                input.next();
            }
        }
        return videoGame;
    }
    
    // Add a videoGame to videoGameList 
    public void addVideoGame(){
        String title = askTitle();                            // Ask for a name to user
        if(videoGameList.findVideoGameByTitle(title) >= 0)    // If name already exist in videoGameList
            System.out.println("Name already exists");      // Name must be unique
        else
            // Display message if the object was added or list is Full
            System.out.println(videoGameList.addVideoGame(askVideoGame(title)) ? "New VideoGame Added" : "VideoGame List Full");
        waitUser();        
    }

    // Delete a videoGame from the videoGameList by searching the name 
    public void deleteVideoGame(){
        if(videoGameList.getCount() > 0){                   // Check if videoGameList is not empty
            String name = askName();                        // Ask for a name to user
            // Display message if the object was deleted or name was not found
            System.out.println(videoGameList.deleteVideoGame(name) ? "VideoGame Deleted" : "Name not found");
        } else 
            System.out.println("List is Empty");
        waitUser();
    }

    // Modify a videoGame from the videoGameList by searching the name
    public void modifyVideoGame(){
        if(videoGameList.getCount() > 0){                     // Check if videoGameList is not empty
            String title = askTitle();                        // Ask for a name to user
            if(videoGameList.findVideoGameByTitle(title) < 0) // If name doesn't exist in videoGameList
                System.out.println("Name not found");      
            else
                // Display message if the object was added or there was an error
                System.out.println(videoGameList.updateVideoGame(title, askVideoGame(title)) ? "VideoGame Changed" : "Error updating");
        } else
            System.out.println("List is Empty");
        waitUser();
    }

    // Display videoGame with search criteria Artist or Genre
    public void searchVideoGame(){
        Scanner input = new Scanner(System.in);     // Scanner input
        String searchOption;                        // Choose which type of search 
        String searchCriteria;                      // Type what to search

        // Choose between Developer search or Genre search or Console search
        if(videoGameList.getCount() > 0)                          // If videoGameList is not empty
            while(true){    // While the user choose an invalid option
                System.out.println("Choose criteria searching\n1. Developer\n2. Genre\n3. Console");
                searchOption = input.nextLine();                  // User choice
                if(searchOption.compareTo("1") == 0){             // Company Search
                    System.out.print("Enter Developer: ");
                    searchCriteria = input.nextLine();            // Which Developer to Search
                    if(!videoGameList.displayVideoGameByDeveloper(searchCriteria)) // Search
                        System.out.println("Developer not found");// Search failed
                    break;
                } else if(searchOption.compareTo("2") == 0){      // Region Search
                    System.out.print("Enter Genre: ");      
                    searchCriteria = input.nextLine();            // Which Genre to Search
                    if(!videoGameList.displayVideoGameByGenre(searchCriteria)) // Search
                        System.out.println("Genre not found");    // Search failed
                    break;
                } else if(searchOption.compareTo("3") == 0){      // Region Search
                    System.out.print("Enter Console: ");      
                    searchCriteria = input.nextLine();            // Which Console to Search
                    if(!videoGameList.displayVideoGameByConsole(searchCriteria)) // Search
                        System.out.println("Console not found");  // Search failed
                    break;
                } else 
                    System.out.println("Invalid option");         // Not a valid option  
            }
        else
            System.out.println("List is empty");
        waitUser();
    }

    // Display a videoGame or all the objects from the videoGameList
    public void displayVideoGame(){
        if(videoGameList.getCount() > 0)             // Check if videoGameList is not empty
            videoGameList.displayVideoGameList();
        else 
            System.out.println("List is Empty");
        waitUser();
    }
    
    // Wait for user enter
    public void waitUser(){        
        System.out.println("Please press [Enter] to continue");
        new Scanner(System.in).nextLine();
    }
    
    // Ask for title
    public String askTitle(){
        System.out.print("Title: ");
        return new Scanner(System.in).nextLine();
    }
    
    // Ask for name
    public String askName(){
        System.out.print("Name: ");
        return new Scanner(System.in).nextLine();
    }
    
    //Check if the date is a valid format yyyy-mm-dd
    public boolean checkDate(String date){
        if(date.length() != 10){
            //Display error message string date has to have 10 characters
            System.out.println("Must be 10 characters");
            return false;
        //Check for format and check for months with 29, 30 or 31 days
        }else if(!date.matches("\\d{4}-"
                + "(((01|03|05|07|08|10|12)-(0[1-9]|1[0-9]|2[0-9]|3[0-1]))|"  //Months with up to 31 days
                + "((04|06|09|11)-(0[1-9]|1[0-9]|2[0-9]|30))|"                //Months Valid only up to 30 days
                + "((02)-(0[1-9]|1[0-9]|2[0-9])))" + "$")){                   //February up to 29 days
            //Display error message invalid format or wrong number of days
            System.out.println("Check format yyyy-mm-dd and valid month-day number");
            return false;
        }else
            return true;
    }
    
    //Check if the date is a valid format yyyy-mm-dd and assign in an array of int
    public boolean checkDate(String date, int intDate[]){
        if(date.length() != 10){
            //Display error message string date has to have 10 characters
            System.out.println("Must be 10 characters");
            return false;
        //Check for format and check for months with 29, 30 or 31 days
        }else if(!date.matches("\\d{4}-"
                + "(((01|03|05|07|08|10|12)-(0[1-9]|1[0-9]|2[0-9]|3[0-1]))|"  //Months with up to 31 days
                + "((04|06|09|11)-(0[1-9]|1[0-9]|2[0-9]|30))|"                //Months Valid only up to 30 days
                + "((02)-(0[1-9]|1[0-9]|2[0-9])))" + "$")){                   //February up to 29 days
            //Display error message invalid format or wrong number of days
            System.out.println("Check format yyyy-mm-dd and valid month-day number");
            return false;
        }else{
            intDate[0] = Integer.parseInt(date.substring(0, 4));    // Day
            intDate[1] = Integer.parseInt(date.substring(5, 7));    // Month
            intDate[2] = Integer.parseInt(date.substring(8, 10));   // Year
            return true;
        }
    }
}
