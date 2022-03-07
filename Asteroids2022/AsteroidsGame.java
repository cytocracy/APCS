
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
    private GLabel notificationLabel, scoreLabel, loadingBar;
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
    private Asteroid aPlay, aOptions, aTitle;

    private ArrayList<GObject> menuParts;

    public void init()
    {
        gameState = MENU;

        setBackground(Color.BLACK);

        bullets = new ArrayList<Bullet>();
        asteroids = new ArrayList<Asteroid>();
        keyStrokes = new HashMap<String, Boolean>();

        thrustClip = MediaTools.loadAudioClip("thrust.wav");   
        fireClip = MediaTools.loadAudioClip("fire.wav");   
        bigBangClip = MediaTools.loadAudioClip("bangLarge.wav");   
        mediumBangClip = MediaTools.loadAudioClip("bangMedium.wav");   
        smallBangClip = MediaTools.loadAudioClip("bangSmall.wav");   

        notificationLabel = new GLabel("(up) = thrust, (left) = rotate left, (right) = rotate right, (space) = fire. Click mouse to continue");
        notificationLabel.setColor(Color.WHITE);
        notificationLabel.setFont("Courier-Plain-12");
        notificationLabel.setLocation((getWidth()-notificationLabel.getWidth())/2, getHeight()/2-40);

        scoreLabel = new GLabel("Score:"+score);
        scoreLabel.setColor(Color.WHITE);
        scoreLabel.setFont("Courier-Plain-10");
        scoreLabel.setLocation(16, 16);


        menuParts = new ArrayList<GObject>();

        loadingBar = new GLabel("_________");
        loadingBar.setColor(Color.white);
        loadingBar.setLocation(getWidth()/2-loadingBar.getWidth()/2, getHeight()-30);
        menuParts.add(loadingBar);

        aTitle = new Asteroid(getWidth(), getHeight());
        aTitle.setLocation(getWidth()/2, getHeight()* 0.25);
        menuParts.add(aTitle);

        GLabel tTitle = new GLabel("Asteroids");
        tTitle.setFont("Helvetica-Bold-15");
        tTitle.setColor(Color.white);
        tTitle.setLocation(getWidth()/2-tTitle.getWidth()/2, getHeight() * 0.25 - tTitle.getHeight()/2);
        menuParts.add(tTitle);

        aPlay = new MediumAsteroid(getWidth(), getHeight());
        aPlay.setLocation(getWidth()/3, getHeight()/2);
        asteroids.add(aPlay);
        menuParts.add(aPlay);

        aOptions = new MediumAsteroid(getWidth(), getHeight());
        aOptions.setLocation(getWidth() * 2.0/3, getHeight()/2);
        asteroids.add(aOptions);
        menuParts.add(aOptions);

        GLabel tPlay = new GLabel("Play");
        tPlay.setFont("Helvetica-Bold-10");
        tPlay.setColor(Color.white);
        tPlay.setLocation(getWidth()/3 - tPlay.getWidth()/2, getHeight()/2/*-tPlay.getHeight()/2*/);
        menuParts.add(tPlay);

        GLabel tOptions = new GLabel("Options");
        tOptions.setFont("Helvetica-Bold-10");
        tOptions.setColor(Color.white);
        tOptions.setLocation(getWidth() * 2.0/3 - tOptions.getWidth()/2, getHeight()/2 /*- tOptions.getHeight()/2*/);
        menuParts.add(tOptions);

        ship = new Ship(getWidth(), getHeight());

        ship.setLocation(getWidth()/2 - ship.getWidth()/2, getHeight()* 3/4 /*- ship.getBounds().getHeight()/2*/);
        menuParts.add(ship);

        initKeyStrokes();
        initMenu();
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
                scoreLabel.setText("Score:"+score);
            } else if (gameState == MENU){
                for(GObject obj : menuParts){
                    if(obj instanceof Asteroid){
                        Asteroid a = (Asteroid) obj;
                        a.tick();
                    }
                }
                processKeyStrokes();
                for(int i = 0; i<bullets.size(); i++){

                    if(bullets.get(i).stillMoving()) {
                        bullets.get(i).updatePosition();
                        if(checkForCollisions(bullets.get(i)) != null){
                            Asteroid selection = checkForCollisions(bullets.get(i));
                            incrementLoadingBar();
                        } 
                    }else {
                        remove(bullets.remove(i));
                    }
                }
                if(loadingBar.getLabel().length() > 9)shortenLoadingBar();
            } else if (gameState == RESET){
                for(Asteroid a : asteroids){
                    a.updatePosition();
                }
            }
        } 
    }

    private void incrementLoadingBar(){
        if(loadingBar.getWidth() > getWidth())startGame();
        loadingBar.setText(loadingBar.getLabel() + "_");
        loadingBar.setLocation(getWidth()/2 - loadingBar.getWidth()/2, loadingBar.getY());

    }

    public void startGame(){
        removeAll();
        asteroids.clear();
        bullets.clear();
        initGame();
        gameState = GAME;
    }

    private void shortenLoadingBar(){
        loadingBar.setText(loadingBar.getLabel().substring(1));
        loadingBar.setLocation(getWidth()/2 - loadingBar.getWidth()/2, loadingBar.getY());

    }

    private void initGame(){
        level = 0;
        ships = 3;
        score = 0;

        add(scoreLabel);

        makeAsteroids();
        ship = new Ship(getWidth(), getHeight());

        ship.setLocation(getWidth()/2 - ship.getBounds().getWidth()/2, getHeight()/2 - ship.getBounds().getHeight()/2);
        add(ship);

        shootingCooldown = 50;
    }

    private void initMenu(){
        for(GObject obj : menuParts){
            add(obj);
        }

    }

    private void gameOver(){
    }

    private void checkBulletCollisions(){
        for(int i=0; i<bullets.size(); i++){
            Asteroid collidedAsteroid = checkForCollisions(bullets.get(i));
            if(collidedAsteroid != null){
                remove(bullets.remove(i));
                remove(asteroids.remove(asteroids.indexOf(collidedAsteroid)));
                if(!(collidedAsteroid instanceof SmallAsteroid)){
                    if(collidedAsteroid instanceof MediumAsteroid) score += 50;
                    else score += 20;
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
                } else score += 100;
            }
        }
    }

    private void shipCollided(){
        gameState = RESET;
        for(int i=0; i<bullets.size(); i++){
            remove(bullets.remove(i));
            i--;
        }
        ship.resetRotation();
        ship.setVY(0);
        ship.setVX(0);  
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
            localizeShip(e);
            //for(menu)
        } else if (gameState == MENU){
            localizeShip(e);
        }
    }

    private void localizeShip(MouseEvent e){
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
        if(gameState == MENU) {
        }else if(gameState == RESET) gameState = GAME;
    }

    private void processKeyStrokes(){
        if(gameState == GAME){
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
        } else if(gameState == MENU){
            if(keyStrokes.get("VK_SPACE")){
                Bullet b = ship.makePointer();
                bullets.add(b);
                add(b);
            }
        }

    }
}
