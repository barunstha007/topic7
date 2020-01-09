package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {

    EditText etWord,etDefination;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        etWord = findViewById(R.id.etWord);
        etDefination = findViewById(R.id.etDefination);
        btnAdd= findViewById(R.id.btnAdd);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE | MODE_APPEND));
                    printStream.println(etWord.getText().toString()+"->"+etDefination.getText().toString());
                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Log.d("Dictionary app", "Error" + e.toString());
                    e.printStackTrace();


                }
            }
        });
    }
}
