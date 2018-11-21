package com.example.gursehajharika.dronomatic;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class baropress extends AppCompatActivity {

    public Button homer;
    public EditText readingb;
    ArrayList<String> baroreadings = new ArrayList<String>();
    private ActionBar toolbar;
    public ListView listView ;
    public ListView listView2;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference Reading = database.getReference("Reading");

    private static final String TAG = "baropress";
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthlistener;
    private DatabaseReference mRef;

    String Userid;
   // String DESCRIPTION;

   String[] TIMER = {"10:30","10:31","10:32","10:33","10:34","10:35","10:36","10:37","10:38","10:39","10:30","10:31","10:32","10:33"};
   String[] DESCRIPTION = {"200ft   --  31.02","400ft   --  35.02","200ft   --  31.02","400ft   --  35.02","200ft   --  31.02","400ft   --  35.02","200ft   --  31.02","400ft   --  35.02","200ft   --  31.02","400ft   --  35.02","200ft   --  31.02","400ft   --  35.02","200ft   --  31.02","400ft   --  35.02"};

    private void arraybarometric(){
        baroreadings.add("    Altitude   -- Baro Pressure \n");
        baroreadings.add("      200ft   --      31.02  \n");
        baroreadings.add("      400ft   --      32.51 \n");
        baroreadings.add("      750ft   --      45.67 \n");
        baroreadings.add("      920ft   --      58.12 \n");
        baroreadings.add("      869ft   --      10.22 \n");
        baroreadings.add("      420ft   --      90.23 \n");
        baroreadings.add("      120ft   --      37.55 \n");
        baroreadings.add("      200ft   --      31.02 \n");
        baroreadings.add("      400ft   --      32.51 \n");
        baroreadings.add("      750ft   --      45.67 \n");
        baroreadings.add("      920ft   --      58.12 \n");
        baroreadings.add("      869ft   --      10.22 \n");
        baroreadings.add("      420ft   --      90.23 \n");
        baroreadings.add("      120ft   --      37.55 \n");
        baroreadings.add("      200ft   --      31.02 \n");
        baroreadings.add("      400ft   --      32.51 \n");
        baroreadings.add("      750ft   --      45.67 \n");
        baroreadings.add("      920ft   --      58.12 \n");
        baroreadings.add("      869ft   --      10.22 \n");
        baroreadings.add("      420ft   --      90.23 \n");
        baroreadings.add("      120ft   --      37.55 \n");
        baroreadings.add("      200ft   --      31.02 \n");
        baroreadings.add("      400ft   --      32.51 \n");
        baroreadings.add("      750ft   --      45.67 \n");
        baroreadings.add("      920ft   --      58.12 \n");
        baroreadings.add("      869ft   --      10.22 \n");
        baroreadings.add("      420ft   --      90.23 \n");
        baroreadings.add("      120ft   --      37.55 \n");
        baroreadings.add("      200ft   --      31.02 \n");
        baroreadings.add("      400ft   --      32.51 \n");
        baroreadings.add("      750ft   --      45.67 \n");
        baroreadings.add("      920ft   --      58.12 \n");
        baroreadings.add("      869ft   --      10.22 \n");
        baroreadings.add("      420ft   --      90.23 \n");
        baroreadings.add("      120ft   --      37.55 \n");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baropress);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        setTitle("Barometric Pressure");

        //Array for creating values on the page.

                //   readingb = findViewById(R.id.TextView);
                //    arraybarometric();
        // for(int i=0;i<baroreadings.size();i++) {

        //      readingb.setText(readingb.getText() + baroreadings.get(i));
        // }
      //   readingb.setText(Arrays.toString(new ArrayList[]{baroreadings}));


/*
        // Read from the database
        Reading.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String DESCRIPTION = dataSnapshot.getValue(String.class);

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference();


        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
*/
        listView = (ListView)findViewById(R.id.listview);
        listView2 = (ListView)findViewById(R.id.listview2);
        ListAdapter listAdapter = new Baropress_customAdapter(this,TIMER);
        ListAdapter listAdapter1= new Baropress_customAdapter1(this,DESCRIPTION);
        listView.setAdapter(listAdapter1);
        listView2.setAdapter(listAdapter);

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

    private void showData(DataSnapshot dataSnapshot) {
        DataSnapshot ds = (DataSnapshot) dataSnapshot.getChildren();

        if (ds != null){
       //     DESCRIPTION =
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomnavigationbar = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            if (menuItem.getItemId() == R.id.bottomtemp){
                finish();
                Intent bottomtemperature = new Intent(baropress.this,temperature.class);
                startActivity(bottomtemperature);

            }
            else if (menuItem.getItemId() == R.id.bottomotion){
                finish();
                Intent bottommotion = new Intent(baropress.this,Motionsense.class);
                startActivity(bottommotion);
            }
            else{
                finish();
                Intent bottombaro = new Intent(baropress.this,baropress.class);
                startActivity(bottombaro);
            }
            return false;
        }
    };

}
