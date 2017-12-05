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

public class GiftCardDB {
    // Attributes
    private final int CAPACITY;     // Max number of arrays
    private final GiftCard[] giftCards;   // GiftCard Array
    private int count;              // Current Array ocupied
   
    // Methods
    
    // Default Constructor set Capacity to 20
    public GiftCardDB(){
        this(20);
    }
    
    // Constructor with variable capacity    
    public GiftCardDB(int capacity){
        this.CAPACITY = capacity;
        this.giftCards = new GiftCard[CAPACITY];
        this.count = 0;
    }
    
    // Add GiftCard
    public boolean addGiftCard(GiftCard giftCard){
        boolean added = false;                  // Set added to false
        if(count < CAPACITY){                   // count can't be bigger than CAPACITY
            giftCards[count++] = giftCard;      // Add new giftCard and add one to count
            added = true;                       // Set added flag to true
        }
        return added;                           // Return if giftCard was added
    }
    
    // Find GiftCard By Name
    public int findGiftCardByName(String name){
        int index = -1;                     // Set index to -1
        for(int i = 0; i < count; i++){     // Look in current GiftCard in array giftCards
            if(giftCards[i].getName().compareToIgnoreCase(name) == 0) // If name found
                return i;                   // Return i where name was found
        }
        return index;                       // Return index if name wasn't found
    }
    
    // Display GiftCard By Company search criteria
    public boolean displayGiftCardByCompany(String artist){
        boolean displayed = false;                  // Set displayed to false
        if(count > 0){
            for(int i = 0; i < count; i++){         // Look in giftCards arrays
                if(giftCards[i].getCompany().compareToIgnoreCase(artist) == 0) { // If artist found print giftCard
                    giftCards[i].displayGiftCard(); // Display giftCard with company found
                    displayed = true;               // Set displayed to true
                }
            }
        }
        return displayed;                           // Return if giftCard was deleted
    }
    
    // Display GiftCard By Region search criteria
    public boolean displayGiftCardByRegion(String genre){
        boolean displayed = false;                  // Set displayed to false
        if(count > 0){
            for(int i = 0; i < count; i++){         // Look in giftCards arrays
                if(giftCards[i].getRegion().compareToIgnoreCase(genre) == 0) { // If genre found print giftCard
                    giftCards[i].displayGiftCard(); // Display giftCard with region found
                    displayed = true;               // Set displayed to true
                }
            }
        }
        return displayed;                           // Return if giftCard(s) were displayed
    }
    
    // Delete GiftCard searching by name
    public boolean deleteGiftCard(String name){
        boolean deleted = false;                    // Set deleted to false
        int index = findGiftCardByName(name);       // Look for name in giftCards
        if(index >= 0){                             // If name was found
            for(int i = index; i < count - 1; i++)  // From the found name
                giftCards[i] = giftCards[i+1];      // Move giftCard from next to current giftCard
            deleted = true;                         // Set deleted to true
            count--;                                // Decrease count by one
        }
        return deleted;                             // Return if giftCard was deleted
    }
    
    // Update GiftCard searching by name
    public boolean updateGiftCard(String name, GiftCard newGiftCard){
        boolean updated = false;                    // Set updated to false
        int index = findGiftCardByName(name);       // Look for name in giftCards
        if(index >= 0){                             // If name was found
            giftCards[index] = newGiftCard;         // change giftCard with new giftCard
            updated = true;                         // Set updated to true
        }
        return updated;                             // Return if giftCard was updated
    }
    
    // Display all the GiftCard objects
    public void displayGiftCardList(){
        for(int i = 0; i < count; i++)
            giftCards[i].displayGiftCard();
    }
    
    // Accesor for CAPACITY
    public int getCAPACITY() {
        return CAPACITY;
    }

    // Accesor for count
    public int getCount() {
        return count;
    }
}
