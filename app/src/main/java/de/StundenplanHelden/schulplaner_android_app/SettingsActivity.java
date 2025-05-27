package de.StundenplanHelden.schulplaner_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.net.Uri;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button profileEditButton = (Button) findViewById(R.id.bearbeitenButton);
        profileEditButton.setOnClickListener(v -> changeToProfileEditActivity());

        Button emailButton = (Button) findViewById(R.id.emailButton);
        emailButton.setOnClickListener(v -> sendToEmail());
    }

    private void changeToProfileEditActivity(){
        Intent i = new Intent(this, EditProfileActivity.class);
        startActivity(i);
    }

    private void sendToEmail(){
        String email = "jannismila@gmail.de";
        String subject = "Verbesserungsvorschlag Schulplaner Android App";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + email + "?subject=" + Uri.encode(subject)));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        startActivity(intent);
    }
}