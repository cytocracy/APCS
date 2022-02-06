

public class GetTo15Player implements McCoveyPlayer
{

    public GetTo15Player()
    {

    }
public boolean rollAgain(int myScore, int yourScore, int turnScore)
    {
        if (myScore + turnScore >= 44)
            return false;
        return (turnScore < 15);
    }

}
