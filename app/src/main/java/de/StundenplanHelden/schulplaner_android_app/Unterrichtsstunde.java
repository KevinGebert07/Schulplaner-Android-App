package de.StundenplanHelden.schulplaner_android_app;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Unterrichtsstunde {
    private String stunde;
    private ArrayList<String> lehrer;
    private String raum;

    private Fach fach;

    public Unterrichtsstunde (String stunde, ArrayList<String> lehrer, String raum, Fach fach){
        this.stunde = stunde;
        this.lehrer = lehrer;
        this.raum = raum;
        this.fach = fach;
    }



}
