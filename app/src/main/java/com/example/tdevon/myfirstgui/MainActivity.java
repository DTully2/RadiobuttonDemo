package com.example.tdevon.myfirstgui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewColor;
    CheckBox CheckBoxBold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewColor = findViewById(R.id.textViewColor);
        CheckBoxBold= findViewById(R.id.checkBoxBold);
    }

    public void onRadioClick(View view) {
        switch( view.getId())
        {
            case R.id.radioButtonRed:
            textViewColor.setText(R.string.BubbleRed);
            textViewColor.setBackgroundColor(Color.RED);
                break;
            case R.id.radioButtonGreen:
                textViewColor.setText(R.string.BubbleGreen);
                textViewColor.setBackgroundColor(Color.GREEN);
                break;
            case R.id.radioButtonBlue:
                textViewColor.setText(R.string.BubbleBlue);
                textViewColor.setBackgroundColor(Color.BLUE);
                break;
        }
    }

    public void OnCheckBoxClick(View view) {
        if (CheckBoxBold.isChecked() == true)
            textViewColor.setTypeface(Typeface.DEFAULT_BOLD);
        else
            textViewColor.setTypeface(Typeface.DEFAULT);
    }

    @Override
    protected void onPause() {
        SharedPreferences settings = getSharedPreferences("dataperstistance", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("color", textViewColor.getText().toString());
        editor.putBoolean("cbstate", CheckBoxBold.isChecked());
        editor.apply();//writes shared prefs to the file
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences settings = getSharedPreferences("dataperstistance",Context.MODE_PRIVATE);
        CheckBoxBold.setChecked(settings.getBoolean("cbstate",false));
        String temp = settings.getString("color","color");
        if(temp.equals("Red"))
        {
            RadioButton radioButton = findViewById(R.id.radioButtonRed);
            radioButton.setChecked(true);
            textViewColor.setText(R.string.BubbleRed);
            textViewColor.setBackgroundColor(Color.RED);
        }
        else if(temp.equals("Green"))
        {
            RadioButton radioButton = findViewById(R.id.radioButtonGreen);
            radioButton.setChecked(true);
            textViewColor.setText(R.string.BubbleGreen);
            textViewColor.setBackgroundColor(Color.GREEN);
        }
        else if(temp.equals("Blue"))
        {

            RadioButton radioButton = findViewById(R.id.radioButtonBlue);
            radioButton.setChecked(true);
            textViewColor.setText(R.string.BubbleBlue);
            textViewColor.setBackgroundColor(Color.BLUE);
        }
        if (CheckBoxBold.isChecked() == true)
            textViewColor.setTypeface(Typeface.DEFAULT_BOLD);
        else
            textViewColor.setTypeface(Typeface.DEFAULT);

    }
}