public class Theo implements McCoveyPlayer
{
    
    public boolean rollAgain(int myScore, int yourScore, int turnScore) {
        
        if(myScore + turnScore >= 44) return false;
        else if (myScore + turnScore > 32) return true;
        else if (myScore > 30) return true;
        else if (yourScore > 30) return true;
        else if (yourScore > 23) return turnScore < 18;
        else if (myScore + turnScore < yourScore) return turnScore < 15;
        else if (myScore + turnScore < yourScore - 10) return turnScore < 16;
        else if (myScore + turnScore < yourScore - 15) return turnScore < 17;
        else if (myScore + turnScore < yourScore - 26) return true;
        else if (myScore + turnScore > 27) return turnScore < 11;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
        else return turnScore < 13;
        
    }
}


