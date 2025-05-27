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
    private CheckBox[] checkBoxes;

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
        checkBoxes = new CheckBox[]{findViewById(R.id.checkbox_e1),findViewById(R.id.checkbox_e2),findViewById(R.id.checkbox_q1),findViewById(R.id.checkbox_q2),findViewById(R.id.checkbox_q3),findViewById(R.id.checkbox_q4)};
        IDs = new HashMap<>();
        idCount = 0;
        notenText = (TextView) findViewById(R.id.notendurchschnitt);

        ArrayList<Fach> fächer = Verwaltung.getInstance().fächer;

        for (CheckBox cb : checkBoxes){
            cb.setOnClickListener(v -> OnCheckBoxClick());
        }

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

        //Gesamtdurchschnitt setzen
        setNotenText(verwaltung.berechneGesamtdurchschnitt());

        //Set OnClickListener
        for (CheckBox cb : checkBoxes){
            cb.setOnClickListener(v -> OnCheckBoxClick());
        }
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

    private void OnCheckBoxClick(){
        //Update Notendurchschnitt
        double displayDurchschnitt = 0.0;

        boolean[] bools = new boolean[6];
        int yesNo = 0;
        for (int i = 0; i<6; i++){
            if (checkBoxes[i].isChecked()){
                bools[i] = true;
                yesNo++;
            }
            else{
                bools[i] = false;
                yesNo--;
            }
        }
        if (yesNo == -6){
            //Wenn alle Checkboxes leer
            displayDurchschnitt = verwaltung.berechneGesamtdurchschnitt();
        }
        else{
            int last = 0;
            int first = 0;

            //Ermittelt das erste Häkchen
            for (int i = 0; i < 6; i++){
                if (bools[i] == true){
                    first = i;
                    break;
                }
            }
            //Ermittelt das letzte Häkchen
            for (int i = 0; i < 6; i++){
                if (bools[i] == true){
                    last = i;
                }
            }

            //Checkboxes markieren zwischen Start und End
            for (int i = first; i<last; i++){
                checkBoxes[i].setChecked(true);
            }

            displayDurchschnitt = verwaltung.berechneDurchschnitt(first, last);
        }
        setNotenText(displayDurchschnitt);
    }

    private void setNotenText(double notenavg){
        if (notenavg == -1){
            notenavg = 0.0;
        }
        try {
            String text = String.format("%.2f", notenavg);
            notenText.setText(text);
        }
        catch (Exception e){

        }
    }
}