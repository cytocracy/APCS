

public class VotingMachine
{
    private int yesVotes;
    private int noVotes;
    
    public VotingMachine()
    {
        yesVotes = 0;
        noVotes = 0;
    }
    
    public void voteYes(){
        yesVotes += 1;
    }
    
    public void voteNo(){
        noVotes += 1;
    }
    
    public void rigElection(double rigFactor){
        int votesTransfered = (int) (noVotes * rigFactor);
        yesVotes += votesTransfered;
        noVotes -= votesTransfered;
        
    }
    
    public double getYesPercent(){
        return 100.0 * yesVotes/(yesVotes + noVotes);
    }
    
    public double getNoPercent(){
        return 100.0 - getYesPercent();
    }
    
    public String getWinner(){
        if(yesVotes > noVotes){
            return "Yes";
        } else if(noVotes > yesVotes){
            return "No";
        } else {
            return "Tie";
        }
    }


}
