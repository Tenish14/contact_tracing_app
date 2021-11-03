package com.example.mysejahtera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    SharedPreferences sp;
    EditText nameView, phoneNumberView, passwordView, confirmPasswordView, nricView;
    String name, phoneNumber, password, confirmPassword, nric;
    Button registerBtn;

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

        // Get all views
        nameView = findViewById(R.id.name);
        phoneNumberView = findViewById(R.id.phoneNumber);
        passwordView = findViewById(R.id.password);
        confirmPasswordView = findViewById(R.id.confirmPassword);
        nricView = findViewById(R.id.nric);
        registerBtn = findViewById(R.id.button);

        sp = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();

                if (nameView.getText().toString().isEmpty()) {
                    Toast.makeText(Register.this, "Name is required", Toast.LENGTH_LONG).show();
                    return;
                }

                if (phoneNumberView.getText().toString().isEmpty()) {
                    Toast.makeText(Register.this, "Phone number is required", Toast.LENGTH_LONG).show();
                    return;
                }

                if (nricView.getText().toString().isEmpty()) {
                    Toast.makeText(Register.this, "IC number is required", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!passwordView.getText().toString().equals(confirmPasswordView.getText().toString())) {
                    Toast.makeText(Register.this, "Password don't match", Toast.LENGTH_LONG).show();
                    return;
                }

                editor.putString("name", nameView.getText().toString());
                editor.putString("phoneNumber", phoneNumberView.getText().toString());
                editor.putString("nric", nricView.getText().toString());
                editor.putString("password", passwordView.getText().toString());

                editor.apply();
                Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(v.getContext(), BottomNavigation.class);
                startActivity(intent);
            }
        });
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