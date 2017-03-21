package com.example.mobileapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

public class Main2Activity extends AppCompatActivity {
    Switch sStart;
    int layoutNum;
    FrameLayout layout,layout1,layout2;
    GridLayout layout3,layout4;
    LinearLayout layout5;
    DatePicker dp;
    TimePicker tp;
    Button prev, next;
    EditText e1,e2,e3;
    TextView t_date,t_time,t_adult,t_mid,t_child;
    int num_adult, num_mid, num_child;

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
        layout5 = (LinearLayout)findViewById(R.id.Linearlayout5);
        dp = (DatePicker) findViewById(R.id.datePicker);
        tp = (TimePicker)findViewById(R.id.timePicker);
        prev = (Button) findViewById(R.id.bPrev);
        next = (Button) findViewById(R.id.bNext);
        e1 = (EditText)findViewById(R.id.editText9);
        e2 = (EditText)findViewById(R.id.editText10);
        e3 = (EditText)findViewById(R.id.editText11);
        t_date = (TextView)findViewById(R.id.textView13);
        t_time = (TextView)findViewById(R.id.textView15);
        t_adult = (TextView)findViewById(R.id.textView17);
        t_mid = (TextView)findViewById(R.id.textView19);
        t_child = (TextView)findViewById(R.id.textView21);



        sStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                layout.setVisibility(View.VISIBLE);
                layout1.setVisibility(View.VISIBLE);
                layout5.setVisibility(View.VISIBLE);
                layoutNum = 1;

            }
        });
    }

    public void onMyclick(View v){
        if(v.getId() == R.id.bNext){

            if(layoutNum < 4) layoutNum++;

            if(layoutNum == 2){
                prev.setEnabled(true);
                layout2.setVisibility(View.VISIBLE);
                layout1.setVisibility(View.INVISIBLE);
            }
            else if(layoutNum == 3){
                next.setEnabled(true);
                layout3.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.INVISIBLE);

            }
            else if(layoutNum == 4){
                init_numOfPeople();
                layout4.setVisibility(View.VISIBLE);
                layout3.setVisibility(View.INVISIBLE);
                print();
                next.setEnabled(false);
            }

        }
        else if(v.getId() == R.id.bPrev){

                if(layoutNum > 0) layoutNum--;

                if(layoutNum == 3){
                    layout3.setVisibility(View.VISIBLE);
                    layout4.setVisibility(View.INVISIBLE);
                    next.setEnabled(true);
                }
                else if(layoutNum == 2){
                    layout2.setVisibility(View.VISIBLE);
                    layout3.setVisibility(View.INVISIBLE);
                }
                else if(layoutNum == 1){
                    layout1.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.INVISIBLE);
                    prev.setEnabled(false);
                }

        }
    }

    public void print() {
        t_date.setText(dp.getYear() + "년/" + dp.getMonth()+ "월/" + dp.getDayOfMonth()+"일");
        t_time.setText(tp.getCurrentHour() + "시/" + tp.getCurrentMinute() +"분" );
        t_adult.setText(num_adult+"명");
        t_mid.setText(num_mid+"명");
        t_child.setText(num_child+"명");
    }

    private void init_numOfPeople() {
        num_adult = Integer.parseInt(e1.getText().toString());
        num_mid = Integer.parseInt(e2.getText().toString());
        num_child = Integer.parseInt(e3.getText().toString());
    }


}
