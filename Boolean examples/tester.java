
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class tester extends GraphicsProgram
{
    private McCoveyPlayer p1, p2;
    private McCoveyGame game, game2;
    private GRect bar1, bar2;
    private GLabel text;
    private GLabel infoText;

    public void run()
    {
        int a = 39; //34
        int b = 15;
        int c = 25;
        int d = 28;
        int e = 15;
        int f = 13;
        int g = 17;
        int bestScore = 0;

        
            bestScore = 0; 
            removeAll();
            int temp = a;
            int bestInt = 0;
            

            for(int j = 0; j<10; j++){
                println(a);
                removeAll();
                int modifier = 5-j;
                a = temp + modifier;
                
                
                p2 = new Winner2016();
                p1 = new Theo2(a, b, c, d, e, f, g);

                bar1 = new GRect(0,100,0,100);
                bar1.setColor(Color.RED);
                bar1.setFilled(true);
                add(bar1);
                bar2 = new GRect(0,200,0,100);
                bar2.setColor(Color.ORANGE);
                bar2.setFilled(true);
                add(bar2);
                text = new GLabel("", 10,40);
                text.setFont("Serif-Bold-24");
                add(text);
                infoText = new GLabel("Click to play 100000 games with " + getName(p1) + " going first", 40,320);
                infoText.setFont("Serif-Bold-18");
                add(infoText);
                //waitForClick();
                infoText.setLabel("");
                game = new McCoveyGame("One", "Two", 2500000);     
                while (game.getGamesLeft()>0)
                {
                    while (game.whoseTurn())
                    {
                        if (p1.rollAgain(game.getPlayer1Score(), game.getPlayer2Score(), game.getTurnScore()))
                            game.roll(null);
                        else
                            game.pass();
                    }
                    if (game.getWinner().equals("One"))
                    {
                        game.reset();
                        updateBars();
                    }
                    while (!game.whoseTurn())
                    {
                        if (p2.rollAgain(game.getPlayer2Score(), game.getPlayer1Score(), game.getTurnScore()))
                            game.roll(null);
                        else
                            game.pass();
                    }
                    if (game.getWinner().equals("Two"))
                    {
                        game.reset();
                        updateBars();
                    }

                }
                game2 = new McCoveyGame("One", "Two", 2500000);         
                infoText.setLabel("Click to play 100000 games with " + getName(p2) + " going first");
                //waitForClick();
                infoText.setLabel("");
                while (game2.getGamesLeft()>0)
                {
                    while (game2.whoseTurn())
                    {
                        if (p2.rollAgain(game2.getPlayer1Score(), game2.getPlayer2Score(), game2.getTurnScore()))
                            game2.roll(null);
                        else
                            game2.pass();
                    }
                    if (game2.getWinner().equals("One"))
                    {
                        game2.reset();
                        updateBars2();
                    }
                    while (!game2.whoseTurn())
                    {
                        if (p1.rollAgain(game2.getPlayer2Score(), game2.getPlayer1Score(), game2.getTurnScore()))
                            game2.roll(null);
                        else
                            game2.pass();
                    }
                    if (game2.getWinner().equals("Two"))
                    {
                        game2.reset();
                        updateBars2();
                    }

                }        
                int num1 = game2.getGames2Won() + game.getGames1Won();
                int num2 = game2.getGames1Won() + game.getGames2Won();
                if (num1 == num2)
                    infoText.setLabel("It's a tie!");
                else if (num1 > num2)
                    infoText.setLabel(getName(p1) + " wins!");
                else
                    infoText.setLabel(getName(p2) + " wins!");
                println(game.getGames1Won());
                if (game.getGames1Won() > bestScore){
                    bestScore = game.getGames1Won();
                    bestInt = a;
                } else {

                }

            }
            
            println("b: " + bestInt);
            
        
        // all you should need to do is change the next two lines

    }

    public void init() {        setSize(720,350);    }

    private void updateBars()
    {
        int num1 = game.getGames1Won();
        int num2 = game.getGames2Won();
        double percent1 = (1.0*num1)/(num1+num2);
        double percent2 = (1.0*num2)/(num1+num2);
        bar1.setSize(percent1*600, 100);
        bar2.setSize(percent2*600, 100);
        text.setLabel(getName(p1) + " = " + num1 + " wins, " + getName(p2) +" =  " + num2 + " wins");     
    }

    private void updateBars2()
    {
        int num1 = game2.getGames2Won() + game.getGames1Won();
        int num2 = game2.getGames1Won() + game.getGames2Won();
        double percent1 = (1.0*num1)/(num1+num2);
        double percent2 = (1.0*num2)/(num1+num2);
        bar1.setSize(percent1*600, 100);
        bar2.setSize(percent2*600, 100);
        text.setLabel(getName(p1) + " = " + num1 + " wins, " + getName(p2) +" =  " + num2 + " wins");     
    }

    public String getName(Object obj)
    {
        return obj.getClass().getSimpleName();
    }

}
