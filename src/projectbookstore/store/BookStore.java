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
    private final List<Movie> movies;
    private final List<VideoGame> videoGames;
    
    // Methods
    
    // Constructor
    public BookStore(){
        albumList = new AlbumDB();
        bookList = new BookDB();
        gameConsoleList = new GameConsoleDB();
        giftCardList = new GiftCardDB();
        movies = new ArrayList();
        videoGames = new ArrayList();
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
            if(checkDate(date, intDate)){
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
            waitUser();
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
                if(book.getPrice() > 0)             // Check price is not negative
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
        if(bookList.getCount() > 0){                        // Check if bookList is not empty
            String title = askTitle();                      // Ask for a title to user
            // Display message if the object was deleted or title was not found
            System.out.println(bookList.deleteBook(title) ? "Book Deleted" : "Title not found");
        } else
            System.out.println("List is Empty");
        waitUser();
    }
    
    // Modify a book from the bookList by searching the title
    public void modifyBook(){
        if(bookList.getCount() > 0){                        // Check if bookList is not empty
            String title = askTitle();                      // Ask for a title to user
            if(albumList.findAlbumByTitle(title) < 0)       // If title doesn't exist in bookList
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
        Scanner input = new Scanner(System.in);     // Scanner input
        String searchOption;                        // Choose which type of search 
        String searchCriteria;                      // Type what to search
        
        // Choose between Artist search or Genre search
        if(albumList.getCount() > 0)                // If albumList is not empty
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
            if(checkDate(date, intDate)){
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

    // Display giftCard with search criteria Artist or Genre
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
    public void addMovie(){
        //new Movie object
        Movie movie = new Movie();
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
                
        //Display message for the object movie fields
        System.out.print("Title: ");
        //Search if title already exist in another object in the movies list
        movie.setTitle(input.nextLine());
        if(searchMovie(movie.getTitle()))
            System.out.println("Title already exists"); //Title must be unique in each movie
        else{
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
            //Ask for the Release Date until is a valid date
            while(true){
                System.out.print("Release Date: ");
                movie.setReleaseDate(input.nextLine());
                //Validate if releaseDate is in the format yyyy-mm-dd
                if(checkDate(movie.getReleaseDate()))   
                    break;
            }
            //Validate if duration is just a number without decimals
            while(true){
                try{
                    System.out.print("Duration: ");
                    movie.setDuration(input.nextInt());
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
                    movie.setPrice(input.nextDouble());
                    break;
                }catch(Exception e){
                    //Display error message
                    System.out.println("Only numbers allowed, try again");
                    input.next();
                }
            }
            //Add the object with all the inputs to the list movies
            movies.add(movie);
            //Display success message
            System.out.println("New Movie Added");
        }
        
        System.out.println("Please press [Enter] to continue");
        input.nextLine();
    }
    
    //Delete a movie from the list movies by searching the title 
    public void deleteMovie(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!movies.isEmpty()){
            int index = 0;  //Used for the loop to get object by object in the list
            String title;   //Search string input by user
            boolean found = false;  //Check if movie was found
            //Display message to ask title to the user they want to delete
            System.out.print("Which movie do you want to delete?\nEnter title: ");
            title = input.nextLine();   //User input title
            
            //Search for the title input by the user
            while(index < movies.size() && !found){
                //Compare the title with the movie ojbect title
                if(movies.get(index).getTitle().compareToIgnoreCase(title) == 0){
                    found = true;   //Title found in the list
                    movies.get(index).displayMovie();   //Display movie with the title
                    System.out.println("Are you sure? (y/n)");  //User decide to delete
                    //Delete if the user say "y"
                    if(input.nextLine().compareToIgnoreCase("y") == 0){
                        movies.remove(index);   //Remove movie from list
                        System.out.println("Movie Deleted");    //Display message success
                    }
                }
                index++;    //increase index for next object in list
            }
            if(!found)
                System.out.println("Movie not found"); //Display Movie not found in the list
        }
        else    //List has no object
            System.out.println("List of Movies is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();
    }
    
    //Delete a movie from the list movies by searching the title
    public void modifyMovie(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!movies.isEmpty()){
            int index = 0;  //Used for the loop to get object by object in the list
            String title;   //Search string input by user
            boolean found = false;  //Check if movie was found
            //Ask for the title of the movie to modify in the movies list
            System.out.print("Which movie you want to modify?\n Enter title: ");
            title = input.nextLine();
            //Search for the title until is found
            while(index < movies.size() && !found){
                if(movies.get(index).getTitle().compareToIgnoreCase(title) == 0){
                    found = true;
                    movies.get(index).displayMovie();   //Display found movie
                    System.out.println("Are you sure? (y/n)");  //Ask the user to confirm to modify found movie
                    //Ask again for the fields if the user say [y]es
                    if(input.nextLine().compareToIgnoreCase("y") == 0){
                        System.out.print("Director: ");
                        movies.get(index).setDirector(input.nextLine());
                        System.out.print("Genre: ");
                        movies.get(index).setGenre(input.nextLine());
                        System.out.print("Rating: ");
                        movies.get(index).setRating(input.nextLine());
                        System.out.print("Language: ");
                        movies.get(index).setLanguage(input.nextLine());
                        System.out.print("Type: ");
                        movies.get(index).setType(input.nextLine());
                        //Ask for the releaseDate until is a valid date
                        while(true){
                            System.out.print("Release Date: ");
                            movies.get(index).setReleaseDate(input.nextLine());
                            //Validate if releaseDate is in the format yyyy-mm-dd
                            if(checkDate(movies.get(index).getReleaseDate()))   
                                break;
                        }
                        //Validate if duration is just a number without decimals
                        while(true){
                            try{
                                System.out.print("Duration: ");
                                movies.get(index).setDuration(input.nextInt());
                                break;
                            }catch(Exception e){
                                //Display an error message
                                System.out.println("Only numbers without decimal allowed, try again");
                                input.next();
                            }
                        }
                        //Validate if price is just a number 
                        while(true){
                            try{
                                System.out.print("Price: ");
                                movies.get(index).setPrice(input.nextDouble());
                                break;
                            }catch(Exception e){
                                //Display an error message
                                System.out.println("Only numbers allowed, try again");
                                input.next();
                            }
                        }
                        //Reset input scanner
                        input.nextLine();
                        //Display success message
                        System.out.println("Movie Modified");
                    }
                }
                index++;
            }
            if(!found)
                System.out.println("Movie not found");  //Display Movie not in the list
        }
        else    //List has no object
            System.out.println("List of Movies is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();  
    }
    
    //Display a movie or all the objects from the list movies
    public void displayMovie(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!movies.isEmpty()){
            String title;
            boolean found = false;
            //Display message to ask display one movie with a title seach or all movies in the list movie
            System.out.println("Type title to search or press [Enter] for all movies");
            title = input.nextLine();
            //Check the user choosen option
            if(title.compareTo("") != 0){
                //Search title in object by object in the movie list
                for(Movie movie: movies){
                    //Compare user input title and the title in the current object
                    if(movie.getTitle().compareToIgnoreCase(title) == 0){
                        found = true;   //Movie found
                        movie.displayMovie();   //Display Movie found
                    }
                }
                if(!found)
                    System.out.println("Movie not found");  //Display Movie not in the list
            }
            else                    //Second option
                //Display all movie object in the list
                movies.forEach((movie) -> {
                    movie.displayMovie();
                });
        }
        else    //List has no object
            System.out.println("List of Movies is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();
    }
    
    //Search by title if it exist in the movies list 
    public boolean searchMovie(String title){
        return movies.stream().anyMatch((movie) 
                -> (movie.getTitle().compareToIgnoreCase(title) == 0));
    }
    
    //Create a new object VideoGame to add to the list videoGames with user inputs
    public void addVideoGame(){
        //new VideoGame object
        VideoGame videoGame = new VideoGame();
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
                
        //Display message for the object videoGame fields
        System.out.print("Title: ");
        //Search if name already exist in another object in the videoGames list
        videoGame.setTitle(input.nextLine());
        if(searchVideoGame(videoGame.getTitle()))
            System.out.println("Title already exists"); //Title must be unique in each Video Game
        else{
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
            while(true){
                System.out.print("Release Date: ");
                videoGame.setReleaseDate(input.nextLine());
                //Validate if releaseDate is in the format yyyy-mm-dd
                if(checkDate(videoGame.getReleaseDate()))   
                    break;
            }
            //Validate if price is just a number
            while(true){
                try{
                    System.out.print("Price: ");
                    videoGame.setPrice(input.nextDouble());
                    break;
                }catch(Exception e){
                    //Display error message
                    System.out.println("Only numbers allowed, try again");
                    input.next();
                }
            }
            //Add the object with all the inputs to the list videoGames
            videoGames.add(videoGame);
            //Display success message
            System.out.println("New Video Game Added");
        }
        
        System.out.println("Please press [Enter] to continue");
        input.nextLine();
    }
    
    //Delete a video game from the list videoGames by searching the name
    public void deleteVideoGame(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!videoGames.isEmpty()){
            int index = 0;  //Used for the loop to get object by object in the list
            String name;   //Search string input by user
            boolean found = false;  //Check if videoGame was found
            //Display message to ask name to the user they want to delete
            System.out.print("Which Video Game do you want to delete?\nEnter name: ");
            name = input.nextLine();   //User input name
            
            //Search for the name input by the user
            while(index < videoGames.size() && !found){
                //Compare the name with the videoGame object name
                if(videoGames.get(index).getTitle().compareToIgnoreCase(name) == 0){
                    found = true;   //Title found in the list
                    videoGames.get(index).displayVideoGame();   //Display videoGame with the name
                    System.out.println("Are you sure? (y/n)");  //User decide to delete
                    //Delete if the user say "y"
                    if(input.nextLine().compareToIgnoreCase("y") == 0){
                        videoGames.remove(index);   //Remove videoGame from list
                        System.out.println("Video Game Deleted");    //Display message success
                    }
                }
                index++;    //increase index for next object in list
            }
            if(!found)
                System.out.println("Video Game not found"); //Display VideoGame not found in the list
        }
        else    //List has no object
            System.out.println("List of Video Games is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();
    }
    
    //Modify a video game from the list videoGames by searching the name
    public void modifyVideoGame(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!videoGames.isEmpty()){
            int index = 0;  //Used for the loop to get object by object in the list
            String name;   //Search string input by user
            boolean found = false;  //Check if videoGame was found
            //Ask for the name of the videoGame to modify in the videoGames list
            System.out.print("Which Video Game you want to modify?\n Enter name: ");
            name = input.nextLine();
            //Search for the name until is found
            while(index < videoGames.size() && !found){
                if(videoGames.get(index).getTitle().compareToIgnoreCase(name) == 0){
                    found = true;
                    videoGames.get(index).displayVideoGame();   //Display found videoGame
                    System.out.println("Are you sure? (y/n)");  //Ask the user to confirm to modify found videoGame
                    //Ask again for the fields if the user say [y]es
                    if(input.nextLine().compareToIgnoreCase("y") == 0){
                        System.out.print("Genre: ");
                        videoGames.get(index).setGenre(input.nextLine());
                        System.out.print("Console: ");
                        videoGames.get(index).setConsole(input.nextLine());
                        System.out.print("Publisher: ");
                        videoGames.get(index).setPublisher(input.nextLine());
                        System.out.print("Developer: ");
                        videoGames.get(index).setDeveloper(input.nextLine());
                        System.out.print("Language: ");
                        videoGames.get(index).setLanguage(input.nextLine());
                        //Ask for the releaseDate until is a valid date
                        while(true){
                            System.out.print("Release Date: ");
                            videoGames.get(index).setReleaseDate(input.nextLine());
                            //Validate if releaseDate is in the format yyyy-mm-dd
                            if(checkDate(videoGames.get(index).getReleaseDate()))   
                                break;
                        }
                        //Validate if price is just a number
                        while(true){
                            try{
                                System.out.print("Price: ");
                                videoGames.get(index).setPrice(input.nextDouble());
                                break;
                            }catch(Exception e){
                                //Display error message
                                System.out.println("Only numbers allowed, try again");
                                input.next();
                            }
                        }
                        //Reset input scanner
                        input.nextLine();
                        //Display success message
                        System.out.println("Video Game Modified");
                    }
                }
                index++;
            }
            if(!found)
                System.out.println("Video Game not found");  //Display VideoGame not in the list
        }
        else    //List has no object
            System.out.println("List of Video Games is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();  
    }
    
    //Display a video game or all objects from the list videoGames
    public void displayVideoGame(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!videoGames.isEmpty()){
            String name;
            boolean found = false;
            //Display message to ask display one videoGame with a name seach or all videoGames in the list videoGame
            System.out.println("Type name to search or press [Enter] for all Video Games");
            name = input.nextLine();
            //Check the user choosen option
            if(name.compareTo("") != 0){
                //Search name in object by object in the videoGame list
                for(VideoGame videoGame: videoGames){
                    //Compare user input name and the name in the current object
                    if(videoGame.getTitle().compareToIgnoreCase(name) == 0){
                        found = true;   //VideoGame found
                        videoGame.displayVideoGame();   //Display VideoGame found
                    }
                }
                if(!found)
                    System.out.println("Video Game not found");  //Display VideoGame not in the list
            }
            else                    //Second option
                //Display all videoGame object in the list
                videoGames.forEach((videoGame) -> {
                    videoGame.displayVideoGame();
                });
        }
        else    //List has no object
            System.out.println("List of Video Games is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();
    }
    
    //Search by name if it exist in the videoGames list 
    public boolean searchVideoGame(String name){
        return videoGames.stream().anyMatch((videoGame) 
                -> (videoGame.getTitle().compareToIgnoreCase(name) == 0));
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
