/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: GiftCard
 * Package: projectbookstore.store.products
 *
 */

//Current package
package projectbookstore.store.products;

public class GiftCard {
    //Attributes
    private String name, company, region;
    private int amount;
    private double price;

    //Methods
    
    //Constructor
    public GiftCard() {
        name = "";
        amount = 0;
        company = "";
        region = "";
        price = 0.0;
    }

    //Accesor for name
    public String getName() {
        return name;
    }

    //Mutator for name
    public void setName(String name) {
        this.name = name;
    }

    //Accesor for amount
    public int getAmount() {
        return amount;
    }

    //Mutator for amount
    public void setAmount(int amount) {
        this.amount = amount;
    }

    //Accesor for company
    public String getCompany() {
        return company;
    }

    //Mutator for company
    public void setCompany(String company) {
        this.company = company;
    }

    //Accesor for region
    public String getRegion() {
        return region;
    }

    //Mutator for region
    public void setRegion(String region) {
        this.region = region;
    }

    //Accesor for price
    public double getPrice() {
        return price;
    }

    //Mutator for price
    public void setPrice(double price) {
        this.price = price;
    }
    
    //Display all the fields of the object
    public void displayGiftCard(){
        System.out.println( "Name: " + name +
                            "\nAmount: " + amount +
                            "\nCompany: " + company +
                            "\nRegion: " + region +
                            "\nPrice: $" + price + "\n" );
    }
}
