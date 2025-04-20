package de.StundenplanHelden.schulplaner_android_app;

import java.util.ArrayList;

public class Schulwoche {
    private ArrayList<Schultag> schultage;

    public Schulwoche(ArrayList<Schultag> schultage){
        this.schultage = schultage;
    }

    public ArrayList<Schultag> getSchultage(){
        return this.schultage;
    }

    public Schultag getSchultag(int position){
        return schultage.get(position);
    }

}
