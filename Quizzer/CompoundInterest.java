

public class CompoundInterest
{
    private double interestRate;
    private double startingAmount;

    private static final double e = 2.71828;
    
    public CompoundInterest(double initInterest, double initAmount)
    {
        interestRate = initInterest;
        startingAmount = initAmount;
    }
    
    public double getAmountAfterNYears(int nYears){
        double amount = startingAmount;
        
        for(int i=0; i<nYears*interestRate; i++){
            amount += amount * (interestRate * e);       
        }
        return amount;
    }
    
    public double getNForAmount(double target){
        //while (
        return 0;
    }


}
