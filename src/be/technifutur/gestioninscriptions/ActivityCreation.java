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
        System.out.println("t0");
        if(activitycontroler.checkNomHoraire(name) != null) {
            System.out.println("t1");
            type = activitycontroler.checkActivityType(activityvue.gettype());
            if (type != null){
                System.out.println("t2");
//                start = activitycontroler.checkStart(activityvue.getstart());
                System.out.println(activitycontroler.checkStart(activityvue.getstart()));
//                end = activitycontroler.checkEnd(start, activityvue.getend());
            };
        }
//        System.out.println(name + " " + type.name + " " + type.registration + " " + start + " " +end);
//        if (!(type == null)) {
//            activitycontroler.addnew(name, type, start, end);
//        }
        return null;
    }

    public void setVue(ActivityVue vue) {
        this.activityvue = vue;
    }

    public void setControler(ActivityControler cont) {
        this.activitycontroler = cont;
    }

}
