package de.StundenplanHelden.schulplaner_android_app;

import android.content.Context;
import android.os.Bundle;
import android.os.FileObserver;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import java.util.Scanner;

public class EditProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Nutzer nutzer = loadJSONProfil();
        findEditTexts();
        setEditTextHints(nutzer);


        Button button = (Button) findViewById(R.id.editSave);
        button.setOnClickListener(v -> saveNutzerChanges());
    }

    private EditText vorname;
    private EditText nachname;
    private EditText email;
    private EditText schule;
    private EditText klasse;
    private EditText klassenlehrer;
    private EditText geburtsdatum;


    private Nutzer loadJSONProfil(){
        Nutzer nutzer = null;
        try{
            //ProfilFile lesen
            String profiFileContent = Verwaltung.getInstance().readFile(getFilesDir().getPath() + Verwaltung.PROFILE_FILE_NAME, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            nutzer = gson.fromJson(profiFileContent, Nutzer.class);
        }catch(Exception e)
        {
            Log.e("EditProfileActivity", "loadJSONProfil: " + e);
        }
        return nutzer;
    }
    private void findEditTexts(){
        vorname = findViewById(R.id.editVorname);
        nachname = findViewById(R.id.editNachname);
        email = findViewById(R.id.editEmail);
        schule = findViewById(R.id.editSchule);
        klasse = findViewById(R.id.editKlasse);
        klassenlehrer = findViewById(R.id.editKlassenlehrer);
        geburtsdatum = findViewById(R.id.editGeburtsdatum);
    }
    private void setEditTextHints(Nutzer nutzer){
        vorname.setHint(nutzer.getVorname());
        nachname.setHint(nutzer.getNachname());
        email.setHint(nutzer.getEmail());
        schule.setHint(nutzer.getSchule());
        klasse.setHint(nutzer.getKlasse());
        klassenlehrer.setHint(nutzer.getKlassenlehrer());
        geburtsdatum.setHint(nutzer.getGebDate().toString());
    }

    public Nutzer getEditTexts (){
        EditText[] editTexts = new EditText[]{vorname, nachname, email, schule, klasse, klassenlehrer, geburtsdatum};
        String[] contents = new String[7];
        int count = 0;
        for (EditText eText : editTexts){
            if (eText.getText().length() == 0){
                contents[count] = eText.getHint().toString();
            }
            else{
                contents[count] = eText.getText().toString();
            }
            count++;
        }
        Nutzer nutzer = new Nutzer (contents[0],contents[1],contents[2],contents[3],contents[4],contents[5],new Datum(contents[6]));
        return nutzer;
    }
    private void saveNutzerChanges(){
        Nutzer nutzer = getEditTexts();

        Gson gson = new Gson();
        String jsonString = gson.toJson(nutzer);

        try {
            Verwaltung.getInstance().writeFile(getFilesDir()+Verwaltung.PROFILE_FILE_NAME, jsonString, StandardCharsets.UTF_8);
        }
        catch(Exception e){
            Log.e("saveNutzerChanges", "Error: "+e.toString());
        }
    }
}