package com.example.dell.countappsp;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button black,red,blue,green;
    int cnt=0;
    private int colourCode;
    SharedPreferences sharedPreferences;
    private String spFileName="com.example.dell.countappsp";
    private String countKey="countKey";
    private String colorKey="colorKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.txt);
        black=findViewById(R.id.btn1);
        red=findViewById(R.id.btn2);
        blue=findViewById(R.id.btn3);
        green=findViewById(R.id.btn4);
        colourCode=ContextCompat.getColor(this,R.color.ash);
        sharedPreferences=getSharedPreferences(spFileName,MODE_PRIVATE);

      /*  if(sharedPreferences!=null){
            cnt=sharedPreferences.getInt(countKey,cnt);
            if(cnt!=0){
                tv.setText(String.valueOf(cnt));
            }
            colourCode=sharedPreferences.getInt(colorKey,cnt);
            tv.setBackgroundColor(colourCode);
        }*/

      cnt=sharedPreferences.getInt(countKey,cnt);
      tv.setText(String.valueOf(cnt));
      colourCode=sharedPreferences.getInt(colorKey,colourCode);
      tv.setBackgroundColor(colourCode);

    }

    public void count(View view) {
        cnt++;
        tv.setText(String.valueOf(cnt));
    }

    public void reset(View view) {
        cnt=0;
        tv.setText(""+cnt);
        colourCode=ContextCompat.getColor(this,R.color.ash);
        tv.setBackgroundColor(colourCode);
    }

    /*public void black(View view) {
        int cocolour= getResources().getColor(R.color.black);
        tv.setBackgroundColor(cocolour);
        colourCode=cocolour;
    }

    public void red(View view) {
        int  coColour= getResources().getColor(R.color.red);
        tv.setBackgroundColor(coColour);
        colourCode=coColour;
    }

    public void blue(View view) {
         int coColour= getResources().getColor(R.color.blue);
        tv.setBackgroundColor(coColour);
        colourCode=coColour;
    }

    public void green(View view) {
        int coColour= getResources().getColor(R.color.green);
        tv.setBackgroundColor(coColour);
        colourCode=coColour;
    }*/

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(countKey,cnt);
        editor.putInt(colorKey,colourCode);
        editor.apply();

    }

    public void changeBackGround(View view) {
        int clCode=((ColorDrawable)view.getBackground()).getColor();
        tv.setBackgroundColor(clCode);
        colourCode=clCode;

    }
}
