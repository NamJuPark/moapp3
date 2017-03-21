package com.example.mobileapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;

public class Main2Activity extends AppCompatActivity {
    Switch sStart;
    FrameLayout layout,layout1,layout2;
    GridLayout layout3,layout4;
    DatePicker dp;
    Button prev, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sStart = (Switch) findViewById(R.id.switch1);
        layout = (FrameLayout) findViewById(R.id.layout);
        layout1 = (FrameLayout) findViewById(R.id.layout1);
        layout2 = (FrameLayout) findViewById(R.id.layout2);
        layout3 = (GridLayout) findViewById(R.id.layout3);
        layout4 = (GridLayout) findViewById(R.id.layout4);
        dp = (DatePicker) findViewById(R.id.datePicker);
        prev = (Button) findViewById(R.id.bPrev);
        next = (Button) findViewById(R.id.bNext);


        sStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                layout.setVisibility(View.VISIBLE);


            }
        });

    }



}
