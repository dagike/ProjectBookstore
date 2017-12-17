/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: GiftCardDB
 * Package: projectbookstore.store.db 
 *
 */

// Current Package
package projectbookstore.store.db;

// GiftCard Class
import projectbookstore.store.products.GiftCard;

public class GiftCardDB extends ProductDB{
    // Methods
    
    // Default Constructor set Capacity to 20
    public GiftCardDB(){
        this(20);
    }
    
    // Constructor with variable capacity    
    public GiftCardDB(int capacity){
        super(capacity);
    }
    
    // Display GiftCard By Company search criteria
    public boolean displayGiftCardByCompany(String artist){
        boolean displayed = false;                  // Set displayed to false
        if(super.getCount() > 0){
            for(int i = 0; i < super.getCount(); i++){         // Look in giftCards arrays
                if(((GiftCard)super.getProductByIndex(i)).getCompany().compareToIgnoreCase(artist) == 0) { // If artist found print giftCard
                    System.out.println(((GiftCard)super.getProductByIndex(i))); // Display giftCard with company found
                    displayed = true;               // Set displayed to true
                }
            }
        }
        return displayed;                           // Return if giftCard was deleted
    }
    
    // Display GiftCard By Region search criteria
    public boolean displayGiftCardByRegion(String genre){
        boolean displayed = false;                  // Set displayed to false
        if(super.getCount() > 0){
            for(int i = 0; i < super.getCount(); i++){         // Look in giftCards arrays
                if(((GiftCard)super.getProductByIndex(i)).getRegion().compareToIgnoreCase(genre) == 0) { // If genre found print giftCard
                    System.out.println(((GiftCard)super.getProductByIndex(i))); // Display giftCard with region found
                    displayed = true;               // Set displayed to true
                }
            }
        }
        return displayed;                           // Return if giftCard(s) were displayed
    }
}
