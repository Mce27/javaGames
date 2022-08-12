import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class hangman 
{
    private String word;
    private String[] letters;
    private String[] answer;
    
    hangman()
    {
        word = "test";
        letters = word.split("");
        answer = new String[word.length()];
        for(String a: answer)
        {
            a="_";
        }
    }

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

    @Override
    public String toString()
    {
        return answer.toString();
    }

    

    public static void main(String args[])
    {
        hangman game = new hangman();
        Scanner scan = new Scanner(System.in);
        String guess;
        while(true)
        {   
            System.out.println("Enter your Guess: ");
            guess = scan.nextLine();
            if( guess.equals("quit"))
            {
                break;
            }
            else if(guess.length()<1)
            {
                game.guess_word(guess);
            }
            else
            {
                game.guess_letter(guess);
            }
            System.out.println(game);
            
        }


        scan.close();
    }
    
}
