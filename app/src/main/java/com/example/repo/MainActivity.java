package com.example.repo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView countText, txtStatus;
    Button addButton, resetButton;

    int count = 0;

    private static final String TAG = "LifecycleCounter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countText = findViewById(R.id.countText);
        txtStatus = findViewById(R.id.txtStatus);
        addButton = findViewById(R.id.addButton);
        resetButton = findViewById(R.id.resetButton);

        // Restore the counter after recreation
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count");
        }

        countText.setText(String.valueOf(count));

        // Add button event handler
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                countText.setText(String.valueOf(count));
            }
        });

        // Reset button event handler
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                countText.setText(String.valueOf(count));
            }
        });

        showStatus("onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showStatus("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showStatus("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showStatus("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showStatus("onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showStatus("onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showStatus("onDestroy()");
    }

    // Save the counter before Activity recreation
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count", count);

        Log.d(TAG, "onSaveInstanceState(): " + count);
    }

    // Display lifecycle status and Logcat messages
    private void showStatus(String status) {
        txtStatus.setText("Status: " + status);
        Log.d(TAG, status);
    }
}