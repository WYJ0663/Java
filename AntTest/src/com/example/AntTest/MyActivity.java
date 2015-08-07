package com.example.AntTest;

import android.app.Activity;
import android.os.Bundle;
import com.example.AndroidAnt.AntTest;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        AntTest antTest = new AntTest(this);
        antTest.makeText();
    }
}
