package com.example.counterv2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    private SharedPreferences sharedPref;

    private int counter;


    private void setDisplay(int value){
        this.setDisplay(Integer.toString(value));
    }


    private void setDisplay(String string){
        final TextView display = findViewById(R.id.display);
        display.setText(string);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise data persistence
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        // load counter
        counter = sharedPref.getInt("counter", 0);

        //initialise display
        setDisplay(counter);
    }


    private void storeCounter(){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("counter", counter);
        editor.apply();
    }


    public void incrementDisplay(View view){
        if (counter < 1000) {
            counter++;
            setDisplay(counter);
            storeCounter();
        } else {
            // easter-egg
            setDisplay(":D");
        }
    }


    public void decrementDisplay(View view){
        if (counter > 0) {
            counter--;
            setDisplay(counter);
            storeCounter();
        }
    }


}