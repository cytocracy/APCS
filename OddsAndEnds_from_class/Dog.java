

public class Dog
{
    private String name;
    private int idNumber;
    
    private static int nextAvailableID = 100;
    
    
    public Dog(String name)
    {
        this.name = name;
        idNumber = nextAvailableID;
        Dog.nextAvailableID++;
    }
    
    public String getName(){return name;}
    public int getID(){return idNumber;}
    
    public static boolean isHappyToSeeYou(){
        return true;
    }


}
