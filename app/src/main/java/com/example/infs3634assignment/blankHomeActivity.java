package com.example.infs3634assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.infs3634assignment.ProgressPage.ProgressFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class blankHomeActivity extends AppCompatActivity {
    public TextView loggedUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank_home);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new TheBodyFragment();
        Bundle arguments = new Bundle();
        fragment.setArguments(arguments);
        transaction.replace(R.id.mainFragContainer,fragment);
        transaction.commit();

        BottomNavigationView bottomNavBar = findViewById(R.id.bottom_nav_bar);
        bottomNavBar.setOnNavigationItemSelectedListener(navigationListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragContainer, new TheBodyFragment()).commit();

        loggedUser = findViewById(R.id.loggedUser);
        loggedUser.setText("Hello " + getIntent().getStringExtra("Username"));
    }

    //onclicklistener to open the different fragments when each button in the nav bar is clicked
    //reference: https://www.youtube.com/watch?v=tPV8xA7m-iw
    public BottomNavigationView.OnNavigationItemSelectedListener navigationListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
            Fragment fragment = null;
            switch(menuItem.getItemId()){
                case R.id.nav_progress:
                fragment = new ProgressFragment();
                break;

                case R.id.nav_notes:
                    fragment = new NotesFragment();
                    break;

                case R.id.nav_body:
                    fragment = new TheBodyFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.mainFragContainer,
                    fragment).commit();
            return true;
        }
            };
}
