public class Product {
    private String productName, productDescription;
    private double price;

    public Product(String name, String description, double price){
        this.productName = name;
        this.productDescription = description;
        this.price = price;
    }

    public void displayDetails(){
        System.out.print(productName + " $" + price);
    }
}
