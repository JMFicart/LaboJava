package be.technifutur.gestioninscriptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Activity implements Serializable {
    LocalDateTime start;
    LocalDateTime end;
    String name;
    ActivityType type;

    public Activity(String name, ActivityType activitytype, LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
        this.name = name;
        this.type = activitytype;
    }
}
