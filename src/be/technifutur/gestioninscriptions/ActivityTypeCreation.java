package be.technifutur.gestioninscriptions;

import java.util.concurrent.Callable;

public class ActivityTypeCreation implements Callable {
    ListActivityVue lav;
    ActivityListControler alc;
    String name;
    Boolean registration;

    @Override
    public Object call() {
        name = lav.getname();
        registration = lav.getregistration();
        alc.addnew(name, registration);
        return null;
    }

    public void setVue(ListActivityVue vue) {
        this.lav = vue;
    }

    public void setControler(ActivityListControler cont) {
        this.alc = cont;
    }
}
