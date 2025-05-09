package de.StundenplanHelden.schulplaner_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;

public class TimetableActivity extends AppCompatActivity {
    Datum currentDatum;
    TextView DatumText;
    Button nextButton;
    Button backButton;

    HashMap<String, Integer> IDs;
    int idCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_timetable);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Verwaltung verwaltung = Verwaltung.getInstance();
        DatumText = (TextView) findViewById(R.id.Datum);
        nextButton = (Button) findViewById(R.id.next);
        backButton = (Button) findViewById(R.id.back);
        IDs = new HashMap<String, Integer>();

        //OnClickListener setzen
        nextButton.setOnClickListener(v -> ChangeToNextDay());
        backButton.setOnClickListener(v -> ChangeToPreviousDay());

        //Intent mit Daten bekommen
        Intent myIntent = getIntent();
        Bundle extras = myIntent.getExtras();

        //Wenn Intent ein Datum enthält diese Datum setzen, wenn nicht heutiges Datum setzen
        if (extras != null && extras.containsKey("Datum")){
            currentDatum = new Datum(extras.getString("Datum"));
        }
        else {
            currentDatum = Datum.Heute();
        }
        DatumText.setText(Datum.berechneWochentag(currentDatum)+",\n der "+ currentDatum.toString());

        //Heutige Unterrichtsstunden laden
        Schultag heute = verwaltung.stundenplan.sw1.getSchultag(Datum.berechneWochentagInt(currentDatum));
        ArrayList<Unterrichtsstunde> unterrichtsstunden = heute.unterrichtsstunden;

        for (int i = 0; i < unterrichtsstunden.size(); i++){
            //Erstelle eine Stunde Ding in xml
            InflateToXml();

            //Fülle Daten von Unterrichtsstunde in Button und TextView
            Unterrichtsstunde heuteStunde = unterrichtsstunden.get(i);
            String btnText = heuteStunde.fach.bezeichnung + "\n" + heuteStunde.raum + " | "+ heuteStunde.getLehrer();
            int btnColor = heuteStunde.fach.farbe;
            Button btn = (Button) findViewById(IDs.get("btn"+i));
            TextView txt = (TextView) findViewById(IDs.get("txt"+i));
            txt.setText(heuteStunde.getZeit());
            btn.setText(btnText);
            btn.setBackgroundColor(btnColor);
        }
    }

    private void ChangeToNextDay(){
        Intent i = new Intent(this, TimetableActivity.class);
        i.putExtra("Datum",currentDatum.morgen().toString());
        startActivity(i);
    }
    private void ChangeToPreviousDay(){
        Intent i = new Intent(this, TimetableActivity.class);
        i.putExtra("Datum",currentDatum.gestern().toString());
        startActivity(i);
    }

    private void InflateToXml(){
        LinearLayout parentLayout = findViewById(R.id.parentLayout);

        // Layout programmatisch "inflaten"
        View included = LayoutInflater.from(this).inflate(R.layout.lesson_item, parentLayout, false);
        ConstraintLayout includedLayout = (ConstraintLayout) included;

        //TextView und Button des neuen Objekts bekommen und ID setzen, ID in HashMap einfügen
        TextView txt = (TextView) includedLayout.getChildAt(1);
        Button btn = (Button) includedLayout.getChildAt(0);
        int txtID = View.generateViewId();
        int btnID = View.generateViewId();
        btn.setId(btnID);
        txt.setId(txtID);

        //Bei dem Text die LayoutParams setzen
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) txt.getLayoutParams();
        params.endToStart = btnID;
        txt.setLayoutParams(params);

        IDs.put("txt"+idCount, txtID);
        IDs.put("btn"+idCount, btnID);
        idCount++;

        // Das inflatete Layout zum Parent hinzufügen
        parentLayout.addView(included);
    }
}