import java.util.Arrays;
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
       return Arrays.toString(answer);
    }
    
    private boolean game_over() //this dont work
    {
        for(int i=0;i<letters.length-1;i++)
        {
            if(!answer[i].equals(letters[i]))
            {
                return false;
            }
        }
        return true;
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
                if(game.guess_word(guess))
                {
                    game.answer = game.word.split("");
                }
            }
            else
            {
                if(game.guess_letter(guess))
                {
                    for(Integer n : game.letter_location(guess))
                    {
                        game.answer[n] = game.word.split("")[n];
                    }
                }
            }
            if(game.game_over())
            {
                System.out.println("You win!");
                break;
            }
            System.out.println(game.toString());
            
        }


        scan.close();
    }
    
}
