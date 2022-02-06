
import acm.program.*;

public class CompoundInterestCalculator extends ConsoleProgram
{

    public void run()
    {
       double initAmount = readDouble("Enter the initial amount: ");
       double interestRate = readDouble("Enter the interest rate: ");
       
       if(interestRate == 0) interestRate = 2.71828;
       
       CompoundInterest c = new CompoundInterest(interestRate, initAmount);
       
       while (true){
           int years = readInt("Enter a number of years: ");
           println();
           println("Total amount: " + Math.round(c.getAmountAfterNYears(years)*1000.0)/1000.0);
           println();
       }
       
    }


}
