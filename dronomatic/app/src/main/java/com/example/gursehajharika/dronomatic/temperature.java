package com.example.gursehajharika.dronomatic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static android.media.CamcorderProfile.get;

public class temperature extends AppCompatActivity {

    public Button homer;
    public EditText readingt;
    ArrayList<String> tempreadings = new ArrayList<String>();
    private ActionBar toolbar;
    private static final String TAG = "Temperature";
    DatabaseReference Reading;
    ArrayList<String> list = new ArrayList<>();
    public ListView listView ;


    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private String userID, readings,timer;


    private void  arrayconstruction(){
        tempreadings.add("Temperature  ------    Time\n ");
        tempreadings.add("22.0^0 C            At 10:30am \n ");
        tempreadings.add("20.0^0 C            At 10:31am \n ");
        tempreadings.add("25.0^0 C            At 10:32am \n ");
        tempreadings.add("40.0^0 C            At 10:33am \n ");
        tempreadings.add("50.0^0 C            At 10:34am \n ");
        tempreadings.add("24.0^0 C            At 10:35am \n ");
        tempreadings.add("10.0^0 C            At 10:36am \n ");
        tempreadings.add("20.0^0 C            At 10:37am \n ");
        tempreadings.add("20.5^0 C            At 10:38am \n ");
        tempreadings.add("20.0^0 C            At 10:39am \n ");
        tempreadings.add("20.0^0 C            At 10:40am \n ");
        tempreadings.add("20.0^0 C            At 10:41am \n ");
        tempreadings.add("22.0^0 C            At 10:30am \n ");
        tempreadings.add("20.0^0 C            At 10:31am \n ");
        tempreadings.add("25.0^0 C            At 10:32am \n ");
        tempreadings.add("40.0^0 C            At 10:33am \n ");
        tempreadings.add("50.0^0 C            At 10:34am \n ");
        tempreadings.add("24.0^0 C            At 10:35am \n ");
        tempreadings.add("10.0^0 C            At 10:36am \n ");
        tempreadings.add("20.0^0 C            At 10:37am \n ");
        tempreadings.add("20.5^0 C            At 10:38am \n ");
        tempreadings.add("20.0^0 C            At 10:39am \n ");
        tempreadings.add("20.0^0 C            At 10:40am \n ");
        tempreadings.add("20.0^0 C            At 10:41am \n ");
        tempreadings.add("22.0^0 C            At 10:30am \n ");
        tempreadings.add("20.0^0 C            At 10:31am \n ");
        tempreadings.add("25.0^0 C            At 10:32am \n ");
        tempreadings.add("40.0^0 C            At 10:33am \n ");
        tempreadings.add("50.0^0 C            At 10:34am \n ");
        tempreadings.add("24.0^0 C            At 10:35am \n ");
        tempreadings.add("10.0^0 C            At 10:36am \n ");
        tempreadings.add("20.0^0 C            At 10:37am \n ");
        tempreadings.add("20.5^0 C            At 10:38am \n ");
        tempreadings.add("20.0^0 C            At 10:39am \n ");
        tempreadings.add("20.0^0 C            At 10:40am \n ");
        tempreadings.add("20.0^0 C            At 10:41am \n ");
        tempreadings.add("22.0^0 C            At 10:30am \n ");
        tempreadings.add("20.0^0 C            At 10:31am \n ");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        setTitle("Temperature");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

      //  readingt = findViewById(R.id.TextView);
      //  arrayconstruction();
        //  for(int i=0;i<tempreadings.size();i++) {

    //        readingt.setText(readingt.getText() + tempreadings.get(i));
    //        //readingt.append(tempreadings.get(i));
    //    }

        databaseread();



        homer = findViewById(R.id.button);
        homer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        toolbar = getSupportActionBar();

        BottomNavigationView navigation = findViewById(R.id.bottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(bottomnavigationbar);

    }

    public void databaseread(){

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                shower(dataSnapshot);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void shower(DataSnapshot dataSnapshot) {

        ArrayList<String> array = new ArrayList<>();

        //Object 1.
        baropress_databaseread uinfor = new baropress_databaseread(readings,timer);


        uinfor.setValuer(dataSnapshot.child("user").child(userID).child("Temperature").child("read1").getValue(baropress_databaseread.class).getValuer());
        uinfor.setTimestamp(dataSnapshot.child("user").child(userID).child("Temperature").child("read1").getValue(baropress_databaseread.class).getTimestamp());
        array.add(" Time                : " + convertTimestamp(uinfor.getTimestamp()));
        array.add("Readings         : " + uinfor.getValuer());
        convertTimestamp(uinfor.getTimestamp());
        Log.d(TAG," Converted Time Stamp is" + convertTimestamp(uinfor.getTimestamp()));


        //object 2.
        baropress_databaseread uinfor2 = new baropress_databaseread(readings,timer);
        uinfor2.setValuer(dataSnapshot.child("user").child(userID).child("Temperature").child("read2").getValue(baropress_databaseread.class).getValuer());
        uinfor2.setTimestamp(dataSnapshot.child("user").child(userID).child("Temperature").child("read2").getValue(baropress_databaseread.class).getTimestamp());

        Log.d(TAG," \n \n Showing Readings For Object 2 " + uinfor2.getTimestamp());
        Log.d(TAG," \n \n Showing Time For object 2 " + uinfor2.getValuer());

        array.add(" Time                : " + convertTimestamp(uinfor2.getTimestamp()));
        array.add("Readings         : " + uinfor2.getValuer());


        //object3
        baropress_databaseread uinfor3 = new baropress_databaseread(readings,timer);
        uinfor3.setValuer(dataSnapshot.child("user").child(userID).child("Temperature").child("read3").getValue(baropress_databaseread.class).getValuer());
        uinfor3.setTimestamp(dataSnapshot.child("user").child(userID).child("Temperature").child("read3").getValue(baropress_databaseread.class).getTimestamp());

        Log.d(TAG," \n \n Showing Readings For Object 3 " + uinfor3.getTimestamp());
        Log.d(TAG," \n \n Showing Time For object 3 " + uinfor3.getValuer());


        array.add(" Time                : " + convertTimestamp(uinfor3.getTimestamp()));
        array.add("Readings         : " + uinfor3.getValuer());


        //object 4
        baropress_databaseread uinfor4 = new baropress_databaseread(readings,timer);
        uinfor4.setValuer(dataSnapshot.child("user").child(userID).child("Temperature").child("read4").getValue(baropress_databaseread.class).getValuer());
        uinfor4.setTimestamp(dataSnapshot.child("user").child(userID).child("Temperature").child("read4").getValue(baropress_databaseread.class).getTimestamp());

        Log.d(TAG," \n \n Showing Readings For Object 4 " + uinfor4.getTimestamp());
        Log.d(TAG," \n \n Showing Time For object 4 " + uinfor4.getValuer());


        array.add(" Time                : " + convertTimestamp(uinfor4.getTimestamp()));
        array.add("Readings         : " + uinfor4.getValuer());

        //object 5
        baropress_databaseread uinfor5 = new baropress_databaseread(readings,timer);
        uinfor5.setValuer(dataSnapshot.child("user").child(userID).child("Temperature").child("read5").getValue(baropress_databaseread.class).getValuer());
        uinfor5.setTimestamp(dataSnapshot.child("user").child(userID).child("Temperature").child("read5").getValue(baropress_databaseread.class).getTimestamp());

        Log.d(TAG," \n \n Showing Readings For Object 4 " + uinfor5.getTimestamp());
        Log.d(TAG," \n \nShowing Time For object 4 " + uinfor5.getValuer());

        array.add(" Time                : " + convertTimestamp(uinfor5.getTimestamp()));
        array.add("Readings         : " + uinfor5.getValuer());


        //ListView to display the data.
        listView = (ListView)findViewById(R.id.listview);
        ArrayAdapter adapter = new ArrayAdapter(temperature.this,android.R.layout.simple_list_item_1,array);
        listView.setAdapter(adapter);



    }
    private String convertTimestamp(String timestamp){

        long yourSeconds = Long.valueOf(timestamp);
        Date mDate = new Date(yourSeconds * 1000);
        DateFormat df = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
        return df.format(mDate);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    private void showData() {
        Reading = FirebaseDatabase.getInstance().getReference();
        Reading.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String val = dataSnapshot.getValue(String.class);
                list.add(val);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

private BottomNavigationView.OnNavigationItemSelectedListener bottomnavigationbar = new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.bottomtemp){
            finish();
            Intent bottomtemperature = new Intent(temperature.this,temperature.class);
            startActivity(bottomtemperature);

        }
        else if (menuItem.getItemId() == R.id.bottomotion){
            finish();
            Intent bottommotion = new Intent(temperature.this,Motionsense.class);
            startActivity(bottommotion);
        }
        else{
            finish();
            Intent bottombaro = new Intent(temperature.this,baropress.class);
            startActivity(bottombaro);
        }
        return false;
    }
};
}
