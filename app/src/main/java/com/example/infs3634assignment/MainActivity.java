package com.example.infs3634assignment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.infs3634assignment.Quiz.QuizActivity;
import com.example.infs3634assignment.UserEntity.User;
import com.example.infs3634assignment.UserEntity.UserDb;

public class MainActivity extends AppCompatActivity {
    public TextView username,password;
    public String usernameInput,passwordInput;
    public Button  quizButton, bodyButton, tempLoginBtn,testLogin,register;
    public UserDb userDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDb = Room.databaseBuilder(getApplicationContext(), UserDb.class,"UserDB")
                .build();

        InsertSampleData insertSampleData = new InsertSampleData(userDb);
        insertSampleData.execute();
        username = findViewById(R.id.profileUsername);
        username.addTextChangedListener(loginTextWatcher);
        password = findViewById(R.id.password);
        password.addTextChangedListener(loginTextWatcher);


        quizButton = findViewById(R.id.beginQuizButton);
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        bodyButton = findViewById(R.id.bodyButton);
        bodyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, blankHomeActivity.class);
                intent.putExtra("Username","s");
                startActivity(intent);
            }
        });

        tempLoginBtn = findViewById(R.id.bLogin);
        tempLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, blankHomeActivity.class);
                intent.putExtra("Username","s");
                startActivity(intent);
            }
        });

        register = findViewById(R.id.reg);
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
                    Intent intent = new Intent(MainActivity.this, blankHomeActivity.class);
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
                userDb.userDao().insertNewUser(new User("s","s",R.drawable.bladder));
            } else {
                cancel(true);
            }
            return userDb;
        }
    }

}
