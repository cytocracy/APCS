
import acm.program.*;

public class CashRegisterRunner extends ConsoleProgram
{

    public void run()
    {
        CashRegister register = new CashRegister();
        
        register.recordPurchase(29.50);
        register.recordPurchase(79.25);
        for(int i=0; i<3; i++){
            register.enterPayment(50);
        }
        
        double change = register.getChange();
        println(change);
        register.reset();
     
    }


}
