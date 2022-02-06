public class HangmanGame
{
    private String answer;
    private int guessesLeft;
    private String lettersGuessed;
    
    public HangmanGame(){
        answer = RandomWordGenerator.getRandomWord();
        guessesLeft = 7;
        lettersGuessed = "";
    }
    
    public String getActualAnswer(){
        return answer;
    }
    
    public int getGuessesLeft(){
        return guessesLeft;
    }
    
    public boolean makeGuess(String letter){
        lettersGuessed = lettersGuessed + letter;
        if(answer.indexOf(letter) == -1){
            guessesLeft--;
            return false;
        }
        return true;
    }
    
    public String getLettersGuessed(){
        return lettersGuessed;
    }
    
    public String getPuzzle(){
        String result = "";
        for(int i=0; i <answer.length(); i++){
            String letter = answer.substring(i, i+1);
            
            if(lettersGuessed.indexOf(letter) == -1){
                result = result + "_"; 
            } else {
                result = result + letter;
            }
        }
        return result;
    }
}
