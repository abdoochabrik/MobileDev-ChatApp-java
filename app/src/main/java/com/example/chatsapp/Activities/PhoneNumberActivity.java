package com.example.chatsapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chatsapp.databinding.ActivityPhoneNumberBinding;
import com.google.firebase.auth.FirebaseAuth;
public class PhoneNumberActivity extends AppCompatActivity {
  ActivityPhoneNumberBinding binding;
  FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
     /* if (auth.getCurrentUser() != null){
            Intent intent =new Intent(PhoneNumberActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }*/
        binding.continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneNumberActivity.this, OtpActivity.class);
                intent.putExtra("phonenumber",binding.phonebox.getText().toString());
                startActivity(intent);
            }
        });
    }
}