package com.example.materialdesign2;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText username;
    AppCompatEditText password;

    RelativeLayout relativeLayout;

    TextInputLayout usernameInputLayout;
    TextInputLayout passwordInputLayout;

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);


        relativeLayout = findViewById(R.id.activity_main);

        relativeLayout.setOnClickListener(null);


        usernameInputLayout = findViewById(R.id.inputlayout_username);
        passwordInputLayout = findViewById(R.id.inputlayout_password);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user == "admin" || pass == "password"){
                    Toast.makeText(getApplicationContext(), "OK",Toast.LENGTH_LONG).show();

                }else if(user == "admin" || pass == "password"){
                    Toast.makeText(getApplicationContext(), "OK ",Toast.LENGTH_LONG).show();

                }
            }
        });

        //password length counter

        passwordInputLayout.setCounterEnabled(true);
        passwordInputLayout.setCounterMaxLength(8);



        //set required field

        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(username.getText().toString().isEmpty())
                {
                    usernameInputLayout.setErrorEnabled(true);
                    usernameInputLayout.setError("Please enter username");
                }else{
                    usernameInputLayout.setErrorEnabled(false);
                }
            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(password.getText().toString().isEmpty())
                {
                    passwordInputLayout.setErrorEnabled(true);
                    passwordInputLayout.setError("Please enter password");
                }else{
                    passwordInputLayout.setErrorEnabled(false);
                }
            }
        });



        //setOnFucusChangeListner --> check it out
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //System.out.println("Test");

                if(username.getText().toString().isEmpty())
                {
                    usernameInputLayout.setErrorEnabled(true);
                    usernameInputLayout.setError("Please enter username");
                }else{
                    usernameInputLayout.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(password.getText().toString().isEmpty())
                {
                    passwordInputLayout.setErrorEnabled(true);
                    passwordInputLayout.setError("Please enter password");
                }else{
                    passwordInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
