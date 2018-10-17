package com.example.gursehajharika.dronomatic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static android.media.CamcorderProfile.get;

public class temperature extends AppCompatActivity {

    public Button homer;
    public EditText readingt;
    ArrayList<String> tempreadings = new ArrayList<String>();


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

        readingt = (EditText) findViewById(R.id.TextView);
        arrayconstruction();
        for(int i=0;i<tempreadings.size();i++) {
            readingt.append(tempreadings.get(i));

        }
        readingt.setText(Arrays.toString(new ArrayList[]{tempreadings}));


        homer = (Button)findViewById(R.id.button);
        homer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
