package de.StundenplanHelden.schulplaner_android_app;

import android.graphics.Color;

public class Fach {
    private String bezeichnung;
    private int farbe;

    public Fach (String bezeichnung, int farbe){
        this.bezeichnung = bezeichnung;
        this.farbe = farbe;
    }

    public double berechneFachDurchschnitt (){
        return 0.0;
    }
    public double berechneFachDurchschnitt(String halbjahr){
        return 1.0;
    }
    public double berechneFachDurschschnitt(String halbjahr, String endHalbjahr){
        return 2.0;
    }

    @Override
    public String toString(){
        return "Ich bin "+ bezeichnung;
    }

    public String getBezeichnung(){
        return bezeichnung;
    }

    public int getFarbe(){
        return farbe;
    }
}
