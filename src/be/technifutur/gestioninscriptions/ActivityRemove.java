package be.technifutur.gestioninscriptions;

import java.util.concurrent.Callable;

public class ActivityRemove implements Callable {
    ActivityControler activitycontroler;
    ActivityVue activityvue;

    @Override
    public Object call() {
        activitycontroler.remove(activityvue.getname());
        return null;
    }

    public void setControler(ActivityControler cont){this.activitycontroler = cont;}

    public void setVue(ActivityVue vue){this.activityvue = vue;}
}
