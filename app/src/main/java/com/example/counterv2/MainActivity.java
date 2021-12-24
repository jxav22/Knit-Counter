/*
TODO:
Figure out a better name for this.
    The Greatest Knit Counter to Currently Exist on Wear OS -> TGKCTCEOWO
    Knit Counter
    Counter
Resolve 'Git is not installed' event log backup
Test on Hannah's galaxy watch
Make a cool icon for it
 */

package com.example.counterv2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.support.wearable.activity.WearableActivity;


public class MainActivity extends WearableActivity {

    private SharedPreferences sharedPref;

    private int counter;

    public TextView display;


    private void setDisplay(int value){
        this.setDisplay(Integer.toString(value));
    }


    private void setDisplay(String string){
        final TextView display = findViewById(R.id.display);
        display.setText(string);
    }


    private void storeCounter(){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("counter", counter);
        editor.apply();
    }


    private void incrementDisplay(){
        if (counter < 999) {
            counter++;
            setDisplay(counter);
            storeCounter();
        } else {
            // easter-egg
            setDisplay(":D");
        }
    }


    private void decrementDisplay(){
        if (counter > 0) {
            counter--;
            setDisplay(counter);
            storeCounter();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // enable always-on
        setAmbientEnabled();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_main);

        // initialise data persistence
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        // load counter
        counter = sharedPref.getInt("counter", 0);

        // initialise display
        setDisplay(counter);

        // initialise buttons
        Button decrementButton = findViewById(R.id.decrementButton);
        Button incrementButton = findViewById(R.id.incrementButton);

        decrementButton.setOnTouchListener(new RepeatListener(5000, 100, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // the code to execute repeatedly
                decrementDisplay();
            }
        }));

        incrementButton.setOnTouchListener(new RepeatListener(5000, 100, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // the code to execute repeatedly
                incrementDisplay();
            }
        }));
    }

}