package com.example.mysocialuni;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private static final int REQUEST_EDIT_PROFILE = 1;

    private Uri selectedImageUri;
    private Uri selectedCVUri;

    private ImageView imageViewProfile;
    private TextView textViewName, textViewEmail, textViewDepartment, textViewClass, textViewUniversity, textViewCV;
    private Button buttonEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageViewProfile = findViewById(R.id.imageViewProfile);
        textViewName = findViewById(R.id.textViewName);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewDepartment = findViewById(R.id.textViewDepartment);
        textViewClass = findViewById(R.id.textViewClass);
        textViewUniversity = findViewById(R.id.textViewUniversity);
        textViewCV = findViewById(R.id.textViewCV);
        buttonEditProfile = findViewById(R.id.buttonEditProfile);

        buttonEditProfile.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
            intent.putExtra("name", textViewName.getText().toString());
            intent.putExtra("email", textViewEmail.getText().toString());
            intent.putExtra("department", textViewDepartment.getText().toString());
            intent.putExtra("class", textViewClass.getText().toString());
            startActivityForResult(intent, REQUEST_EDIT_PROFILE);
        });
//asad
        // CV click to open file
        textViewCV.setOnClickListener(v -> {
            if (selectedCVUri != null) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(selectedCVUri);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(intent, "CV Aç"));


                try {
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(ProfileActivity.this, "CV açılamadı!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_EDIT_PROFILE && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            String email = data.getStringExtra("email");
            String department = data.getStringExtra("department");
            String className = data.getStringExtra("class");
            String profileImageUriString = data.getStringExtra("profileImage");
            String cvUriString = data.getStringExtra("cvUri");

            if (name != null) textViewName.setText(name);
            if (email != null) textViewEmail.setText(email);
            if (department != null) textViewDepartment.setText(department);
            if (className != null) textViewClass.setText(className);

            if (profileImageUriString != null) {
                selectedImageUri = Uri.parse(profileImageUriString);
                imageViewProfile.setImageURI(selectedImageUri);
            }

            if (cvUriString != null) {
                selectedCVUri = Uri.parse(cvUriString);
                textViewCV.setText("CV seçildi (tıklayın)");
            }
        }
    }
}
