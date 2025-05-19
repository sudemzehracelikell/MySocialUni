package com.example.mysocialuni;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditProfileActivity extends AppCompatActivity {

    private static final int REQUEST_PICK_IMAGE = 2;
    private static final int REQUEST_CAPTURE_IMAGE = 3;
    private static final int REQUEST_PICK_CV = 4;

    private Uri selectedImageUri;
    private Uri selectedCVUri;
    private String currentPhotoPath;

    private ImageView imageViewProfileEdit;
    private EditText editTextName, editTextEmail, editTextDepartment, editTextClass;
    private Button buttonAddCV, buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        imageViewProfileEdit = findViewById(R.id.imageViewProfileEdit);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextDepartment = findViewById(R.id.editTextDepartment);
        editTextClass = findViewById(R.id.editTextClass);
        buttonAddCV = findViewById(R.id.buttonAddCV);
        buttonSave = findViewById(R.id.buttonSave);

        // Load previous data
        Intent intent = getIntent();
        if (intent != null) {
            editTextName.setText(intent.getStringExtra("name"));
            editTextEmail.setText(intent.getStringExtra("email"));
            editTextDepartment.setText(intent.getStringExtra("department"));
            editTextClass.setText(intent.getStringExtra("class"));
        }

        imageViewProfileEdit.setOnClickListener(v -> {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(EditProfileActivity.this);
            builder.setTitle("Fotoğraf Seç");

            String[] options = {"Galeriden Seç", "Kamera ile Çek"};
            builder.setItems(options, (dialog, which) -> {
                if (which == 0) {
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK);
                    galleryIntent.setType("image/*");
                    startActivityForResult(galleryIntent, REQUEST_PICK_IMAGE);
                } else if (which == 1) {
                    dispatchTakePictureIntent();
                }
            });

            builder.show();
        });

        buttonAddCV.setOnClickListener(v -> {
            Intent cvIntent = new Intent(Intent.ACTION_GET_CONTENT);
            cvIntent.setType("*/*");
            startActivityForResult(Intent.createChooser(cvIntent, "CV Dosyası Seç"), REQUEST_PICK_CV);
        });

        buttonSave.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();
            String department = editTextDepartment.getText().toString();
            String className = editTextClass.getText().toString();

            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", name);
            resultIntent.putExtra("email", email);
            resultIntent.putExtra("department", department);
            resultIntent.putExtra("class", className);

            if (selectedImageUri != null) {
                resultIntent.putExtra("profileImage", selectedImageUri.toString());
            }

            if (selectedCVUri != null) {
                resultIntent.putExtra("cvUri", selectedCVUri.toString());
            }

            Toast.makeText(EditProfileActivity.this, "Profil başarıyla güncellendi!", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Toast.makeText(this, "Fotoğraf oluşturulamadı!", Toast.LENGTH_SHORT).show();
            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        getPackageName() + ".provider",
                        photoFile);
                selectedImageUri = photoURI;
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_CAPTURE_IMAGE);
            }
        }
    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM + "/Camera");
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_PICK_IMAGE && data != null) {
                selectedImageUri = data.getData();
                imageViewProfileEdit.setImageURI(selectedImageUri);
            }
                else if (requestCode == REQUEST_CAPTURE_IMAGE) {
                    if (selectedImageUri != null) {
                        imageViewProfileEdit.setImageURI(selectedImageUri);

                        // Refresh Gallery AFTER the photo is taken ✅
                        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                        mediaScanIntent.setData(selectedImageUri);
                        sendBroadcast(mediaScanIntent);
                    }
                }

                imageViewProfileEdit.setImageURI(selectedImageUri);
            } else if (requestCode == REQUEST_PICK_CV && data != null) {
                selectedCVUri = data.getData();
                Toast.makeText(this, "CV seçildi!", Toast.LENGTH_SHORT).show();
            }
        }
    }

