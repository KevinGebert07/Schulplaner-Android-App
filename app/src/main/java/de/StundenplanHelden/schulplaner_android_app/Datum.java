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

