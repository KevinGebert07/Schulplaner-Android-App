package de.StundenplanHelden.schulplaner_android_app;

import java.util.ArrayList;

public class Schultag {
    private String wochentag;
    private ArrayList<Unterrichtsstunde> unterrichtsstunden;

    public Schultag (String wochentag){
        this.wochentag = wochentag;
    }

    public void unterrichtsstundeEinfügen(int position, Unterrichtsstunde unterrichtsstunde){
        unterrichtsstunden.add(position, unterrichtsstunde);
    }

    public String getWochentag(){
        return wochentag;
    }

}
