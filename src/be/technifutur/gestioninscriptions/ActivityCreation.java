package be.technifutur.gestioninscriptions;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class ActivityCreation implements Callable {
    ActivityVue activityvue;
    ActivityControler activitycontroler;
    String name;
    ActivityType type;
    LocalDateTime start;
    LocalDateTime end;

    @Override
    public Object call() {
        name = activityvue.getname();
        type = activityvue.gettype();
        start = activityvue.getstart();
        end = activityvue.getend();
        activitycontroler.addnew(name, type, start, end);
        return null;
    }

    public void setVue(ActivityVue vue) {
        this.activityvue = vue;
    }

    public void setControler(ActivityControler cont) {
        this.activitycontroler = cont;
    }

}
