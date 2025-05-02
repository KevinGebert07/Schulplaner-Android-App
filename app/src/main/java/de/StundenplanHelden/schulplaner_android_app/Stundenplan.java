package de.StundenplanHelden.schulplaner_android_app;

import java.util.ArrayList;
import java.util.HashMap;

public class Stundenplan {
    protected String bezeichnung;
    protected HashMap<String, String> abweichung;
    protected Schulwoche sw1;
    protected Schulwoche sw2;

    public Stundenplan (String bezeichnung, Schulwoche sw1, Schulwoche sw2){
        this.bezeichnung = bezeichnung;
        this.sw1 = sw1;
        this.sw2 = sw2;
        abweichung = new HashMap<>();
    }

    public void abweichungEinfügen (Datum tag, int stunde, String abweichungCode){
        abweichung.put(tag.toString()+"|"+stunde, abweichungCode);
    }

    public void schultagEinrichten (int position, ArrayList<Unterrichtsstunde> stunden){

    }

    public String toString(){
        String s = new String("Stundenplan: "+ bezeichnung + "\nSchulwoche 1: "+sw1.toString()+"\nSchulwoche 2: "+sw2.toString());
        return s;
    }

    //<editor-fold desc="Set-Methoden">
    public void setBezeichnung(String bezeichnung){
        this.bezeichnung = bezeichnung;
    }
    public void setSchulwoche1 (Schulwoche schulwoche){
        this.sw1 = schulwoche;
    }
    public void setSchulwoche2(Schulwoche schulwoche){
        this.sw2 = schulwoche;
    }
    //</editor-fold>
}
