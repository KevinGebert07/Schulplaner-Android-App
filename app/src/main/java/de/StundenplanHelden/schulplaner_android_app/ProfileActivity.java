package de.StundenplanHelden.schulplaner_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ProfileActivity extends AppCompatActivity {

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
        Button bearbeiten = (Button) findViewById(R.id.bearbeiten);
        bearbeiten.setOnClickListener(v -> startActivity(new Intent(this, EditProfileActivity.class)));
        loadJSONProfil();


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
}