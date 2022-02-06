
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import acm.util.*;
import java.applet.*;

public class HangmanGraphicsProgram extends GraphicsProgram
{
    /** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 800;
    public static final int APPLICATION_HEIGHT = 500;
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    private static final int PUZZLE_Y_OFFSET = 100;
    private static final int GUESSED_LETTERS_X_OFFSET = 50;
    private static final int GUESSED_LETTERS_Y_OFFSET = 300;

    // task #0 - familiarize yourself with the private instance variables below
    private boolean gameOver;
    private GLabel puzzleLabel;
    private GLabel lettersGuessedLabel;
    private HangmanGame game;
    private GImage head;
    private GImage torso;
    private GImage rightArm;
    private GImage leftArm;
    private GImage leftFoot;
    private GImage rightFoot;
    private GLine rope;
    

    public void run()
    {
        AudioClip music = MediaTools.loadAudioClip("music.au");
        //music.loop(); // I never was able to get the music working correctly, i tried a different file converter, same thing
        initMenu();
        while(true){
            playGame();
        }
        
    }
    public void initMenu(){
        GLabel title = new GLabel("Defend the Pentagon from KMo!!!!");
        title.setFont("TimesNewRoman-Bold-24");
        title.setLocation(WIDTH/2-title.getWidth()/2, 80);

        add(title);

        GLabel subtitle = new GLabel("Created by: Theo Parker");
        subtitle.setFont("TimesNewRoman-Plain-18");
        subtitle.setLocation(WIDTH/2-subtitle.getWidth()/2, 110);

        add(subtitle);

        GLabel playButton = new GLabel("Click Anywhere to Play");
        playButton.setFont("TimesNewRoman-Bold-18");
        playButton.setLocation(WIDTH/2-playButton.getWidth()/2, HEIGHT/2-playButton.getHeight()/2);

        add(playButton);
        
        waitForClick();
        removeAll();
        
    }
    public void playGame(){
        game = new HangmanGame();
        gameOver = false;

        initImages();
        initBackground();
        initLabels();

        while(!gameOver){
            pause(50);
            if(game.getPuzzle().equals(game.getActualAnswer())) gameOver = true;
        }
        if(game.getGuessesLeft() == 0) gameOver(false);
        else gameOver(true);

    }
    public void initBackground(){
        GImage pentagon = new GImage("pentagon.jpg");
        pentagon.scale(0.25, 0.25);
        pentagon.setBounds(WIDTH-pentagon.getWidth(), HEIGHT-pentagon.getHeight(), pentagon.getWidth(), pentagon.getHeight());
        pentagon.sendToBack();

        rope = new GLine(WIDTH-160, 20, WIDTH-160, torso.getY() + 70);
        
        rope.sendToFront();
        
        GImage heli = new GImage("heli.png");
        heli.scale(0.1);
        heli.setLocation(WIDTH-195, 10);
        add(heli);

        add(rope);
        add(pentagon);
    }
    public void initLabels(){
        puzzleLabel = new GLabel(game.getPuzzle());
        int fontSize = 64;
        puzzleLabel.setFont("Monospaced-plain-"+fontSize);
           
        while(puzzleLabel.getWidth()>WIDTH)
        {
            fontSize--;
            puzzleLabel.setFont("*-*-"+fontSize);
        }
        puzzleLabel.setLocation((WIDTH/2-WIDTH/4-puzzleLabel.getWidth()/2), PUZZLE_Y_OFFSET);
        if(puzzleLabel.getX() < 10) puzzleLabel.setLocation(10, puzzleLabel.getY());
        add(puzzleLabel);

        lettersGuessedLabel = new GLabel("Letters guessed: ", GUESSED_LETTERS_X_OFFSET, GUESSED_LETTERS_Y_OFFSET);
        lettersGuessedLabel.setFont("Sansserif-Plain-18");
        lettersGuessedLabel.setColor(Color.red);
        add(lettersGuessedLabel);
    }
    
    public void initImages(){
        head = new GImage("kmo2.jpg");
        torso = new GImage("kmo1.jpg");
        rightArm = new GImage("kmo3.jpg");
        leftArm = new GImage("kmo4.jpg");
        rightFoot = new GImage("kmo5.jpg");
        leftFoot = new GImage("kmo6.png");
        
        positionImage(head);
        positionImage(torso);
        positionImage(rightArm);
        positionImage(leftArm);
        positionImage(rightFoot);
        positionImage(leftFoot);
        
    }
    public void positionImage(GImage image){
        image.scale(0.5, 0.5);
        image.setBounds(WIDTH - image.getWidth(), 100, image.getWidth(), image.getHeight());
    }

    public void keyPressed(KeyEvent event)
    {
        String letter = KeyEvent.getKeyText(event.getKeyCode()).toUpperCase();

        if(game.makeGuess(letter)) puzzleLabel.setText(game.getPuzzle());
        else drawBodyPart();

        lettersGuessedLabel.setText("Letters guessed: " + game.getLettersGuessed());
    }
    
    public void drawBodyPart(){
        int i = game.getGuessesLeft();
        if(i == 6) add(torso);
        else if (i == 5) {
            remove(torso);
            add(head);
        }
        else if (i == 4) {
            remove(head);
            add(rightArm);
        }
        else if (i == 3) {
            remove(rightArm);
            add(leftArm);
        }
        else if (i == 2) {
            remove(leftArm);
            add(rightFoot);
        }
        else if (i == 1) {
            remove(rightFoot);
            add(leftFoot);
        }
        else gameOver = true;
        rope.sendToFront();
    }

    public void gameOver(boolean hasWon){
        GLabel gameOverMessage;
        if (hasWon){
            gameOverMessage = new GLabel("Congratualtions! You guessed the password: " + game.getActualAnswer() + ".");
            gameOverMessage.setColor(Color.GREEN);
        } else {
            gameOverMessage = new GLabel("Oh no! You didn't guess the password of " + game.getActualAnswer() + ".");
            gameOverMessage.setColor(Color.RED);
            drop();
        }
        gameOverMessage.setFont("TimesNewRoman-Bold-14");
        gameOverMessage.setLocation(WIDTH/2 - gameOverMessage.getWidth()/2, 30);
        add(gameOverMessage);
        pause(50);
        
        GLabel playAgain = new GLabel("Click to Play Again.");
        playAgain.setFont("TimesNewRoman-Bold-20");
        playAgain.setLocation(WIDTH/2 - playAgain.getWidth()/2, HEIGHT/2 - playAgain.getHeight()/2);
        add(playAgain);
        waitForClick();
        removeAll();
    }

    public void drop(){
        while(leftFoot.getY() < HEIGHT-100){
            leftFoot.scale(0.95);
            leftFoot.move(0, 10);
            leftFoot.setLocation(WIDTH-160-leftFoot.getWidth()/2, leftFoot.getY());
            rope.setEndPoint(rope.getEndPoint().getX(), (70 * leftFoot.getHeight() / 197.5) +  leftFoot.getY());
            pause(50);
        }
    }

}
