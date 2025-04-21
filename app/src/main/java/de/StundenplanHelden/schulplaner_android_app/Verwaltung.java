package de.StundenplanHelden.schulplaner_android_app;

import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;

public class Verwaltung {
    //Singleton Aufbau
    private static Verwaltung instance;
    private Verwaltung(){

    }
    public static Verwaltung getInstance(){
        if (instance==null){
            instance = new Verwaltung();
        }
        return instance;
    }


    //Methoden
    public Stundenplan neuerStundenplan(){
        return new Stundenplan("kekw");
    }

    public double notendurchschnittBerechnen (String halbjahr){
        return 0.0;
    }

    public double notendurchschnittBerechnen (String halbjahr, ArrayList<Fach> fächer){
        return 2.0;
    }


}
