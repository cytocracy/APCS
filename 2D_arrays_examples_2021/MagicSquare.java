
import acm.program.*;
import java.util.ArrayList;

public class MagicSquare extends ConsoleProgram
{
    private static final int SIZE = 4;
    
    public void run()
    {
        int[][] square = getRandomSquare();
        while (!isMagic(square))
            square = getRandomSquare();
        print2D(square);
    }
    public int[][] getRandomSquare(){
        int[][] result = new int[SIZE][SIZE];
        
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i=1; i<=SIZE*SIZE; i++)
            numbers.add(i);
        
        for(int i=0; i<result.length; i++){
            for(int j=0; j<result[i].length; j++){
                int index = (int)(Math.random() * numbers.size());
                result[i][j] = numbers.remove(index);
            }
        }
        return result;
    }
    public void print2D(int[][] array){
        for(int i=0; i < array.length; i++){
            for(int j=0; j<array[i].length; j++)
                print(array[i][j] + " ");
            println();
        }   
    }
    
    public boolean isMagic(int[][] square){
        int magicSum = 0;
        for(int c=0; c<SIZE; c++)
            magicSum += square[0][c];
            
        for(int r=1; r<SIZE; r++){
            int sum = 0;
            for(int c=0; c<SIZE; c++)
                sum+=square[r][c];
            if(sum != magicSum)
                return false;
        }
        
        for (int c=0; c<SIZE; c++){
            int sum=0;
            for (int r=0; r<SIZE; r++)
                sum += square[r][c];
            if (sum != magicSum)
                return false;
        }
        
        int sum = 0;
        for (int i=0; i<SIZE; i++)
            sum += square[i][i];
        if(sum != magicSum)
            return false;
            
        sum = 0;
        for (int i=0; i<SIZE; i++)
            sum += square[i][SIZE-1-i];
        if(sum != magicSum)
            return false;

        return true;
    }
}
