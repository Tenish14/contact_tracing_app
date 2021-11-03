package com.example.mysejahtera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetPasswordActivity extends AppCompatActivity {

    SharedPreferences sp;
    EditText password, confirmPassword;
    Button resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        password = findViewById(R.id.newPassword);
        confirmPassword = findViewById(R.id.confirmPassword);
        resetBtn = findViewById(R.id.resetBtn);
        sp = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                if (password.getText().toString().isEmpty()) {
                    Toast.makeText(ForgetPasswordActivity.this, "Please enter a password", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
                    Toast.makeText(ForgetPasswordActivity.this, "Password don't match", Toast.LENGTH_LONG).show();
                    return;
                }

                editor.putString("password", password.getText().toString());

                editor.apply();
                Toast.makeText(ForgetPasswordActivity.this, "Reset Successfully", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ForgetPasswordActivity.this, SignIn.class);
                startActivity(intent);
            }
        });

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