package com.example.jbt.sharedprefsettingact;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);


        ((Button) findViewById(R.id.SettingBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, setting.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean isshowlogin = preferences.getBoolean("showLoginBtn", false);
        if (isshowlogin) {
            ((Button) findViewById(R.id.LoginBtn)).setVisibility(View.INVISIBLE);
        } else if (!isshowlogin) {
            ((Button) findViewById(R.id.LoginBtn)).setVisibility(View.VISIBLE);
        }
        String email = preferences.getString("usernameET", "email@email.com");
        TextView emailET = (TextView) findViewById(R.id.usenameET);
        emailET.setText(email);
        String password = preferences.getString("passwordkey", "password");
        TextView passwordET = (TextView) findViewById(R.id.passET);
        passwordET.setText(password);

    }
}
