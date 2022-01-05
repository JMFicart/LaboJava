package be.technifutur.gestioninscriptions;

import java.time.LocalDateTime;

public class ActivityControler {
    ActivityVue activityvue;
    ActivityModele activitymodele;
    IOData io;
    Activity activity;

    public Activity addnew(String name, ActivityType type, LocalDateTime start, LocalDateTime end){
        if (search(name) == null) {
            activity = new Activity(name, type, start, end);
            activitymodele.getDt().list.add(activity);
            io.SaveDataActivity(activitymodele.getDt());
        }
        else {
            System.out.println(name + " existe déjà !");
            activity = null;
        }
        return activity;
    }

    public Activity afficher(String name){
        activity = search(name);
        if (activity != null) {
            activityvue.displayinfo(activity);
        }
        else {
            activityvue.displaymessagenotfound(name);
            activity = null;
        }
        return activity;
    }

    public Activity remove(String name){
        activity = search(name);
        if (activity != null) {
            activityvue.displayinfo(activity);
            if (activityvue.getdeleteconfirmation() == true){
                activitymodele.getDt().list.remove(activity);
                io.SaveDataActivity(activitymodele.getDt());
            }
        }
        else {
            System.out.println(name + " pas trouvé !");
            activity = null;
        }
        return activity;
    }

    public void lister() {
        System.out.println("Nom de l'activité, Type d'activité, Date de début, Date de fin");

        for (Activity a : activitymodele.getDt().list){
            System.out.println(a.name + ", " + a.type + ", " + a.start + ", " + a.end);
        }
    }

    private Activity search(String name){
        Activity rt;

        rt = null;
        for (Activity a : activitymodele.getDt().list){
            if(a.name.equals(name)){
                rt = a;
                break;
            }
        }
        return rt;
    }

    public void setModele(ActivityModele type){this.activitymodele = type;}

    public void setIO(IOData io) {this.io = io;}

    public void setVue(ActivityVue activityvue){this.activityvue = activityvue;}
}
