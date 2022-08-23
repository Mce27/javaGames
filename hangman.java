import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class hangman 
{
    private String word;
    private String[] letters;
    private String[] answer;
    private int answercount;
    private int wordcount;
    private boolean GAMEOVER;
    private int WrongCount;
    
    private static String NoneWrong = "_____\n|   |\n|   \n|  \n|";
    private static String OneWrong= "_____\n|   |\n|   O\n|  \n|";
    private static String TwoWrong= "_____\n|   |\n|   O\n|   |\n|";
    private static String ThreeWrong= "_____\n|   |\n|   O\n|  /|\n|";
    private static String FourWrong= "_____\n|   |\n|   O\n|  /|/\n|";
    private static String FiveWrong= "_____\n|   |\n|   O\n|  /|/\n|  /";
    private static String SixWrong = "_____\n|   |\n|   O\n|  /|/\n|  // ";
    private static String[] WrongImg= new String[7];
    
 

    hangman()
    {
        WrongImg[0] = NoneWrong;
        WrongImg[1] = OneWrong;
        WrongImg[2] = TwoWrong;
        WrongImg[3] = ThreeWrong;
        WrongImg[4] = FourWrong;
        WrongImg[5] = FiveWrong;
        WrongImg[6] = SixWrong;

        word = get_word();
        letters = word.split("");
        answer = new String[word.length()];
        for(String a: answer)
        {
            a="_";
        }
        answercount=0;
        wordcount=letters.length;
        GAMEOVER=false;
        WrongCount=0;
    }

    private String get_word()
    {
        Random rand = new Random();
        try 
        {
            Scanner scan = new Scanner(new File("./dictionary.txt"));
            String out= "";
            int target = rand.nextInt(1,69903);
            for (int i =0;i<target-1;i++)
            {
                out = scan.nextLine();
            }
            return out;
            
        } 
        catch (FileNotFoundException e) 
        {/*watermelon*/ } 
        return "poop";      
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
        WrongCount++;
        return false;
    }
    
    private boolean guess_word(String guess)
    {
        if(word.equals(guess))
        {
            GAMEOVER= true;
            return true;
        }
        else
        {
            WrongCount++;
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
       return WrongImg[WrongCount]+"\n"+ Arrays.toString(answer) ;
    }
    
    private boolean game_over() 
    {
        
        if(answercount==wordcount || GAMEOVER==true)
        {
            System.out.println(toString());
            System.out.println("You win! \nThe word was "+word+"!");
            return true;
        }
        else if(WrongCount ==6)
        {
            System.out.println(toString());
            System.out.println("You lost :(\nThe word was "+word+ "\nTry again?");
            return true;
        }
        
        return false;
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
            else if(guess.length()>1)
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
                        game.answercount++;
                    }
                }
            }
            if(game.game_over())
            {
                
                break;
            }
            System.out.println(game.toString());
            
        }


        scan.close();
    }
    
}
