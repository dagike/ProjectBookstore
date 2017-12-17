/*
 * Project: Book Store Management 
 * Course: Java Programming 1 ITC-5102-0NA
 * Class: GameConsole
 * Package: projectbookstore.store.products
 *
 */

//Current package
package projectbookstore.store.products;

// Calendar and GregorianCalendar for dates in the class
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class GameConsole extends Product{
    //Attributes
    private String company; 
    private Calendar releaseDate;
    private int memory;
    private double weight;
    // Formatter for dates
    private final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

    //Methods
    
    //Constructor
    public GameConsole() {
        super();
        company = "";
        releaseDate = new GregorianCalendar(1900, 0, 1); // Set Date to 1900-01-01
        memory = 0;
        weight = 0.0;
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
    public Calendar getReleaseDate() {
        return releaseDate;
    }

    //Mutator for releaseDate
    public void setReleaseDate(Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    // Mutator for releaseDate with 3 int
    public void setReleaseDate(int year, int month, int day) {
        if(year > 0 && month >= 0 && month <= 11 && day > 0 && day <= 31)
            this.releaseDate.set(year, month-1, day);       // Month - 1 Calendar object 0 first month
    }

    //Accesor for memory
    public int getMemory() {
        return memory;
    }

    //Mutator for memory
    public void setMemory(int memory) {
        if(memory > 0)
            this.memory = memory;
    }

    //Accesor for weight
    public double getWeight() {
        return weight;
    }

    //Mutator for weight
    public void setWeight(double weight) {
        if(weight > 0)
            this.weight = weight;
    }
    
    @Override
    // Override toString to format a Strirng with fields of the object
    public String toString(){
        return "Title: " + super.getTitle() +
               "\nCompany: " + company +
               "\nRelease Date: " + 
               date.format(releaseDate.getTime()) +    // Using date formatter to display as yyyy-MM-dd
               "\nMemory: " + memory +
               " Gb\nWeight: " + weight +
               " Kg.\nPrice: $" + super.getPrice() + "\n";
    }
}
