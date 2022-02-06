

public class WaterPuzzle
{
    private int jugA;
    private int jugB;
    
    
    
    public WaterPuzzle()
    {
        jugA = 0;
        jugB = 0;
    }
    
    public void fill(String whichJug){
        if(whichJug.equals("A")){
            jugA = 5;
        } else {
            jugB = 3;
        }
    }
    
    public void empty(String whichJug){
        if(whichJug.equals("A")){
            jugA = 0;
        } else {
            jugB = 0;
        }
    }
    
    public void pourFromAToB(){
        int spaceInB = 3-jugB;
        if(jugA< spaceInB){
            jugB = jugB+ jugA;
            jugA = 0;
        } else {
            jugA = jugA-spaceInB;
            jugB = 3;
        }
        
    }
    
    public void pourFromBToA(){
        int spaceInA = 5-jugA;
        if(jugB< spaceInA){
            jugA = jugA+ jugB;
            jugB = 0;
        } else {
            jugB = jugB-spaceInA;
            jugA = 5;
        }
    }
    
    public int getAmount(String whichJug){
        if(whichJug.equals("A")){
            return jugA;
        } else {
            return jugB;
        }
    }


}
