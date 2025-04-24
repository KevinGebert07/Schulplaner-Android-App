package de.StundenplanHelden.schulplaner_android_app;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Verwaltung {
    //Singleton Aufbau
    private static Verwaltung instance;

    protected static final String PROFILE_FILE_NAME = "profil.json";
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

    public static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}
