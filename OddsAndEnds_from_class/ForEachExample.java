
import acm.program.*;
import java.util.ArrayList;

public class ForEachExample extends ConsoleProgram
{

    public void run()
    {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i=0; i<20; i++)
        {
            nums.add((int)(Math.random() * 7)+1);           
        }
        
        for (int num : nums)
        {
            if (num == 7)
                nums.add(27);
        }
        
        for (int num : nums)
            println(num);
    }

}
