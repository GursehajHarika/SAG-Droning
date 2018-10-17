package com.example.gursehajharika.dronomatic;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {


    public Button register;
    public EditText email;
    public EditText password;
    public Button signin;
    // private static int SPLASH_TIME_OUT = 2000 ;
    private int counter = 3;
    private TextView tv;
    public MenuView.ItemView quit;


    public void init() {

        signin = (Button) findViewById(R.id.signin);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(HomeActivity.this, register.class);
                startActivity(signup);

            }
        });

    }

    public void goinghome() {

        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                authenti(email.getText().toString(), password.getText().toString());
            }
        });

    }

    private void authenti(String userName, String userPassword) {
        if ((userName.equals("Gursehaj")) && (userPassword.equals("Gursehaj"))) {
            String nameuser = email.getText().toString();

            Intent sign = new Intent(HomeActivity.this, loginwelcomeadmin.class);
            sign.putExtra("User", nameuser);
            startActivity(sign);


        } else if (userName.equals("Shubham") && (userPassword.equals("$hubham"))) {

            String nameuser = email.getText().toString();

            Intent sign = new Intent(HomeActivity.this, loginwelcomeadmin.class);
            sign.putExtra("User", nameuser);
            startActivity(sign);

        } else if (userName.equals("Arman") && (userPassword.equals("Arman"))) {

            String nameuser = email.getText().toString();

            Intent sign = new Intent(HomeActivity.this, loginwelcomeadmin.class);
            sign.putExtra("User", nameuser);
            startActivity(sign);
        }
        else if (userName.equals("User@gmail.com") && (userPassword.equals("user"))) {

            String nameuser = email.getText().toString();

            Intent sign = new Intent(HomeActivity.this, Loginwelcome.class);
            sign.putExtra("User", nameuser);
            startActivity(sign);
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Invalid Email And password";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            counter--;
            attemps();
        }

    }

    public void attemps() {

        tv = (TextView) findViewById(R.id.tvinfo);
        tv.setText("Number of attempts left : " + counter);

        if (counter == 0) {
            signin.setEnabled(false);
        } else {
            signin.setEnabled(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        goinghome();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.homepagequit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.quit:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
