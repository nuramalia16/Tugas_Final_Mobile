//////package com.example.flashnews.Activity;
//////
//////import android.os.Bundle;
//////
//////import androidx.appcompat.app.AppCompatActivity;
//////
//////import com.example.flashnews.R;
//////
//////public class EditProfileActivity extends AppCompatActivity {
//////
//////    @Override
//////    protected void onCreate(Bundle savedInstanceState) {
//////        super.onCreate(savedInstanceState);
//////        setContentView(R.layout.activity_edit_profile);
//////    }
//////}
////package com.example.flashnews.Activity;
////
////import android.os.Bundle;
////import android.widget.Button;
////import android.widget.EditText;
////import android.widget.Toast;
////
////import androidx.appcompat.app.AppCompatActivity;
////
////import com.example.flashnews.Models.User;
////import com.example.flashnews.R;
////import com.example.flashnews.SQLite.DatabaseHelper;
////
////public class EditProfileActivity extends AppCompatActivity {
////    private EditText newNameEditText, newPhoneEditText;
////    private Button saveButton;
////    private DatabaseHelper databaseHelper;
////    private User currentUser;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_edit_profile);
////
////        newNameEditText = findViewById(R.id.et_new_name);
////        newPhoneEditText = findViewById(R.id.et_new_phone);
////        saveButton = findViewById(R.id.btn_save);
////        databaseHelper = new DatabaseHelper(this);
////
////        // Get current user data from Intent
////        String email = getIntent().getStringExtra("email");
////        if (email != null) {
////            currentUser = databaseHelper.getUser(email); // Get user data from database based on email
////            if (currentUser != null) {
////                newNameEditText.setText(currentUser.getName());
////                newPhoneEditText.setText(currentUser.getPhone());
////            }
////        }
////
////        // Handle Save button click
////        saveButton.setOnClickListener(v -> {
////            String newName = newNameEditText.getText().toString().trim();
////            String newPhone = newPhoneEditText.getText().toString().trim();
////
////            if (newName.isEmpty() || newPhone.isEmpty()) {
////                Toast.makeText(EditProfileActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
////            } else {
////                // Update user data in database
////                boolean isUpdated = databaseHelper.updateUser(currentUser.getId(), newName, newPhone);
////                if (isUpdated) {
////                    Toast.makeText(EditProfileActivity.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
////                    finish(); // Close EditProfileActivity after update
////                } else {
////                    Toast.makeText(EditProfileActivity.this, "Failed to update profile", Toast.LENGTH_SHORT).show();
////                }
////            }
////        });
////    }
////}
//package com.example.flashnews.Activity;
//
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.flashnews.Models.User;
//import com.example.flashnews.R;
//import com.example.flashnews.SQLite.DatabaseHelper;
//
//public class EditProfileActivity extends AppCompatActivity {
//    private EditText newNameEditText, newPhoneEditText;
//    private Button saveButton;
//    private DatabaseHelper databaseHelper;
//    private User currentUser;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit_profile);
//
//        newNameEditText = findViewById(R.id.et_new_name);
//        newPhoneEditText = findViewById(R.id.et_new_phone);
//        saveButton = findViewById(R.id.btn_save);
//        databaseHelper = new DatabaseHelper(this);
//
//        // Get current user data from Intent
//        String email = getIntent().getStringExtra("email");
//        if (email != null) {
//            currentUser = databaseHelper.getUser(email); // Get user data from database based on email
//            if (currentUser != null) {
//                newNameEditText.setText(currentUser.getName());
//                newPhoneEditText.setText(currentUser.getPhone());
//            }
//        }
//
//        // Handle Save button click
//        saveButton.setOnClickListener(v -> {
//            String newName = newNameEditText.getText().toString().trim();
//            String newPhone = newPhoneEditText.getText().toString().trim();
//
//            if (newName.isEmpty() || newPhone.isEmpty()) {
//                Toast.makeText(EditProfileActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
//            } else {
//                // Update user data in database
//                boolean isUpdated = databaseHelper.updateUser(currentUser.getId(), newName, newPhone);
//                if (isUpdated) {
//                    Toast.makeText(EditProfileActivity.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
//                    finish(); // Close EditProfileActivity after update
//                } else {
//                    Toast.makeText(EditProfileActivity.this, "Failed to update profile", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//}
package com.example.flashnews.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flashnews.Models.User;
import com.example.flashnews.R;
import com.example.flashnews.SQLite.DatabaseHelper;

public class EditProfileActivity extends AppCompatActivity {
    private EditText newNameEditText, newPhoneEditText;
    private Button saveButton;
    private DatabaseHelper databaseHelper;
    private User currentUser;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        newNameEditText = findViewById(R.id.et_new_name);
        newPhoneEditText = findViewById(R.id.et_new_phone);
        saveButton = findViewById(R.id.btn_save);
        databaseHelper = new DatabaseHelper(this);

        email = getIntent().getStringExtra("email");
        if (email != null) {
            currentUser = databaseHelper.getUser(email);
            if (currentUser != null) {
                newNameEditText.setText(currentUser.getName());
                newPhoneEditText.setText(currentUser.getPhone());
            }
        }

        saveButton.setOnClickListener(v -> {
            String newName = newNameEditText.getText().toString().trim();
            String newPhone = newPhoneEditText.getText().toString().trim();

            if (newName.isEmpty() || newPhone.isEmpty()) {
                Toast.makeText(EditProfileActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                boolean isUpdated = databaseHelper.updateUser(currentUser.getId(), newName, newPhone);
                if (isUpdated) {
                    Toast.makeText(EditProfileActivity.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(EditProfileActivity.this, ProfileActivity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(EditProfileActivity.this, "Failed to update profile", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
