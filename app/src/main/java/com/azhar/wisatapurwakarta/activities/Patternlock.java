package com.azhar.wisatapurwakarta.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.azhar.wisatapurwakarta.R;

import java.util.List;

public class Patternlock extends AppCompatActivity implements PatternLockViewListener {
    PatternLockView patternLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patternlock);
        patternLockView = (PatternLockView) findViewById(R.id.patternlock1);

        patternLockView.addPatternLockListener(this);
    }

    @Override
    public void onStarted() {

    }

    @Override
    public void onProgress(List<PatternLockView.Dot> progressPattern) {

    }

    @Override
    public void onComplete(List<PatternLockView.Dot> pattern) {
        if (PatternLockUtils.patternToString(patternLockView,pattern).equalsIgnoreCase("03678")){
            patternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
            Toast.makeText(Patternlock.this, "Unlocked Pattern Correct",Toast.LENGTH_LONG).show();
            Intent intent = new Intent( Patternlock.this,MainActivity.class);
            startActivity(intent);
        }
        else {
            patternLockView.setViewMode(PatternLockView.PatternViewMode.WRONG);
            Toast.makeText(Patternlock.this, "Sorry Pattern Incorrect",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCleared() {

    }
}