
public class CashRegister
{
    private double totalPurchased;
    private double totalPaid;

    public CashRegister()
    {
       totalPurchased = 0;
       totalPaid = 0;
    }

    public void recordPurchase(double price)
    {
       totalPurchased += price;
    }

    public void enterPayment(double amount)
    {
       totalPaid += amount;
    }

    public double getChange()
    {
        return totalPaid - totalPurchased;
    }

    public void reset() 
    {
        totalPurchased = 0;
        totalPaid = 0;
    }
}
