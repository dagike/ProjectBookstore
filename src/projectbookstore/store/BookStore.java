/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: BookStore
 * Package: projectbookstore.store 
 *
 */

//Current package
package projectbookstore.store;

//Import java libraries and other libraries
import projectbookstore.store.products.*;   //Product Classes
import java.util.List;  //List object
import java.util.ArrayList; //ArrayList object
import java.util.Scanner;   //Scanner object

public class BookStore {
    //Attributes
    private final List<Album> albums;
    private final List<Book> books;
    private final List<GameConsole> gameConsoles;
    private final List<GiftCard> giftCards;
    private final List<Movie> movies;
    private final List<VideoGame> videoGames;
    
    //Methods
    
    //Constructor
    public BookStore(){
        albums = new ArrayList();
        books = new ArrayList();
        gameConsoles = new ArrayList();
        giftCards = new ArrayList();
        movies = new ArrayList();
        videoGames = new ArrayList();
    }
    
    //Create a new object Album to add to the list albums with user inputs
    public void addAlbum(){
        //new Album object
        Album album = new Album();
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
                
        //Display message for the object album fields
        System.out.print("Title: ");
        //Search if title already exist in another object in the albums list
        album.setTitle(input.nextLine());
        if(searchAlbum(album.getTitle()))
            System.out.println("Title already exists"); //Title must be unique in each album
        else{
            //Ask for all the other fields
            System.out.print("Artist: ");
            album.setArtist(input.nextLine());
            System.out.print("Genre: ");
            album.setGenre(input.nextLine());
            System.out.print("Language: ");
            album.setLanguage(input.nextLine());
            //Ask for the Release Date until is a valid date
            while(true){
                System.out.print("Release Date: ");
                //album.setReleaseDate(input.nextLine());
                //Validate if releaseDate is in the format yyyy-mm-dd
                //if(checkDate(album.getReleaseDate()))   
                    break;
            }
            //Validate if duration is just a number without decimals
            while(true){
                try{
                    System.out.print("Duration: ");
                    album.setDuration(input.nextInt());
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
                    album.setPrice(input.nextDouble());
                    break;
                }catch(Exception e){
                    //Display error message
                    System.out.println("Only numbers allowed, try again");
                    input.next();
                }
            }
            //Add the object with all the inputs to the list albums
            albums.add(album);
            //Display success message
            System.out.println("New Album Added");
        }
        
        System.out.println("Please press [Enter] to continue");
        input.nextLine();
    }
    
    //Delete an album from the list albums by searching the title 
    public void deleteAlbum(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!albums.isEmpty()){
            int index = 0;  //Used for the loop to get object by object in the list
            String title;   //Search string input by user
            boolean found = false;  //Check if album was found
            //Display message to ask title to the user they want to delete
            System.out.print("Which album do you want to delete?\nEnter title: ");
            title = input.nextLine();   //User input title
            
            //Search for the title input by the user
            while(index < albums.size() && !found){
                //Compare the title with the album ojbect title
                if(albums.get(index).getTitle().compareToIgnoreCase(title) == 0){
                    found = true;   //Title found in the list
                    albums.get(index).displayAlbum();   //Display album with the title
                    System.out.println("Are you sure? (y/n)");  //User decide to delete
                    //Delete if the user say "y"
                    if(input.nextLine().compareToIgnoreCase("y") == 0){
                        albums.remove(index);   //Remove album from list
                        System.out.println("Album Deleted");    //Display message success
                    }
                }
                index++;    //increase index for next object in list
            }
            if(!found)
                System.out.println("Album not found"); //Display Album not found in the list
        }
        else    //List has no object
            System.out.println("List of Albums is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();
    }
    
