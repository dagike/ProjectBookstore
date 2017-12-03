/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: main
 * Package: projectbookstore 
 *
 */

//Current package
package projectbookstore;

import projectbookstore.store.Menu;
import java.util.Scanner;   //Scanner import
import java.io.*;

public class ProjectBookstore {
    public static void main(String[] args) {
        //Object Menu
        Menu menu = new Menu();
        //Object Scanner for inputs
        Scanner input = new Scanner(System.in);
        
        do{
            //Display available categories
            menu.displayCategories();
            //Validate and save category typed
            menu.category(input.nextLine());
            //if its not -1 error or 7 Exit
            if(menu.getCategory() != -1 && menu.getCategory() != 7)    
                do{
                    //Display current selected category
                    menu.displayCategory();
                    //Display available options
                    menu.displayOptions();
                    //Validate and save option typed
                    menu.option(input.nextLine());
                //While Menu Option is not an error or is not option Back
                }while(menu.getOption() == -1 || menu.getOption() < 5);
        //While Menu Option is not an error or is not option Exit
        }while(menu.getCategory() == -1 || menu.getCategory() < 7);       
    }
}
