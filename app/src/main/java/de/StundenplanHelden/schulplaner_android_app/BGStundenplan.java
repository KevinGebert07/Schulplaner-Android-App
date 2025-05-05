package de.StundenplanHelden.schulplaner_android_app;

import android.graphics.Color;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class BGStundenplan {
    public static ArrayList<Fach> tlsFächer(){

        //Erstelle Beispielfächer, die beim Starten der APP als JSON gespeichert werden
        ArrayList<Fach> fächer = new ArrayList<>() {
            new Fach("Deutsch", ),
            new Fach("Mathe", ),
            new Fach("Englisch", ),
            new Fach("Powi", ),
            new Fach("Geschichte", ),
            new Fach("Chemie", ),
            new Fach("Physik", ),
            new Fach("Biologie", ),
            new Fach("PI", ),
            new Fach("ITEC", ),
            new Fach("Software Engeneering", ),
            new Fach("Bautechnik", ),
            new Fach("Konstruktionslehre", ),
            new Fach("Technische Kommunikation", ),
            new Fach("Mechatronik", ),
            new Fach("Elektrotechnik", ),
            new Fach("DS", ),
            new Fach("Debattieren", ),
            new Fach("Veranstaltungstechnik", ),
            new Fach("Schulband", ),
            new Fach("Religion", ),
            new Fach("Ethik", ),
            new Fach("Sport", ),
            new Fach("Spanisch", )
        };
        return fächer;
    }

    public static String jannisStundenplan(){
        ArrayList<Fach> fächer = tlsFächer();
    }
}
