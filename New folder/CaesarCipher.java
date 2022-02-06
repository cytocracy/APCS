



import java.util.Scanner;
    import java.io.*;//A Java Program to illustrate Caesar Cipher Technique

    // Encrypts text using a shift od s
    

 public class CaesarCipher{
     
/*public class CaesarCipherMain {
    public static final String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz .,?!;:()";
    // static because all other functions are static, and we can't reference from a
    // non-static
 
    public static String encoding(String plainT, int shift) {
        plainT = plainT.toLowerCase();
        // converting the text to lowercase
        String cipherT = "";
        // initializing empty string to add alphabets iteratively
        for (int i = 0; i < plainT.length(); i++) {
            int mappingV = alph.indexOf(plainT.charAt(i));
            // value of each alphabet in integers like for A=0, B=1 ...
            int enVal = (shift + mappingV) % 26;
            char Val = alph.charAt(enVal); // the character to be replaced
            cipherT = cipherT + Val; // adding to ciphertext
        }
        return cipherT;
    }
 
    // following same algorithm but in reverse way, plaintext becomes
    // ciphertext and vice versa
    public static String decoding(String cipherT, int shift) {
        cipherT = cipherT.toLowerCase();
        // converting the text to lowercase
        String plainT = "";
        // initializing empty string to add alphabets iteratively
        for (int i = 0; i < cipherT.length(); i++) {
            int mappingV = alph.indexOf(cipherT.charAt(i));
            int deVal = (mappingV - shift) % 26;
            if (deVal < 0) // to handle the negative values
            {
                deVal = alph.length() + deVal;
            }
            char Val = alph.charAt(deVal); // the character to be replaced
            plainT = plainT + Val; // adding to plaintext
        }
        return plainT;
    }*/
public static StringBuffer encrypt(String text, int s)

    {
        String symbols = " ,.!?;:()'";
 
        StringBuffer result= new StringBuffer();
        
        //if(t.equals(" ") || t.equals(".") || t.equals(",") || t.equals("?") || t.equals("!") || t.equals(";") || t.equals(":") || t.equals("(") || t.equals(")"))
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
    
    

    // Driver code
    /*public static void main(String[] args)
    {
        String text = "ATTACKATONCE";
        int s = 4;
        System.out.println("Text : " + text);
        System.out.println("Shift : " + s);
        System.out.println("Cipher: " + encrypt(text, s));
    }*/
}
