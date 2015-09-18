package com.example.jochem.madlibspoging2;


import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.app.Activity;
import android.content.res.AssetManager;
import android.widget.TextView;
import java.io.InputStream;


public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        InputStream is = this.getResources().openRawResource(R.raw.story);
        Story Storyobject = new Story(is);
        String storystring = Storyobject.toString();
        System.out.println(storystring);
        System.out.println(R.id.storytext);

        TextView myTextView = (TextView) findViewById(R.id.storytext);
        System.out.println(myTextView);
        myTextView.setText("" + storystring);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main3, menu);
        return true;
    }

    public void switchScreen(View v){
        startActivity(new Intent(Main3Activity.this, com.example.jochem.madlibspoging2.MainActivity.class));
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
