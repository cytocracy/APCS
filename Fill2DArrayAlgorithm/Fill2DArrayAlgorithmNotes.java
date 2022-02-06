

public class Fill2DArrayAlgorithmNotes
{

    public int[][] getGridOfNumbersUsingCounterStartingAtOne(int rows, int cols)
    {
       int[][] result = new int[rows][cols];
       int counter = 1;
       for(int r=0; r<rows; r++){
           for(int c=0; c<cols; c++){
               result[r][c] = counter;
               counter++;
            }
        }
    }
    
    public int[][] getGridOfNumbersUsingCounter(int rows, int cols)
    {
       int[][] result = new int[rows][cols];
       for(int r=0; r<rows; r++){
           for(int c=0; c<cols;c++){
               result[r][c] = r * cols + c;
            }
        }
        return result;
    }

    public int[][] getGridOfNumbersUsingMath(int rows, int cols)
    {
    }
    
    public int[][] getGridOfNumbersUsingMathColumnMajorOrder(int rows, int cols)
    {
    }
    
    public String[][] getGridOfWordsUsingMath (int rows, int cols, String[] words)
    {
    }
    
    public String[][] getGridOfWordsUsingMathIfPresent (int rows, int cols, String[] words)
    {
    }
    
    public String[][] getGridOfWordsColumnMajorUsingMathIfPresent (int rows, int cols, String[] words)
    {
    }
}
