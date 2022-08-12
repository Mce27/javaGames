import java.util.LinkedList;
import java.util.List;

public class hangman 
{
    String word;
    String[] letters;
    private boolean guess_letter(String x)
    {
        for( String n : letters)
        {
            if(x.equals(n))
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean guess_word(String guess)
    {
        if(word.equals(guess))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private List<Integer> letter_location(String letter)
    {
        List<Integer> locations =new LinkedList<>();
        for(int i = 0; i<letters.length;i++)
        {
            if(letters[i].equals(letter))
            {
                locations.add(i);
            }
        }
        return locations;
    }

    public static void main(String args[])
    {

    }
    
}
