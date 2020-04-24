package com.example.infs3634assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3634assignment.Notes.NotesFragment;
import com.example.infs3634assignment.ProgressPage.ProgressFragment;
import com.example.infs3634assignment.UserEntity.User;
import com.example.infs3634assignment.UserEntity.UserDb;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class blankHomeActivity extends AppCompatActivity {
    public ImageView userDp,achievements;
    public TextView title;
    public String loggedInUser;
    public UserDb userDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank_home);
        userDb = Room.databaseBuilder(getApplicationContext(), UserDb.class,"UserDB")
                .build();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new TheBodyFragment();
        Bundle arguments = new Bundle();
        fragment.setArguments(arguments);
        transaction.replace(R.id.mainFragContainer,fragment);
        transaction.commit();

        title = findViewById(R.id.title);

        BottomNavigationView bottomNavBar = findViewById(R.id.bottom_nav_bar);
        bottomNavBar.setOnNavigationItemSelectedListener(navigationListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragContainer, new TheBodyFragment()).commit();
        setTitleText("The Body");

        userDp = findViewById(R.id.userDp);
        loggedInUser = getIntent().getStringExtra("Username");

      //  LoggedIn loggedIn = new LoggedIn(userDb);
        //loggedIn.execute();
    }

    //onclicklistener to open the different fragments when each button in the nav bar is clicked
    //reference: https://www.youtube.com/watch?v=tPV8xA7m-iw
    public BottomNavigationView.OnNavigationItemSelectedListener navigationListener = new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
            Fragment fragment = null;
            switch(menuItem.getItemId()){
                case R.id.nav_progress:
                fragment = new ProgressFragment();
                setTitleText("Progress");
                break;

                case R.id.nav_notes:
                 fragment = new NotesFragment();
                 setTitleText("Notes");
                 break;

                case R.id.nav_body:
                fragment = new TheBodyFragment();
                setTitleText("The Body");
                break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.mainFragContainer,
                    fragment).commit();
            return true;
        }
    };

    public void setTitleText(String text){
        title.setText(text);
    }

    public class LoggedIn extends AsyncTask<Void,Void, UserDb> {
        public UserDb userDb;
        public User currentUser;

        public LoggedIn(UserDb userDb){
            this.userDb = userDb;
        }

        @Override
        protected UserDb doInBackground(Void... voids) {
            currentUser = userDb.userDao().searchUser(loggedInUser);
            return userDb;
        }

        @Override
        protected void onPostExecute(UserDb userDb) {
            super.onPostExecute(userDb);
            userDp.setImageResource(currentUser.getDisplayPictureId());
        }
    }
}
