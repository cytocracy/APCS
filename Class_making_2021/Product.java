

public class Product
{
    private String name;
    private double price;
    
    public Product(String givenName, double startPrice)
    {
        name = givenName;
        price = startPrice;
    }
    
    public void reducePrice(double reduction){
        price -= reduction;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }


}
