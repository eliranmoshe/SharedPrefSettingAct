package com.example.jbt.sharedprefsettingact;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        ((Button)findViewById(R.id.SetBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, setting.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        preferences= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String user= preferences.getString("set_background", "white");
        ((RelativeLayout)findViewById(R.id.activity_main)).setBackgroundColor(Color.parseColor(user));
        boolean isShowTutorial= preferences.getBoolean("with_tutorial",false);
        if (isShowTutorial) {
            ((TextView) findViewById(R.id.TV)).setText("welcome");
        }
        if (!isShowTutorial)
        {
            ((TextView) findViewById(R.id.TV)).setText("olduser");
        }
    }
}
