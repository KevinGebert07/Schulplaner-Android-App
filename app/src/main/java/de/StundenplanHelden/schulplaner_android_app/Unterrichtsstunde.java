package de.StundenplanHelden.schulplaner_android_app;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Unterrichtsstunde {
    protected String stunde;
    protected ArrayList<String> lehrer;
    protected String raum;
    protected Fach fach;

    public Unterrichtsstunde (String stunde, ArrayList<String> lehrer, String raum, Fach fach){
        this.stunde = stunde;
        this.lehrer = lehrer;
        this.raum = raum;
        this.fach = fach;
    }

}
