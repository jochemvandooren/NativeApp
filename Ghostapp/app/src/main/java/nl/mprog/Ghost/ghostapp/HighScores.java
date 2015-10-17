package nl.mprog.Ghost.ghostapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jochem.ghostapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//Jochem van Dooren (10572929
public class HighScores extends AppCompatActivity {
    String player1;
    String player2;
    String winningplayer;
    Set<String> HIGHSCORES;
    List<String> data = new ArrayList<>();

    //navigates to homescreen
    public void newgame(View v) {
        Intent newgame = new Intent(HighScores.this, StartScreen.class);
        startActivity(newgame);
        finish();

    }

    //restarts game
    public void rematch(View v) {
        Intent rematch = new Intent(HighScores.this, MainActivity.class);
        Bundle b5 = new Bundle();
        b5.putString("player1string", player1);
        b5.putString("player2string", player2);
        rematch.putExtras(b5);
        startActivity(rematch);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        Bundle b = getIntent().getExtras();
        player1 = b.getString("player1string");
        player2 = b.getString("player2string");

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        HIGHSCORES = prefs.getStringSet("HIGHSCORES", HIGHSCORES);

        //load highscores in listview
        for (String h : HIGHSCORES) {
            data.add(h);
        }
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) data);
        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(itemsAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_high_scores, menu);
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
