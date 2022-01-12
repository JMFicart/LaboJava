package be.technifutur.gestioninscriptions;

import java.util.concurrent.Callable;

public class ActivityFileList implements Callable {
    ActivityControler activitycontroler;

    @Override
    public Object call() {
        activitycontroler.lister();
        return null;
    }

    public void setControler(ActivityControler cont){this.activitycontroler = cont;}

}
