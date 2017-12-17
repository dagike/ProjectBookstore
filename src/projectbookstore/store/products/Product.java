
package projectbookstore.store.products;

public class Product {
    private double price;
    private String title;
    
    public Product(){
        price = 0.0;
        title = "";
    }
    
    // Accesor for price
    public double getPrice() {
        return price;
    }

    // Mutator for price
    public void setPrice(double price) {
        if(price >= 0)
            this.price = price;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
