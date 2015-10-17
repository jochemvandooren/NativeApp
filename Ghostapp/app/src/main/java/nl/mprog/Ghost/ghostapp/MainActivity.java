package nl.mprog.Ghost.ghostapp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jochem.ghostapp.R;

//Jochem van Dooren (10572929
public class MainActivity extends AppCompatActivity {

    Game game;
    Lexicon lexicon;
    String currentword = "";
    String player1;
    String player2;
    boolean turn = true;
    String winningplayer = "";
    String language;



    //submit letter to play
    public void commit(View v){

        EditText userInput = (EditText) findViewById(R.id.inputLetter);
        TextView currentWord = (TextView) findViewById(R.id.currentWord);
        TextView ghost = (TextView) findViewById(R.id.currentlyPlaying);


        currentword = currentWord.getText().toString();
        String userinput = userInput.getText().toString();

        //validate userinput
        if (!userinput.equals("")) {
            userInput.setText("");

            //adds userinput to currentword
            currentword = game.guess(userinput, currentword);
            currentWord.setText(currentword);


            //checks if game has ended
            if (!game.ended(lexicon.result(lexicon.count(lexicon.filter(currentword, lexicon.currentfilter)), lexicon.filter(currentword, lexicon.currentfilter), currentword), currentword)) {
                System.out.println(lexicon.filter(currentword, lexicon.currentfilter));

                //players switching turns
                if (game.turn(turn) == false) {
                    ghost.setText(player2 + " is playing");
                    turn = false;
                    winningplayer = player1;
                }
                else {
                    ghost.setText(player1 + " is playing");
                    turn = true;
                    winningplayer = player2;
                }

            }
            else {

                //define winningplayer if first letter is incorrect for debugging purposes
                if (winningplayer.equals("")) {
                    winningplayer = player2;
                }

                //open victory screen
                Intent endscreen = new Intent(MainActivity.this, EndScreen.class);
                Bundle b = new Bundle();
                b.putString("winningplayer", winningplayer);
                b.putString("player1", player1);
                b.putString("player2", player2);
                b.putString("currentword", currentword);
                endscreen.putExtras(b);
                startActivity(endscreen);
                finish();
            }
        }

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create lexicon based on language chosen
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        language = prefs.getString("LANGUAGE", language);
        language = language + ".txt";
        lexicon = new Lexicon(this, language);
        game = new Game(lexicon);

        System.out.println(language);

        Bundle b = getIntent().getExtras();
        player1 = b.getString("player1string");
        player2 = b.getString("player2string");

        //redirects to startscreen if player not defined
        if (player1 == null && player2 == null){
            Intent newgame = new Intent(MainActivity.this, StartScreen.class);
            startActivity(newgame);
            finish();
        }

        TextView currentlyPlaying = (TextView) findViewById(R.id.currentlyPlaying);
        currentlyPlaying.setText(player1 + " is playing");

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


