package com.example.mysocialuni;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddProjectActivity extends AppCompatActivity {

    private ImageButton goback;

    private ImageView projectPhoto;

    private Button addPhotoProject;
    private Button addProjectOkey;
    private Button addMembersProject;
    private Button addInPhotosProject;

    private EditText projectName;
    private EditText projectDesc;

    private void init(){
        goback = findViewById(R.id.imageButton_goBack);

        projectPhoto = findViewById(R.id.imageView_projectPhoto);

        addPhotoProject = findViewById(R.id.button_addPhotoProject);
        addProjectOkey = findViewById(R.id.button_addProjectOkey);
        addMembersProject = findViewById(R.id.button_addMembersProject);

        addInPhotosProject = findViewById(R.id.button_addInPhotosProject);

        projectName = findViewById(R.id.editText_projectName);
        projectDesc = findViewById(R.id.editText_projectDesc);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_project);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        goback.setOnClickListener(v -> finish());
    }
}