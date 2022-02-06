import java.util.Scanner;
import java.io.*;

public class CaesarCipher{
    public static StringBuffer encrypt(String text, int s){
        String symbols = " ,.!?;:()'";
        StringBuffer result= new StringBuffer();
        for (int i=0; i<text.length(); i++)
        {
            String t = text.substring(i, i+1);
            if(symbols.indexOf(t) != -1){
                result.append(t);
            }
            else if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

}
