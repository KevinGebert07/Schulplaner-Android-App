package de.StundenplanHelden.schulplaner_android_app;

import java.util.ArrayList;
import java.util.HashMap;

public class Stundenplan {
    private String bezeichnung;
    private HashMap<String, String> abweichung;
    private Schulwoche sw1;
    private Schulwoche sw2;

    public Stundenplan (String bezeichnung){
        this.bezeichnung = bezeichnung;
        abweichung = new HashMap<>();
    }

    public void abweichungEinfügen (Datum tag, int stunde, String abweichungCode){
        abweichung.put(tag.toString()+"|"+stunde, abweichungCode);
    }

    public void schultagEinrichten (int position, ArrayList<Unterrichtsstunde> stunden){

    }
}
