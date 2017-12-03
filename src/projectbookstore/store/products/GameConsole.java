/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: GameConsole
 * Package: projectbookstore.store.products
 *
 */

//Current package
package projectbookstore.store.products;

public class GameConsole {
    //Attributes
    private String name, company, releaseDate;
    private int memory;
    private double weight, price;

    //Methods
    
    //Constructor
    public GameConsole() {
        name = "";
        company = "";
        releaseDate = "";
        memory = 0;
        weight = 0.0;
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

    //Accesor for company
    public String getCompany() {
        return company;
    }

    //Mutator for company
    public void setCompany(String company) {
        this.company = company;
    }

    //Accesor for releaseDate
    public String getReleaseDate() {
        return releaseDate;
    }

    //Mutator for releaseDate
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    //Accesor for memory
    public int getMemory() {
        return memory;
    }

    //Mutator for memory
    public void setMemory(int memory) {
        this.memory = memory;
    }

    //Accesor for weight
    public double getWeight() {
        return weight;
    }

    //Mutator for weight
    public void setWeight(double weight) {
        this.weight = weight;
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
    public void displayGameConsole(){
        System.out.println( "Name: " + name +
                            "\nCompany: " + company +
                            "\nRelease Date: " + releaseDate +
                            "\nMemory: " + memory +
                            " Gb\nWeight: " + weight +
                            " Kg.\nPrice: $" + price + "\n" );
    }
}
