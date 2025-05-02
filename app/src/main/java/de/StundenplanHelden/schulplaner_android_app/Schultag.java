package de.StundenplanHelden.schulplaner_android_app;

import java.util.ArrayList;

public class Schultag {
    protected String wochentag;
    protected ArrayList<Unterrichtsstunde> unterrichtsstunden;

    public Schultag (String wochentag){
        this.wochentag = wochentag;
        this.unterrichtsstunden = new ArrayList<>();
    }
    public Schultag (String wochentag, ArrayList<Unterrichtsstunde> unterrichtsstunden){
        this.wochentag = wochentag;
        this.unterrichtsstunden = unterrichtsstunden;
    }

    public void unterrichtsstundeEinfügen(int position, Unterrichtsstunde unterrichtsstunde){
        unterrichtsstunden.add(position, unterrichtsstunde);
    }

    public String getWochentag(){
        return wochentag;
    }
}
