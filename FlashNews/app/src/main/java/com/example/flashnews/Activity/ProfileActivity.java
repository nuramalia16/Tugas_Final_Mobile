package com.example.flashnews.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.flashnews.Models.User;
import com.example.flashnews.R;
import com.example.flashnews.SQLite.DatabaseHelper;

public class ProfileActivity extends AppCompatActivity {
    private TextView emailTextView, nameTextView, phoneTextView;
    private Button logoutButton, editProfileButton;
    private DatabaseHelper databaseHelper;
    private User currentUser;
    private String email;
    private boolean isDataLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        emailTextView = findViewById(R.id.email);
        nameTextView = findViewById(R.id.nameTextView);
        phoneTextView = findViewById(R.id.phoneTextView);
        editProfileButton = findViewById(R.id.btn_edit_profile);
        logoutButton = findViewById(R.id.btn_logout);
        databaseHelper = new DatabaseHelper(this);

        loadProfileData();


        logoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        editProfileButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
            intent.putExtra("email", email);
            startActivity(intent);
        });
    }
    private void loadProfileData() {
        email = getIntent().getStringExtra("email");
        if (email != null) {
            emailTextView.setText("Email: " + email);
            currentUser = databaseHelper.getUser(email);
            if (currentUser != null) {
                nameTextView.setText("Name: " + currentUser.getName());
                phoneTextView.setText("Phone: " + currentUser.getPhone());
            }
        }
    }
}

