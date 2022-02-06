
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class PyramidB extends GraphicsProgram
{
    private static int BRICK_HEIGHT = 12;
    private static int BRICK_WIDTH = 30;
    private static int GAP = 4;
    private static int NUM_ROWS = 10;
    private static int START_X = 50;
    private static int START_Y = 60;

    public void run()
    {
        for(int i=0; i<NUM_ROWS; i++){
            for(int j=0; j<i; j++){
                GRect brick = new GRect(j*(BRICK_WIDTH + GAP) + START_X, i*(BRICK_HEIGHT + GAP) + START_Y, BRICK_WIDTH, BRICK_HEIGHT);
                brick.setFilled(true);
                add(brick);
            }
        }
    }

}
