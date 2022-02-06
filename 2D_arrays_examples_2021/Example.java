
import acm.program.*;

public class Example extends ConsoleProgram
{
    public void run()
    {
        int[][] nums = new int[10][15];

        for(int i=0; i < nums.length; i++)
            for(int j=0; j<nums[i].length; j++)
                nums[i][j] = (int)(Math.random()*12);
                
        nums[7][2] = 9;
        nums[0][0] = 27;
        nums[0][14] = 27;
        nums[9][0] = 27;
        nums[9][14] = 27;
        
        int count = 0;
        
        for(int i=0; i<nums.length; i++)
            for(int j=0; j<nums[i].length; j++)
                if(nums[i][j] == 9) count++;
                
        println("There are " + count + " nines.");
        
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums[i].length; j++){
                print(nums[i][j] + " ");
            }
            println();
        }    
    }
}
