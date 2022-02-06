import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.Color;

public class PictureBug extends Bug
{

    int[][] pictureValues;
    public PictureBug()
    {
        super();
        
        pictureValues = new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    public void act(){
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        
        if(loc.getRow() == 0){
            
            if(loc.getCol() == 0){
                setDirection(180);
                move();
            } else if(loc.getCol() == gr.getNumCols()-1){
                setDirection(270);
                move();
            } else if (getDirection() == 270){
                move();
            } else{
                setDirection(90);
                move();
                setDirection(180);
                move();
            }
        }
        
        else if(loc.getRow() == gr.getNumRows()-1){
            
            if(loc.getCol() == gr.getNumCols() -1){
                setDirection(0);
                move();
            } else if(getDirection() == 180){
                setDirection(90);
                move();
                setDirection(0);
                move();
            } else {
                move();
            }
        }else move();
        
        loc = getLocation();
        if(pictureValues[loc.getRow()][loc.getCol()] == 1)
            setColor(Color.blue);
        else
            setColor(Color.white);
        
        
    }
}
