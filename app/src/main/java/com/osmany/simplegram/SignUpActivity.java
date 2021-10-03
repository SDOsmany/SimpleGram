package com.osmany.simplegram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    public static final String TAG = "SignUpActivity";
    EditText etUsernameSignUp;
    EditText etPasswordSignUp;
    Button btnSignup;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsernameSignUp = findViewById(R.id.etUsernameSignUp);
        etPasswordSignUp = findViewById(R.id.etPasswordSignUp);
        btnSignup = findViewById(R.id.btnSignUp);
        tvLogin = findViewById(R.id.tvLogin);

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLogin();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String username = etUsernameSignUp.getText().toString();
               String password = etPasswordSignUp.getText().toString();
               signUp(username,password);
            }
        });

    }
    private void signUp(String username, String password){


        if(!username.isEmpty() && !password.isEmpty() ) {
            // Create the ParseUser
            ParseUser user = new ParseUser();
            // Set core properties
            user.setUsername(username);
            user.setPassword(password);
            // Invoke signUpInBackground
        Toast.makeText(SignUpActivity.this, "sign up info: "+ user.getUsername(), Toast.LENGTH_SHORT).show();

        user.signUpInBackground(new SignUpCallback() {
                public void done(ParseException e) {
//                    Toast.makeText(SignUpActivity.this, "issue signing up", Toast.LENGTH_SHORT).show();
                    if (e != null) {
                        Log.e(TAG, "Issue with signing up", e);
                        Toast.makeText(SignUpActivity.this, "issue signing up", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        Toast.makeText(SignUpActivity.this
                                , "you have successfully signed up"
                                , Toast.LENGTH_SHORT).show();
                        ParseUser.logOut();
                        goLogin();
                    }
                }
            });
        }else Toast.makeText(SignUpActivity.this
                , "Cannot leave fields empty"
                , Toast.LENGTH_SHORT).show();
    }
    private void goLogin(){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
