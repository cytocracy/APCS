

public class Balloon
{
    private final double MAXVOLUME = 8000000;
    
    private double r;
    private boolean popped;
    
    public Balloon()
    {
        popped = false;
        r = 0;
    }
    
    public void addAir(double ccAdded){
        if(popped){
            return;
        }
        double volume = getVolume();
        volume += ccAdded;
        if(volume > MAXVOLUME){
            popped = true;
            r = 0;
            return;
        }
        r = Math.pow(3*volume / (4 * Math.PI), 1.0/3);
    }
    
    public boolean isPopped(){
        return popped;
    }
    
    public double getRadius(){
        return r;
    }
    
    public double getSurfaceArea(){
        return 4 * Math.PI * Math.pow(r, 2);
    }
    
    public double getVolume(){
        return 4.0/3  * Math.PI * Math.pow(r, 3);
    }


}
