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
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3634assignment.Notes.NotesFragment;
import com.example.infs3634assignment.ProgressPage.ProgressFragment;
import com.example.infs3634assignment.UserEntity.User;
import com.example.infs3634assignment.UserEntity.UserDb;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.infs3634assignment.ProgressPage.ProgressFragment.EXTRA_MESSAGE;

public class BlankHomeActivity extends AppCompatActivity {
    public ImageView userDp,achievements;
    public TextView title;
    public String loggedInUser;
    public User currentUser;
    public UserDb userDb;
    public boolean achievementClick,profileClick;
    @Override
    //This activity is the main screen for the application. All functionalities excluding the quiz,
    // utilize this activity and the main fragment container is swapped depending on what functionality is being used.
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

        //getting userDetails
        userDp = findViewById(R.id.userDp);
        loggedInUser = getIntent().getStringExtra("Username");

        LoggedIn loggedIn = new LoggedIn(userDb,currentUser);
        loggedIn.execute();

        //setting up additional buttons
        userDp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!profileClick){
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFragContainer, new ProfileFragment(loggedInUser)).commit();
                    setTitleText("Profile");
                    achievements.setImageResource(R.drawable.trophy);
                    profileClick = true;
                } else {
                    profileClick = false;
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFragContainer, new TheBodyFragment()).commit();
                }
            }
        });

        achievements = findViewById(R.id.achievements);
        achievements.setImageResource(R.drawable.trophy);
        achievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!achievementClick){
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFragContainer, new AchievementsFragment()).commit();
                    setTitleText("Achievements");
                    achievements.setImageResource(R.drawable.trophyunlocked);
                    achievementClick = true;
                } else{
                    achievementClick = false;
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFragContainer, new TheBodyFragment()).commit();
                    achievements.setImageResource(R.drawable.trophy);
                }
            }
        });
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
                achievements.setImageResource(R.drawable.trophy);
                achievementClick = false;
                break;

                case R.id.nav_notes:
                 fragment = new NotesFragment();
                 setTitleText("Notes");
                 achievements.setImageResource(R.drawable.trophy);
                 achievementClick = false;
                 break;

                case R.id.nav_body:
                fragment = new TheBodyFragment();
                setTitleText("The Body");
                achievements.setImageResource(R.drawable.trophy);
                achievementClick = false;
                break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.mainFragContainer,
                    fragment).commit();
            return true;
        }
    };

    //title will change dependong on the screen you're on
    public void setTitleText(String text){
        title.setText(text);
    }

    //this string is passed to other fragments when querying the db.
    public String getLoggedInUser(){
        return loggedInUser;
    }

    //this async task grabs current user to set the display picture in the top right
    public class LoggedIn extends AsyncTask<Void,Void, UserDb> {
        public UserDb userDb;
        public User currentUser;

        public LoggedIn(UserDb userDb, User currentUser){
            this.userDb = userDb;
            this.currentUser = currentUser;
        }

        @Override
        protected UserDb doInBackground(Void... voids) {
            currentUser = userDb.userDao().searchUser(loggedInUser);
            return userDb;
        }

        @Override
        protected void onPostExecute(UserDb userDb) {
            userDp.setImageResource(currentUser.getDisplayPictureId());
        }
    }


    //pressing back to log out
    // reference: https://stackoverflow.com/questions/8430805/clicking-the-back-button-twice-to-exit-an-activity
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            ;Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(EXTRA_MESSAGE, "sign out");
            startActivity(intent);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
