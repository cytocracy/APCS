
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import java.applet.AudioClip;
import acm.util.MediaTools;

public class AsteroidsGame extends GraphicsProgram
{
    private ArrayList<Asteroid> asteroids;
    private boolean playing;
    private GLabel notificationLabel, scoreLabel;
    // uncomment out the line below in version 0.4.1
    // private Ship ship;
    // uncomment out the line below in version 0.5.2
    // (and don't forget to write bullets = new ArrayList<Bullet>() in the init method!)
    // private ArrayList<Bullet> bullets; 
    private int level;
    private int ships;
    private int score;
    private AudioClip thrustClip, fireClip, bigBangClip, mediumBangClip, smallBangClip;

    public void init()
    {
        thrustClip = MediaTools.loadAudioClip("thrust.wav");   
        fireClip = MediaTools.loadAudioClip("fire.wav");   
        bigBangClip = MediaTools.loadAudioClip("bangLarge.wav");   
        mediumBangClip = MediaTools.loadAudioClip("bangMedium.wav");   
        smallBangClip = MediaTools.loadAudioClip("bangSmall.wav");   

        level = 0;
        ships = 3;
        score = 0;

        setBackground(Color.BLACK);

        notificationLabel = new GLabel("(up) = thrust, (left) = rotate left, (right) = rotate right, (space) = fire. Click mouse to continue");
        notificationLabel.setColor(Color.WHITE);
        notificationLabel.setFont("Courier-Plain-12");
        notificationLabel.setLocation((getWidth()-notificationLabel.getWidth())/2, getHeight()/2-40);
        add(notificationLabel);

        scoreLabel = new GLabel("Score:"+score);
        scoreLabel.setColor(Color.WHITE);
        scoreLabel.setFont("Courier-Plain-10");
        scoreLabel.setLocation(16, 16);
        add(scoreLabel);

        asteroids = new ArrayList<Asteroid>();
        makeAsteroids();

    }

    private void makeAsteroids()
    {
        // code for version 0.3.1 goes here
    }

    public void run()
    {

        while (true)
        {
            pause(10);
            // code for version 0.3 goes here
        } 
    }

    private Asteroid checkForCollisions(GVectorPolygon obj)
    {
        for (Asteroid a:asteroids)
            if (a.getBounds().intersects(obj.getBounds()))
            {
                return a;
            }
        return null;       
    }

}
