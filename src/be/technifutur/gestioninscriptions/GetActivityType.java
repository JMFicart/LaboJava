package be.technifutur.gestioninscriptions;

import java.util.concurrent.Callable;

public class GetActivityType implements Callable {
    ListActivityVue lav;
    ActivityListControler alc;

    @Override
    public Object call() {
        alc.afficher(lav.getname());
        return null;
    }

    public void setVue(ListActivityVue vue){this.lav = vue;}

    public void setModele(ActivityListControler type){this.alc = type;}
}
