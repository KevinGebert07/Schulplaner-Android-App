package de.StundenplanHelden.schulplaner_android_app;

import java.io.Serializable;

public class Fach implements Serializable {
    protected String bezeichnung;
    protected int farbe;
    protected Halbjahr[] halbjahre;

    public Fach (String bezeichnung, int farbe){
        this.bezeichnung = bezeichnung;
        this.farbe = farbe;
        this.halbjahre = new Halbjahr[]{
                new Halbjahr("E1"),
                new Halbjahr("E2"),
                new Halbjahr("Q1"),
                new Halbjahr("Q2"),
                new Halbjahr("Q3"),
                new Halbjahr("Q4")
        };
    }


    //Methoden zur Berechnung des Fachdurchschnitts, gesamt, von einem bestimmten Halbjahr und von mehreren bestimmten Halbjahren
    public double berechneFachDurchschnitt (){
        double avg = -1.0;
        avg = Verwaltung.berechneDurchschnittPositiv(new double[] {
                halbjahre[0].durchSchnittBerechnen(),
                halbjahre[1].durchSchnittBerechnen(),
                halbjahre[2].durchSchnittBerechnen(),
                halbjahre[3].durchSchnittBerechnen(),
                halbjahre[4].durchSchnittBerechnen(),
                halbjahre[5].durchSchnittBerechnen()}
        );
        if (avg == 0){ avg=-1.0;}
        return avg;
    }

    //Berechnet den Durchschnitt des Fach-Objektes in einem bestimmten Halbjahr und gibt diesen zurück
    public double berechneFachDurchschnitt(int halbjahr){
        double avg = 0.0;
        avg = halbjahre[halbjahr].durchSchnittBerechnen();
        return avg;
    }

    //Berechnet den Durchschnitt des Fach-Objektes für einen Bereich von Halbjahren und gibt diesen zurück
    public double berechneFachDurchschnitt(int halbjahrStart, int halbJahrEnd) {
        double avg = 0.0;
        int count = 0;
        for (int i = halbjahrStart; i <= halbJahrEnd; i++) {
            avg += halbjahre[i].durchSchnittBerechnen();
            count++;
        }
        if (count != 0) {
            avg = avg / count;
        }
        return avg;
    }

    @Override
    public String toString(){
        return "Ich bin "+ bezeichnung;
    }
}
