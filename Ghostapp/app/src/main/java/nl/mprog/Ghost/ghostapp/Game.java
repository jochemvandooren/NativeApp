package nl.mprog.Ghost.ghostapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

//Jochem van Dooren (10572929
public class Game extends AppCompatActivity {
    Lexicon lexicon;

    public Game(Lexicon lexicon){
        this.lexicon = lexicon;
    }

    String wordcheck;
    //add letter to currentword
    public String guess(String input, String currentword){
        //check if user input is valid
        if (input.equals(" ") || input.length()> 1 || input.equals("") ) {
            return currentword;
        }

        else{
            currentword = currentword.concat(input);
        }

        return currentword;
    }



    //switches turns when called
    public boolean turn(boolean turn){
        if (turn) return false;
        else{
            return true;

        }
    }

    boolean ended = false;
    //checks if game should be over
    public boolean ended(String result, String currentword){
        if (result.equals(currentword) && currentword.length() > 3 || lexicon.count(lexicon.filter(currentword, lexicon.currentfilter)) == 0){
            ended = true;
            return ended;
        }
        else{
            return ended;
        }
    }




}
