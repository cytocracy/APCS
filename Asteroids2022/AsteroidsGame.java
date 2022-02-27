
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
    private Ship ship;
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
        ship = new Ship(getWidth(), getHeight());
        
        ship.setLocation(getWidth()/2 - ship.getBounds().getWidth()/2, getHeight()/2 - ship.getBounds().getHeight()/2);
        add(ship);

    }

    private void makeAsteroids()
    {
        for(int i=0; i<3+level; i++){
            //System.out.println("Width: " + getWidth());
            
            //System.out.println("Height: " + getHeight());
            Asteroid a = new Asteroid(getWidth(), getHeight());
            double x = Math.random() < 0.5 ? getWidth()/2 + Math.random()*50 : getWidth()/2 - Math.random()*50;
            double y = Math.random() < 0.5 ? getHeight()/2 + Math.random()*50 : getHeight()/2 - Math.random()*50;
            
            a.setLocation(x, y);
            a.rotate(Math.random() * 360);
            a.increaseVelocity(1);
            asteroids.add(a);
            add(a);
        }
    }

    public void run()
    {

        while (true)
        {
            pause(10);
            for(Asteroid a : asteroids){
                a.updatePosition();
            }
            ship.updatePosition();
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

    @Override
    public void mouseMoved(MouseEvent e){
        double totalTheta;
        double turnTheta;

        if(e.getX()-ship.getX() == 0){return;}        
        totalTheta = Math.toDegrees(Math.atan((e.getY()-ship.getY())/(e.getX()-ship.getX())));
        if(e.getX() < ship.getX()){
            if(e.getY() <= ship.getY())totalTheta-= 180;
            else totalTheta +=180;
        }     
        turnTheta = -totalTheta-ship.getTheta();

        ship.rotate(turnTheta);
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_W){
            System.out.println("w key pressed");
            ship.increaseVelocity(0.5);
        }
    }
    
   
    
    
}
