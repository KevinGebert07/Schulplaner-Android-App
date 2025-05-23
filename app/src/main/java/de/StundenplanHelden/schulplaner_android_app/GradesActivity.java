package de.StundenplanHelden.schulplaner_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class GradesActivity extends AppCompatActivity {

    private HashMap<String, Integer> IDs;
    private int idCount;
    private TextView notenText;
    private Verwaltung verwaltung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grades);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Werte setzen
        verwaltung = Verwaltung.getInstance();
        IDs = new HashMap<>();
        idCount = 0;
        notenText = (TextView) findViewById(R.id.notendurchschnitt);

        ArrayList<Fach> fächer = Verwaltung.getInstance().fächer;

        //Für die Anzahl der Fächer Felder mit Checkbox und Button einfügen
        for (int i = 0; i < fächer.size(); i++){
            InflateToXml();
        }
        for (int i = 0; i < fächer.size(); i++){
            Button btn = (Button) findViewById(IDs.get("btn" + i));
            CheckBox chk = (CheckBox) findViewById(IDs.get("chk" + i));

            btn.setText(fächer.get(i).bezeichnung);
            btn.setBackgroundColor(fächer.get(i).farbe);
        }
        notenText.setText(String.valueOf(verwaltung.berechneGesamtdurchschnitt()));
    }


    private void InflateToXml(){
        LinearLayout parentLayout = findViewById(R.id.subjects);

        // Layout programmatisch "inflaten"
        View included = LayoutInflater.from(this).inflate(R.layout.subject_item, parentLayout, false);
        ConstraintLayout includedLayout = (ConstraintLayout) included;

        //TextView und Button des neuen Objekts bekommen und ID setzen, ID in HashMap einfügen
        CheckBox chk = (CheckBox) includedLayout.getChildAt(1);
        Button btn = (Button) includedLayout.getChildAt(0);

        int chkID = View.generateViewId();
        int btnID = View.generateViewId();
        btn.setId(btnID);
        chk.setId(chkID);

        btn.setOnClickListener(v -> changeToFachViewActivity(v));

        //Bei dem Text die LayoutParams setzen
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) chk.getLayoutParams();
        params.endToStart = btnID;
        chk.setLayoutParams(params);

        IDs.put("chk"+idCount, chkID);
        IDs.put("btn"+idCount, btnID);
        idCount++;

        // Das inflatete Layout zum Parent hinzufügen
        parentLayout.addView(included);
    }

    public void changeToFachViewActivity(View v){
        Intent i = new Intent(this, FachViewActivity.class );
        i.putExtra("fach", ((Button) v).getText().toString());
        Toast.makeText(this, (((Button) v).getText()).toString(), Toast.LENGTH_SHORT).show();
        startActivity(i);
    }
}