package be.technifutur.gestioninscriptions;

import java.util.concurrent.Callable;

public class ListActivityType implements Callable {
    ActivityListControler alc;

    @Override
    public Object call() {
        alc.lister();
        return null;
    }

    public void setControler(ActivityListControler cont){this.alc = cont;}
}
