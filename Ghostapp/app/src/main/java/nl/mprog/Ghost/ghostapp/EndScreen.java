package nl.mprog.Ghost.ghostapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.jochem.ghostapp.R;

import java.util.HashSet;
import java.util.Set;

//Jochem van Dooren (10572929
public class EndScreen extends AppCompatActivity {

    String player1;
    String player2;
    String language;
    Set<String> HIGHSCORES = new HashSet<String>();

    //navigate to start screen
    public void newgame(View v) {
        Intent newgame = new Intent(EndScreen.this, StartScreen.class);
        startActivity(newgame);
        finish();

    }

    //restart the game
    public void rematch(View v) {
        Intent rematch = new Intent(EndScreen.this, MainActivity.class);
        Bundle b3 = new Bundle();
        b3.putString("player1string", player1);
        b3.putString("player2string", player2);
        rematch.putExtras(b3);
        startActivity(rematch);
        finish();
    }

    //navigate to highscores
    public void highscores(View v) {
        Intent highscores = new Intent(EndScreen.this, HighScores.class);
        Bundle b4 = new Bundle();
        b4.putString("player1string", player1);
        b4.putString("player2string", player2);
        highscores.putExtras(b4);
        startActivity(highscores);
        finish();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);


        //retrieve currentword and winningplayer
        Bundle b = getIntent().getExtras();
        String winningplayer = b.getString("winningplayer");
        String endword = b.getString("currentword");

        TextView endWord = (TextView) findViewById(R.id.endWord);
        TextView winningPlayer = (TextView) findViewById(R.id.winningPlayer);

        endWord.setText(endword);
        winningPlayer.setText(winningplayer + " has won the game!");

        player1 = b.getString("player1");
        player2 = b.getString("player2");



        //create highscores
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();

        language = prefs.getString("LANGUAGE",language);


        int score;
        String lasthighscore = "";
        String updatehighscore = "";
        if (prefs.contains("HIGHSCORES")) {
            HIGHSCORES = prefs.getStringSet("HIGHSCORES", HIGHSCORES);
            for (String s : HIGHSCORES) {
                //if winning player already exists in highscores add 1 to score
                if (s.startsWith(winningplayer + "_")) {
                    String[] splitted = s.split("_");
                    score = Integer.parseInt(splitted[1]);
                    score = score + 1;
                    updatehighscore = winningplayer + "_" + score;
                    lasthighscore = s;
                }
            }
            //update highscore from existing player
            if (updatehighscore != "") {
                HIGHSCORES.remove(lasthighscore);
                HIGHSCORES.add(updatehighscore);

            }

            else{
                HIGHSCORES.add(winningplayer + "_1");
            }
        }

        else{
            HIGHSCORES.add(winningplayer + "_1");
        }

        editor.putStringSet("HIGHSCORES", HIGHSCORES);
        editor.putString("LANGUAGE", language);
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_end_screen, menu);
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
