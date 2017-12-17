/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: ProductDB
 * Package: projectbookstore.store.db 
 *
 */

// Current Package
package projectbookstore.store.db;

// Product Class
import projectbookstore.store.products.Product;

public class ProductDB {
    // Attributes
    private final int CAPACITY;         // Max number of arrays
    private final Product[] products;   // Product Array
    private int count;                  // Current Array ocupied
   
    // Methods
    
    // Default Constructor set Capacity to 20
    public ProductDB(){
        this(20);
    }
    
    // Constructor with variable capacity    
    public ProductDB(int capacity){
        this.CAPACITY = capacity;
        this.products = new Product[CAPACITY];
        this.count = 0;
    }
    
    // Add Product
    public boolean addProduct(Product product){
        boolean added = false;              // Set added to false
        if(count < CAPACITY){               // count can't be bigger than CAPACITY
            products[count++] = product;    // Add new product and add one to count
            added = true;                   // Set added flag to true
        }
        return added;                       // Return if product was added
    }
    
    // Find Product By Title
    public int findProductByTitle(String title){
        int index = -1;                     // Set index to -1
        for(int i = 0; i < count; i++){     // Look in current Product in array products
            if(products[i].getTitle().compareToIgnoreCase(title) == 0) // If title found
                return i;                   // Return i where title was found
        }
        return index;                       // Return index if title wasn't found
    }
    
    // Delete Product searching by title
    public boolean deleteProduct(String title){
        boolean deleted = false;                // Set deleted to false
        int index = findProductByTitle(title);  // Look for title in products
        if(index >= 0){                         // If title was found
            for(int i = index; i < count - 1; i++)  // From the found title
                products[i] = products[i+1];        // Move product from next to current product
            deleted = true;                     // Set deleted to true
            count--;                            // Decrease count by one
        }
        return deleted;                         // Return if product was deleted
    }
    
    // Update Product searching by title
    public boolean updateProduct(String title, Product newProduct){
        boolean updated = false;                // Set updated to false
        int index = findProductByTitle(title);  // Look for title in products
        if(index >= 0){                         // If title was found
            products[index] = newProduct;       // change product with new product
            updated = true;                     // Set updated to true
        }
        return updated;                         // Return if product was updated
    }
    
    public Product getProductByIndex(int index){
        return products[index];
    }
    
    // Display all the Product objects
    public void displayProductList(){
        for(int i = 0; i < count; i++)
            System.out.println(products[i]);
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
