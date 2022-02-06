
import acm.program.*;

public class CompoundInterestFinder extends ConsoleProgram
{

    public void run()
    {
       double initAmount = readDouble("Enter the initial amount: ");
       double interestRate = readDouble("Enter the interest rate: ");
       
       if(interestRate == 0) interestRate = 2.71828;
       
       CompoundInterest c = new CompoundInterest(interestRate, initAmount);
       
       while (true){
           int years = readInt("Enter a target value: ");
           println();
           println("T: " + c.getAmountAfterNYears(years));
           println();
       }
       
    }

}
