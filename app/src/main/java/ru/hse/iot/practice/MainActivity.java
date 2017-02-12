package ru.hse.iot.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import ru.hse.iot.practice.model.Model;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Model model = new Model();
        ToggleButton red = (ToggleButton) findViewById(R.id.red);
        red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    model.turnOnLight("red","1");
                } else {
                    model.turnOnLight("red","0");
                }
            }
        });
        ToggleButton green = (ToggleButton) findViewById(R.id.green);
        green.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    model.turnOnLight("green","1");
                } else {
                    model.turnOnLight("green","0");
                }
            }
        });
        ToggleButton blue = (ToggleButton) findViewById(R.id.blue);
        blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    model.turnOnLight("blue","1");
                } else {
                    model.turnOnLight("blue","0");
                }
            }
        });
        ((Button) findViewById(R.id.play)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.player("play");
            }
        });
        ((Button) findViewById(R.id.stop)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.player("stop");
            }
        });
        ((Button) findViewById(R.id.pause)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.player("pause");
            }
        });
        ((Button)findViewById(R.id.send)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.sendText(((EditText)findViewById(R.id.editText)).getText().toString());
            }
        });

    }

    private void play(){

    }
    private void stop(){

    }
    private void pause(){

    }
}