    //Delete an album from the list albums by searching the title
    public void modifyAlbum(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!albums.isEmpty()){
            int index = 0;  //Used for the loop to get object by object in the list
            String title;   //Search string input by user
            boolean found = false;  //Check if album was found
            //Ask for the title of the album to modify in the albums list
            System.out.print("Which album you want to modify?\n Enter title: ");
            title = input.nextLine();
            //Search for the title until is found
            while(index < albums.size() && !found){
                if(albums.get(index).getTitle().compareToIgnoreCase(title) == 0){
                    found = true;
                    albums.get(index).displayAlbum();   //Display found album
                    System.out.println("Are you sure? (y/n)");  //Ask the user to confirm to modify found album
                    //Ask again for the fields if the user say [y]es
                    if(input.nextLine().compareToIgnoreCase("y") == 0){
                        System.out.print("Artist: ");
                        albums.get(index).setArtist(input.nextLine());
                        System.out.print("Genre: ");
                        albums.get(index).setGenre(input.nextLine());
                        System.out.print("Language: ");
                        albums.get(index).setLanguage(input.nextLine());
                        //Ask for the releaseDate until is a valid date
                        while(true){
                            System.out.print("Release Date: ");
                            albums.get(index).setReleaseDate(input.nextLine());
                            //Validate if releaseDate is in the format yyyy-mm-dd
                            if(checkDate(albums.get(index).getReleaseDate()))   
                                break;
                        }
                        //Validate if duration is just a number without decimals
                        while(true){
                            try{
                                System.out.print("Duration: ");
                                albums.get(index).setDuration(input.nextInt());
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
                                albums.get(index).setPrice(input.nextDouble());
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
                        System.out.println("Album Modified");
                    }
                }
                index++;
            }
            if(!found)
                System.out.println("Album not found");  //Display Album not in the list
        }
        else    //List has no object
            System.out.println("List of Albums is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();  
    }
    
    //Display an album or all the objects from the list albums
    public void displayAlbum(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!albums.isEmpty()){
            String title;
            boolean found = false;
            //Display message to ask display one album with a title seach or all albums in the list album
            System.out.println("Type title to search or press [Enter] for all albums");
            title = input.nextLine();
            //Check the user choosen option
            if(title.compareTo("") != 0){
                //Search title in object by object in the album list
                for(Album album: albums){
                    //Compare user input title and the title in the current object
                    if(album.getTitle().compareToIgnoreCase(title) == 0){
                        found = true;   //Album found
                        album.displayAlbum();   //Display Album found
                    }
                }
                if(!found)
                    System.out.println("Album not found");  //Display Album not in the list
            }
            else                    //Second option
                //Display all album object in the list
                albums.forEach((album) -> {
                    album.displayAlbum();
                });
        }
        else    //List has no object
            System.out.println("List of Albums is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();
    }
    
    //Search by title if it exist in the albums list 
    public boolean searchAlbum(String title){
        return albums.stream().anyMatch((album) 
                -> (album.getTitle().compareToIgnoreCase(title) == 0));
    }
    
    //Create a new object Book to add to the list books with user inputs
    public void addBook(){
        //new Book object
        Book book = new Book();
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
                
        //Display message for the object book fields
        System.out.print("Title: ");
        //Search if title already exist in another object in the books list
        book.setTitle(input.nextLine());
        if(searchBook(book.getTitle()))
            System.out.println("Title already exists"); //Title must be unique in each book
        else{
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
                    break;
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
                    break;
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
                    break;
                }catch(Exception e){
                    //Display error message
                    System.out.println("Only numbers allowed, try again");
                    input.next();
                }
            }
            //Add the object with all the inputs to the list books
            books.add(book);
            //Display success message
            System.out.println("New Book Added");
        }
        
        System.out.println("Please press [Enter] to continue");
        input.nextLine();
    }
    
