package de.StundenplanHelden.schulplaner_android_app;

import android.graphics.Color;
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
import java.util.Arrays;
import java.util.List;

public class Verwaltung {
    //Singleton Aufbau
    private static Verwaltung instance = null;

    // Attribute
    protected Nutzer nutzer;
    protected Stundenplan stundenplan;
    protected ArrayList<Fach> fächer;


    //Finale Attribute (z.B. Filenames)
    protected static final String PROFILE_FILE_NAME = "nutzer.json";
    protected static final String FÄCHER_FILE_NAME = "fächer.json";
    protected static final String STUNDENPLAN_FILE_NAME = "stundenplan.json";

    //Konstruktor
    private Verwaltung(){
        fächer = new ArrayList<>();
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
        else {avg = -1.0;}
        return avg;
    }

    //Statische Methode zum Lesen und Schreiben von Files im getFilesDir() Ordner
    public static String readFile(String path, Charset encoding) throws IOException{
        byte[] encoded = new byte[]{};
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        }
        catch (Exception e){
            Log.e("Verwaltung", "readFile: "+ e);
        }
        return new String(encoded, encoding);
    }
    public static void writeFile(String path, String content, Charset encoding) throws IOException {
        byte[] bytes = content.getBytes(encoding);
        Files.write(Paths.get(path), bytes);
    }

    public static Fach getFach(String bezeichnung){
        for (Fach fach : getInstance().fächer){
            if (fach.bezeichnung.equalsIgnoreCase(bezeichnung)){
                return fach;
            }
        }
        return new Fach("FEHLER", Color.RED);
    }

    //Public Methoden, die über das Singleton Objekt ausgeführt werden
    public Stundenplan neuerStundenplan(String bezeichnung, Schulwoche sw1, Schulwoche sw2){
        Stundenplan neuerStundenplan = new Stundenplan(bezeichnung, sw1, sw2);
        this.stundenplan = neuerStundenplan;
        return neuerStundenplan;
    }
    public Stundenplan neuerStundenplan(Stundenplan neuerStundenplan){
        this.stundenplan = neuerStundenplan;
        return this.stundenplan;
    }
    public ArrayList<Fach> neueFächer(ArrayList<Fach> neueFächer){
        this.fächer = neueFächer;
        return this.fächer;
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
            Log.e("FETT", i+": "+fächerAVG[i] + " ; "+fächer.get(i));
        }
        avg = Verwaltung.berechneDurchschnittPositiv(fächerAVG);
        Log.e("FETT", "Avg: " + avg);
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

    //Methoden die Datensätze als String (JSON) generieren, die bei Erstinstallation der App aufgerfufen werden, um Beispieldatensätze zu integrieren
    public String erstelleBeispielNutzerJSON(){
        //Erstellt einen Beispielnutzer der beim Starten der App als JSON gespeichert wird
        Nutzer nutzer = new Nutzer("Max","Mustermann","max.mustermann@musterdomain.com", "Herr Lehrer", "11a", "Musterschule 12345 Musterhausen",new Datum(1,1,2000));
        Gson gson = new Gson();
        return gson.toJson(nutzer);
    }
    public String erstelleBeispielFächerJSON(){
        Log.e("Fatal", "FATAL Fächer creating");
        //Erstelle drei Beispielfächer, die beim Starten der APP als JSON gespeichert werden
        Fach deutsch = new Fach("Deutsch", Color.RED);
        Fach mathe = new Fach("Mathe", Color.BLUE);
        Fach englisch = new Fach("Englisch", Color.YELLOW);

        getInstance().fächer.add( deutsch);
        getInstance().fächer.add( mathe);
        getInstance().fächer.add( englisch);


        Gson gson = new Gson();
        List<Fach> fächerList = fächer;
        String json = gson.toJson(fächerList);

        Log.e("Fatal", "FATAL Fächer created");

        return json;
    }
    public String erstelleBeispielStundenplanJSON(){
        ArrayList<Unterrichtsstunde> unterrichtsstunden = new ArrayList<>();
        unterrichtsstunden.add(new Unterrichtsstunde("1", new ArrayList<String>(Arrays.asList("Deutschlehrer")),"R100",fächer.get(0)));
        unterrichtsstunden.add(new Unterrichtsstunde("2", new ArrayList<String>(Arrays.asList("Mathelehrer")),"R101",fächer.get(1)));
        unterrichtsstunden.add(new Unterrichtsstunde("3", new ArrayList<String>(Arrays.asList("Englischlehrer")),"R102",fächer.get(2)));

        Schulwoche sw1 = new Schulwoche(
                new Schultag[]{
                        new Schultag("Montag",unterrichtsstunden),
                        new Schultag("Dienstag",unterrichtsstunden),
                        new Schultag("Mittwoch",unterrichtsstunden),
                        new Schultag("Donnerstag",unterrichtsstunden),
                        new Schultag("Freitag",unterrichtsstunden),
                        new Schultag("Samstag",new ArrayList<>()),
                        new Schultag("Sonntag",new ArrayList<>()),
                }
        );
        Schulwoche sw2 = new Schulwoche(
                new Schultag[]{
                        new Schultag("Montag",unterrichtsstunden),
                        new Schultag("Dienstag",unterrichtsstunden),
                        new Schultag("Mittwoch",unterrichtsstunden),
                        new Schultag("Donnerstag",unterrichtsstunden),
                        new Schultag("Freitag",unterrichtsstunden),
                        new Schultag("Samstag", new ArrayList<>()),
                        new Schultag("Sonntag", new ArrayList<>()),
                }
        );

        Stundenplan neuerStundenplan = new Stundenplan("GeneratedStundenplan",sw1,sw2);
        this.stundenplan = neuerStundenplan;
        Gson gson = new Gson();
        return gson.toJson(stundenplan);
    }
}
