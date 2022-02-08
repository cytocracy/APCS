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
        
        //could have done with booleans, but 1's and 0's are shorter lol
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
        
        //get bug to travel across entire grid, probably could have condensed this a little bit..
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
        
        
        
        //make bug blue when in correct positions for picture, white otherwise
        loc = getLocation();
        if(pictureValues[loc.getRow()][loc.getCol()] == 1)
            setColor(Color.blue);
        else
            setColor(Color.white);
        
        
    }
    
    //override move method
    public void move(){
        Grid<Actor> gr = getGrid();
        if (gr == null) return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if(gr.isValid(next)) moveTo(next);
        else removeSelfFromGrid();
        
        
        //only leave flowers where needed for picture
        if(pictureValues[loc.getRow()][loc.getCol()] == 1){
            Flower flower = new Flower(getColor());
            flower.putSelfInGrid(gr, loc);
        }
    }
       
    
}
