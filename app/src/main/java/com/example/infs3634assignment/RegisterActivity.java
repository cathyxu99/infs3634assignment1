package com.example.infs3634assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3634assignment.UserEntity.User;
import com.example.infs3634assignment.UserEntity.UserDb;

public class RegisterActivity extends AppCompatActivity {
    public TextView newUsername,newPassword,confirmNewPassword;
    public ImageView newDP,dP1,dP2,dP3;
    public String usernameInput,passwordInput,confirmedPasswordInput;
    public UserDb userDb;
    public int confirmedDP;
    public Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userDb = Room.databaseBuilder(getApplicationContext(), UserDb.class,"UserDB")
                .build();
        newUsername = findViewById(R.id.newUsername);
        newPassword = findViewById(R.id.newPassword);
        confirmNewPassword = findViewById(R.id.newPasswordConfirmed);


        newUsername.addTextChangedListener(registerTextWatcher);
        newPassword.addTextChangedListener(registerTextWatcher);
        confirmNewPassword.addTextChangedListener(registerTextWatcher);



        newDP = findViewById(R.id.newDP);
        confirmedDP = R.drawable.brain;
        dP1 = findViewById(R.id.DP1);
        dP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newDP.setImageResource(R.drawable.bladder);
                confirmedDP = R.drawable.bladder;
            }
        });
        dP2 = findViewById(R.id.DP2);
        dP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newDP.setImageResource(R.drawable.lungs);
                confirmedDP = R.drawable.lungs;
            }
        });
        dP3 = findViewById(R.id.DP3);
        dP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newDP.setImageResource(R.drawable.heart);
                confirmedDP = R.drawable.heart;            }
        });

        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (confirmedPasswordInput.equals(passwordInput) == false) {
                    Toast.makeText(getApplicationContext(), "Password does not match!", Toast.LENGTH_SHORT).show();
                } else {
                    RegisterUserTask registerUser = new RegisterUserTask(userDb);
                    registerUser.execute();
                }

            }
        });

    }

    private TextWatcher registerTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
             usernameInput = newUsername.getText().toString().trim();
             passwordInput = newPassword.getText().toString().trim();
             confirmedPasswordInput = confirmNewPassword.getText().toString().trim();

            register.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty() && !confirmedPasswordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public class RegisterUserTask extends AsyncTask<Void,Void,UserDb> {
        public UserDb userDb;

        public RegisterUserTask (UserDb userDb){
            this.userDb = userDb;
        }
        @Override
        protected UserDb doInBackground(Void... voids) {
             if (userDb.userDao().searchUser(usernameInput)!=null) {
                cancel(true);
            } else {
                User user = new User(usernameInput,confirmedPasswordInput,0,confirmedDP);
                userDb.userDao().insertNewUser(user);
                 Intent intent = new Intent(RegisterActivity.this, blankHomeActivity.class);
                 intent.putExtra("Username",user.getUserName().toString());
                 startActivity(intent);
            }
            return userDb;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(getApplicationContext(), "Username already exists!", Toast.LENGTH_SHORT).show();
        }
    }
}
