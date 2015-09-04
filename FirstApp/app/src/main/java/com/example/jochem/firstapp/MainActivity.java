package com.example.jochem.firstapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;
import android.view.View.OnKeyListener;
import android.view.View;
import android.view.KeyEvent;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public EditText guessednumber;
    int somenumber = 5;
    Random rand = new Random();
    public int generatedNumber = rand.nextInt(1000) + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guessednumber = (EditText) findViewById(R.id.guessednumber);
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

    public void onButtonClick(View view) {

        TextView myTextView = (TextView) findViewById(R.id.textView);

        Random rand = new Random();
        int generatedNumber = rand.nextInt(1000) + 1;
        myTextView.setText("" + generatedNumber);


    }

    public void makeGuess(View view) {
        Button higherbutton = (Button) findViewById(R.id.button3);
        Button lowerbutton = (Button) findViewById(R.id.button2);
        TextView myTextView = (TextView) findViewById(R.id.textView);

        EditText guessednumber = (EditText) findViewById(R.id.guessednumber);
        int guessednumberint = Integer.parseInt(guessednumber.getText().toString());
        if (generatedNumber > guessednumberint) {
            higherbutton.setTextColor(Color.parseColor("#ff0000"));
            lowerbutton.setTextColor(Color.parseColor("#000000"));
        }
        else if (generatedNumber < guessednumberint) {
            lowerbutton.setTextColor(Color.parseColor("#ff0000"));
            higherbutton.setTextColor(Color.parseColor("#000000"));


            }
        else{myTextView.setText("The right number was " + generatedNumber);}

        }
    }
