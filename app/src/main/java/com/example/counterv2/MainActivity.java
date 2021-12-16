package com.example.counterv2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {
    private int counter = 0;

    private void setDisplay(int value){
        this.setDisplay(String.format("%d", value));
    }

    private void setDisplay(String string){
        final TextView display = (TextView)findViewById(R.id.display);
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
        } else {
            // easter-egg
            setDisplay(":D");
        }
    }

    public void decrementDisplay(View view){
        if (counter > 0) {
            counter--;
            setDisplay(counter);
        }
    }
}