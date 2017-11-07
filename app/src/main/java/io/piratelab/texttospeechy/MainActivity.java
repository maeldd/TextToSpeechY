package io.piratelab.texttospeechy;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener {

    EditText text_input;
    Button button_speak, button_clear;
    TextToSpeech tts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_input = (EditText) findViewById(R.id.text_input);
        button_clear = (Button) findViewById(R.id.button_clear);
        button_speak = (Button) findViewById(R.id.button_speak);
        button_clear.setOnClickListener(this);
        button_speak.setOnClickListener(this);

        tts = new TextToSpeech(this, this);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_clear:
                text_input.setText("");
                break;
            case R.id.button_speak:
                String text = text_input.getText().toString();
                if (text.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vous n'avez rien écrit", Toast.LENGTH_SHORT).show();
                } else {
                    tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                }
                break;
        }

    }
}
