package com.example.gursehajharika.dronomatic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class register extends AppCompatActivity {

    private Button alreadyre;
    private Button register;

    public void backtostart(){
        alreadyre =  (Button)findViewById(R.id.alreadyreg);
        alreadyre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
    public void toaster(){

        Toast.makeText(this,"User has been created.",Toast.LENGTH_LONG).show();
    }
    public void reger(){
        register= (Button)findViewById(R.id.reg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toaster();
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        backtostart();
        reger();
    }
}
