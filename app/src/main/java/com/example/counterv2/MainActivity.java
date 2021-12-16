package com.example.counterv2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {
    private int counter = 0;

    private void setDisplay(int value){
        final TextView display = (TextView)findViewById(R.id.display);
        display.setText(String.format("%d", value));
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
        }
    }

    public void decrementDisplay(View view){
        if (counter > 0) {
            counter--;
            setDisplay(counter);
        }
    }
}