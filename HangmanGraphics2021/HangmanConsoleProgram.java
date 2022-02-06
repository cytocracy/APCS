
import acm.program.*; 

public class HangmanConsoleProgram extends ConsoleProgram
{

    public void run()
    {
        println("Welcome to Hangman!");
        HangmanGame man = new HangmanGame();
        println(man.getPuzzle());
        println(man.getGuessesLeft() + " guesses left.");
        boolean gameOver = false;

        while (gameOver == false)
        {
            String guess = readLine("Enter a letter: ");
            if (man.makeGuess(guess) == true)
                println("Good guess!");
            else
                println("Bad guess!");

            println(man.getPuzzle());
            println(man.getGuessesLeft() + " guesses left.");
            println("Letters guessed: " + man.getLettersGuessed());  // we didn't do this in class
            if (man.getGuessesLeft() == 0)
                gameOver = true;
            if (man.getPuzzle().equals(man.getActualAnswer()))
                gameOver = true;
        }
        if (man.getGuessesLeft() == 0)
        {
            println("You lost!");
            println("The actual correct answer was " + man.getActualAnswer());
        }
        else
        {
            println("You win!");
        }
    }

}
