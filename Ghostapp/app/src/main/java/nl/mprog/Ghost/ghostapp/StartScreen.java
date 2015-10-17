package nl.mprog.Ghost.ghostapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jochem.ghostapp.R;

//Jochem van Dooren (10572929
public class StartScreen extends AppCompatActivity {

    String player1string;
    String player2string;


    //start the game
    public void start(View v){
        //validate player names
        EditText player1 = (EditText) findViewById(R.id.player1);
        EditText player2 = (EditText) findViewById(R.id.player2);
        player1string = player1.getText().toString();
        player2string = player2.getText().toString();
        if (player1string.matches("")|| player2string.matches("") || player1string.equals(player2string)){
            Toast.makeText(getApplicationContext(), "Names must be filled in and not equal!",
                    Toast.LENGTH_LONG).show();

        }

        else {

            //start game and pass trough player names
            Intent startgame = new Intent(StartScreen.this, MainActivity.class);
            Bundle b2 = new Bundle();
            b2.putString("player1string", player1string);
            b2.putString("player2string", player2string);
            startgame.putExtras(b2);
            startActivity(startgame);
            finish();
        }



    }

    //navigate to highscores from startscreen
    public void highscores(View v) {
        Intent highscores = new Intent(StartScreen.this, HighScores.class);
        Bundle b = new Bundle();
        b.putString("player1string", null);
        b.putString("player2string", null);
        highscores.putExtras(b);
        startActivity(highscores);
        finish();
    }

    String buttontext;
    String language;
    public void switchlanguage(View v) {

        Button languageButton = (Button) findViewById(R.id.languageSwitch);
        buttontext = languageButton.getText().toString();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();

        //switches language based on current language
        if (prefs.contains("LANGUAGE")){
            language = prefs.getString("LANGUAGE", language);

            if (language.equals("dutch")){
                editor.putString("LANGUAGE", "english");
                languageButton.setText("English");
            }

            else{
                editor.putString("LANGUAGE", "dutch");
                languageButton.setText("Dutch");
            }
        }

        else{
            editor.putString("LANGUAGE", "english");
            languageButton.setText("English");
        }

        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        Button languageButton = (Button) findViewById(R.id.languageSwitch);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();

        //set last chosen language or dutch as default
        if (prefs.contains("LANGUAGE")){
            language = prefs.getString("LANGUAGE", language);

            if (language == null){
                editor.putString("LANGUAGE", "dutch");
                languageButton.setText("Dutch");

            }

            else if (language.equals("dutch")){
                languageButton.setText("Dutch");
            }

            else{
                languageButton.setText("English");
            }

        }

        else{
            languageButton.setText("Dutch");
            editor.putString("LANGUAGE", "dutch");
        }

        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_screen, menu);
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
