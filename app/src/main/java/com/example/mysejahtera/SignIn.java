package com.example.mysejahtera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    SharedPreferences sp;
    EditText phoneNumberView, passwordView;
    TextView displayNameView;
    String phoneNumber, password, displayName;
    Button signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        phoneNumberView = findViewById(R.id.phoneNumber);
        passwordView = findViewById(R.id.password);
        displayNameView = findViewById(R.id.displayName);
        signInBtn = findViewById(R.id.signInBtn);

        sp = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);

        phoneNumber = sp.getString("phoneNumber", "");
        password = sp.getString("password", "");
        displayName = sp.getString("name", "");

        displayNameView.setText(displayName.isEmpty() ? "" : displayName);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phoneNumberView.getText().toString().isEmpty()) {
                    Toast.makeText(SignIn.this, "Phone Number Missing", Toast.LENGTH_LONG).show();
                    return;
                }

                if (passwordView.getText().toString().isEmpty()) {
                    Toast.makeText(SignIn.this, "Password is missing", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!phoneNumberView.getText().toString().equals(phoneNumber)) {
                    Toast.makeText(SignIn.this, "Incorrect phone number", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!passwordView.getText().toString().equals(password)) {
                    Toast.makeText(SignIn.this, "Incorrect password", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(v.getContext(), BottomNavigation.class);
                startActivity(intent);
            }
        });
    }

    public void navigateDashboard(View view) {
        Intent intent = new Intent(SignIn.this, BottomNavigation.class);
        startActivity(intent);
    }

    public void navigateForgetPassword(View view) {
        Intent intent = new Intent(SignIn.this, ForgetPasswordActivity.class);
        startActivity(intent);
    }
}