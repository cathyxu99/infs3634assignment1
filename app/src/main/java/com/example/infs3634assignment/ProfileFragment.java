package com.example.infs3634assignment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3634assignment.UserEntity.User;
import com.example.infs3634assignment.UserEntity.UserDb;

public class ProfileFragment extends Fragment {
    public Button changePassword, updatePassword, updateDp;
    public TextView username, currentPassword, resetPassword, resetPasswordConfirmed;
    public String usernameString,loggedInUser;
    public ImageView currentDp,changeDp;
    public Space buttonSpace;
    public int currentDpId;
    public UserDb  userDb;
    public User currentUser;
    public boolean editDp,editPass = true;
    public DpAdapter dpAdapter;
    public Space space1, space2, space3, space4, space5;


    public ProfileFragment(String username) {
        this.usernameString = username;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_profile, container, false);
       username = view.findViewById(R.id.profileUsername);
       username.setText(usernameString);

       userDb = Room.databaseBuilder(getContext(), UserDb.class,"UserDB")
               .build();

       currentDp = view.findViewById(R.id.currentDp);

       LoggedInUserDetails loggedInUserDetails = new LoggedInUserDetails();
       loggedInUserDetails.execute();

       //changing Dp code
       final RecyclerView recyclerView = view.findViewById(R.id.dpRecycler);
       changeDp = view.findViewById(R.id.changeDp);
       changeDp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //if pressed again will hide the ability to change dps.
               if(editDp){
                   recyclerView.setVisibility(View.VISIBLE);
                   updateDp.setVisibility(View.VISIBLE);
                   editDp = false;



               } else {
                   recyclerView.setVisibility(View.GONE);
                   updateDp.setVisibility(View.GONE);
                   editDp = true;
               }
           }
       });
       updateDp = view.findViewById(R.id.updateDp);
       updateDp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ChangeDp changeDp = new ChangeDp();
               changeDp.execute();
               Intent intent = new Intent(getActivity(), BlankHomeActivity.class);
               intent.putExtra("Username",usernameString);
               startActivity(intent);
           }
       });

        loggedInUser =  ((BlankHomeActivity) getActivity()).getLoggedInUser();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        dpAdapter = new DpAdapter(currentDp, currentDpId,loggedInUser);
        recyclerView.setAdapter(dpAdapter);

       //changing password code
        currentPassword = view.findViewById(R.id.currentPassword);
        resetPassword = view.findViewById(R.id.resetPassword);
        resetPasswordConfirmed = view.findViewById(R.id.resetPasswordConfirmed);
        updatePassword = view.findViewById(R.id.updatePassword);
        buttonSpace = view.findViewById(R.id.buttonSpace);
        space1 = view.findViewById(R.id.space1pw);
        space2 = view.findViewById(R.id.space2pw);
        space3 = view.findViewById(R.id.space3pw);


        changePassword = view.findViewById(R.id.changePassword);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if pressed again will hide the ability to change dps.
                if(editPass){
                    currentPassword.setVisibility(View.VISIBLE);
                    resetPassword.setVisibility(View.VISIBLE);
                    resetPasswordConfirmed.setVisibility(View.VISIBLE);
                    updatePassword.setVisibility(View.VISIBLE);
                    buttonSpace.setVisibility(View.VISIBLE);
                    space1.setVisibility(View.VISIBLE);
                    space2.setVisibility(View.VISIBLE);
                    space3.setVisibility(View.VISIBLE);
                    changePassword.setText("Cancel");
                    editPass = false;
                } else {
                    currentPassword.setVisibility(View.GONE);
                    resetPassword.setVisibility(View.GONE);
                    resetPasswordConfirmed.setVisibility(View.GONE);
                    updatePassword.setVisibility(View.GONE);
                    buttonSpace.setVisibility(View.GONE);
                    space1.setVisibility(View.GONE);
                    space2.setVisibility(View.GONE);
                    space3.setVisibility(View.GONE);
                    changePassword.setText("Change Password");
                    editPass = true;
                }
            }
        });

        updatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resetPasswordConfirmed.getText().toString().equals(resetPassword.getText().toString()) == false) {
                    Toast.makeText(getContext(), "Password does not match!", Toast.LENGTH_SHORT).show();
                }
                else {
                    ChangePass changePass = new ChangePass();
                    changePass.execute();
                }
            }
        });
       return view;
    }

    public class LoggedInUserDetails extends AsyncTask<Void, Void, User> {

        @Override
        protected User doInBackground(Void... voids) {
            currentUser = userDb.userDao().searchUser(username.getText().toString());
            return currentUser;
        }

        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);
            currentDp.setImageResource(currentUser.getDisplayPictureId());
            if(currentUser.getBrainTrophy()!=null) {
                dpAdapter.addAvatar(R.drawable.brain);
            }

            if(currentUser.getLungsTrophy()!=null){
                dpAdapter.addAvatar(R.drawable.lungs);
            }

            if(currentUser.getHeartTrophy()!=null) {
                dpAdapter.addAvatar(R.drawable.heart);
            }

            if(currentUser.getSpleenTrophy()!=null) {
                dpAdapter.addAvatar(R.drawable.spleen);
            }

            if(currentUser.getStomachTrophy()!=null) {
                dpAdapter.addAvatar(R.drawable.stomach);
            }

            if(currentUser.getLiverTrophy()!=null) {
                dpAdapter.addAvatar(R.drawable.liver);
            }

            if(currentUser.getKidneyTrophy()!=null) {
                dpAdapter.addAvatar(R.drawable.kidneys);
            }

            if(currentUser.getIntestineTrophy()!=null) {
                dpAdapter.addAvatar(R.drawable.intestine);

            }
            if ((currentUser.getPancreasTrophy()!=null)) {
                dpAdapter.addAvatar(R.drawable.pancreas);

            }
        }
    }

    //gets tag of imageview which in the case of display pictures was set in the DpAdapter
    private int getDrawableId(ImageView iv) {
        return (Integer) iv.getTag();
    }

    // Async task to make an update (dp) to query
    public class ChangeDp extends  AsyncTask<Void,Void,User>{
        @Override
        protected User doInBackground(Void... voids) {
            userDb.userDao().changeDp(getDrawableId(currentDp),usernameString);
            return null;
        }

    }

    // Async task to make an update (password) to query
    public class ChangePass extends  AsyncTask<Void,Void,User>{
        @Override
        protected User doInBackground(Void... voids) {
            if (!userDb.userDao().searchUser(usernameString).getPassword().equals(currentPassword.getText().toString())) {
                cancel(true);
            } else {
                userDb.userDao().changePassword(resetPasswordConfirmed.getText().toString(), usernameString);
            }
            return null;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(getContext(), "Incorrect current password", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);
            Intent intent = new Intent(getActivity(), BlankHomeActivity.class);
            intent.putExtra("Username",usernameString);
            startActivity(intent);
        }
    }
}
