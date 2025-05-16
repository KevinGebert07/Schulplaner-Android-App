package de.StundenplanHelden.schulplaner_android_app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

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

    public String getLehrer(){
        String s = lehrer.toString().replace("[","").replace("]","").replace(",","");
        return s;
    }

    public String getZeit(){
        String s = "";
        switch (stunde) {
            case "1":
                s = "08:00\n- 08:45";
                break;
            case "2":
                s = "08:45\n- 09:30";
                break;
            case "3":
                s = "09:45\n- 10:30";
                break;
            case "4":
                s = "10:30\n- 11:15";
                break;
            case "5":
                s = "11:30\n- 12:15";
                break;
            case "6":
                s = "12:15\n- 13:00";
                break;
            case "7":
                s = "13:30\n- 14:15";
                break;
            case "8":
                s = "14:15\n- 15:00";
                break;
            case "9":
                s = "15:00\n- 15:45";
                break;
            case "10":
                s = "15:45\n- 16:30";
                break;
            default:
                s = "KACKE";
                break;
        }
        return s;
    }
}
