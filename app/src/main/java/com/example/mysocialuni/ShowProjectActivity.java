package com.example.mysocialuni;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowProjectActivity extends AppCompatActivity {

    private ImageButton goback;

    private ImageView projectPhoto;
    private TextView projectTitle;
    private TextView projectDescription;
    private Button button_joinProject;

    private ProjectsItem activeProject;

    private void init(){
        goback = findViewById(R.id.imageButton_goBackInShow);

        projectPhoto = findViewById(R.id.imageView_projectPhotoInShow);
        projectTitle = findViewById(R.id.textView_projectTitleInShow);
        projectDescription = findViewById(R.id.textView_projectDescriptionInShow);
        button_joinProject = findViewById(R.id.button_addProject);

        activeProject = (ProjectsItem) getIntent().getSerializableExtra("projectItem");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_project);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        goback.setOnClickListener(v -> finish());

        projectPhoto.setImageResource(activeProject.getImage());
        projectTitle.setText(activeProject.getTitle());
        projectDescription.setText(activeProject.getDesc());

        button_joinProject.setOnClickListener(v -> {
            Toast.makeText(this, "Katılma isteği gönderildi.", Toast.LENGTH_SHORT).show();
        });

    }
}