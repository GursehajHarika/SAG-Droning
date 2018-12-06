package com.example.gursehajharika.dronomatic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Set;

public class Accountinfo extends AppCompatActivity {

    public Button home;
    public MenuView.ItemView quit;
    public EditText fullnam, emailadd,oldpasswrd,newpassrd;

    String fulna = null;
    String emailr = null;
    String older = null;
    String prod = null;

    //Firebase
    private FirebaseAuth mAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference dbref;
    private String userID;

    private static final String TAG = "Accountinfo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountinfo);

        setTitle( "Account Info");


        userinfogetter();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        home = findViewById(R.id.button2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void userinfogetter(){

        fullnam = (EditText)findViewById(R.id.fullname);
        emailadd = (EditText)findViewById(R.id.emailler);
        oldpasswrd = (EditText)findViewById(R.id.opaswrd);
        newpassrd = (EditText)findViewById(R.id.newpas);


        fullnam.setText(fulna);
        emailadd.setText(emailr);
        oldpasswrd.setText(older);
        newpassrd.setText(prod);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        dbref = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();




        //Authentication Listener.
        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null)
                {


                    Log.d(TAG, "onAuthStateListenerChanged: Signed in" + user.getUid());
                    toastmessage("Succesfully Signed in with :" + user.getUid());
                }
                else{
                    Log.d(TAG,"Signed out");
                    toastmessage("Signed out");
                }
            }
        };

     /*   dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               showdata(dataSnapshot);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void showdata(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            Userinformation uinfo = new Userinformation(emailr,fulna,older,prod,userID);
            uinfo.setName(ds.child(userID).getValue(Userinformation.class).getName());
            uinfo.setEmail(ds.child(userID).getValue(Userinformation.class).getEmail());
            uinfo.setPassword(ds.child(userID).getValue(Userinformation.class).getPassword());
            uinfo.setProductID(ds.child(userID).getValue(Userinformation.class).getProductID());

            Log.d(TAG,"showData : name" + uinfo.getName());
            Log.d(TAG,"showData : email" + uinfo.getEmail());
            Log.d(TAG,"showData : password" + uinfo.getPassword());
            Log.d(TAG,"showData : productID" + uinfo.getProductID());
            Log.d(TAG,"ShowData : UserID " + uinfo.getUserID());

         //   fullnam.setText(uinfo.getName());
         //   emailadd.setText(uinfo.getEmail());
         //   oldpasswrd.setText(uinfo.getPassword());
          //  newpassrd.setText(uinfo.getProductID());

        }
        */

    }


    private void toastmessage(String message){
        Toast.makeText(Accountinfo.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
