package com.example.mysocialuni;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ASBoşSayfaActivity extends AppCompatActivity {

    private Button geriDonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.as_resim_button);  // XML layout dosyasını bağla

        geriDonButton = findViewById(R.id.geri_don_button);  // Geri dön butonunu bul

        geriDonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ana sayfaya dön
                //Intent intent = new Intent(BosSayfaActivity.this, MainActivity.class);
               // startActivity(intent);
                finish();  // Geçerli activity'yi kapat
            }
        });
    }
}
