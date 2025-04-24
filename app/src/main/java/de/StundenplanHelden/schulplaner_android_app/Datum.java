package de.StundenplanHelden.schulplaner_android_app;

public class Datum {
    private int tag;
    private int monat;
    private int jahr;

    // Konstruktor
    public Datum(int tag, int monat, int jahr) {
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }
    public Datum (String datum){
        String[] dat = datum.split("[.]");
        if (dat.length == 3){
            this.tag = Integer.valueOf(dat[0]);
            this.monat = Integer.valueOf(dat[1]);
            this.jahr = Integer.valueOf(dat[2]);
        }
        else {
            this.monat = 1;
            this.tag = 1;
            this.jahr = 2000;
        }
    }



    // Getter-Methoden
    public int getTag() {
        return tag;
    }

    public int getMonat() {
        return monat;
    }

    public int getJahr() {
        return jahr;
    }

    // Optional: toString-Methode zur schönen Ausgabe
    @Override
    public String toString() {
        return String.format("%02d.%02d.%04d", tag, monat, jahr);
    }
}

