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
import ru.hse.iot.practice.presenter.Presenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Model model = new Model();
        Presenter presenter = new Presenter(this);
        ToggleButton red = (ToggleButton) findViewById(R.id.red);
        red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    presenter.turnOnLight("red","on");
                } else {
                    presenter.turnOnLight("red","off");
                }
            }
        });
        ToggleButton green = (ToggleButton) findViewById(R.id.green);
        green.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    presenter.turnOnLight("green","on");
                } else {
                    presenter.turnOnLight("green","off");
                }
            }
        });
        ToggleButton blue = (ToggleButton) findViewById(R.id.blue);
        blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    presenter.turnOnLight("blue","on");
                } else {
                    presenter.turnOnLight("blue","off");
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
                presenter.sendText(((EditText)findViewById(R.id.editText)).getText().toString());
            }
        });
        TextView tempTextView = (TextView)findViewById(R.id.tempTextView);
        Button getTempButton = (Button) findViewById(R.id.getTempButton);
        getTempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getTemp();
            }
        });
    }

    private void play(){

    }
    private void stop(){

    }
    private void pause(){

    }

    public void showTemp(String temp) {
        TextView tempTextView = (TextView)findViewById(R.id.tempTextView);
        tempTextView.setText(temp);
    }
}
