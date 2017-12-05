/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: Menu
 * Package: projectbookstore.store 
 *
 */

// Current package
package projectbookstore.store;

public class Menu {
    // Attributes 
    private int category, option;
    private final BookStore bookStore;
    
    // Methods
    
    // Constructor
    public Menu(){
        this.category = 0;
        this.option = 0;
        this.bookStore = new BookStore();
    }
    
    // Display all the categories available
    public void displayCategories(){
        System.out.println("*********Categories**********");
        System.out.println("*                           *");    
        System.out.println("*	1. Albums           *");    
        System.out.println("*	2. Books            *");    
        System.out.println("*	3. Game Consoles    *");    
        System.out.println("*	4. Gift Cards       *");    
        System.out.println("*	5. Movies           *");    
        System.out.println("*	6. Video Games      *");    
        System.out.println("*	7. Exit             *");    
        System.out.println("*                           *");    
        System.out.println("*****************************");
    }
    
    // Display all the options available after choosing the category
    public void displayOptions(){
        System.out.println("***********Options***********");
        System.out.println("*                           *");    
        System.out.println("*	1. Add              *");    
        System.out.println("*	2. Delete           *");    
        System.out.println("*	3. Modify           *");    
        System.out.println("*	4. Display          *");    
        System.out.println("*	5. Search           *");    
        System.out.println("*	6. Back             *");    
        System.out.println("*                           *");    
        System.out.println("*****************************");
    }
    
    // Parameters type String name category, validates which category and 
    // saves it in the attribute category
    public void category(String category){
        switch(category){
            case "1":this.category = 1;     // Albums category
                     break;
            case "2":this.category = 2;     // Books category
                     break;
            case "3":this.category = 3;     // Game Consoles category
                     break;
            case "4":this.category = 4;     // Gift Cards category
                     break;
            case "5":this.category = 5;     // Movies category
                     break;
            case "6":this.category = 6;     // Video Games category
                     break;
                    // Exit display end message
            case "7":System.out.println(" -----------------------------");
                     System.out.println("|                             |");
                     System.out.println("|          GoodBye!!          |");
                     System.out.println("|                             |");
                     System.out.println(" -----------------------------");
                     this.category = 7;
                     break;
                    // Error message if its not if the category is not available
            default: System.out.println("Category not available, please try again");
                     this.category = -1;
        }
    }
    
    // Parameters type String name option, validates which option and 
    // saves it in the attribute option
    public void option(String option){
        switch(option){
                    // Insert option
            case "1":System.out.println("***********Add***************");
                    this.option = 1;
                    // Add a product according to the current category
                    switch(category){
                        case 1:bookStore.addAlbum();       // Add Album
                                break;
                        case 2:bookStore.addBook();        // Add Book
                                break;
                        case 3:bookStore.addGameConsole(); // Add Game Console
                                break;
                        case 4:bookStore.addGiftCard();    // Add Gift Card
                                break;
                        case 5:bookStore.addMovie();       // Add Movie
                                break;
                        case 6:bookStore.addVideoGame();   // Add Video Game
                    }
                    break;
                    // Delete option
            case "2":System.out.println("***********Delete************");
                    this.option = 2;
                    // Delete a product according to the current category
                    switch(category){
                        case 1:bookStore.deleteAlbum();         // Delete Album
                                break;
                        case 2:bookStore.deleteBook();          // Delete Book
                                break;
                        case 3:bookStore.deleteGameConsole();   // Delete Game Console
                                break;
                        case 4:bookStore.deleteGiftCard();      // Delete Gift Card
                                break;
                        case 5:bookStore.deleteMovie();         // Delete Movie
                                break;
                        case 6:bookStore.deleteVideoGame();     // Delete Video Game
                     }
                     break;
            case "3":System.out.println("***********Modify************");
                    this.option = 3;
                    // Modify a product according to the current category
                    switch(category){
                        case 1:bookStore.modifyAlbum();         // Modify Album
                                break;
                        case 2:bookStore.modifyBook();          // Modify Book
                                break;
                        case 3:bookStore.modifyGameConsole();   // Modify Game Console
                                break;
                        case 4:bookStore.modifyGiftCard();      // Modify Gift Card
                                break;
                        case 5:bookStore.modifyMovie();         // Modify Movie
                                break;
                        case 6:bookStore.modifyVideoGame();     // Modify Video Game
                     }
                     break;
                     // Display option
            case "4":System.out.println("***********Display***********");
                    this.option = 4;
                    // Display a product according to the current category
                    switch(category){
                        case 1:System.out.println("Albums");
                                bookStore.displayAlbum();           // Display Album
                                break;
                        case 2:System.out.println("Books");
                                bookStore.displayBook();            // Display Book
                                break;
                        case 3:System.out.println("Game Consoles");
                                bookStore.displayGameConsole();     // Display Game Console
                                break;
                        case 4:System.out.println("Gift Cards");
                                bookStore.displayGiftCard();        // Display Gift Card
                                break;
                        case 5:System.out.println("Movies");
                                bookStore.displayMovie();           // Display Movie
                                break;
                        case 6:System.out.println("Video Games");
                                bookStore.displayVideoGame();       // Display Video Game
                    }
                    break;
            case "5":System.out.println("***********Search************");
                    this.option = 5;
                    // Display a product according to the current category
                    switch(category){
                        case 1:System.out.println("Albums");
                                bookStore.searchAlbum();            // Search Album
                                break;
                        case 2:System.out.println("Books");
                                bookStore.searchBook();             // Search Book
                                break;
                        case 3:System.out.println("Game Consoles");
                                bookStore.searchGameConsole();      // Search Game Console
                                break;
                        case 4:System.out.println("Gift Cards");
                                bookStore.searchGiftCard();         // Search Gift Card
                                break;
                        case 5:System.out.println("Movies");
                                bookStore.searchMovie();            // Search Movie
                                break;
                        case 6:System.out.println("Video Games");
                                bookStore.searchVideoGame();        // Search Video Game
                    }
                    break;
                    // Exit the option menu back to category menu no action made
            case "6":this.option = 6;
                     break;
                     // Error message if its not if the category is not available
            default: System.out.println("Option not available, please try again");
                     this.option = -1;
        }
    }
    
    // Diplay current selected category top of the option menu
    public void displayCategory(){
        switch(category){
                   // Albums category
            case 1:System.out.println("***********Albums************");
                   break;
                   // Books category
            case 2:System.out.println("***********Books*************");
                   break;
                   // Game Consoles category
            case 3:System.out.println("*******Game Consoles*********");
                   break;
                   // Gift Cards category
            case 4:System.out.println("*********Gift Cards**********");
                   break;
                   // Movies category
            case 5:System.out.println("***********Movies************");
                   break;
                   // Video Gamescategory
            case 6:System.out.println("*********Video Games*********");
                     break;
        }
    }
    
    // Accessor for category
    public int getCategory() {
        return category;
    }
    
    // Mutator for category
    public void setCategory(int category) {
        this.category = category;
    }

    // Accessor for option
    public int getOption() {
        return option;
    }

    // Mutator for option
    public void setOption(int option) {
        this.option = option;
    }
}
