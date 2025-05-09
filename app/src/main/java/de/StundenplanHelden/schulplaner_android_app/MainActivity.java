package de.StundenplanHelden.schulplaner_android_app;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
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
import java.util.Arrays;
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
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        createFiles();

        Verwaltung verwaltung = Verwaltung.getInstance();
        Gson gson = new Gson();

        try {
            //verwaltung.stundenplan = gson.fromJson(Verwaltung.readFile(getFilesDir().getPath()+Verwaltung.STUNDENPLAN_FILE_NAME, StandardCharsets.UTF_8), Stundenplan.class);

            //String fächerJson = Verwaltung.readFile(getFilesDir().getPath()+Verwaltung.FÄCHER_FILE_NAME,StandardCharsets.UTF_8);
            //Type listType = new TypeToken<List<Fach>>(){}.getType();
            //List<Fach> fächer = gson.fromJson(fächerJson, listType);
            //verwaltung.fächer = new ArrayList<>(fächer);

            verwaltung.neueFächer(tlsFächer());
            verwaltung.neuerStundenplan(BGStundenplan.jannisStundenplan());

        } catch (Exception e) {
            Log.e("MainActivity", "Catch Data from JSON: "+ e);
        }

    }

    public ArrayList<Fach> tlsFächer(){
        //Erstelle Beispielfächer, die beim Starten der APP als JSON gespeichert werden
    ArrayList<Fach> fächer = new ArrayList<>(Arrays.asList(
        new Fach("Deutsch", getResources().getColor(R.color.Deutsch, null)),
        new Fach("Mathe", getResources().getColor(R.color.Mathematik, null)),
        new Fach("Geschichte", getResources().getColor(R.color.Geschichte, null)),
        new Fach("Powi", getResources().getColor(R.color.Powi, null)),
        new Fach("Physik", getResources().getColor(R.color.Physik, null)),
        new Fach("Biologie", getResources().getColor(R.color.Biologie, null)),
        new Fach("Chemie", getResources().getColor(R.color.Chemie, null)),
        new Fach("Ethik", getResources().getColor(R.color.Ethik, null)),
        new Fach("Religion", getResources().getColor(R.color.Religion, null)),
        new Fach("Sport", getResources().getColor(R.color.Sport, null)),
        new Fach("Spanisch", getResources().getColor(R.color.Spanisch, null)),
        new Fach("Praktische Informatik", getResources().getColor(R.color.PraktischeInformatik, null)),
        new Fach("Englisch", getResources().getColor(R.color.Englisch, null)),
        new Fach("ITEC", getResources().getColor(R.color.Informationstechnik, null)),
        new Fach("Software Engeneering", getResources().getColor(R.color.SoftwareEngineering, null)),
        new Fach("Bautechnik", getResources().getColor(R.color.Bautechnik, null)),
        new Fach("Konstruktionslehre", getResources().getColor(R.color.Konstruktionslehre, null)),
        new Fach("Technische Kommunikation", getResources().getColor(R.color.TechnischeKommunikation, null)),
        new Fach("Mechatronik", getResources().getColor(R.color.Mechatronik, null)),
        new Fach("Elektrotechnik", getResources().getColor(R.color.Elektrotechnik, null)),
        new Fach("DS", getResources().getColor(R.color.DS, null)),
        new Fach("Debattieren", getResources().getColor(R.color.Deutsch, null)),
        new Fach("Veranstaltungstechnik", getResources().getColor(R.color.Veranstaltungstechnik, null)),
        new Fach("Schulband", getResources().getColor(R.color.Schulband, null))
        ));
        Log.e("FATAL", "TLS Fächer erstellt:" + fächer.toString());
        return fächer;
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