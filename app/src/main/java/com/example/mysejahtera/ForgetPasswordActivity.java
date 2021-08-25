package com.example.mysejahtera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class ForgetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        //navigate to login page text css
        TextView redirect_login = findViewById(R.id.backtoLogin);

        String text = "Back to Login";
        SpannableString ss = new SpannableString(text);

        ForegroundColorSpan fcsBlue = new ForegroundColorSpan(0xFF3E73FF);
        ForegroundColorSpan fcsBlack = new ForegroundColorSpan(Color.BLACK);

        ss.setSpan(fcsBlack, 0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(fcsBlue, 9, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        redirect_login.setText(ss);
    }

    public void navigateSignInPage(View view) {
        Intent myIntent = new Intent(ForgetPasswordActivity.this, SignIn.class);
        startActivity(myIntent);
    }
}