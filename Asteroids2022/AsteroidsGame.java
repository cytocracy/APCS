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

    private static final int SHOOTINGCOOLDOWNTIME = 15;
    private static final int LEVELCOOLDOWNTIME = 200;

    private int gameState;
    private HashMap<String, Boolean> keyStrokes;

    private ArrayList<Asteroid> asteroids;
    private ArrayList<Bullet> bullets;
    private Ship ship;
    private int level, ships, score;
    private int shootingCooldown;
    private int levelCooldown;

    private ArrayList<GObject> menuParts;
    private GLabel notificationLabel, scoreLabel, levelLabel, shipsLabel, loadingBar;
    private Asteroid aPlay, aOptions, aTitle;
    private AudioClip thrustClip, fireClip, bigBangClip, mediumBangClip, smallBangClip;

    //
    //
    //Runtime Methods

    public void run()
    {
        while (true){
            pause(10);
            //System.out.println(gameState);
            if(gameState == GAME) gameLoop();   
            else if (gameState == MENU)menuLoop();   
            else if (gameState == RESET){
                for(Asteroid a : asteroids){
                    a.updatePosition();
                }
            }
        } 
    }

    private void gameLoop(){
        updatePositions();
        if(checkForCollisions(ship) != null){
            shipCollided();
            return;
        }

        checkBulletCollisions();
        if(asteroids.size() == 0){
            notificationLabel.setText("Level " + level + " Complete.");
            notificationLabel.setLocation((getWidth()-notificationLabel.getWidth())/2, getHeight()/2-40);
            add(notificationLabel);
            levelCooldown++;
            if(levelCooldown > LEVELCOOLDOWNTIME){
                nextLevel();
                levelCooldown = 0;
            }
        } else processKeyStrokes();

        scoreLabel.setText("Score: "+score);
    }

    private void menuLoop(){
        for(GObject obj : menuParts){
            if(obj instanceof Asteroid){
                Asteroid a = (Asteroid) obj;
                a.updatePosition();
            }
        }
        processKeyStrokes();
        for(int i = 0; i<bullets.size(); i++){

            if(bullets.get(i).stillMoving()) {
                bullets.get(i).updatePosition();
                if(checkForCollisions(bullets.get(i)) != null){
                    Asteroid selection = checkForCollisions(bullets.get(i));
                    remove(bullets.remove(i));
                    incrementLoadingBar();
                } 
            }else {
                remove(bullets.remove(i));
            }
        }
        if(!keyStrokes.get("SPACE") && loadingBar.getLabel().length() > 9)shortenLoadingBar();
    }

    private void startGame(){
        gameState = RESET;
        removeAll();
        asteroids.clear();
        bullets.clear();
        initGame();
    }

    private void nextLevel(){
        gameState = RESET;
        level++;
        levelLabel.setText("Level: " + level);

        resetShip();
        makeAsteroids();

        notificationLabel.setText("Click to start level " + level + ".");
        notificationLabel.setLocation((getWidth()-notificationLabel.getWidth())/2, getHeight()/2-40);

    }

    private void gameOver(){
        gameState = GAMEOVER;
        removeAll();
        asteroids.clear();
        bullets.clear();
        gameOverScreen();
    }

    private void checkBulletCollisions(){
        for(int i=0; i<bullets.size(); i++){
            Asteroid collidedAsteroid = checkForCollisions(bullets.get(i));

            //hit asteroid
            if(collidedAsteroid != null){
                remove(bullets.remove(i));
                remove(asteroids.remove(asteroids.indexOf(collidedAsteroid)));

                if(!(collidedAsteroid instanceof SmallAsteroid)){ //regular or medium asteroid
                    if(collidedAsteroid instanceof MediumAsteroid){ //medium asteroid
                        score += 50;
                        mediumBangClip.play();
                    } 
                    else { //regular asteroid
                        score += 20;
                        bigBangClip.play();
                    }
                    makeSmallerAsteroids(collidedAsteroid);
                } else  {//hit small asteroid
                    score += 100;
                    smallBangClip.play();
                }
            }
        }
    }

    private void shipCollided(){
        ships--;
        shipsLabel.setText("Ships: " + ships);
        gameState = RESET;
        for(int i=0; i<bullets.size(); i++){
            remove(bullets.remove(i));
            i--;
        }
        resetShip();
        String shipStr = ships == 1 ? "ship" : "ships";
        notificationLabel.setText("You have " + ships + " " + shipStr + " remaining. Click to resume.");
        notificationLabel.setLocation((getWidth()-notificationLabel.getWidth())/2, getHeight()/2-40);
        add(notificationLabel);
        if(ships == 0) gameOver();
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

    //Util methods
    private void makeSmallerAsteroids(Asteroid collidedAsteroid){
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

    private void updatePositions(){
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

    private void resetShip(){
        ship.resetRotation();
        ship.setVY(0);
        ship.setVX(0);  
        ship.rotate(90);
        ship.setLocation(getWidth()/2 - ship.getBounds().getWidth()/2, getHeight()/2 - ship.getBounds().getHeight()/2);
    }

    private void initMenu(){
        menuParts.remove(5);
        ship = new Ship(getWidth(), getHeight());
        ship.setLocation(getWidth()/2 - ship.getBounds().getWidth()/2, getHeight()* 3/4 /*- ship.getBounds().getHeight()/2*/);
        menuParts.add(ship);

        asteroids.add(aTitle);
        asteroids.add(aPlay);
        //asteroids.add(aOptions);

        for(GObject obj : menuParts){
            add(obj);
        }
        //System.out.println(menuParts);
    }

    private void shortenLoadingBar(){
        loadingBar.setText(loadingBar.getLabel().substring(1));
        loadingBar.setLocation(getWidth()/2 - loadingBar.getWidth()/2, loadingBar.getY());
    }

    private void incrementLoadingBar(){
        if(loadingBar.getWidth() > getWidth()){
            loadingBar.setText("_________");
            startGame();
        }
        loadingBar.setText(loadingBar.getLabel() + "_");
        loadingBar.setLocation(getWidth()/2 - loadingBar.getWidth()/2, loadingBar.getY());
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

    private void initGame(){
        level = 0;
        ships = 3;
        score = 0;
        levelCooldown = 0;

        bullets.clear();
        asteroids.clear();

        shipsLabel.setText("Ships: " + ships);
        levelLabel.setText("Level: " + level);
        scoreLabel.setText("Score: " + score);
        add(scoreLabel);
        add(levelLabel);
        add(shipsLabel);

        notificationLabel.setText("Click to start level " + level + ".");
        notificationLabel.setLocation((getWidth()-notificationLabel.getWidth())/2, getHeight()/2-40);

        add(notificationLabel);

        makeAsteroids();
        ship = new Ship(getWidth(), getHeight());

        ship.setLocation(getWidth()/2 - ship.getBounds().getWidth()/2, getHeight()/2 - ship.getBounds().getHeight()/2);
        add(ship);

        shootingCooldown = 50;
    }

    private void gameOverScreen(){
        GLabel gameOverLabel = new GLabel("Game Over!");
        gameOverLabel.setFont("Helvetica-Plain-64");
        gameOverLabel.setColor(Color.WHITE);
        gameOverLabel.setLocation(getWidth()/2 - gameOverLabel.getWidth()/2, 100);
        add(gameOverLabel);

        GLabel stats = new GLabel("You made it to level " + level + " with a score of " + score + ".");
        stats.setFont("Helvetica-Plain-22");
        stats.setColor(Color.WHITE);
        stats.setLocation(getWidth()/2 - stats.getWidth()/2, getHeight()/2-stats.getHeight()/2);
        add(stats);

        GLabel returnToMenu = new GLabel("Click to return to the main menu.");
        returnToMenu.setFont("Helvetica-Plain-12");
        returnToMenu.setColor(Color.WHITE);
        returnToMenu.setLocation(getWidth()/2-returnToMenu.getWidth()/2, getHeight()/2 + 50);
        add(returnToMenu);
    }

    //
    //
    //
    //Keystroke Methods

    private void initKeyStrokes(){
        String[] keys = {
                "W",
                "S",
                "A",
                "D",
                "SPACE",
            };

        for(String key : keys){
            keyStrokes.put(key, false);
        }
    }

    @Override
    public void keyPressed(KeyEvent e){

        //ik you don't like switch cases but this seemed like a somewhat reasonable use
        switch(e.getKeyCode()){
            case KeyEvent.VK_W: keyStrokes.put("W", true); break;
            case KeyEvent.VK_UP: keyStrokes.put("W", true); break;

            case KeyEvent.VK_S: keyStrokes.put("S", true); break;
            case KeyEvent.VK_DOWN: keyStrokes.put("S", true); break;

            case KeyEvent.VK_A: keyStrokes.put("A", true); break;
            case KeyEvent.VK_LEFT: keyStrokes.put("A", true); break;

            case KeyEvent.VK_D: keyStrokes.put("D", true); break;
            case KeyEvent.VK_RIGHT: keyStrokes.put("D", true); break;

            case KeyEvent.VK_SPACE: keyStrokes.put("SPACE", true); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_W: keyStrokes.put("W", false); break;
            case KeyEvent.VK_UP: keyStrokes.put("W", false); break;

            case KeyEvent.VK_S: keyStrokes.put("S", false); break;
            case KeyEvent.VK_DOWN: keyStrokes.put("S", false); break;

            case KeyEvent.VK_A: keyStrokes.put("A", false); break;
            case KeyEvent.VK_LEFT: keyStrokes.put("A", false); break;

            case KeyEvent.VK_D: keyStrokes.put("D", false); break;
            case KeyEvent.VK_RIGHT: keyStrokes.put("D", false); break;

            case KeyEvent.VK_SPACE: keyStrokes.put("SPACE", false); break;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e){
        if(gameState == GAME || gameState == MENU){
            if(ship == null) return;
            localizeShip(e);
        }
    }

    public void mouseClicked(MouseEvent e){
        if(gameState == MENU) {
        }else if(gameState == RESET) {
            remove(notificationLabel);
            gameState = GAME;
        } else if(gameState == GAMEOVER){
            removeAll();
            initMenu();
            gameState = MENU;
        }
    }

    private void processKeyStrokes(){
        if(gameState == GAME){
            if(keyStrokes.get("W")){
                ship.boost(0.5);
                thrustClip.play();
            }
            if(keyStrokes.get("S"))ship.brake(-ship.getMagnitude()/20);
            if(keyStrokes.get("SPACE")){
                if(shootingCooldown <= 0){
                    Bullet b = ship.makeBullet();
                    bullets.add(b);
                    add(b);
                    shootingCooldown = SHOOTINGCOOLDOWNTIME;
                    thrustClip.play();
                }
            }
            if(keyStrokes.get("A")) ship.rotate(5);
            if(keyStrokes.get("D")) ship.rotate(-5);
            shootingCooldown--;
        } else if(gameState == MENU){
            if(keyStrokes.get("SPACE")){
                Bullet b = ship.makePointer();
                bullets.add(b);
                add(b);
            }
            if(keyStrokes.get("A")) ship.rotate(5);
            if(keyStrokes.get("D")) ship.rotate(-5);

        }
    }

    //init
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

        scoreLabel = new GLabel("Score: "+ score);
        scoreLabel.setColor(Color.WHITE);
        scoreLabel.setFont("Courier-Plain-10");
        scoreLabel.setLocation(16, 16);

        levelLabel = new GLabel("Level: " + level);
        levelLabel.setColor(Color.WHITE);
        levelLabel.setFont("Courier-Plain-10");
        levelLabel.setLocation(getWidth()-100, 16);

        shipsLabel = new GLabel("Ships: " + ships);
        shipsLabel.setColor(Color.WHITE);
        shipsLabel.setFont("Courier-Plain-10");
        shipsLabel.setLocation(getWidth()-50, 16);

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
        aPlay.setLocation(getWidth()/2, getHeight()/2);
        asteroids.add(aPlay);
        menuParts.add(aPlay);

        /*aOptions = new MediumAsteroid(getWidth(), getHeight());
        aOptions.setLocation(getWidth() * 2.0/3, getHeight()/2);
        asteroids.add(aOptions);
        menuParts.add(aOptions);*/

        GLabel tPlay = new GLabel("Play");
        tPlay.setFont("Helvetica-Bold-10");
        tPlay.setColor(Color.white);
        tPlay.setLocation(getWidth()/2 - tPlay.getWidth()/2, getHeight()/2/*-tPlay.getHeight()/2*/);
        menuParts.add(tPlay);


        ship = new Ship(getWidth(), getHeight());

        ship.setLocation(getWidth()/2 - ship.getWidth()/2, getHeight()* 3/4 /*- ship.getBounds().getHeight()/2*/);
        menuParts.add(ship);

        initKeyStrokes();
        initMenu();
    }
}
