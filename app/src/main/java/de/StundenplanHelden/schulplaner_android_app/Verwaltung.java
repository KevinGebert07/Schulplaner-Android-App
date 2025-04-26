package de.StundenplanHelden.schulplaner_android_app;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Verwaltung {
    //Singleton Aufbau
    private static Verwaltung instance = null;

    protected Nutzer nutzer;
    protected Stundenplan stundenplan;
    protected ArrayList<Fach> fächer;


    protected static final String PROFILE_FILE_NAME = "nutzer.json";
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


    //Importiert mit einem Path einen JSON File zu einem Stundenplan. Bei erfolgreicher Konvertierung wird der Stundenplan von Verwaltung mit dem importierten Stundenplan überschrieben
    public boolean importiereStundenplan(String path){
        boolean check = false;
        try{
            String json = readFile(path, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            Stundenplan neuerStundenplan = gson.fromJson(json, Stundenplan.class);
            this.stundenplan = neuerStundenplan;
            check = true;
        }
        catch(Exception e){
            Log.e("Verwaltung", "importiereStundenplan: "+e);
        }
        return check;
    }

    //Methoden zur Berechnung des Durchschnitts

    //Diese Methode berechnet den Gesamtdurchschnitt aller eingetragenen Noten
    public double berechneGesamtdurchschnitt (){
        return 1.2;
    }

    //Diese Methoden berechnen den Durchschnitt von allen Fächer in einem bestimmten oder von mehreren bestimmten Halbjahren
    public double berechneDurchschnitt (Halbjahr halbjahr){
        return 0.0;
    }
    public double berechneDurchschnitt (Halbjahr halbjahr, Halbjahr endHalbjahr){
        return 0.0;
    }

    //Diese Methoden berechnen den Durchschnitt eines gesamten Fachs, eines Fachs auf ein Halbjahr und eines Fachs auf bestimmte Halbjahre
    public double berechneFachDurchschnitt (Fach fach){
        return 0.0;
    }
    public double berechneFachDurchschnitt (Fach fach, Halbjahr halbjahr){
        return 0.0;
    }
    public double berechneFachDurchschnitt (Fach fach, Halbjahr halbjahr, Halbjahr endHalbjahr){
        return 0.0;
    }

    public String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    public void writeFile(String path, String content, Charset encoding) throws IOException {
        byte[] bytes = content.getBytes(encoding);
        Files.write(Paths.get(path), bytes);
    }



    public String erstelleBeispielNutzerJSON(){
        //Erstellt einen Beispielnutzer der beim Starten der App als JSON gespeichert wird
        Nutzer nutzer = new Nutzer("Max","Mustermann","max.mustermann@musterdomain.com", "Herr Lehrer", "11a", "Musterschule 12345 Musterhausen",new Datum(1,1,2000));
        Gson gson = new Gson();
        return gson.toJson(nutzer);
    }

}
