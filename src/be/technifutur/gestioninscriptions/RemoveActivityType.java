package be.technifutur.gestioninscriptions;

import java.util.concurrent.Callable;

public class RemoveActivityType implements Callable  {
    ActivityListControler alc;
    ListActivityVue lav;

    @Override
    public Object call() {
        alc.remove(lav.getname());
        return null;
    }

    public void setControler(ActivityListControler cont){this.alc = cont;}

    public void setVue(ListActivityVue vue){this.lav = vue;}

}
