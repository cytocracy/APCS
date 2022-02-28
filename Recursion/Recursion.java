

public class Recursion
{

    public static int sum(int n){
        if(n>0){
            return n+ sum(n-1);
        } else {
            return 0;
        }    
    }
    
    public static void main(String[] args){
        int result = fibonacci(0);
        System.out.println(result);
    }
    
    public static int factorial(int n){
        if(n>0) return n * factorial(n-1);
        else return 1;
    }
    
    public static int fibonacci(int n){
        if(n>1) return fibonacci(n-1) + fibonacci(n-2);
        else if(n>0) return 1;
        else return 0;
    }


}
