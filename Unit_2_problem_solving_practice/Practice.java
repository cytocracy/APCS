import java.util.ArrayList;

public class Practice
{
    public boolean containsNoWordsShorterThanFiveLetters(String[] words)
    {
        for(int i=0; i< words.length; i++){
            if(words[i].length() < 5) return false;
        }
        
        return true; 
    }

    public void removeAllCatWords(ArrayList<String> words)
    {
        for (int i=0; i <words.size(); i++){
            if(words.get(i).length() > 2 && words.get(i).substring(0, 3).equals("cat")) {
                words.remove(i);
                i--;
            }
        }
    }

    public int countAdjacentMultiplesOfTen(ArrayList<Integer> nums)
    {
        int counter = 0;
        for(int i=0; i<nums.size()-1; i++){
            if(nums.get(i) % 10 == 0 && nums.get(i+1) % 10 ==0) counter++;
        
        }
        return counter;
    }

    public boolean sameNumberOfFiveAndSevenFactors(int[] nums)
    {
        int count5 = 0;
        int count7 = 0;
        for (int i=0; i < nums.length; i++){
            if(nums[i] % 5 == 0) count5++;
            if(nums[i] % 7 == 0) count7++;
        }
        return count5 == count7;
    }

    public boolean hasWordBetween5and10LettersLong(String[] words)
    {
        for (String word : words){
            if (word.length() >= 5 && word.length() <= 10 ) return true;
        }
        return false;
    }

    public boolean containsKwordAndMword(ArrayList<String> words)
    {
        boolean foundK = false;
        boolean foundM = false;
        
        for (String word : words){
            if(word.indexOf("k") == 0) foundK = true;
            if(word.indexOf("m") == 0) foundM = true;
        }
        return foundK && foundM;
    }
        
    public int biggestEvenNumber(int[] nums)
    {
        int champion = -1;
        for (int n : nums){
            if(n % 2 == 0 && n > champion) champion = n;
        
        }
        return champion;
    }
    
    public ArrayList<String> getAllWordsSameLengthAsFirstWord(String[] words)
    {
        int length = words[0].length();
        ArrayList<String> result = new ArrayList<String>();
        for(String word : words){
            if(word.length() == length) result.add(word);
        }
        
        return result;
    }
}