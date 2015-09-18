package com.example.jochem.madlibspoging2;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import com.example.jochem.madlibspoging2.Story;
import android.widget.TextView;
import android.widget.EditText;
import java.io.InputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Create story and save to storystring
        InputStream is = this.getResources().openRawResource(R.raw.story);
        Story Storyobject = new Story(is);
        String storystring = Storyobject.toString();
        Storyobject.read(is);

        //Create string wordsleft
        TextView wordsleft = (TextView) findViewById(R.id.wordsLeft);
        wordsleft.setText("" + Storyobject.getPlaceholderCount() + " word(s) left!");

        //Create hint for word
        String hint = "" + Storyobject.getNextPlaceholder();
        EditText edittext = (EditText) findViewById(R.id.editText);
        edittext.setText("Fill in a " + hint);

        //create input for button and text
        final Button input = (Button)findViewById(R.id.button);

    }


    public void switchScreen3(View v){
        startActivity(new Intent(Main2Activity.this, Main3Activity.class));
    }

    public void submitword(View v){

        InputStream is = this.getResources().openRawResource(R.raw.story);
        Story Storyobject = new Story(is);

        EditText getWord = (EditText)findViewById(R.id.editText);
        String string = getWord.getText().toString();
        System.out.println(string);
        Storyobject.fillInPlaceholder(string);
        getWord.setText("");

        //new hint
        String hint = "" + Storyobject.getNextPlaceholder();
        EditText edittext = (EditText) findViewById(R.id.editText);
        edittext.setText("Fill in a " + hint);

        //update count
        TextView wordsleft = (TextView) findViewById(R.id.wordsLeft);
        wordsleft.setText("" + Storyobject.getPlaceholderCount() + " word(s) left!");





        String storystring = Storyobject.toString();
        System.out.println(storystring);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
