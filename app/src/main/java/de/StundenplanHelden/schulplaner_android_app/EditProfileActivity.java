package de.StundenplanHelden.schulplaner_android_app;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

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
            //load JSON
            InputStream inputStream = getAssets().open("profil.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            Log.i("loadJSONProfile", "InputStrem cloased");

            //JSONArray Objekt erstellen
            String json;
            int max;

            json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);
            max = jsonArray.length();

            //JSON-Objekt erstellen
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            //Aus JSON Objekt Nutzer Objekt erstellen
            nutzer = new Nutzer(
                    jsonObject.getString("vorname"),
                    jsonObject.getString("nachname"),
                    jsonObject.getString("email"),
                    jsonObject.getString("klasse"),
                    jsonObject.getString("klassenlehrer"),
                    jsonObject.getString("schule"),
                    jsonObject.getString("geburtsdatum")
            );
        }catch(Exception e)
        {
            Log.e("TAG", "getJSONProfil: " + e);
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

    private void saveNutzerChanges(){
        //Warscheinlich arbeiten mit GSON
    }
}