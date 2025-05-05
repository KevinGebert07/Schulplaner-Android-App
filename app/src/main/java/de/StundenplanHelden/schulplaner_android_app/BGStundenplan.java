package de.StundenplanHelden.schulplaner_android_app;

import android.graphics.Color;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BGStundenplan {
    public static Stundenplan jannisStundenplan(){
        ArrayList<Fach> fächer = Verwaltung.getInstance().fächer;
        //Objekte Unterrichtsstunden Montag
        Unterrichtsstunde mo1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Engel")), "U042", fächer.get(11));
        Unterrichtsstunde mo2 = new Unterrichtsstunde("2", new ArrayList<>(Arrays.asList("Engel")), "U042", fächer.get(11));
        Unterrichtsstunde mo3 = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Schmidt")), "U040", fächer.get(13));
        Unterrichtsstunde mo4 = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Schmidt")), "U040", fächer.get(13));
        Unterrichtsstunde mo5 = new Unterrichtsstunde("5", new ArrayList<>(Arrays.asList("Harth")), "208", fächer.get(0));
        Unterrichtsstunde mo6 = new Unterrichtsstunde("6", new ArrayList<>(Arrays.asList("Harth")), "208", fächer.get(0));

//Objekte Unterrichtsstunden Dienstag
        Unterrichtsstunde di1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Aldudak")), "R25", fächer.get(3));
        Unterrichtsstunde di2 = new Unterrichtsstunde("2", new ArrayList<>(Arrays.asList("Aldudak")), "R25", fächer.get(3));
        Unterrichtsstunde di3 = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Penschinski")), "R040", fächer.get(1));
        Unterrichtsstunde di4 = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Penschinski")), "R040", fächer.get(1));
        Unterrichtsstunde di5 = new Unterrichtsstunde("5", new ArrayList<>(Arrays.asList("Kühn")), "R212", fächer.get(6));
        Unterrichtsstunde di6 = new Unterrichtsstunde("6", new ArrayList<>(Arrays.asList("Kühn")), "R212", fächer.get(6));
        Unterrichtsstunde di7 = new Unterrichtsstunde("7", new ArrayList<>(Arrays.asList("Becker")), "Sporthalle", fächer.get(9));
        Unterrichtsstunde di8 = new Unterrichtsstunde("8", new ArrayList<>(Arrays.asList("Becker")), "Sporthalle", fächer.get(9));

//Objekte Unterrichtsstunden Mittwoch
        Unterrichtsstunde mi5 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Schaub")), "R25", fächer.get(10));
        Unterrichtsstunde mi6 = new Unterrichtsstunde("2", new ArrayList<>(Arrays.asList("Schaub")), "R25", fächer.get(10));
        Unterrichtsstunde mi7 = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Schaum")), "R040", fächer.get(12));
        Unterrichtsstunde mi8 = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Schaum")), "R040", fächer.get(12));

//Objekte Unterrichtsstunden Donnerstag
        Unterrichtsstunde do1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Penschinski")), "A010", fächer.get(1));
        Unterrichtsstunde do2 = new Unterrichtsstunde("2", new ArrayList<>(Arrays.asList("Penschinski")), "A010", fächer.get(1));
        Unterrichtsstunde do3 = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Penschinski")), "A010", fächer.get(1));
        Unterrichtsstunde do4 = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Penschinski")), "A010", fächer.get(1));
        Unterrichtsstunde do5 = new Unterrichtsstunde("5", new ArrayList<>(Arrays.asList("Bledau")), "D010", fächer.get(8));
        Unterrichtsstunde do6 = new Unterrichtsstunde("6", new ArrayList<>(Arrays.asList("Bledau")), "D010", fächer.get(8));
        Unterrichtsstunde do7 = new Unterrichtsstunde("7", new ArrayList<>(Arrays.asList("Harth")), "A010", fächer.get(0));
        Unterrichtsstunde do8 = new Unterrichtsstunde("8", new ArrayList<>(Arrays.asList("Harth")), "A010", fächer.get(0));
        Unterrichtsstunde do9 = new Unterrichtsstunde("9", new ArrayList<>(Arrays.asList("Watolla")), "DS Raum", fächer.get(20));
        Unterrichtsstunde do10 = new Unterrichtsstunde("10", new ArrayList<>(Arrays.asList("Watolla")), "DS Raum", fächer.get(20));

//Objekte Unterrichtsstunden Freitag
        Unterrichtsstunde fr1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Engel")), "U040", fächer.get(11));
        Unterrichtsstunde fr2 = new Unterrichtsstunde("2", new ArrayList<>(Arrays.asList("Engel")), "U040", fächer.get(11));
        Unterrichtsstunde fr3 = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Schmidt")), "U040", fächer.get(14));
        Unterrichtsstunde fr4 = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Schmidt")), "U040", fächer.get(14));
        Unterrichtsstunde fr5 = new Unterrichtsstunde("5", new ArrayList<>(Arrays.asList("Aldudak")), "R040", fächer.get(2));
        Unterrichtsstunde fr6 = new Unterrichtsstunde("6", new ArrayList<>(Arrays.asList("Aldudak")), "R040", fächer.get(2));
        Unterrichtsstunde fr7 = new Unterrichtsstunde("7", new ArrayList<>(Arrays.asList("Schaum")), "R040", fächer.get(12));
        Unterrichtsstunde fr8 = new Unterrichtsstunde("8", new ArrayList<>(Arrays.asList("Schaum")), "R040", fächer.get(12));

        //Schultage
        Schultag montag1 = new Schultag("Montag", new ArrayList<>(Arrays.asList(mo1, mo2, mo3, mo4, mo5, mo6)));
        Schultag dienstag1 = new Schultag("Dienstag", new ArrayList<>(Arrays.asList(di1, di2, di3, di4, di5, di6, di7, di8)));
        Schultag mittwoch1 = new Schultag("Mittwoch", new ArrayList<>(Arrays.asList(mi5, mi6, mi7, mi8)));
        Schultag donnerstag1 = new Schultag("Donnerstag", new ArrayList<>(Arrays.asList(do1, do2, do3, do4, do5, do6, do7, do8, do9, do10)));
        Schultag freitag1 = new Schultag("Freitag", new ArrayList<>(Arrays.asList(fr1, fr2, fr3, fr4, fr5, fr6)));

        //Schulwochen
        Schulwoche sw1 = new Schulwoche(new Schultag[] {montag1, dienstag1, mittwoch1, donnerstag1, freitag1, new Schultag("Samstag"), new Schultag("Sonntag")});
        Schulwoche sw2 = new Schulwoche(new Schultag[] {montag1, dienstag1, mittwoch1, donnerstag1, freitag1, new Schultag("Samstag"), new Schultag("Sonntag")});

        Stundenplan stundenplan = new Stundenplan("TLS Stundenplan Jannis", sw1, sw2);
        return stundenplan;

    }
}