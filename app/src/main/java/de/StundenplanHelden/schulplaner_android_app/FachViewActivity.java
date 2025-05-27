package de.StundenplanHelden.schulplaner_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FachViewActivity extends AppCompatActivity {

    Fach fach;
    Button nxt;
    Button prev;
    ViewFlipper flipper;
    TextView flipperDisplay;
    TextView fachText;
    List<EditText> editTextList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fach_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent myIntent = getIntent();
        if (myIntent.hasExtra("fach")) {
            fach = Verwaltung.getFach(myIntent.getStringExtra("fach"));
            if (fach == null){
                finish();
            }
        }
        else{
            finish();
        }

        fachText = (Button) findViewById(R.id.fach);
        nxt = (Button) findViewById(R.id.btn_next);
        prev = (Button) findViewById(R.id.btn_prev);
        flipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        flipperDisplay = (TextView) findViewById(R.id.flipperDisplay);


        fachText.setText(fach.bezeichnung);
        fachText.setBackgroundColor(fach.farbe);
        fachText.setOnClickListener(v -> changeToGradesActivity());
        nxt.setOnClickListener(v -> showNext());
        prev.setOnClickListener(v -> showPrevious());

        findAllEditTexts((ViewGroup)flipper.getCurrentView(), editTextList);
        editFlipperTexts();
    }

    private void showNext(){
        notenAktualisieren();
        flipper.showNext();
        switch(flipper.getDisplayedChild()){
            case 0:
                flipperDisplay.setText("E1");
                break;
            case 1:
                flipperDisplay.setText("E2");
                break;
            case 2:
                flipperDisplay.setText("Q1");
                break;
            case 3:
                flipperDisplay.setText("Q2");
                break;
            case 4:
                flipperDisplay.setText("Q3");
                break;
            case 5:
                flipperDisplay.setText("Q4");
                break;
        }
        editFlipperTexts();
    }

    private void showPrevious(){
        notenAktualisieren();
        flipper.showPrevious();

        switch(flipper.getDisplayedChild()){
            case 0:
                flipperDisplay.setText("E1");
                break;
            case 1:
                flipperDisplay.setText("E2");
                break;
            case 2:
                flipperDisplay.setText("Q1");
                break;
            case 3:
                flipperDisplay.setText("Q2");
                break;
            case 4:
                flipperDisplay.setText("Q3");
                break;
            case 5:
                flipperDisplay.setText("Q4");
                break;
        }

        editFlipperTexts();
    }

    private void editFlipperTexts(){
        View aktuelleSicht = flipper.getCurrentView();

        // 3. Die EditTexts finden (z.B. alle EditTexts in der aktuellen Sicht)
        editTextList = new ArrayList<>();
        if (aktuelleSicht instanceof ViewGroup) {
            editTextList = new ArrayList<>();
            findAllEditTexts((ViewGroup) aktuelleSicht, editTextList);
        }

        for (int i = 0; i < editTextList.size(); i++){
            int note = fach.halbjahre[flipper.getDisplayedChild()].getNote(i);
            if (note >= 0){
                editTextList.get(i-1).setHint(String.valueOf(note));
            }
        }
    }

    private void findAllEditTexts(ViewGroup parent, List<EditText> result) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            if (child instanceof EditText) {
                result.add((EditText) child);
            } else if (child instanceof ViewGroup) {
                findAllEditTexts((ViewGroup) child, result);
            }
        }
    }

    private void notenAktualisieren(){
        for (int i = 0; i < editTextList.size(); i++){
            try {
                int note = Integer.valueOf(editTextList.get(i).getText().toString());
                if (note > 15){
                    note = 15;
                    editTextList.get(i).setText("15");
                }
                if (note >= 0) {
                    fach.halbjahre[flipper.getDisplayedChild()].noteEintragen(i, note);

                }
            }
            catch(Exception ignored) {
                Log.e("FATAL", "FUCK!");
            }
        }
    }

    private void changeToGradesActivity(){
        notenAktualisieren();
        Intent i = new Intent(this, GradesActivity.class);
        try{
            Gson gson = new Gson();
            String fächerJSON = gson.toJson(Verwaltung.getInstance().fächer);
            Verwaltung.writeFile(getFilesDir().getPath()+Verwaltung.FÄCHER_FILE_NAME, fächerJSON, StandardCharsets.UTF_8);
        }
        catch (Exception e){
            Log.e("changeToGradesActivity", e.toString());
        }
        startActivity(i);
    }
}