package de.StundenplanHelden.schulplaner_android_app;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        createFiles();
    }

    public void createFiles(){

        //Hier werden alle Files erstellt bei getFilesDir()
        try{
            File profileFile = new File(getFilesDir(), Verwaltung.PROFILE_FILE_NAME);
            if (profileFile.createNewFile()){
                //Wenn die Datei vom Profil noch nicht existier (beim ersten Start) wird dieser Nutzer eingefügt
                Verwaltung.getInstance().writeFile(getFilesDir().getPath()+Verwaltung.PROFILE_FILE_NAME, Verwaltung.getInstance().erstelleBeispielNutzerJSON(), StandardCharsets.UTF_8);
            }

        }
        catch (Exception e) {
            Log.e("MainActivity", "CreateFiles: "+ e);
        }
    }
}