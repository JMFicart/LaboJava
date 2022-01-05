package be.technifutur.gestioninscriptions;

import java.io.Serializable;

public class ActivityType implements Serializable {
    String name;
    Boolean registration;

    public ActivityType(String name, Boolean inscription) {
        this.name = name;
        this.registration = inscription;
    }
}
