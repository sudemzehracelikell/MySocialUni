package com.example.mysocialuni;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileMenuActivity extends AppCompatActivity {

    static class MenuItemData {
        int iconResId;
        String text;

        MenuItemData(int iconResId, String text) {
            this.iconResId = iconResId;
            this.text = text;
        }
    }

    private TextView nameText, emailText;
    private ImageView profileImageView;
    private LinearLayout menuLayout;

    private static final int EDIT_PROFILE_REQUEST = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_menu);

        nameText = findViewById(R.id.userName);
        emailText = findViewById(R.id.userEmail);
        profileImageView = findViewById(R.id.profileImage);
        menuLayout = findViewById(R.id.menuSection);

        findViewById(R.id.backButton).setOnClickListener(v -> finish());


        loadProfileInfo();

        MenuItemData[] menuItems = {
                new MenuItemData(R.drawable.ic_bell, "Proje İstekleri"),
                new MenuItemData(R.drawable.ic_projects, "Katıldığım Projeler"),
                new MenuItemData(R.drawable.ic_edit, "Profilini Düzenle"),
                new MenuItemData(R.drawable.ic_settings, "Ayarlar"),
                new MenuItemData(R.drawable.ic_logout, "Çıkış Yap"),
        };

        for (MenuItemData item : menuItems) {
            View itemView = getLayoutInflater().inflate(R.layout.menu_item, menuLayout, false);
            ImageView icon = itemView.findViewById(R.id.icon);
            TextView text = itemView.findViewById(R.id.text);

            icon.setImageResource(item.iconResId);
            text.setText(item.text);

            itemView.setOnClickListener(v -> {
                if (item.text.equals("Proje İstekleri")) {
                    startActivity(new Intent(ProfileMenuActivity.this, ProjectRequestsActivity.class));
                }

                else if (item.text.equals("Profilini Düzenle")) {
                    Intent intent = new Intent(this, EditProfileActivity.class);
                    startActivityForResult(intent, EDIT_PROFILE_REQUEST);

                } else if (item.text.equals("Çıkış Yap")) {
                    finish();
                }
            });

            menuLayout.addView(itemView);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadProfileInfo();
    }

    private void loadProfileInfo() {
        SharedPreferences prefs = getSharedPreferences("userProfile", MODE_PRIVATE);
        String name = prefs.getString("name", "Yusuf Deliğöz");
        String email = prefs.getString("email", "yusufdeligoz@gmail.com");
        String profileImage = prefs.getString("profileImage", null);

        nameText.setText(name);
        emailText.setText(email);

        if (profileImage != null) {
            profileImageView.setImageURI(Uri.parse(profileImage));
        } else {
            profileImageView.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }
}
