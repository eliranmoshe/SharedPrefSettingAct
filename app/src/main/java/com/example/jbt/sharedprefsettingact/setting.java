package com.example.jbt.sharedprefsettingact;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by jbt on 01/03/2017.
 */

public class setting extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);
    }
}
