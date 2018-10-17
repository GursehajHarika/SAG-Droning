package com.example.gursehajharika.dronomatic;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class baropress extends AppCompatActivity {

    public Button homer;
    public EditText readingb;
    ArrayList<String> baroreadings = new ArrayList<String>();

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

        readingb = (EditText) findViewById(R.id.TextView);
        arraybarometric();
        for(int i=0;i<baroreadings.size();i++) {
            readingb.append(baroreadings.get(i));
        }
        readingb.setText(Arrays.toString(new ArrayList[]{baroreadings}));

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
