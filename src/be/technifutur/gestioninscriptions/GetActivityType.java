package be.technifutur.gestioninscriptions;

import java.util.concurrent.Callable;

public class GetActivityType implements Callable {
    ListActivityVue listactivityvue;
    ActivityListControler activitylistcontroler;

    @Override
    public Object call() {
        activitylistcontroler.afficher(listactivityvue.getname());
        return null;
    }

    public void setVue(ListActivityVue vue){this.listactivityvue = vue;}

    public void setModele(ActivityListControler type){this.activitylistcontroler = type;}
}
