package be.technifutur.gestioninscriptions;

import java.util.concurrent.Callable;

public class ActivityUpdate implements Callable {
    ActivityVue activityvue;
    ActivityControler activitycontroler;
    String name;
    Boolean registration;

    @Override
    public Object call() {
        name = activityvue.getname();
//        registration = activityvue.getregistration();
//        activitycontroler.addnew(name, registration);
        return null;
    }

    public void setVue(ActivityVue vue) {
        this.activityvue = vue;
    }

    public void setControler(ActivityControler cont) {
        this.activitycontroler = cont;
    }
}
