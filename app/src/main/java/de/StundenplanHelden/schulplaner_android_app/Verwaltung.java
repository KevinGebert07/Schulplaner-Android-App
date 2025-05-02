package de.StundenplanHelden.schulplaner_android_app;

import android.util.Log;

import androidx.annotation.NonNull;

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

    // Attribute
    protected Nutzer nutzer;
    protected Stundenplan stundenplan;
    protected ArrayList<Fach> fächer;


    //Finale Attribute (z.B. Filenames)
    protected static final String PROFILE_FILE_NAME = "nutzer.json";

    //Konstruktor
    private Verwaltung(){

    }
    //Singleton Instanz bekommen
    public static Verwaltung getInstance(){
        if (instance==null){
            instance = new Verwaltung();
        }
        return instance;
    }


    //Statische Methoden für generelle Aufgaben

    //Statische Methode zur Berechnung des Durchschnitts eines double-Arrays, mit Missachtung negativer Werte
    public static double berechneDurchschnittPositiv(double[] werte){
        // Werte avg (Durchschnitt) und count anlegen
        double avg = 0.0;
        int count = 0;

        //Jeden Wert der nicht negativ ist zu avg hinzufügen; dann count erhöhen
        for (double wert : werte){
            if (wert >= 0){
                avg+=wert;
                count++;
            }
        }

        //Wenn count >= 0 avg durch count teilen -> Durchschnitt, ohne dass durch 0 geteilt wird
        if (count != 0){avg = avg / count;}
        return avg;
    }

    //Statische Methode zum Lesen und Schreiben von Files im getFilesDir() Ordner
    public static String readFile(String path, Charset encoding) throws IOException{
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    public static void writeFile(String path, String content, Charset encoding) throws IOException {
        byte[] bytes = content.getBytes(encoding);
        Files.write(Paths.get(path), bytes);
    }


    //Public Methoden, die über das Singleton Objekt ausgeführt werden
    public Stundenplan neuerStundenplan(String bezeichnung, Schulwoche sw1, Schulwoche sw2){
        Stundenplan neuerStundenplan = new Stundenplan(bezeichnung, sw1, sw2);
        this.stundenplan = neuerStundenplan;
        return neuerStundenplan;
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
        double avg = 0.0;
        //Zuerst die Durchschnittsnoten von allen Fächern berechnen
        double[] fächerAVG = new double[fächer.size()];
        for (int i = 0; i<fächer.size(); i++){
            fächerAVG[i] = fächer.get(i).berechneFachDurchschnitt();
        }
        avg = Verwaltung.berechneDurchschnittPositiv(fächerAVG);
        return avg;
    }

    //Diese Methoden berechnen den Durchschnitt von allen Fächer in einem bestimmten oder von mehreren bestimmten Halbjahren
    public double berechneDurchschnitt (int halbjahr){
        double avg = 0.0;
        double[] fächerAVG = new double[fächer.size()];
        for (int i = 0; i<fächer.size(); i++){
            fächerAVG[i] = fächer.get(i).berechneFachDurchschnitt(halbjahr);
        }
        avg = Verwaltung.berechneDurchschnittPositiv(fächerAVG);
        return avg;
    }
    public double berechneDurchschnitt (int halbjahr, int endHalbjahr){
        double avg = 0.0;
        double[] fächerAVG = new double[fächer.size()];
        for (int i = 0; i<fächer.size(); i++){
            fächerAVG[i] = fächer.get(i).berechneFachDurchschnitt(halbjahr, endHalbjahr);
        }
        avg = Verwaltung.berechneDurchschnittPositiv(fächerAVG);
        return avg;
    }

    //Diese Methoden berechnen den Durchschnitt eines gesamten Fachs, eines Fachs auf ein Halbjahr und eines Fachs auf bestimmte Halbjahre
    public double berechneFachDurchschnitt (Fach fach){
        double avg = 0;
        avg = fach.berechneFachDurchschnitt();
        return avg;
    }
    public double berechneFachDurchschnitt (Fach fach, int halbjahr){
        double avg = 0;
        avg = fach.berechneFachDurchschnitt(halbjahr);
        return avg;
    }
    public double berechneFachDurchschnitt (Fach fach, int halbjahr, int endHalbjahr){
        double avg = 0;
        avg = fach.berechneFachDurchschnitt(halbjahr, endHalbjahr);
        return avg;
    }


    
    public String erstelleBeispielNutzerJSON(){
        //Erstellt einen Beispielnutzer der beim Starten der App als JSON gespeichert wird
        Nutzer nutzer = new Nutzer("Max","Mustermann","max.mustermann@musterdomain.com", "Herr Lehrer", "11a", "Musterschule 12345 Musterhausen",new Datum(1,1,2000));
        Gson gson = new Gson();
        return gson.toJson(nutzer);
    }
}
