package com.example.mysejahtera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //navigate to login page text css
        TextView redirect_login = findViewById(R.id.redirect_login);

        String text = "Have Account? Log in here";
        SpannableString ss = new SpannableString(text);

        ForegroundColorSpan fcsBlue = new ForegroundColorSpan(0xFF3E73FF);
        ForegroundColorSpan fcsBlack = new ForegroundColorSpan(Color.BLACK);

        ss.setSpan(fcsBlack, 0, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(fcsBlue, 14, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        redirect_login.setText(ss);
    }

    public void navigateDashboard(View view) {
        Intent intent = new Intent(Register.this, BottomNavigation.class);
        startActivity(intent);
    }

    public void navigateSignInPage(View view) {
        Intent myIntent = new Intent(Register.this, SignIn.class);
        startActivity(myIntent);
    }
}