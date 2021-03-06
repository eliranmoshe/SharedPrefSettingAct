package com.example.jbt.sharedprefsettingact;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by jbt on 01/03/2017.
 */

public class setting extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);

        Preference exitBtn=(Preference) findPreference("exitBtn");
        exitBtn.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                finish();
                return true;
            }
        });

        EditTextPreference email= (EditTextPreference) findPreference("usernameET");
        email.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                String email= (String) newValue;
                if (!email.contains("@"))
                {
                    Toast.makeText(setting.this, "incorrect email", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else {
                    Toast.makeText(setting.this, "saved email", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        EditTextPreference password= (EditTextPreference) findPreference("passwordkey");
        password.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                String password= (String) newValue;
                if (password.toCharArray().length<8)
                {
                    Toast.makeText(setting.this, "incorrect password", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else
                {
                    Toast.makeText(setting.this, "saved password", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });






    }


}