    //Delete a book from the list books by searching the title 
    public void deleteBook(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!books.isEmpty()){
            int index = 0;  //Used for the loop to get object by object in the list
            String title;   //Search string input by user
            boolean found = false;  //Check if book was found
            //Display message to ask title to the user they want to delete
            System.out.print("Which book do you want to delete?\nEnter title: ");
            title = input.nextLine();   //User input title
            
            //Search for the title input by the user
            while(index < books.size() && !found){
                //Compare the title with the book object title
                if(books.get(index).getTitle().compareToIgnoreCase(title) == 0){
                    found = true;   //Title found in the list
                    books.get(index).displayBook();   //Display book with the title
                    System.out.println("Are you sure? (y/n)");  //User decide to delete
                    //Delete if the user say "y"
                    if(input.nextLine().compareToIgnoreCase("y") == 0){
                        books.remove(index);   //Remove book from list
                        System.out.println("Book Deleted");    //Display message success
                    }
                }
                index++;    //increase index for next object in list
            }
            if(!found)
                System.out.println("Book not found"); //Display Book not found in the list
        }
        else    //List has no object
            System.out.println("List of Books is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();
    }
    
    //Modify a book from the list books by searching the title
    public void modifyBook(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!books.isEmpty()){
            int index = 0;  //Used for the loop to get object by object in the list
            String title;   //Search string input by user
            boolean found = false;  //Check if book was found
            //Ask for the title of the book to modify in the books list
            System.out.print("Which book you want to modify?\n Enter title: ");
            title = input.nextLine();
            //Search for the title until is found
            while(index < books.size() && !found){
                if(books.get(index).getTitle().compareToIgnoreCase(title) == 0){
                    found = true;
                    books.get(index).displayBook();   //Display found book
                    System.out.println("Are you sure? (y/n)");  //Ask the user to confirm to modify found book
                    //Ask again for the fields if the user say [y]es
                    if(input.nextLine().compareToIgnoreCase("y") == 0){
                        System.out.print("Author: ");
                        books.get(index).setAuthor(input.nextLine());
                        System.out.print("Genre: ");
                        books.get(index).setGenre(input.nextLine());
                        System.out.print("Publisher: ");
                        books.get(index).setPublisher(input.nextLine());
                        System.out.print("Language: ");
                        books.get(index).setLanguage(input.nextLine());
                        System.out.print("ISBN: ");
                        books.get(index).setISBN(input.nextLine());
                        //Validate if Pages is just a number without decimals
                        while(true){
                            try{
                                System.out.print("Pages: ");
                                books.get(index).setPages(input.nextInt());
                                break;
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
                                books.get(index).setPublicationYear(input.nextInt());
                                break;
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
                                books.get(index).setPrice(input.nextDouble());
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
                        System.out.println("Book Modified");
                    }
                }
                index++;
            }
            if(!found)
                System.out.println("Book not found");  //Display Book not in the list
        }
        else    //List has no object
            System.out.println("List of Books is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();  
    }
    
    //Display a book or all the objects from the list books
    public void displayBook(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!books.isEmpty()){
            String title;
            boolean found = false;
            //Display message to ask display one book with a title seach or all books in the list book
            System.out.println("Type title to search or press [Enter] for all books");
            title = input.nextLine();
            //Check the user choosen option
            if(title.compareTo("") != 0){
                //Search title in object by object in the book list
                for(Book book: books){
                    //Compare user input title and the title in the current object
                    if(book.getTitle().compareToIgnoreCase(title) == 0){
                        found = true;   //Book found
                        book.displayBook();   //Display Book found
                    }
                }
                if(!found)
                    System.out.println("Book not found");  //Display Book not in the list
            }
            else                    //Second option
                //Display all book object in the list
                books.forEach((book) -> {
                    book.displayBook();
                });
        }
        else    //List has no object
            System.out.println("List of Books is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();
    }
    
    //Search by title if it exist in the books list 
    public boolean searchBook(String title){
        return books.stream().anyMatch((book) 
                -> (book.getTitle().compareToIgnoreCase(title) == 0));
    }
    
    //Create a new object GameConsole to add to the list gameConsoles with user inputs
    public void addGameConsole(){
        //new GameConsole object
        GameConsole gameConsole = new GameConsole();
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
                
        //Display message for the object gameConsole fields
        System.out.print("Name: ");
        //Search if name already exist in another object in the gameConsoles list
        gameConsole.setName(input.nextLine());
        if(searchGameConsole(gameConsole.getName()))
            System.out.println("Name already exists"); //Name must be unique in each Game Console
        else{
            //Ask for all the other fields
            System.out.print("Company: ");
            gameConsole.setCompany(input.nextLine());
            //Ask for the releaseDate until is a valid date
            while(true){
                System.out.print("Release Date: ");
                gameConsole.setReleaseDate(input.nextLine());
                //Validate if releaseDate is in the format yyyy-mm-dd
                if(checkDate(gameConsole.getReleaseDate()))   
                    break;
            }
            //Validate if memory is just a number without decimals
            while(true){
                try{
                    System.out.print("Memory: ");
                    gameConsole.setMemory(input.nextInt());
                    break;
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
                    break;
                }catch(Exception e){
                    //Display error message
                    System.out.println("Only numbers allowed, try again");
                    input.next();
                }
            }
            //Add the object with all the inputs to the list gameConsoles
            gameConsoles.add(gameConsole);
            //Display success message
            System.out.println("New Game Console Added");
        }
        
        System.out.println("Please press [Enter] to continue");
        input.nextLine();
    }
    
    //Delete a game console from the list gameConsoles by searching the title
    public void deleteGameConsole(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!gameConsoles.isEmpty()){
            int index = 0;  //Used for the loop to get object by object in the list
            String name;   //Search string input by user
            boolean found = false;  //Check if gameConsole was found
            //Display message to ask name to the user they want to delete
            System.out.print("Which Game Console do you want to delete?\nEnter name: ");
            name = input.nextLine();   //User input name
            
            //Search for the name input by the user
            while(index < gameConsoles.size() && !found){
                //Compare the name with the gameConsole object name
                if(gameConsoles.get(index).getName().compareToIgnoreCase(name) == 0){
                    found = true;   //Name found in the list
                    gameConsoles.get(index).displayGameConsole();   //Display gameConsole with the name
                    System.out.println("Are you sure? (y/n)");  //User decide to delete
                    //Delete if the user say "y"
                    if(input.nextLine().compareToIgnoreCase("y") == 0){
                        gameConsoles.remove(index);   //Remove gameConsole from list
                        System.out.println("Game Console Deleted");    //Display message success
                    }
                }
                index++;    //increase index for next object in list
            }
            if(!found)
                System.out.println("Game Console not found"); //Display GameConsole not found in the list
        }
        else    //List has no object
            System.out.println("List of Game Consoles is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();
    }
    
    //Modify a game console from the list gameConsoles by searching the title
    public void modifyGameConsole(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!gameConsoles.isEmpty()){
            int index = 0;  //Used for the loop to get object by object in the list
            String name;   //Search string input by user
            boolean found = false;  //Check if gameConsole was found
            //Ask for the name of the gameConsole to modify in the gameConsoles list
            System.out.print("Which Game Console you want to modify?\n Enter name: ");
            name = input.nextLine();
            //Search for the name until is found
            while(index < gameConsoles.size() && !found){
                if(gameConsoles.get(index).getName().compareToIgnoreCase(name) == 0){
                    found = true;
                    gameConsoles.get(index).displayGameConsole();   //Display found gameConsole
                    System.out.println("Are you sure? (y/n)");  //Ask the user to confirm to modify found gameConsole
                    //Ask again for the fields if the user say [y]es
                    if(input.nextLine().compareToIgnoreCase("y") == 0){
                        System.out.print("Company: ");
                        gameConsoles.get(index).setCompany(input.nextLine());
                        //Ask for the releaseDate until is a valid date
                        while(true){
                            System.out.print("Release Date: ");
                            gameConsoles.get(index).setReleaseDate(input.nextLine());
                            //Validate if releaseDate is in the format yyyy-mm-dd
                            if(checkDate(gameConsoles.get(index).getReleaseDate()))   
                                break;
                        }
                        //Validate if memory is just a number without decimals
                        while(true){
                            try{
                                System.out.print("Memory: ");
                                gameConsoles.get(index).setMemory(input.nextInt());
                                break;
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
                                gameConsoles.get(index).setWeight(input.nextDouble());
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
                                gameConsoles.get(index).setPrice(input.nextDouble());
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
                        System.out.println("Game Console Modified");
                    }
                }
                index++;
            }
            if(!found)
                System.out.println("Game Console not found");  //Display GameConsole not in the list
        }
        else    //List has no object
            System.out.println("List of Game Consoles is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();  
    }
    
    //Display a game console or all objects from the list gameConsoles
    public void displayGameConsole(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!gameConsoles.isEmpty()){
            String name;
            boolean found = false;
            //Display message to ask display one gameConsole with a name seach or all gameConsoles in the list gameConsole
            System.out.println("Type name to search or press [Enter] for all Game Consoles");
            name = input.nextLine();
            //Check the user choosen option
            if(name.compareTo("") != 0){
                //Search name in object by object in the gameConsole list
                for(GameConsole gameConsole: gameConsoles){
                    //Compare user input name and the name in the current object
                    if(gameConsole.getName().compareToIgnoreCase(name) == 0){
                        found = true;   //GameConsole found
                        gameConsole.displayGameConsole();   //Display GameConsole found
                    }
                }
                if(!found)
                    System.out.println("Game Console not found");  //Display GameConsole not in the list
            }
            else                    //Second option
                //Display all gameConsole object in the list
                gameConsoles.forEach((gameConsole) -> {
                    gameConsole.displayGameConsole();
                });
        }
        else    //List has no object
            System.out.println("List of Game Consoles is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();
    }
    
    //Search by name if it exist in the gameConsoles list 
    public boolean searchGameConsole(String name){
        return gameConsoles.stream().anyMatch((gameConsole) 
                -> (gameConsole.getName().compareToIgnoreCase(name) == 0));
    }
    
//Create a new object GiftCard to add to the list gifs with user inputs
    public void addGiftCard(){
        //new GiftCard object
        GiftCard giftCard = new GiftCard();
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
                
        //Display message for the object giftCard fields
        System.out.print("Name: ");
        //Search if name already exist in another object in the giftCards list
        giftCard.setName(input.nextLine());
        if(searchGiftCard(giftCard.getName()))
            System.out.println("Name already exists"); //Name must be unique in each giftCard
        else{
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
                    break;
                }catch(Exception e){
                    //Display error message
                    System.out.println("Only numbers allowed, try again");
                    input.next();
                }
            }
            //Add the object with all the inputs to the list giftCards
            giftCards.add(giftCard);
            //Display success message
            System.out.println("New Gift Card Added");
        }
        
        System.out.println("Please press [Enter] to continue");
        input.nextLine();
    }
    
    //Delete a gift card from the list giftCards by searching the name 
    public void deleteGiftCard(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!giftCards.isEmpty()){
            int index = 0;  //Used for the loop to get object by object in the list
            String name;   //Search string input by user
            boolean found = false;  //Check if giftCard was found
            //Display message to ask name to the user they want to delete
            System.out.print("Which giftCard do you want to delete?\nEnter name: ");
            name = input.nextLine();   //User input name
            
            //Search for the name input by the user
            while(index < giftCards.size() && !found){
                //Compare the name with the giftCard object name
                if(giftCards.get(index).getName().compareToIgnoreCase(name) == 0){
                    found = true;   //Name found in the list
                    giftCards.get(index).displayGiftCard();   //Display gift card with the name
                    System.out.println("Are you sure? (y/n)");  //User decide to delete
                    //Delete if the user say "y"
                    if(input.nextLine().compareToIgnoreCase("y") == 0){
                        giftCards.remove(index);   //Remove gift card from list
                        System.out.println("Gift Card Deleted");    //Display message success
                    }
                }
                index++;    //increase index for next object in list
            }
            if(!found)
                System.out.println("Gift Card not found"); //Display Gift Card not found in the list
        }
        else    //List has no object
            System.out.println("List of GiftCards is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();
    }
    
    //Delete a gift card from the list giftCards by searching the name
    public void modifyGiftCard(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!giftCards.isEmpty()){
            int index = 0;  //Used for the loop to get object by object in the list
            String name;   //Search string input by user
            boolean found = false;  //Check if giftCard was found
            //Ask for the name of the giftCard to modify in the giftCards list
            System.out.print("Which giftCard you want to modify?\n Enter name: ");
            name = input.nextLine();
            //Search for the name until is found
            while(index < giftCards.size() && !found){
                if(giftCards.get(index).getName().compareToIgnoreCase(name) == 0){
                    found = true;
                    giftCards.get(index).displayGiftCard();   //Display found gift card
                    System.out.println("Are you sure? (y/n)");  //Ask the user to confirm to modify found gift card
                    //Ask again for the fields if the user say [y]es
                    if(input.nextLine().compareToIgnoreCase("y") == 0){
                        System.out.print("Company: ");
                        giftCards.get(index).setCompany(input.nextLine());
                        System.out.print("Region: ");
                        giftCards.get(index).setRegion(input.nextLine());
                        //Validate if amount is just a number without decimals
                        while(true){
                            try{
                                System.out.print("Amount: ");
                                giftCards.get(index).setAmount(input.nextInt());
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
                                giftCards.get(index).setPrice(input.nextDouble());
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
                        System.out.println("Gift Card Modified");
                    }
                }
                index++;
            }
            if(!found)
                System.out.println("Gift Card not found");  //Display GiftCard not in the list
        }
        else    //List has no object
            System.out.println("List of Gift Cards is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();  
    }
    
    //Display a gift card or all the objects from the list giftCards
    public void displayGiftCard(){
        //Scanner object for user input
        Scanner input = new Scanner(System.in);
        //Check if the list not empty
        if(!giftCards.isEmpty()){
            String name;
            boolean found = false;
            //Display message to ask display one giftCard with a name seach or all giftCards in the list giftCard
            System.out.println("Type name to search or press [Enter] for all gift cards");
            name = input.nextLine();
            //Check the user choosen option
            if(name.compareTo("") != 0){
                //Search name in object by object in the giftCard list
                for(GiftCard giftCard: giftCards){
                    //Compare user input name and the name in the current object
                    if(giftCard.getName().compareToIgnoreCase(name) == 0){
                        found = true;   //GiftCard found
                        giftCard.displayGiftCard();   //Display GiftCard found
                    }
                }
                if(!found)
                    System.out.println("Gift Card not found");  //Display GiftCard not in the list
            }
            else                    //Second option
                //Display all giftCard object in the list
                giftCards.forEach((giftCard) -> {
                    giftCard.displayGiftCard();
                });
        }
        else    //List has no object
            System.out.println("List of Gift Cards is empty");  
        //Display message Enter to continue
        System.out.println("Please press [Enter] to continue");
        //Wait for the user to read all the messages before this
        input.nextLine();
    }
    
    //Search by name if it exist in the giftCards list 
    public boolean searchGiftCard(String name){
        return giftCards.stream().anyMatch((giftCard) 
                -> (giftCard.getName().compareToIgnoreCase(name) == 0));
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
    
    //Check if the date is a valid format yyyy-mm-dd
    public boolean checkDate(String date){
        if(date.length() != 10){
            //Display error message string date has to have 10 characters
            System.out.println("Must be 10 characters");
            return false;
        //Check for format and check for months with 29, 30 or 31 days
        }else if(!date.matches("\\d{4}-"
                + "(((01|03|05|07|08|10|12)-(0[1-9]|1[0-9]|2[0-9]|3[0-1]))|"  //Months with up to 31 days
                + "((04|06|09|11)-(0[1-9]|1[0-9]|2[0-9]|30))|"   //Months Valid only up to 30 days
                + "((02)-(0[1-9]|1[0-9]|2[0-9])))" + "$")){      //February up to 29 days
            //Display error message invalid format or wrong number of days
            System.out.println("Check format yyyy-mm-dd and valid month-day number");
            return false;
        }else
            return true;
    }
}
