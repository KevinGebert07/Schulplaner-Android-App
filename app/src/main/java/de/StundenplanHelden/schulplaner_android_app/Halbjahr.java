package de.StundenplanHelden.schulplaner_android_app;

import java.util.ArrayList;

public class Halbjahr {
    private String bezeichnung;
    private int klausur1;
    private int klausur2;
    private int mündlich;
    private String notiz;

    public Halbjahr (String bezeichnung){
        this.bezeichnung = bezeichnung;
        klausur1 = -1;
        klausur2 = -1;
        mündlich = -1;
        notiz = "";
    }

    public void noteEintragen (int position, int notenpunkte){
        switch (position) {
            case 0:
                klausur1 = notenpunkte;
                break;
            case 1:
                klausur2 = notenpunkte;
                break;
            case 2:
                mündlich = notenpunkte;
                break;
        }
    }
    public int getNote(int position){
        switch(position){
            case 1:
                return klausur1;
            case 2:
                return klausur2;
            case 3:
                return mündlich;
        }
        return -1;
    }
    public void setNotiz(String notiz){
        this.notiz = notiz;
    }

    public double durchSchnittBerechnen(){
        double[] werte = new double[]{klausur1,klausur2,mündlich};
        double avg = Verwaltung.berechneDurchschnittPositiv(werte);
        return avg;
    }
}
