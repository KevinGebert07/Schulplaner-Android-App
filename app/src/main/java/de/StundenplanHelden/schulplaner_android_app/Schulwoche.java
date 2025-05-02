package de.StundenplanHelden.schulplaner_android_app;

public class Schulwoche {
    protected Schultag[] schultage;

    public Schulwoche(Schultag[] schultage){
        this.schultage = schultage;
    }

    public Schultag getSchultag(int position){
        return schultage[position-1];
    }
}