package com.example.milestone_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.milestone_1", Context.MODE_PRIVATE);

        if(!sharedPreferences.getString(usernameKey, "").equals("")) {
            String name = sharedPreferences.getString(usernameKey, "");
            goToActivity2(name);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void onButtonClick(View v) {
        EditText myUsername = (EditText) findViewById(R.id.editUsername);
        String user = myUsername.getText().toString();

        EditText myPassword = (EditText) findViewById(R.id.editPassword);
        String pass = myUsername.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.milestone_1", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", user).apply();

        String username = sharedPreferences.getString("username", "");

        goToActivity2(user);
    }

    public void goToActivity2(String s) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }


}