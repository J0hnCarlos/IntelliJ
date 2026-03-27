import java.util.Scanner;

/*
1. App name: AllShop

2. Things that will be needed: item array, variable to call method from another class

3. Class identified: Product class.
   Every items that will be listed must have a name, description, price that comes from Product class

4. AllShop class;
    private Product[] items;
    private String name, description;
    private double price;
    private int index; --> For items array
    private boolean programRunning = true;
    private Scanner scanner;

   Product class:
    private String productName, productDescription;
    private double price;

5. Things that are mandatory to create objects in items:
   AllShop class
   name, price

   Constructor:
   public AllShop(){
        System.out.println("What is the product name?");
        this.name = scanner.nextLine();
        System.out.println("What is the price of " + name + "?");
        this.price = scanner.nextDouble();
        System.out.println("What is its description? (Can be blank)");
        this.description = scanner.nextLine();
        if (description == null || description == ""){
            description = "";
        }
    }

   Product class
   name, price

   Constructor:
   public Product(String name, String description, double price){
        this.productName = name;
        this.productDescription = description;
        this.price = price;
    }

6. Important methods:
   Search method, displayAll method, delete
 */
public class AllShop {
    private Product[] items;
    private String name, description;
    private double price;
    private int index; // For items array
    private boolean programRunning = true;
    private Scanner scanner;

    public AllShop(){
        System.out.println("What is the product name?");
        this.name = scanner.nextLine();
        System.out.println("What is the price of " + name + "?");
        this.price = scanner.nextDouble();
        System.out.println("What is its description? (Can be blank)");
        this.description = scanner.nextLine();
        if (description == null || description == ""){
            description = "";
        }
    }

    public static void main(String[] args){

    }
}
