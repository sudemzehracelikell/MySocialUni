package com.example.mysocialuni;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ASTanıtımActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.as_tanitim_button);

        Button geriDonButton = findViewById(R.id.geri_don_button);
        geriDonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Bu activity'yi kapat ve geri dön
            }
        });
    }
}
