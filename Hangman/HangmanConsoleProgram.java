
import acm.program.*;

public class HangmanConsoleProgram extends ConsoleProgram
{

    public void run()
    {
        println("Welcome to Hangman!");
        HangmanGame game = new HangmanGame();
        println(game.getPuzzle());

        while(game.getGuessesLeft() > 0){
            String guess = readLine("Enter a guess: ");
            game.makeGuess(guess.toUpperCase());
            clearConsole();
            println(game.getPuzzle());

            println("Letters guessed: " + game.getLettersGuessed());
            println("Guesses left: " + game.getGuessesLeft());

            if(game.getPuzzle().equals(game.getActualAnswer())){
                println("You won!");
                return;
            }
        }
        println("You lost! The correct answer was: " + game.getActualAnswer());

    }
}
