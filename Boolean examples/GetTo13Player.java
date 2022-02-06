

public class GetTo13Player implements McCoveyPlayer
{

    public GetTo13Player()
    {

    }
public boolean rollAgain(int myScore, int yourScore, int turnScore)
    {
        if (myScore + turnScore >= 44)
            return false;
        return (turnScore < 13);
    }

}
