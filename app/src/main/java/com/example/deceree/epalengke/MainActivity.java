package com.example.deceree.epalengke;


import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Context self = this;
    TextInputEditText txtUsername, txtPassword;
    Button btnLogin, btnSignup;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = findViewById(R.id.idUserName);
        txtPassword = findViewById(R.id.idPassword);
        btnLogin = findViewById(R.id.idBtnLogin);
        btnSignup = findViewById(R.id.idBtnSignup);

        btnSignup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(self, SignupActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                login();


            }
        });
    }

    private void login() {
        if (TextUtils.isEmpty(txtUsername.getText().toString().trim()) ||
                TextUtils.isEmpty(txtPassword.getText().toString().trim())) {
            txtUsername.setError("Field can't be Empty");
            txtPassword.setError("Field can't be Empty");
        }else if (emailValidator(txtUsername.getText().toString())){
            txtUsername.setError("Please enter valid email address");
        }else {
            Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, MainmenuActivity.class);
            startActivity(intent);
        }
    }

    private boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
