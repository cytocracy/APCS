


public class Card
{

    private int suit;
    private int rank;
    
    public Card(int theSuit, int theRank)
    {
        suit = theSuit;
        rank = theRank;
    }
    
    public String toString(){
        return getRank() + " of " + getSuit();
    }
    
    public String getSuit(){
        switch(suit){
            case 0: return "spades";
            case 1: return "hearts";
            case 2: return "diamonds";
            case 3: return "clubs";
        }
        return "unknown";
    }
    
    public String getRank(){
        if(rank == 0) return "ace";
        else if (rank == 1) return "two";
        else if (rank == 2) return "three";
        else if (rank == 3) return "four";
        else if (rank == 4) return "five";
        else if (rank == 5) return "six";
        else if (rank == 6) return "seven";
        else if (rank == 7) return "eight";
        else if (rank == 8) return "nine";
        else if (rank == 9) return "ten";
        else if (rank == 10) return "jack";
        else if (rank == 11) return "queen";
        else return "king"; 
    }

}
