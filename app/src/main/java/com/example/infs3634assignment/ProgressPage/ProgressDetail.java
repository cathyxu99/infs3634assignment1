package com.example.infs3634assignment.ProgressPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.infs3634assignment.R;

public class ProgressDetail extends AppCompatActivity {
    private TextView levelName;

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


        Intent intent = getIntent();
        int position = intent.getIntExtra(ProgressFragment.EXTRA_MESSAGE, 0);


        */
    }
}

