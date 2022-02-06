/* Note: You can test this by compiling it, then
 *       right-clicking on Paycheck and selecting
 *       "new Paycheck".  Then, enter the hours and
 *       rate, and click "OK".  Then, a Paycheck 
 *       instance will show up as a red rectangle
 *       on the instance shelf at the bottom.  Click 
 *       on that red instance and select getAmount().
 *       Did you get the correct amount of your check?
 *       You might have to do a little math to check...
 */


public class Paycheck
{
    private double hoursWorked;
    private double hourlyRate;

    public Paycheck(double hours, double rate)
    {
        hoursWorked = hours;
        hourlyRate = rate;
    }

    public double getAmount()
    {
          double pay = hoursWorked * hourlyRate;
          if (hoursWorked > 40){
              double overtime = hoursWorked-40;
              double overtimePay = overtime* hourlyRate*0.5;
              pay += overtimePay;
          }
          
          if (pay <200)pay *= .89;
          else if (pay < 400) pay *= .85;
          else if (pay < 600) pay *= .82;
          else pay *= .76;
          
          pay -= 14;
          
          if(pay < 0)pay = 0;
          return pay;
           
    }

}
