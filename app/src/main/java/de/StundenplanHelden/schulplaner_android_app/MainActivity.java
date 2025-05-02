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

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

        Verwaltung verwaltung = Verwaltung.getInstance();
        Gson gson = new Gson();

        try {
            verwaltung.stundenplan = gson.fromJson(Verwaltung.readFile(getFilesDir().getPath()+Verwaltung.STUNDENPLAN_FILE_NAME, StandardCharsets.UTF_8), Stundenplan.class);

            String fächerJson = Verwaltung.readFile(getFilesDir().getPath()+Verwaltung.FÄCHER_FILE_NAME,StandardCharsets.UTF_8);
            Type listType = new TypeToken<List<Fach>>(){}.getType();
            List<Fach> fächer = gson.fromJson(fächerJson, listType);
            verwaltung.fächer = new ArrayList<>(fächer);

        } catch (Exception e) {
            Log.e("MainActivity", "Catch Data from JSON: "+ e);
        }

    }

    public void createFiles(){
        //Hier werden alle Files erstellt bei getFilesDir()
        try{
            File profileFile = new File(getFilesDir(), Verwaltung.PROFILE_FILE_NAME);
            if (profileFile.createNewFile()){
                //Wenn die Datei vom Profil noch nicht existier (beim ersten Start) wird dieser Nutzer eingefügt
                Verwaltung.writeFile(getFilesDir().getPath()+Verwaltung.PROFILE_FILE_NAME, Verwaltung.getInstance().erstelleBeispielNutzerJSON(), StandardCharsets.UTF_8);
            }
            Log.e("FATAL", "FAtal Profil passed");


            File fächerFile = new File(getFilesDir(), Verwaltung.FÄCHER_FILE_NAME);
            if (fächerFile.createNewFile()){
                //Wenn die Datei von Fächern noch nicht existiert (beim ersten Start) werden diese Fächer eigefügt
                Verwaltung.writeFile(getFilesDir().getPath()+Verwaltung.FÄCHER_FILE_NAME, Verwaltung.getInstance().erstelleBeispielFächerJSON(), StandardCharsets.UTF_8);
            }
            Log.e("FATAL", "FAtal Fächer passed");

            File stundenplanFile = new File(getFilesDir(), Verwaltung.STUNDENPLAN_FILE_NAME);
            if (stundenplanFile.createNewFile()){
                Log.e("FATAL", "FATAL Stundenplan Creating");
                //Wenn die Datei von Fächern noch nicht existiert (beim ersten Start) werden diese Fächer eigefügt
                Verwaltung.writeFile(getFilesDir().getPath()+Verwaltung.STUNDENPLAN_FILE_NAME, Verwaltung.getInstance().erstelleBeispielStundenplanJSON(), StandardCharsets.UTF_8);
                Log.e("FATAL", "FATAL Stundenplan Created");
            }
            Log.e("FATAL", "FAtal Stundenplan passed");

        }
        catch (Exception e) {
            Log.e("MainActivity", "CreateFiles: "+ e);
        }
    }
}