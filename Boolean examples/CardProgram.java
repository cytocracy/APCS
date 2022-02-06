
import acm.program.*;

public class CardProgram extends ConsoleProgram
{

    public void run() 
    {
        for(int i=0;i<5;i++){
            int suit = (int)(Math.random() *4);
            int rank = (int) (Math.random() *13);
            Card card = new Card(suit, rank);
            println(card.toString());
        }
    }


}
