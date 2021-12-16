package com.example.counterv2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    private SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
    private SharedPreferences.Editor editor = sharedPref.edit();

    private void storeCounter(){
        editor.putInt("counter", counter);
        editor.apply();
    }

    private int loadCounter(){
        return sharedPref.getInt("counter", 0);
    }

    private int counter = loadCounter();

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

        //initialise display
        setDisplay(counter);
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