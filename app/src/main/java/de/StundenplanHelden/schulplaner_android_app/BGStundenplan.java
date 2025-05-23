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
        Unterrichtsstunde mo1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Engel","Magdeburg")), "U042", fächer.get(11));
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
        Schultag freitag1 = new Schultag("Freitag", new ArrayList<>(Arrays.asList(fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8)));

        //Schulwochen
        Schulwoche sw1 = new Schulwoche(new Schultag[] {montag1, dienstag1, mittwoch1, donnerstag1, freitag1, new Schultag("Samstag"), new Schultag("Sonntag")});
        Schulwoche sw2 = new Schulwoche(new Schultag[] {montag1, dienstag1, mittwoch1, donnerstag1, freitag1, new Schultag("Samstag"), new Schultag("Sonntag")});

        Stundenplan stundenplan = new Stundenplan("TLS Stundenplan Jannis", sw1, sw2);
        return stundenplan;

    }

    public static Stundenplan BGStundenplan(String bezeichnung, boolean spanisch, int nawi, int lk, boolean reli, boolean ds) {
        // Fächerliste holen
        ArrayList<Fach> fächer = Verwaltung.getInstance().fächer;

        // Montag
        Unterrichtsstunde mo1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Engel", "Magdeburg")), "U40/ U42", fächer.get(11));
        Unterrichtsstunde mo2 = new Unterrichtsstunde("2", new ArrayList<>(Arrays.asList("Engel", "Magdeburg")), "U40/ U42", fächer.get(11));
        Unterrichtsstunde mo3 = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Schmidt", "Berjani")), "U40/ U42", fächer.get(13));
        Unterrichtsstunde mo4 = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Schmidt", "Berjani")), "U40/ U42", fächer.get(13));
        Unterrichtsstunde mo5 = new Unterrichtsstunde("5", new ArrayList<>(Arrays.asList("Harth", "Günther")), "208/ 205", fächer.get(0));
        Unterrichtsstunde mo6 = new Unterrichtsstunde("6", new ArrayList<>(Arrays.asList("Harth", "Günther")), "208/ 205", fächer.get(0));

        // Dienstag
        Unterrichtsstunde di1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Aldudak", "Behmel", "Heinrich")), "R24/ R23", fächer.get(3));
        Unterrichtsstunde di2 = new Unterrichtsstunde("2", new ArrayList<>(Arrays.asList("Aldudak", "Behmel", "Heinrich")), "R24/ R23", fächer.get(3));
        Unterrichtsstunde di7 = new Unterrichtsstunde("7", new ArrayList<>(Arrays.asList("Becker")), "Sporthalle", fächer.get(9));
        Unterrichtsstunde di8 = new Unterrichtsstunde("8", new ArrayList<>(Arrays.asList("Becker")), "Sporthalle", fächer.get(9));
        Unterrichtsstunde di9 = new Unterrichtsstunde("9", new ArrayList<>(Arrays.asList("Schaub")), "R48", fächer.get(10));
        Unterrichtsstunde di10 = new Unterrichtsstunde("10", new ArrayList<>(Arrays.asList("Schaub")), "R48", fächer.get(10));

        // Mittwoch
        Unterrichtsstunde mi1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Schmidt")), "R140", fächer.get(1));
        Unterrichtsstunde mi2 = new Unterrichtsstunde("2", new ArrayList<>(Arrays.asList("Schmidt")), "R140", fächer.get(1));
        Unterrichtsstunde mi3 = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Schmidt")), "R140", fächer.get(1));
        Unterrichtsstunde mi4 = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Schmidt")), "R140", fächer.get(1));
        Unterrichtsstunde mi5 = new Unterrichtsstunde("5", new ArrayList<>(Arrays.asList("Schaub")), "R200", fächer.get(10));
        Unterrichtsstunde mi6 = new Unterrichtsstunde("6", new ArrayList<>(Arrays.asList("Schaub")), "R200", fächer.get(10));
        Unterrichtsstunde mi7 = new Unterrichtsstunde("7", new ArrayList<>(Arrays.asList("Schaum")), "R040", fächer.get(12));
        Unterrichtsstunde mi8 = new Unterrichtsstunde("8", new ArrayList<>(Arrays.asList("Schaum")), "R040", fächer.get(12));

        // Donnerstag
        Unterrichtsstunde do5 = new Unterrichtsstunde("5", new ArrayList<>(Arrays.asList("Aldudak")), "D203", fächer.get(7));
        Unterrichtsstunde do6 = new Unterrichtsstunde("6", new ArrayList<>(Arrays.asList("Aldudak")), "D203", fächer.get(7));
        Unterrichtsstunde do7 = new Unterrichtsstunde("7", new ArrayList<>(Arrays.asList("Harth/ Günther")), "A010/ A113", fächer.get(0));
        Unterrichtsstunde do8 = new Unterrichtsstunde("8", new ArrayList<>(Arrays.asList("Harth/ Günther")), "A010/ A113", fächer.get(0));

        // Freitag
        Unterrichtsstunde fr1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Engel", "Magdeburg")), "U40/ U42", fächer.get(11));
        Unterrichtsstunde fr2 = new Unterrichtsstunde("2", new ArrayList<>(Arrays.asList("Engel", "Magdeburg")), "U40/ U42", fächer.get(11));
        Unterrichtsstunde fr3a = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Schmidt", "Berjani")), "U40/ U42", fächer.get(13));
        Unterrichtsstunde fr4a = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Schmidt", "Berjani")), "U40/ U42", fächer.get(13));
        Unterrichtsstunde fr3b = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Engel", "Magdeburg")), "U40/ U42", fächer.get(11));
        Unterrichtsstunde fr4b = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Engel", "Magdeburg")), "U40/ U42", fächer.get(11));
        Unterrichtsstunde fr5 = new Unterrichtsstunde("5", new ArrayList<>(Arrays.asList("Aldudak")), "R040", fächer.get(2));
        Unterrichtsstunde fr6 = new Unterrichtsstunde("6", new ArrayList<>(Arrays.asList("Aldudak")), "R040", fächer.get(2));
        Unterrichtsstunde fr7a = new Unterrichtsstunde("7", new ArrayList<>(Arrays.asList("Schaum")), "R040", fächer.get(12));
        Unterrichtsstunde fr8a = new Unterrichtsstunde("8", new ArrayList<>(Arrays.asList("Schaum")), "R040", fächer.get(12));
        Unterrichtsstunde fr7b = fr7a; // Platzhalter, ggf. anpassen
        Unterrichtsstunde fr8b = fr8a; // Platzhalter, ggf. anpassen

        // Etik/Reli
        if (reli) {
            do5 = new Unterrichtsstunde("5", new ArrayList<>(Arrays.asList("Bledau")), "D010", fächer.get(8));
            do6 = new Unterrichtsstunde("6", new ArrayList<>(Arrays.asList("Bledau")), "D010", fächer.get(8));
        }

        // Nawi
        Unterrichtsstunde di5 = null, di6 = null, do3b = null, do4b = null;
        if (nawi == 1) { // Chemie
            di5 = new Unterrichtsstunde("5", new ArrayList<>(Arrays.asList("Kühn")), "R212", fächer.get(6));
            di6 = new Unterrichtsstunde("6", new ArrayList<>(Arrays.asList("Kühn")), "R212", fächer.get(6));
            do3b = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Kühn")), "R212", fächer.get(6));
            do4b = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Kühn")), "R212", fächer.get(6));
        } else if (nawi == 2) { // Physik
            di5 = new Unterrichtsstunde("5", new ArrayList<>(Arrays.asList("Spanke")), "R123", fächer.get(4));
            di6 = new Unterrichtsstunde("6", new ArrayList<>(Arrays.asList("Spanke")), "R123", fächer.get(4));
            do3b = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Spanke")), "R123", fächer.get(4));
            do4b = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Spanke")), "R123", fächer.get(4));
        } else if (nawi == 3) { // Bio
            di5 = new Unterrichtsstunde("5", new ArrayList<>(Arrays.asList("Lynker", "Brasch")), "R208/ R142", fächer.get(5));
            di6 = new Unterrichtsstunde("6", new ArrayList<>(Arrays.asList("Lynker", "Brasch")), "R208/ R142", fächer.get(5));
            do3b = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Lynker", "Brasch")), "R208/ R142", fächer.get(5));
            do4b = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Lynker", "Brasch")), "R208/ R142", fächer.get(5));
        }

        // LK
        Schultag montag1, dienstag1, mittwoch1, donnerstag1, donnerstag2, freitag1, freitag2;
        if (lk == 0) { // Mathe
            Unterrichtsstunde di3 = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Penschinski")), "R040", fächer.get(1));
            Unterrichtsstunde di4 = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Penschinski")), "R040", fächer.get(1));
            Unterrichtsstunde do1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Penschinski")), "A010", fächer.get(1));
            Unterrichtsstunde do2 = new Unterrichtsstunde("2", new ArrayList<>(Arrays.asList("Penschinski")), "A010", fächer.get(1));
            Unterrichtsstunde do3a = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Penschinski")), "A010", fächer.get(1));
            Unterrichtsstunde do4a = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Penschinski")), "A010", fächer.get(1));

            montag1 = new Schultag("Montag", new ArrayList<>(Arrays.asList(mo1, mo2, mo3, mo4, mo5, mo6)));
            dienstag1 = new Schultag("Dienstag", new ArrayList<>(Arrays.asList(di1, di2, di3, di4, di5, di6, di7, di8)));
            mittwoch1 = new Schultag("Mittwoch", new ArrayList<>(Arrays.asList(mi7, mi8)));
            donnerstag1 = new Schultag("Donnerstag", new ArrayList<>(Arrays.asList(do1, do2, do3a, do4a, do5, do6, do7, do8)));
            freitag1 = new Schultag("Freitag", new ArrayList<>(Arrays.asList(fr1, fr2, fr3a, fr4a, fr5, fr6, fr7a, fr8a)));
            donnerstag2 = new Schultag("Donnerstag", new ArrayList<>(Arrays.asList(do1, do2, do3b, do4b, do5, do6, do7, do8)));
            freitag2 = new Schultag("Freitag", new ArrayList<>(Arrays.asList(fr1, fr2, fr3b, fr4b, fr5, fr6, fr7b, fr8b)));

        } else if (lk == 1) { // Englisch
            Unterrichtsstunde di3 = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Tegethoff")), "R23", fächer.get(12));
            Unterrichtsstunde di4 = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Tegethoff")), "R23", fächer.get(12));
            Unterrichtsstunde do1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Tegethoff")), "D108", fächer.get(12));
            Unterrichtsstunde do2 = new Unterrichtsstunde("2", new ArrayList<>(Arrays.asList("Tegethoff")), "D108", fächer.get(12));
            Unterrichtsstunde do3a = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Tegethoff")), "D108", fächer.get(12));
            Unterrichtsstunde do4a = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Tegethoff")), "D108", fächer.get(12));

            montag1 = new Schultag("Montag", new ArrayList<>(Arrays.asList(mo1, mo2, mo3, mo4, mo5, mo6)));
            dienstag1 = new Schultag("Dienstag", new ArrayList<>(Arrays.asList(di1, di2, di3, di4, di5, di6, di7, di8)));
            mittwoch1 = new Schultag("Mittwoch", new ArrayList<>(Arrays.asList(mi1, mi2, mi3, mi4)));
            donnerstag1 = new Schultag("Donnerstag", new ArrayList<>(Arrays.asList(do1, do2, do3a, do4a, do5, do6, do7, do8)));
            freitag1 = new Schultag("Freitag", new ArrayList<>(Arrays.asList(fr1, fr2, fr3a, fr4a, fr5, fr6)));
            donnerstag2 = new Schultag("Donnerstag", new ArrayList<>(Arrays.asList(do1, do2, do3b, do4b, do5, do6, do7, do8)));
            freitag2 = new Schultag("Freitag", new ArrayList<>(Arrays.asList(fr1, fr2, fr3b, fr4b, fr5, fr6, fr7b, fr8b)));

        } else if (lk == 2) { // Physik
            Unterrichtsstunde di3 = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Spanke")), "R123", fächer.get(4));
            Unterrichtsstunde di4 = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Spanke")), "R123", fächer.get(4));
            Unterrichtsstunde do1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Spanke")), "A113", fächer.get(4));
            Unterrichtsstunde do2 = new Unterrichtsstunde("2", new ArrayList<>(Arrays.asList("Spanke")), "A113", fächer.get(4));
            Unterrichtsstunde do3a = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Spanke")), "A113", fächer.get(4));
            Unterrichtsstunde do4a = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Spanke")), "A113", fächer.get(4));

            montag1 = new Schultag("Montag", new ArrayList<>(Arrays.asList(mo1, mo2, mo3, mo4, mo5, mo6)));
            dienstag1 = new Schultag("Dienstag", new ArrayList<>(Arrays.asList(di1, di2, di3, di4, di7, di8)));
            mittwoch1 = new Schultag("Mittwoch", new ArrayList<>(Arrays.asList(mi1, mi2, mi3, mi4, mi7, mi8)));
            donnerstag1 = new Schultag("Donnerstag", new ArrayList<>(Arrays.asList(do1, do2, do3a, do4a, do5, do6, do7, do8)));
            freitag1 = new Schultag("Freitag", new ArrayList<>(Arrays.asList(fr1, fr2, fr3a, fr4a, fr5, fr6, fr7a, fr8a)));
            donnerstag2 = new Schultag("Donnerstag", new ArrayList<>(Arrays.asList(do1, do2, do5, do6, do7, do8)));
            freitag2 = new Schultag("Freitag", new ArrayList<>(Arrays.asList(fr1, fr2, fr3b, fr4b, fr5, fr6, fr7b, fr8b)));

        } else if (lk == 3) { // Deutsch
            Unterrichtsstunde di3 = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Mund")), "R24", fächer.get(0));
            Unterrichtsstunde di4 = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Mund")), "R24", fächer.get(0));
            Unterrichtsstunde do1 = new Unterrichtsstunde("1", new ArrayList<>(Arrays.asList("Mund")), "D107", fächer.get(0));
            Unterrichtsstunde do2 = new Unterrichtsstunde("2", new ArrayList<>(Arrays.asList("Mund")), "D107", fächer.get(0));
            Unterrichtsstunde do3a = new Unterrichtsstunde("3", new ArrayList<>(Arrays.asList("Mund")), "D107", fächer.get(0));
            Unterrichtsstunde do4a = new Unterrichtsstunde("4", new ArrayList<>(Arrays.asList("Mund")), "D107", fächer.get(0));
            montag1 = new Schultag("Montag", new ArrayList<>(Arrays.asList(mo1, mo2, mo3, mo4)));
            dienstag1 = new Schultag("Dienstag", new ArrayList<>(Arrays.asList(di1, di2, di3, di4, di5, di6, di7, di8)));
            mittwoch1 = new Schultag("Mittwoch", new ArrayList<>(Arrays.asList(mi1, mi2, mi3, mi4, mi7, mi8)));
            donnerstag1 = new Schultag("Donnerstag", new ArrayList<>(Arrays.asList(do1, do2, do3a, do4a, do5, do6)));
            freitag1 = new Schultag("Freitag", new ArrayList<>(Arrays.asList(fr1, fr2, fr3a, fr4a, fr5, fr6, fr7a, fr8a)));
            donnerstag2 = new Schultag("Donnerstag", new ArrayList<>(Arrays.asList(do1, do2, do3b, do4b, do5, do6)));
            freitag2 = new Schultag("Freitag", new ArrayList<>(Arrays.asList(fr1, fr2, fr3b, fr4b, fr5, fr6, fr7b, fr8b)));
        } else {
            // Fallback/Fehlerbehandlung
            Log.e("FATAL", "FATAL Fallback Stundenplan create");
            montag1 = new Schultag("Montag", new ArrayList<>(Arrays.asList(mo1, mo2, mo3, mo4, mo5, mo6)));
            dienstag1 = new Schultag("Dienstag", new ArrayList<>(Arrays.asList(di1, di2, di7, di8)));
            mittwoch1 = new Schultag("Mittwoch", new ArrayList<>(Arrays.asList(mi1, mi2, mi3, mi4)));
            donnerstag1 = new Schultag("Donnerstag", new ArrayList<>(Arrays.asList(do5, do6, do7, do8)));
            freitag1 = new Schultag("Freitag", new ArrayList<>(Arrays.asList(fr1, fr2, fr5, fr6)));
            donnerstag2 = donnerstag1;
            freitag2 = freitag1;
        }

        // Spanisch
        if (spanisch) {
            dienstag1.unterrichtsstundeEinfügen(8, di9);
            dienstag1.unterrichtsstundeEinfügen(9, di10);
            if (lk != 0){ //Mathe GK
                mittwoch1.unterrichtsstundeEinfügen(4, mi5);
                mittwoch1.unterrichtsstundeEinfügen(5, mi6);

                mittwoch1.unterrichtsstundeEinfügen(6, mi7);
                mittwoch1.unterrichtsstundeEinfügen(7, mi8);
            }
            else{
                mittwoch1.unterrichtsstundeEinfügen(0, mi5);
                mittwoch1.unterrichtsstundeEinfügen(1, mi6);
                mittwoch1.unterrichtsstundeEinfügen(2, mi7);
                mittwoch1.unterrichtsstundeEinfügen(3, mi8);
            }

        }

        // DS
        if (ds) {
            Unterrichtsstunde do9 = new Unterrichtsstunde("9", new ArrayList<>(Arrays.asList("Watolla")), "DS Raum", fächer.get(20));
            Unterrichtsstunde do10 = new Unterrichtsstunde("10", new ArrayList<>(Arrays.asList("Watolla")), "DS Raum", fächer.get(20));
            donnerstag1.unterrichtsstundeEinfügen(8, do9);
            donnerstag1.unterrichtsstundeEinfügen(9, do10);
        }

        // Schulwochen
        Schulwoche sw1 = new Schulwoche(new Schultag[] {montag1, dienstag1, mittwoch1, donnerstag1, freitag1, new Schultag("Samstag"), new Schultag("Sonntag")});
        Schulwoche sw2 = new Schulwoche(new Schultag[] {montag1, dienstag1, mittwoch1, donnerstag2, freitag2, new Schultag("Samstag"), new Schultag("Sonntag")});

        Stundenplan stundenplan = new Stundenplan(bezeichnung, sw1, sw2);
        return stundenplan;
    }
}