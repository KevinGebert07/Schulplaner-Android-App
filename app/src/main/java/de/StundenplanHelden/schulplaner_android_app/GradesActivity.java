package de.StundenplanHelden.schulplaner_android_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        IDs = new HashMap<>();
        idCount = 0;

        ArrayList<Fach> fächer = Verwaltung.getInstance().fächer;
        for (int i = 0; i < fächer.size(); i++){
            InflateToXml();
        }
        for (int i = 0; i < fächer.size(); i++){
            Button btn = (Button) findViewById(IDs.get("btn" + i));
            CheckBox chk = (CheckBox) findViewById(IDs.get("chk" + i));

            btn.setText(fächer.get(i).bezeichnung);
            btn.setBackgroundColor(fächer.get(i).farbe);
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
}