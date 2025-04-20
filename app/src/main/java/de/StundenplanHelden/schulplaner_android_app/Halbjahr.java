package de.StundenplanHelden.schulplaner_android_app;

public class Halbjahr {
    private String bezeichnung;
    private int klausur1;
    private int klausur2;
    private int mündlich;
    private String notiz;

    public Halbjahr (String bezeichnung){
        this.bezeichnung = bezeichnung;
    }

    public void noteEintragen (int position, int notenpunkte){
        switch (position) {
            case 1:
                klausur1 = notenpunkte;
                break;
            case 2:
                klausur2 = notenpunkte;
                break;
            case 3:
                mündlich = notenpunkte;
                break;
        }
    }

    public void setNotiz(String notiz){
        this.notiz = notiz;
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
}
