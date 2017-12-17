/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: GiftCard
 * Package: projectbookstore.store.products
 *
 */

//Current package
package projectbookstore.store.products;

public class GiftCard extends Product{
    //Attributes
    private String company, region;
    private int amount;

    //Methods
    
    //Constructor
    public GiftCard() {
        super();
        amount = 0;
        company = "";
        region = "";
    }

    //Accesor for amount
    public int getAmount() {
        return amount;
    }

    //Mutator for amount
    public void setAmount(int amount) {
        if(amount > 0)
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
    
    @Override
    // Override toString to format a Strirng with fields of the object
    public String toString(){
        return "Title: " + super.getTitle() +
              "\nAmount: " + amount +
              "\nCompany: " + company +
              "\nRegion: " + region +
              "\nPrice: $" + super.getPrice() + "\n";
    }
}
