package com.example.infs3634assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
    public ImageView newDp,dP1,dP2,dP3;
    public String usernameInput,passwordInput,confirmedPasswordInput;
    public UserDb userDb;
    public int newDpId;
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



        newDp = findViewById(R.id.newDP);
        newDp.setImageResource(R.drawable.avatarbloodcellsmall);
        newDpId = R.drawable.avatarbloodcellsmall;

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = findViewById(R.id.newDpRecycler);
        recyclerView.setLayoutManager(layoutManager);
        DpAdapter dpAdapter = new DpAdapter(newDp, newDpId);
        recyclerView.setAdapter(dpAdapter);

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

    //does not let register button be clicked unless fields are complete
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

    //inserts user into database also checking username validity
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
                User user = new User(usernameInput,confirmedPasswordInput,getDrawableId(newDp));
                userDb.userDao().insertNewUser(user);
                 Intent intent = new Intent(RegisterActivity.this, blankHomeActivity.class);
                 intent.putExtra("Username",user.getUsername().toString());
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

    //gets tag of imageview which in the case of display pictures was set in the DpAdapter
    private int getDrawableId(ImageView iv) {
        return (Integer) iv.getTag();
    }
}
