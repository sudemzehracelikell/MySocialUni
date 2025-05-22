package com.example.mysocialuni;
import java.io.IOException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import java.util.Date;
import java.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;
import java.io.File;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;


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


        SharedPreferences prefs = getSharedPreferences("userProfile", MODE_PRIVATE);
        String name = prefs.getString("name", "");
        String email = prefs.getString("email", "");
        String department = prefs.getString("department", "");
        String classYear = prefs.getString("class", "");
        String imageUri = prefs.getString("profileImage", "");

        editTextName.setText(name);
        editTextEmail.setText(email);
        editTextDepartment.setText(department);
        editTextClass.setText(classYear);

        if (!imageUri.isEmpty()) {
            selectedImageUri = Uri.parse(imageUri);
            imageViewProfileEdit.setImageURI(selectedImageUri);
        }

        imageViewProfileEdit.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Fotoğraf Seç");
            builder.setItems(new String[]{"Galeriden Seç", "Kamera ile Çek"}, (dialog, which) -> {
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
            String newName = editTextName.getText().toString();
            String newEmail = editTextEmail.getText().toString();
            String newDepartment = editTextDepartment.getText().toString();
            String newClass = editTextClass.getText().toString();

            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("name", newName);
            editor.putString("email", newEmail);
            editor.putString("department", newDepartment);
            editor.putString("class", newClass);
            if (selectedImageUri != null) {
                editor.putString("profileImage", selectedImageUri.toString());
            }
            editor.apply();

            Toast.makeText(this, "Profil güncellendi!", Toast.LENGTH_SHORT).show();

            setResult(RESULT_OK); // Inform ProfileMenuActivity
            finish();
        });


        findViewById(R.id.iconEditName).setOnClickListener(v -> editTextName.requestFocus());
        findViewById(R.id.iconEditEmail).setOnClickListener(v -> editTextEmail.requestFocus());
        findViewById(R.id.iconEditDepartment).setOnClickListener(v -> editTextDepartment.requestFocus());
        findViewById(R.id.iconEditClass).setOnClickListener(v -> editTextClass.requestFocus());
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Toast.makeText(this, "Hata oluştu!", Toast.LENGTH_SHORT).show();
            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this, getPackageName() + ".provider", photoFile);
                selectedImageUri = photoURI;
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_CAPTURE_IMAGE);
            }
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
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
            } else if (requestCode == REQUEST_CAPTURE_IMAGE) {
                if (selectedImageUri != null) {
                    imageViewProfileEdit.setImageURI(selectedImageUri);

                    Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    mediaScanIntent.setData(selectedImageUri);
                    sendBroadcast(mediaScanIntent);
                }


        }
            } else if (requestCode == REQUEST_PICK_CV && data != null) {
                selectedCVUri = data.getData();
                Toast.makeText(this, "CV seçildi!", Toast.LENGTH_SHORT).show();
            }
        }
    }

