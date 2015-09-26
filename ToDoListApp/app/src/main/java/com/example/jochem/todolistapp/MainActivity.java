package com.example.jochem.todolistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    String[] toDotoDoArray = {"Click on me to remove me!","Click on me to remove me!","Click on me to remove me!"};
    ArrayList<String> toDoArray = new ArrayList<String>(Arrays.asList(toDotoDoArray));
    ListView toDoList;
    EditText toAdd;
    ArrayAdapter ArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            ArrayList<String> temporaryarray = savedInstanceState.getStringArrayList("LIST");
            toDoArray = temporaryarray;
        }


        ArrayAdapter<String> ArrayAdapter =  new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, toDoArray);
        toDoList = (ListView) findViewById(R.id.listView);
        toDoList.setAdapter(ArrayAdapter);



        toDoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                onListItemClick(v, pos, id);
            }

        });



    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList("LIST", toDoArray);
        super.onSaveInstanceState(outState);
    }

    protected void onListItemClick(View v, int pos, long id) {
        toDoArray.remove((int) id);
        ArrayAdapter<String> ArrayAdapter =  new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, toDoArray);
        Log.i("Leftoverlist", "onListItemClick id=" + toDoArray);

        toDoList.setAdapter(ArrayAdapter);
        ArrayAdapter.notifyDataSetChanged();





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
    public void AddToList(View v){
        toAdd = (EditText) findViewById(R.id.editText);


        Log.i("Leftoverlist", "onListItemClick id=" + toDoArray);

        toDoArray.add(toAdd.getText().toString());
        ArrayAdapter<String> ArrayAdapter =  new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, toDoArray);
        toAdd.getText().clear();
        toDoList.setAdapter(ArrayAdapter);
        ArrayAdapter.notifyDataSetChanged();

    }
}
