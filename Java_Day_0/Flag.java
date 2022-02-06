//Theo Parker

import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Flag extends GraphicsProgram
{

    public void run()
    {
        createBlueSquares();
        createWhiteGaps();
        createRedStripes();
        createRedCross();
        createOutline();
        addLabel();
    }
    public void createOutline(){
        GRect outline = new GRect(25, 25, 200, 100);
        add(outline);
    }
    public void createBlueSquares(){
        GRect topLeftSquare = new GRect(25, 25, 75, 33);
        GRect topRightSquare = new GRect(150, 25, 75, 33);
        GRect bottomLeftSquare = new GRect(25, 92, 75, 33);
        GRect bottomRightSquare = new GRect(150, 92, 75, 33);
        
        topLeftSquare.setColor(Color.blue);
        topRightSquare.setColor(Color.blue);
        bottomRightSquare.setColor(Color.blue);
        bottomLeftSquare.setColor(Color.blue);
        
        topLeftSquare.setFilled(true);
        topRightSquare.setFilled(true);
        bottomLeftSquare.setFilled(true);
        bottomRightSquare.setFilled(true);
        
        
        add(bottomRightSquare);
        add(bottomLeftSquare);
        add(topLeftSquare);
        add(topRightSquare);
    }
    public void createWhiteGaps(){
        GPolygon topLeftGap = new GPolygon(20, 20);
        GPolygon topRightGap = new GPolygon (225, 20);
        GPolygon bottomLeftGap = new GPolygon(20, 130);
        GPolygon bottomRightGap = new GPolygon (225, 130);
        
        
        topLeftGap.addEdge(100, 0);
        topLeftGap.addEdge(0, 17);
        topLeftGap.addEdge(-100, 0);
        topLeftGap.addEdge(0, -17);
        
        topRightGap.addEdge(-100, 0);
        topRightGap.addEdge(0, 17);
        topRightGap.addEdge(100, 0);
        topRightGap.addEdge(0, -17);
        
        bottomLeftGap.addEdge(100, 0);
        bottomLeftGap.addEdge(0, -17);
        bottomLeftGap.addEdge(-100, 0);
        bottomLeftGap.addEdge(0, 17);
        
        bottomRightGap.addEdge(-100, 0);
        bottomRightGap.addEdge(0, -17);
        bottomRightGap.addEdge(100, 0);
        bottomRightGap.addEdge(0, 17);
        
        topLeftGap.setFilled(true);
        topLeftGap.setColor(Color.white);
        
        topRightGap.setFilled(true);
        topRightGap.setColor(Color.white);
        
        bottomLeftGap.setFilled(true);
        bottomLeftGap.setColor(Color.white);
        
        bottomRightGap.setFilled(true);
        bottomRightGap.setColor(Color.white);
        
        topRightGap.rotate(20);
        topLeftGap.rotate(-20);
        bottomLeftGap.rotate(20);
        bottomRightGap.rotate(-20);
        
        
        add(topRightGap);
        add(topLeftGap);
        add(bottomLeftGap);
        add(bottomRightGap);
    }
    public void createRedCross(){
        GRect verticalStripe = new GRect(110, 25, 30, 100);
        GRect horizontalStripe = new GRect(25, 65, 200, 20);
        
        verticalStripe.setFilled(true);
        verticalStripe.setColor(Color.red);
        
        horizontalStripe.setFilled(true);
        horizontalStripe.setColor(Color.red);
        
        add(horizontalStripe);
        add(verticalStripe);
    }
    public void createRedStripes(){
        GPolygon topLeftStripe = new GPolygon(25, 25);
        GPolygon topRightStripe = new GPolygon(225, 25);
        GPolygon bottomLeftStripe = new GPolygon(25, 125);
        GPolygon bottomRightStripe = new GPolygon (225, 125);
        
        topLeftStripe.addVertex(0,0);
        topLeftStripe.addVertex(2, 0);
        topLeftStripe.addVertex(75, 29);
        topLeftStripe.addVertex(75, 33);
        topLeftStripe.addVertex(65, 33);
        topLeftStripe.addVertex(0, 9);
        
        topRightStripe.addVertex(0,0);
        topRightStripe.addVertex(-2, 0);
        topRightStripe.addVertex(-75, 29);
        topRightStripe.addVertex(-75, 33);
        topRightStripe.addVertex(-65, 33);
        topRightStripe.addVertex(0, 9);
        
        bottomLeftStripe.addVertex(0,0);
        bottomLeftStripe.addVertex(2, 0);
        bottomLeftStripe.addVertex(75, -29);
        bottomLeftStripe.addVertex(75, -33);
        bottomLeftStripe.addVertex(65, -33);
        bottomLeftStripe.addVertex(0, -9);
        
        bottomRightStripe.addVertex(0,0);
        bottomRightStripe.addVertex(-2, 0);
        bottomRightStripe.addVertex(-75, -29);
        bottomRightStripe.addVertex(-75, -33);
        bottomRightStripe.addVertex(-65, -33);
        bottomRightStripe.addVertex(0, -9);
        
        topLeftStripe.setFilled(true);
        topLeftStripe.setColor(Color.red);
        
        topRightStripe.setFilled(true);
        topRightStripe.setColor(Color.red);
        
        bottomLeftStripe.setFilled(true);
        bottomLeftStripe.setColor(Color.red);
        
        bottomRightStripe.setFilled(true);
        bottomRightStripe.setColor(Color.red);
        
        add(topLeftStripe);
        add(topRightStripe);
        add(bottomLeftStripe);
        add(bottomRightStripe);
    }
    public void addLabel(){
        GLabel label = new GLabel("The Union Flag.", 45, 150);
        label.setFont("TimesNewRoman-Bold-24");
        add(label);
    }
}