package com.example.infs3634assignment.ProgressPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.infs3634assignment.R;

public class ProgressDetail2 extends AppCompatActivity {
    private TextView levelName;
    private ProgressData mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_detail);
        System.out.println("progress detail activity open");
       /*
        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            Intent intent = getIntent();
            int position = intent.getIntExtra(ProgressFragment.EXTRA_MESSAGE, 0);
        }

         */
        Intent intent = getIntent();
        int position = intent.getIntExtra(ProgressFragment.EXTRA_MESSAGE, 0);
        mProgress = ProgressData.getLevel9().get(position);
        System.out.println(position);
       // TextView levelName = findViewById(R.id.levelName);
        //levelName.setText(mProgress.getLevel());

    }
}

