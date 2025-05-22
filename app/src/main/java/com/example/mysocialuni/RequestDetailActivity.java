package com.example.mysocialuni;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RequestDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_detail);

        // Back button
        findViewById(R.id.backButton).setOnClickListener(v -> finish());

        // Get data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String department = intent.getStringExtra("department");
        String classYear = intent.getStringExtra("class");
        String university = intent.getStringExtra("university");
        int imageRes = intent.getIntExtra("imageRes", R.drawable.ic_launcher_foreground);
        int cvRes = intent.getIntExtra("cvRes", R.drawable.ic_launcher_foreground);

        // Set data to views
        ((TextView) findViewById(R.id.textName)).setText(name);
        ((TextView) findViewById(R.id.textEmail)).setText(email);
        ((TextView) findViewById(R.id.textDepartment)).setText(department);
        ((TextView) findViewById(R.id.textClass)).setText(classYear);
        ((TextView) findViewById(R.id.textUniversity)).setText(university);
        ((ImageView) findViewById(R.id.imageProfile)).setImageResource(imageRes);
        ((ImageView) findViewById(R.id.imageCV)).setImageResource(cvRes);

        // Accept button
        findViewById(R.id.btnAccept).setOnClickListener(v -> {
            Toast.makeText(this, "Onaylandı", Toast.LENGTH_SHORT).show();
            finish();
        });

        // Reject button
        findViewById(R.id.btnReject).setOnClickListener(v -> {
            Toast.makeText(this, "Reddedildi", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
