package com.example.gursehajharika.dronomatic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final String TAG = "Homepage";

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle ;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    private FirebaseAuth mAuth;
    public ListView listView ;
    private FirebaseAuth.AuthStateListener mAuthListener;

    //variables for cardview temperature.
    private CardView cardView;
    private TextView temptextview;
    ArrayList<String> temcarview = new ArrayList<String>();

    //variables for cardview barometric pressure.
    private CardView cardView2;
    private TextView barotextview;
    ArrayList<String> barocarview = new ArrayList<String>();

    //variables for carview motion sensor.
    private CardView cardview3;
    private TextView motiontext;
    ArrayList<String>motioncardview = new ArrayList<>();


    //Database Values
    private FirebaseDatabase mFirebaseDatabase;
    //private FirebaseAuth.AuthStateListener mAuthlistener;
    private DatabaseReference mRef;
    private String userID, readings,timer;




    //Database Readings




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


    public void shower(DataSnapshot dataSnapshot){


        baropress_databaseread uinfor = new baropress_databaseread(readings,timer);
        ArrayList<String> barocarview = new ArrayList<String>();

        uinfor.setValuer(dataSnapshot.child("user").child(userID).child("Reading").child("read1").getValue(baropress_databaseread.class).getValuer());
        uinfor.setTimestamp(dataSnapshot.child("user").child(userID).child("Reading").child("read1").getValue(baropress_databaseread.class).getTimestamp());
        barocarview.add(" Time : " + convertTimestamp(uinfor.getTimestamp()));
        barocarview.add("\n \n Readings : " + uinfor.getValuer());
        convertTimestamp(uinfor.getTimestamp());
        Log.d(TAG," Converted Time Stamp is" + convertTimestamp(uinfor.getTimestamp()));

        uinfor.setValuer(dataSnapshot.child("user").child(userID).child("Reading").child("read2").getValue(baropress_databaseread.class).getValuer());
        uinfor.setTimestamp(dataSnapshot.child("user").child(userID).child("Reading").child("read2").getValue(baropress_databaseread.class).getTimestamp());
        barocarview.add("\n \n Time : " + convertTimestamp(uinfor.getTimestamp()));
        barocarview.add("\n \n Readings : " + uinfor.getValuer());
        convertTimestamp(uinfor.getTimestamp());
        Log.d(TAG," Converted Time Stamp is" + convertTimestamp(uinfor.getTimestamp()));

        barotextview.setText("" +barocarview);
    }


    public void databasereadTemp(){

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();


        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showernew(dataSnapshot);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public void showernew(DataSnapshot dataSnapshot){


        baropress_databaseread uinfor = new baropress_databaseread(readings,timer);
        ArrayList<String> barocarview = new ArrayList<String>();

        uinfor.setValuer(dataSnapshot.child("user").child(userID).child("Temperature").child("read1").getValue(baropress_databaseread.class).getValuer());
        uinfor.setTimestamp(dataSnapshot.child("user").child(userID).child("Temperature").child("read1").getValue(baropress_databaseread.class).getTimestamp());
        temcarview.add(" Time : " + convertTimestamp(uinfor.getTimestamp()));
        barocarview.add("\n \n Readings : " + uinfor.getValuer());
        convertTimestamp(uinfor.getTimestamp());
        Log.d(TAG," Converted Time Stamp is" + convertTimestamp(uinfor.getTimestamp()));

        uinfor.setValuer(dataSnapshot.child("user").child(userID).child("Temperature").child("read2").getValue(baropress_databaseread.class).getValuer());
        uinfor.setTimestamp(dataSnapshot.child("user").child(userID).child("Temperature").child("read2").getValue(baropress_databaseread.class).getTimestamp());
        barocarview.add("\n \n Time : " + convertTimestamp(uinfor.getTimestamp()));
        barocarview.add("\n \n Readings : " + uinfor.getValuer());
        convertTimestamp(uinfor.getTimestamp());
        Log.d(TAG," Converted Time Stamp is" + convertTimestamp(uinfor.getTimestamp()));

        barotextview.setText("" +barocarview);
    }





    //Ended-databsee stuff


    private String convertTimestamp(String timestamp){

        long yourSeconds = Long.valueOf(timestamp);
        Date mDate = new Date(yourSeconds * 1000);
        DateFormat df = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
        return df.format(mDate);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        mDrawerLayout= findViewById(R.id.drawer);
        mToggle= new ActionBarDrawerToggle(homepage.this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView= findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Temrature Card view initalization

        cardviewtemp();


        //barometric Carview initalization.

       cardviewbaro();


        //Motion sensor Cardview initalization.
        cardview3 = findViewById(R.id.motioncard);
        motiontext = findViewById(R.id.motiontextview);
        motionreadingcardview();
        for (int i = 0; i<motioncardview.size();i++){
            motiontext.append(motioncardview.get(i));
        }

        //User's name for personalization.

        String usersnam = getIntent().getStringExtra("session");
        setTitle(usersnam);


        //Spinner for Sensor selection started.

        spinner = findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.sensorname,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //to initiate the selections from spinner.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 1){

                    Toast.makeText(getBaseContext()," Showing temrature readings",Toast.LENGTH_SHORT).show();
                    cardView2.setVisibility(View.INVISIBLE);
                    cardView.setVisibility(View.VISIBLE);
                    cardview3.setVisibility(View.INVISIBLE);
                   // cardviewtemp();
                }
                else if (position == 2){

                    Toast.makeText(getBaseContext()," Showing Barometric readings",Toast.LENGTH_SHORT).show();
                   cardView.setVisibility(View.GONE);
                   cardView2.setVisibility(View.VISIBLE);
                   cardview3.setVisibility(View.INVISIBLE);
                  // cardviewbaro();
                }
                else if (position == 3){

                    Toast.makeText(getBaseContext()," Showing Motion sensor readings",Toast.LENGTH_SHORT).show();
                    cardView.setVisibility(View.INVISIBLE);
                    cardView2.setVisibility(View.INVISIBLE);
                    cardview3.setVisibility(View.VISIBLE);
                }
                else {

                    Toast.makeText(getBaseContext()," Please select a sensor",Toast.LENGTH_SHORT).show();
                    cardView.setVisibility(View.INVISIBLE);
                    cardView2.setVisibility(View.INVISIBLE);
                    cardview3.setVisibility(View.INVISIBLE);
                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void cardviewbaro(){
        cardView2 = findViewById(R.id.barcard);
        barotextview = findViewById(R.id.barotextview);
          databasereadTemp();


    }
    public void cardviewtemp(){

        cardView = findViewById(R.id.Tempcard);
        temptextview = findViewById(R.id.temptextview);
        databaseread();

    }

    //navigation drawer implimentation.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//navigation drawer content.
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.account)
        {
            // goes back to home.
           // Toast.makeText(this,"you are at home right now",Toast.LENGTH_SHORT).show();

            Intent account = new Intent(homepage.this,Accountinfo.class);
            startActivity(account);
        }
        else if(id == R.id.temp)
        {
            // go to temprature
            Intent temp = new Intent(this,temperature.class);
            startActivity(temp);
        }
        else if (id ==R.id.baropressure)
        {
            // go to Barometric pressure page
            Intent temp = new Intent(this,baropress.class);
            startActivity(temp);
        }
        else if (id ==R.id.Motionsense)
        {
            // go to Motion sensor page
            Intent temp = new Intent(this,Motionsense.class);
            startActivity(temp);
        }
        else if (id ==R.id.settings)
        {
            // go to settings
            Intent temp = new Intent(this,settings.class);
            startActivity(temp);
        }
        else if (id ==R.id.contact)
        {
            // go to help page
            Intent temp = new Intent(this,contactus.class);
            startActivity(temp);
        }
        else
        {


           //go to logout
            Toast.makeText(this,"You have been logged out.",Toast.LENGTH_LONG).show();
            finish();

        }
        return false;
    }



    //temprature readings.
    private void temreadingcardview(){
        temcarview.add("      Time     --  Temperature \n");
        temcarview.add("  11:05am  --     21.43^0c \n");
        temcarview.add("  12:05pm  --     22.50^0c \n");
        temcarview.add("  01:05pm  --     23.73^0c \n");
        temcarview.add("  02:05pm  --     22.32^0c \n");
        temcarview.add("  03:05pm  --     21.32^0c \n");
        temcarview.add("  04:05pm  --     20.32^0c \n");

    }
    //Barometric sensor readings.
    private void baroreadingcardview(){
        barocarview.add("   Altitude   --   Baro Pressure \n");
        barocarview.add("     400ft     --        31.02 \n");
        barocarview.add("   1400ft     --       40.02 \n");
        barocarview.add("     842ft     --        60.02 \n");
        barocarview.add("     900ft     --        30.02 \n");
        barocarview.add("   1002ft     --       10.02 \n");
        barocarview.add("   1602ft     --       25.02 \n");
    }

    //Motion sensor readings.
    private void motionreadingcardview(){
        motioncardview.add("  x-axis  --  y-axis  --   z-axis\n");
        motioncardview.add("   0.98   --    0.90   --    1.00\n");
        motioncardview.add("   2.98   --    0.92   --    1.23\n");
        motioncardview.add("   0.76   --    0.95   --    1.34\n");
        motioncardview.add("  65.50   --   9.99   --    0.40\n");
        motioncardview.add("  10.10   --   0.20   --   30.56\n");
        motioncardview.add("  43.30   --   6.30   --   56.33\n");



    }


}
