import java.math.*;
import java.util.*;

public class Cryptography
{
    
    private String alphabet;
    private String numbers;
    
    
    public Cryptography()
    {
        alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz .,?!;:()'";
        numbers = "0123456789";
    }
    
    
    public String base10ToBaseN(int base, String input1){
        if(input1.equals("0")) return "";
        BigInteger input = new BigInteger(input1);

        String output = "";
        //int quotient = input;
        BigInteger bigBase = BigInteger.valueOf(base);

        //while(input.max(BigInteger.valueOf(base)).equals(input)){
        output = charAt(input.mod(bigBase).intValue()) + output;
        BigInteger newInput = input.divide(bigBase);

        //}
        /*while (input >= base){
        long l = base;
        output = charat((int)(input % base)) + output;
        input /= base;
        }*/
        //output = input.toString() + output;

        //input /= base;
        //println(newInput.toString());
        return base10ToBaseN(base, newInput.toString()) + output;
        //return output;
    }

    public String baseNToBase10(int base, String input){
        String output = "";
        int len = input.length();
        int power = 1;
        BigInteger num = new BigInteger("0");
        BigInteger bigPower = new BigInteger("1");
        BigInteger bigBase = BigInteger.valueOf(base);

        for(int i = len - 1; i>=0; i--){
            int val = val(input.charAt(i));
            if(val > base) return "-1";

            //BigInteger bigPower = BigInteger.valueOf(power);
            BigInteger bigValue = BigInteger.valueOf(val(input.charAt(i)));
            BigInteger addValue = bigPower.multiply(bigValue);
            num = num.add(addValue);

            //num.add(new BigInteger(String.valueOf(val(input.charAt(i)).multiply(new BigInteger(String.valueOf(power)))));
            //num += val(input.charAt(i)) * power;
            //println("e: " + bigBase.toString());
            //println("f: " + String.valueOf(base));
            bigPower = bigPower.multiply(bigBase);//power = power * base;
        }
        return num.toString();
    }

    public String baseNToBaseN(String input, int base1, int base2){
        return base10ToBaseN(base2, baseNToBase10(base1, input));
    }

    public int val(char c){
        return alphabet.indexOf(c);
    }

    public String charAt(int index){
        return alphabet.substring(index, index+1);
    }


}
