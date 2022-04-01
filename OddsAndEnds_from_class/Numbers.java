
import acm.program.*;

public class Numbers extends ConsoleProgram
{

    public void run()
    {
        int num = 27;  // int is 32 bits
        long anotherNum = 27; // 64-bits
        
        int big = Integer.MAX_VALUE;
        println(big);
        int small = Integer.MIN_VALUE;
        println(small);
        
        num = Integer.MAX_VALUE - 10;
        for (int i=0; i<20; i++)
        {
            println(num);
            num++;
        }
        
        int[] nums = {67, 44, 27, 81, 73, 23, 55};
        int champ = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++)
        {
            if (nums[i] > champ)
                champ = nums[i];
        }
        println(champ);
    }

}
