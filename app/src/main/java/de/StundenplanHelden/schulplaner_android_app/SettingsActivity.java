package de.StundenplanHelden.schulplaner_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;

import android.net.Uri;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    Switch styleSwitch;
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

        FragmentContainerView fragment = (FragmentContainerView) findViewById(R.id.fragmentContainerView5);

        styleSwitch = (Switch) findViewById(R.id.styleSwitch);
        if (Verwaltung.getInstance().styleGray){
            styleSwitch.setChecked(true);
        }

        styleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Aktion ausführen, wenn Switch eingeschaltet ist
                    Verwaltung.getInstance().styleGray = true;
                } else {
                    // Aktion ausführen, wenn Switch ausgeschaltet ist
                    Verwaltung.getInstance().styleGray = false;
                }
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView5, new Fragment(R.layout.fragment_menueleiste)).commitNow();
            }
        });
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