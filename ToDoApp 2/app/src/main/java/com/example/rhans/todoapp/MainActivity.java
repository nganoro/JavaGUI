package com.example.rhans.todoapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
String userItem = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText input = (EditText) findViewById(R.id.editText);

        final RadioButton rbLow = (RadioButton) findViewById(R.id.rbLow);
        final RadioButton rbMed = (RadioButton) findViewById(R.id.rbMed);
        final RadioButton rbHigh = (RadioButton) findViewById(R.id.rbHigh);
        Button SwitchtoList = (Button) findViewById(R.id.btnSwitchtoList);

        SwitchtoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, ListInterface.class);
                startActivity(intent);
            }
        });

        Button addList = (Button) findViewById(R.id.btAdd);

        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userItem = input.getText().toString();
                ListInterface listInterface = new ListInterface();
                if(userItem.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter a list name", Toast.LENGTH_LONG).show();

                }
                else if(rbLow.isChecked()) {
                    userItem=userItem+" (Low)";
                    listInterface.addList(userItem);
                    Toast.makeText(MainActivity.this,"Added "+userItem+" to the list", Toast.LENGTH_LONG).show();

                }
                else if(rbMed.isChecked()) {
                    userItem=userItem+" (Medium)";
                    listInterface.addList(userItem);
                    Toast.makeText(MainActivity.this,"Added "+userItem+" to the list", Toast.LENGTH_LONG).show();
                }
                else if(rbHigh.isChecked()) {
                    userItem=userItem+" (High)";
                    listInterface.addList(userItem);
                    Toast.makeText(MainActivity.this,"Added "+userItem+" to the list", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Please select a priority", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
