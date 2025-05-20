package com.example.mysocialuni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddEventActivity extends AppCompatActivity {

    private EditText editTextGun, editTextAy, editTextBaslik, editTextAciklama;
    private Button btnKaydet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        editTextGun = findViewById(R.id.editTextGun);
        editTextAy = findViewById(R.id.editTextAy);
        editTextBaslik = findViewById(R.id.editTextBaslik);
        editTextAciklama = findViewById(R.id.editTextAciklama);
        btnKaydet = findViewById(R.id.btnEtkinlikKaydet);

        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gun = editTextGun.getText().toString();
                String ay = editTextAy.getText().toString();
                String baslik = editTextBaslik.getText().toString();
                String aciklama = editTextAciklama.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("gun", gun);
                resultIntent.putExtra("ay", ay);
                resultIntent.putExtra("baslik", baslik);
                resultIntent.putExtra("aciklama", aciklama);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
