package com.example.mysejahtera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GetStarted extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
    }

    public void navigateSignInPage(View view) {
        Intent intent = new Intent(GetStarted.this, SignIn.class);
        startActivity(intent);
    }

    public void navigateRegisterPage(View view) {
        Intent intent = new Intent(GetStarted.this, Register.class);
        startActivity(intent);
    }
}