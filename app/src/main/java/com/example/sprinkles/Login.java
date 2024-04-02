package com.example.sprinkles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    EditText etname, etpassword;
    Button btnlogin, btnreset, btnsignup;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        etname = findViewById(R.id.lname);
        etpassword = findViewById(R.id.lpassword);
        btnlogin = findViewById(R.id.login);
        btnreset = findViewById(R.id.lreset);
        btnsignup = findViewById(R.id.Lsignup);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name = etname.getText().toString();
                String pass = etpassword.getText().toString();

                ArrayList<User> userDetails = dbHelper.ValidLogin(name, pass);

                if(name.isEmpty() || pass.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Inputs Are Empty. Please Try Again!" , Toast.LENGTH_LONG).show();
                }
                else if(userDetails.size()!=0)
                {
                    User user = userDetails.get(0);
                    String Type = user.getUsertype();

                    if(Type.toLowerCase().equals("admin"))
                    {
                        Toast.makeText(getApplicationContext(), " Admin login Successful" , Toast.LENGTH_LONG).show();
                        Intent Adminhome = new Intent(Login.this, Admin_Home.class);
                        startActivity(Adminhome);
                    }

                    else{
                        Toast.makeText(getApplicationContext(), " User login Successful" , Toast.LENGTH_LONG).show();
                        Intent Userpage = new Intent(Login.this, User_Home.class);
                        //Intent Userpage = new Intent(Login.this, Admin_Home.class);
                        startActivity(Userpage);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), " Username or password Wrong " , Toast.LENGTH_LONG).show();
                }
            }
        });


        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etname.setText("");
                etpassword.setText("");
            }
        });


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Admin = new Intent(Login.this, signup_user.class);
                startActivity(Admin);
            }
        });

    }
}