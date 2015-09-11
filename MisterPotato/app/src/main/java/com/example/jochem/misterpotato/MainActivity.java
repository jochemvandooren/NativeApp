package com.example.jochem.misterpotato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.CheckBox;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.armsCB:
                ImageView armsView = (ImageView)findViewById(R.id.arms);
                if (checked) {
                armsView .setVisibility(View.VISIBLE);


                }
                else
                armsView .setVisibility(View.INVISIBLE);
                break;

            case R.id.glassesCB:
                ImageView glassesView = (ImageView)findViewById(R.id.glasses);
                if (checked) {
                    glassesView .setVisibility(View.VISIBLE);


                }
                else
                    glassesView .setVisibility(View.INVISIBLE);
                break;

            case R.id.mustacheCB:
                ImageView mustacheView = (ImageView)findViewById(R.id.mustache);
                if (checked) {
                    mustacheView .setVisibility(View.VISIBLE);


                }
                else
                    mustacheView .setVisibility(View.INVISIBLE);
                break;

            case R.id.earsCB:
                ImageView earsView = (ImageView)findViewById(R.id.ears);
                if (checked) {
                    earsView .setVisibility(View.VISIBLE);


                }
                else
                    earsView .setVisibility(View.INVISIBLE);
                break;

            case R.id.hatCB:
                ImageView hatView = (ImageView)findViewById(R.id.hat);
                if (checked) {
                    hatView .setVisibility(View.VISIBLE);


                }
                else
                    hatView .setVisibility(View.INVISIBLE);
                break;

            case R.id.noseCB:
                ImageView noseView = (ImageView)findViewById(R.id.nose);
                if (checked) {
                    noseView .setVisibility(View.VISIBLE);


                }
                else
                    noseView .setVisibility(View.INVISIBLE);
                break;

            case R.id.eyebrowsCB:
                ImageView eyebrowsView = (ImageView)findViewById(R.id.eyebrows);
                if (checked) {
                    eyebrowsView .setVisibility(View.VISIBLE);


                }
                else
                    eyebrowsView .setVisibility(View.INVISIBLE);
                break;

            case R.id.mouthCB:
                ImageView mouthView = (ImageView)findViewById(R.id.mouth);
                if (checked) {
                    mouthView .setVisibility(View.VISIBLE);


                }
                else
                    mouthView .setVisibility(View.INVISIBLE);
                break;

            case R.id.shoesCB:
                ImageView shoesView = (ImageView)findViewById(R.id.shoes);
                if (checked) {
                    shoesView .setVisibility(View.VISIBLE);


                }
                else
                    shoesView .setVisibility(View.INVISIBLE);
                break;

            case R.id.eyesCB:
                ImageView eyesView = (ImageView)findViewById(R.id.eyes);
                if (checked) {
                    eyesView .setVisibility(View.VISIBLE);


                }
                else
                    eyesView .setVisibility(View.INVISIBLE);
                break;
            // TODO: Veggie sandwich
        }
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
