package com.example.gursehajharika.dronomatic;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class loginwelcomeadmin extends AppCompatActivity {

    public TextView usernm;
    private static int SPLASH_TIME_OUT = 1500 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginwelcomeadmin);

        setTitle("");
        usernm = (TextView) findViewById(R.id.textView2);
        usernm.setText(""+ getIntent().getStringExtra("User") );

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run(){

                String usersession = usernm.getText().toString();
                Intent homeIntent = new Intent(loginwelcomeadmin.this, homepage.class);
                homeIntent.putExtra("session",usersession);
                startActivity(homeIntent);

                //   String quitmsg = .getText().toString();
                //   Intent quiter = new Intent();

                finish();

            }
        },SPLASH_TIME_OUT);
    }

}
