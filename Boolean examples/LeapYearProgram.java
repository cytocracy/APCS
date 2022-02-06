
import acm.program.*;

public class LeapYearProgram extends ConsoleProgram
{

    public void run()
    {
        while(true){
            int year = readInt("Enter a year: ");
            if(isLeapYear(year))println("Yup! It's a leap year.");
            else println("Nope. It's not a leap year.");
        }
    }
    public boolean isLeapYear(int year){
        return ((year%4 == 0 && year%100 != 0) || year%400 == 0);
    }


}
