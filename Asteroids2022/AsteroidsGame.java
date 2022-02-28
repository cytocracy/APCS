
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import java.applet.AudioClip;
import acm.util.MediaTools;

public class AsteroidsGame extends GraphicsProgram
{
    private static final int MENU = 0;
    private static final int GAME = 1;
    private static final int RESET = 2;
    private static final int GAMEOVER = 3;

    private ArrayList<Asteroid> asteroids;
    private int gameState;
    private GLabel notificationLabel, scoreLabel;
    // uncomment out the line below in version 0.4.1
    private Ship ship;
    // uncomment out the line below in version 0.5.2
    // (and don't forget to write bullets = new ArrayList<Bullet>() in the init method!)
    private ArrayList<Bullet> bullets; 
    private int level;
    private int ships;
    private int score;
    private AudioClip thrustClip, fireClip, bigBangClip, mediumBangClip, smallBangClip;
    private HashMap<String, Boolean> keyStrokes;
    private int shootingCooldown;

    public void init()
    {
        keyStrokes = new HashMap<String, Boolean>();
        initKeyStrokes();

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

        bullets = new ArrayList<Bullet>();
        shootingCooldown = 0;

        gameState = MENU;
    }

    private void initKeyStrokes(){
        String[] keys = {
                "VK_W",
                "VK_S",
                "VK_SPACE",
            };

        for(String key : keys){
            keyStrokes.put(key, false);
        }
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
        while (true){
            pause(10);
            if(gameState == GAME){
                updatePositions();
                if(ship.incrementInvincibility() < 0 && checkForCollisions(ship) != null){
                    shipCollided();
                }
                checkBulletCollisions();
                processKeyStrokes();
            }
        } 
    }

    private void checkBulletCollisions(){
        for(int i=0; i<bullets.size(); i++){
            Asteroid collidedAsteroid = checkForCollisions(bullets.get(i));
            if(collidedAsteroid != null){
                remove(bullets.remove(i));
                remove(asteroids.remove(asteroids.indexOf(collidedAsteroid)));
                if(!(collidedAsteroid instanceof SmallAsteroid)){
                    double vectorAngle = Math.random() * 360;
                    for(int j=0; j<3; j++){
                        Asteroid newAstro = collidedAsteroid instanceof MediumAsteroid ? new SmallAsteroid(getWidth(), getHeight()) : new MediumAsteroid(getWidth(), getHeight());
                        newAstro.setLocation(collidedAsteroid.getX(), collidedAsteroid.getY());
                        newAstro.rotate(vectorAngle + 120*j);
                        if(newAstro instanceof MediumAsteroid)newAstro.increaseVelocity(1.5);
                        else newAstro.increaseVelocity(2);
                        asteroids.add(newAstro);
                        add(newAstro);
                    }
                }
            }
        }
    }

    private void shipCollided(){
        gameState = RESET;
        ship.resetRotation();
        ship.rotate(90);
        ship.setLocation(getWidth()/2 - ship.getBounds().getWidth()/2, getHeight()/2 - ship.getBounds().getHeight()/2);
    }

    public void updatePositions(){
        for(Asteroid a : asteroids){
            a.updatePosition();
        }
        for(int i = 0; i<bullets.size(); i++){

            if(bullets.get(i).stillMoving()) bullets.get(i).updatePosition();
            else {
                remove(bullets.remove(i));
            }
        }
        ship.updatePosition();
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
        if(gameState == GAME){
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
    }
    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_W: keyStrokes.put("VK_W", true); break;
            case KeyEvent.VK_S: keyStrokes.put("VK_S", true); break;
            case KeyEvent.VK_SPACE: keyStrokes.put("VK_SPACE", true); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_W: keyStrokes.put("VK_W", false); break;
            case KeyEvent.VK_S: keyStrokes.put("VK_S", false); break;
            case KeyEvent.VK_SPACE: keyStrokes.put("VK_SPACE", false); break;
        }
    }

    public void mouseClicked(MouseEvent e){
        if(gameState == MENU) gameState = GAME;
        if(gameState == RESET) gameState = GAME;
    }

    private void processKeyStrokes(){
        if(keyStrokes.get("VK_W"))ship.boost(0.5);
        if(keyStrokes.get("VK_S"))ship.brake(-ship.getMagnitude()/20);
        if(keyStrokes.get("VK_SPACE")){
            if(shootingCooldown <= 0){
                Bullet b = ship.makeBullet();
                bullets.add(b);
                add(b);
                shootingCooldown = 5;
            } else shootingCooldown--;

        }
    }

}
