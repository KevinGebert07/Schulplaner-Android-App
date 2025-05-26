package de.StundenplanHelden.schulplaner_android_app;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ProfileActivity extends AppCompatActivity {

    TextView vntext;
    TextView nntext;
    TextView mailtext;
    TextView klltext;
    TextView kltext;
    TextView schtext;
    TextView gebtext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadJSONProfil();
        getTextViews();
        setTextViews();

    }

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
                    new Datum(jsonObject.getString("geburtsdatum"))
            );
        }catch(Exception e)
        {
            Log.e("TAG", "getJSONProfil: " + e);
        }
        return nutzer;
    }

    private void getTextViews(){
        vntext = (TextView) findViewById(R.id.text_vorname);
        nntext = (TextView) findViewById(R.id.text_nachname);
        mailtext = (TextView) findViewById(R.id.text_email);
        klltext = (TextView) findViewById(R.id.text_klassenlehrer);
        kltext = (TextView) findViewById(R.id.text_klasse);
        schtext = (TextView) findViewById(R.id.text_schule);
        gebtext = (TextView) findViewById(R.id.text_geburtsdatum);
    }

    private void setTextViews(){
        Nutzer nutzer = Verwaltung.getInstance().nutzer;
        vntext.setText(nutzer.getVorname());
        nntext.setText(nutzer.getNachname());
        mailtext.setText(nutzer.getEmail());
        klltext.setText(nutzer.getKlassenlehrer());
        kltext.setText(nutzer.getKlasse());
        schtext.setText(nutzer.getSchule());
        gebtext.setText(nutzer.getGebDate().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Hier Daten aktualisieren oder UI refreshen
        setTextViews();
    }
}