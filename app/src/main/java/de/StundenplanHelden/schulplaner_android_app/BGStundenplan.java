package de.StundenplanHelden.schulplaner_android_app;

import android.graphics.Color;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BGStundenplan {
    public static ArrayList<Fach> tlsFächer(){

        //Erstelle Beispielfächer, die beim Starten der APP als JSON gespeichert werden
        ArrayList<Fach> fächer = new ArrayList<>() {
            new Fach("Deutsch", ),                      //0
            new Fach("Englisch", ),                     //1
            new Fach("Mathematik", ),                   //2
            new Fach("Geschichte", ),                   //3
            new Fach("PoWi", ),                         //4
            new Fach("Physik", ),                       //5
            new Fach("Biologie", ),                     //6
            new Fach("Chemie", ),                       //7
            new Fach("Ethik", ),                        //8
            new Fach("Religion", ),                     //9
            new Fach("Sport", ),                        //10
            new Fach("Spanisch", )                      //11
            new Fach("Praktische Informatik", ),        //12
            new Fach("Informationstechnik", ),          //13
            new Fach("Software Engineering", ),         //14
            new Fach("Bautechnik", ),                   //15
            new Fach("Konstruktionslehre", ),           //16
            new Fach("Mechatronik", ),                  //17
            new Fach("Elektrotechnik", ),               //18
            new Fach("Technische Kommunikation", ),     //19
            new Fach("Darstellendes Spiel", ),          //20
            new Fach("Debattieren", ),                  //21
            new Fach("Veranstaltungstechnik", ),        //22
            new Fach("Schulband", ),                    //23
            new Fach("Kreatives Schreiben"),            //24

        };
        return fächer;
    }

    public static String jannisStundenplan(){
        ArrayList<Fach> fächer = tlsFächer();

        //Objekte Unterrichtsstunden Montag
        Unterrichtsstunde m1 = new Unterrichtsstunde("1", new ArrayList<>(){"Engel"}, "U042", fächer.get(12));
        Unterrichtsstunde m2 = new Unterrichtsstunde("2", new ArrayList<>(){"Engel"}, "U042", fächer.get(13));
        Unterrichtsstunde m3 = new Unterrichtsstunde("3", new ArrayList<>(){"Schmidt"}, "U040", fächer.get(13));
        Unterrichtsstunde m4 = new Unterrichtsstunde("4", new ArrayList<>(){"Schmidt"}, "U040", fächer.get(13));
        Unterrichtsstunde m5 = new Unterrichtsstunde("5", new ArrayList<>(){"Harth"}, "208", fächer.get(0));
        Unterrichtsstunde m6 = new Unterrichtsstunde("6", new ArrayList<>(){"Harth"}, "208", fächer.get(0));

        //Objekte Unterrichtsstunden Dienstag
        Unterrichtsstunde d1 = new Unterrichtsstunde("1", new ArrayList<>(){"Aldudak"}, "R25", fächer.get(4));
        Unterrichtsstunde d2 = new Unterrichtsstunde("2", new ArrayList<>(){"Aldudak"}, "R25", fächer.get(4));
        Unterrichtsstunde d3 = new Unterrichtsstunde("3", new ArrayList<>(){"Penschinski"}, "R040", fächer.get(2));
        Unterrichtsstunde d4 = new Unterrichtsstunde("4", new ArrayList<>(){"Penschinski"}, "R040", fächer.get(2));
        Unterrichtsstunde d5 = new Unterrichtsstunde("5", new ArrayList<>(){"Kühn"}, "212", fächer.get(7));
        Unterrichtsstunde d6 = new Unterrichtsstunde("6", new ArrayList<>(){"Kühn"}, "212", fächer.get(7));
        Unterrichtsstunde d7 = new Unterrichtsstunde("7", new ArrayList<>(){"Becker"}, "Sporthalle", fächer.get(10));
        Unterrichtsstunde d8 = new Unterrichtsstunde("8", new ArrayList<>(){"Becker"}, "Sporthalle", fächer.get(10));

        //Objekte Unterrichtsstunden Mittwoch
        Unterrichtsstunde m1 = new Unterrichtsstunde("1", new ArrayList<>(){"Schaub"}, "R25", fächer.get(11));
        Unterrichtsstunde m2 = new Unterrichtsstunde("2", new ArrayList<>(){"Schaub"}, "R25", fächer.get(11));
        Unterrichtsstunde m3 = new Unterrichtsstunde("3", new ArrayList<>(){"Schaum"}, "R040", fächer.get(1));
        Unterrichtsstunde m4 = new Unterrichtsstunde("4", new ArrayList<>(){"Schaum"}, "R040", fächer.get(2));

        //Objekte Unterrichtsstunden Donnerstag
        Unterrichtsstunde d1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Penschinski")), "A010", fächer.get(2));
        Unterrichtsstunde d2 = new Unterrichtsstunde("2", new ArrayList<>(){"Penschinski"}, "A010", fächer.get(2));
        Unterrichtsstunde d3 = new Unterrichtsstunde("3", new ArrayList<>(){"Penschinski"}, "A010", fächer.get(2));
        Unterrichtsstunde d4 = new Unterrichtsstunde("4", new ArrayList<>(){"Penschinski"}, "A010", fächer.get(2));
        Unterrichtsstunde d5 = new Unterrichtsstunde("5", new ArrayList<>(){"Bledau"}, "D010", fächer.get(9));
        Unterrichtsstunde d6 = new Unterrichtsstunde("6", new ArrayList<>(){"Bledau"}, "D010", fächer.get(9));
        Unterrichtsstunde d7 = new Unterrichtsstunde("7", new ArrayList<>(){"Harth"}, "A010", fächer.get(0));
        Unterrichtsstunde d8 = new Unterrichtsstunde("8", new ArrayList<>(){"Harth"}, "A010", fächer.get(0));
        Unterrichtsstunde d9 = new Unterrichtsstunde("9", new ArrayList<>(){"Watolla"}, "DS Raum", fächer.get(20));
        Unterrichtsstunde d10 = new Unterrichtsstunde("10", new ArrayList<>(){"Watolla"}, "DS Raum", fächer.get(20));

        //Objekte Unterrichtsstunden Freitag
        Unterrichtsstunde f1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Engel")), "U040", fächer.get(4));
        Unterrichtsstunde f2 = new Unterrichtsstunde("2", new ArrayList<>(){"Engel"}, "U040", fächer.get(4));
        Unterrichtsstunde f3 = new Unterrichtsstunde("3", new ArrayList<>(){"Schmidt"}, "U040", fächer.get(2));
        Unterrichtsstunde f4 = new Unterrichtsstunde("4", new ArrayList<>(){"Schmidt"}, "U040", fächer.get(2));
        Unterrichtsstunde f5 = new Unterrichtsstunde("5", new ArrayList<>(){"Aldudak"}, "R040", fächer.get(7));
        Unterrichtsstunde f6 = new Unterrichtsstunde("6", new ArrayList<>(){"Aldudak"}, "R040", fächer.get(7));
        Unterrichtsstunde f7 = new Unterrichtsstunde("7", new ArrayList<>(){"Schaum"}, "R040", fächer.get(10));
        Unterrichtsstunde f8 = new Unterrichtsstunde("8", new ArrayList<>(){"Schaum"}, "R040", fächer.get(10));

        //Schultage
        Schultag mo1 = new Schultag("Montag", new ArrayList<>(Arrays.asList(m1, m2, m3, m4, m5, m6)));
        Schultag di1 = new Schultag("Montag", new ArrayList<>(Arrays.asList(m1, m2, m3, m4, m5, m6)));
        Schultag mi3 = new Schultag("Montag", new ArrayList<>(Arrays.asList(m1, m2, m3, m4, m5, m6)));
        Schultag do4 = new Schultag("Montag", new ArrayList<>(Arrays.asList(m1, m2, m3, m4, m5, m6)));
        Schultag fr5 = new Schultag("Montag", new ArrayList<>(Arrays.asList(m1, m2, m3, m4, m5, m6)));

        //Schulwochen
        Schulwoche sw1 = new Schulwoche("mo1, di1, mi1, do1, fr1");
        Schulwoche sw2 = new Schulwoche("mo2, di2, mi2, do2, fr2");



    }
}