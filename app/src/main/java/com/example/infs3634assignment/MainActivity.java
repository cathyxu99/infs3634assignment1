package com.example.infs3634assignment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.infs3634assignment.Quiz.QuizActivity;
import com.example.infs3634assignment.UserEntity.User;
import com.example.infs3634assignment.UserEntity.UserDb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public TextView username,password,register;
    public String usernameInput,passwordInput;
    public Button  quizButton, bodyButton, tempLoginBtn,testLogin;;
    public UserDb userDb;
    public EditText usernameBox, passwordBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDb = Room.databaseBuilder(getApplicationContext(), UserDb.class, "UserDB")
                .build();

        InsertSampleData insertSampleData = new InsertSampleData(userDb);
        insertSampleData.execute();
        username = findViewById(R.id.profileUsername);
        username.addTextChangedListener(loginTextWatcher);
        password = findViewById(R.id.password);
        password.addTextChangedListener(loginTextWatcher);


        register = findViewById(R.id.regText);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        testLogin = findViewById(R.id.testLogin);
        testLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser loginUser = new LoginUser(userDb);
                loginUser.execute();
            }
        });

        //Makes username and password field clear on click
        usernameBox = findViewById(R.id.profileUsername);
        usernameBox.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                usernameBox.setHint("");
                return false;
            }

        });

        usernameBox.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    usernameBox.setHint("Username");
                }
            }
        });

        passwordBox = findViewById(R.id.password);
        passwordBox.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    passwordBox.setHint("Password");
                }
            }
        });

        passwordBox.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                passwordBox.setHint("");
                return false;
            }

        });

       Bundle bundle = getIntent().getExtras();
    }



    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            usernameInput = username.getText().toString().trim();
            passwordInput = password.getText().toString().trim();

            testLogin.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public class LoginUser extends AsyncTask<Void,Void, UserDb> {
        public UserDb userDb;

        public LoginUser(UserDb userDb){
            this.userDb = userDb;
        }

        @Override
        protected UserDb doInBackground(Void... voids) {

            if(userDb.userDao().searchUser(usernameInput)!=null){
                User loginUser = userDb.userDao().searchUser(usernameInput);
                if (!loginUser.getPassword().toString().equals(passwordInput)) {
                    cancel(true);
                } else {
                    Intent intent = new Intent(MainActivity.this, BlankHomeActivity.class);
                    intent.putExtra("Username",loginUser.getUsername());
                    startActivity(intent);
                }
            } else {
                cancel(true);
            }


            return userDb;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(getApplicationContext(), "Incorrect credentials!", Toast.LENGTH_SHORT).show();
        }
    }

    public class InsertSampleData extends AsyncTask<Void,Void, UserDb> {
        public UserDb userDb;

        public InsertSampleData(UserDb userDb){
            this.userDb = userDb;
        }

        @Override
        protected UserDb doInBackground(Void... voids) {
            if(userDb.userDao().getUsers().size() == 0){
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date = format.parse("2020-05-25");
                    User sampleUser = new User("s","s", R.drawable.avatarbloodcellsmall
                    ,"g","s","b","g","s","g","g","g","g"
                    , date, format.parse("2020-04-23"), format.parse("2020-03-13"), date, date, date, date, date, date
                    ,110000,220000,330000,330000,330000,330000,330000,330000,330000);

                    userDb.userDao().insertNewUser(sampleUser);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                cancel(true);
            }
            return userDb;
        }
    }

}
