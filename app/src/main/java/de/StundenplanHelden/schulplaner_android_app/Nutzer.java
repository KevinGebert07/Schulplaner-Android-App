package de.StundenplanHelden.schulplaner_android_app;


import android.util.Log;

public class Nutzer {
    private String vorname;
    private String nachname;
    private String email;
    private String klassenlehrer;
    private String klasse;
    private String schule;
    private Datum gebDate;


    public Nutzer (String vorname, String nachname, String email, String klassenlehrer, String klasse, String schule, Datum gebDate){
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.klassenlehrer = klassenlehrer;
        this.klasse = klasse;
        this.schule = schule;
        this.gebDate = gebDate;
    }

    @Override
    public String toString(){
        String s = "Vorname: %s\nNachname: %s\nEmail: %s\nKlassenlehrer: ½s\nKlasse: ½s\nSchule: ½s\nGeburtstdatum: %s".format(vorname, nachname, email, klassenlehrer, klasse, schule, gebDate.toString());
        return s;
    }

    // <editor-fold desc="Get-Methoden">
    public String getVorname(){
        return vorname;
    }
    public String getNachname(){
        return nachname;
    }
    public String getEmail(){
        return email;
    }
    public String getKlassenlehrer(){
        return klassenlehrer;
    }
    public String getKlasse(){
        return klasse;
    }
    public String getSchule(){
        return schule;
    }
    public Datum getGebDate(){
        return gebDate;
    }
    // </editor-fold>
}
