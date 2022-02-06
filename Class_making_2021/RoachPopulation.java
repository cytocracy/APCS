

public class RoachPopulation
{
    int roaches;
    
    
    public RoachPopulation(int startRoaches)
    {
        roaches = startRoaches;
    }
    
    public void breed(){
        roaches = roaches *2;
    }
    
    public void spray(){
        roaches = (int) roaches/10;
    }
    
    public int getNumRoaches(){
        return roaches;
    }

}
