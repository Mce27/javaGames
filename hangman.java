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
    public static void main(String args[])
    {

    }
    
}
