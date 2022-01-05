package be.technifutur.gestioninscriptions;

public class ActivityListControler {
    ListActivityVue lav;
    ActivityListFactory alf;
    IOData io;
    ActivityType activitytype;

    public ActivityType addnew(String name, boolean registrationRequired){
        if (search(name) == null) {
            activitytype = new ActivityType(name, registrationRequired);
            alf.getDt().list.add(activitytype);
            io.SaveData(alf.getDt());
        }
        else {
            System.out.println(name + " existe déjà !");
            activitytype = null;
        }
        return activitytype;
    }

    public ActivityType afficher(String name){
        activitytype = search(name);
        if (activitytype != null) {
            lav.displayinfo(activitytype);
        }
        else {
            lav.displaymessagenotfound(name);
            activitytype = null;
        }
        return activitytype;
    }

    public ActivityType remove(String name){
        activitytype = search(name);
        if (activitytype != null) {
            lav.displayinfo(activitytype);
            if (lav.getdeleteconfirmation() == true){
                alf.getDt().list.remove(activitytype);
                io.SaveData(alf.getDt());
            }
        }
        else {
            System.out.println(name + " pas trouvé !");
            activitytype = null;
        }
        return activitytype;
    }

    public void lister() {
        System.out.println("Type d'activité, Registration");

        for (ActivityType a : alf.getDt().list){
            System.out.println(a.name + ", " + a.registration);
        }
    }

    private ActivityType search(String name){
        ActivityType rt;

        rt = null;
        for (ActivityType a : alf.getDt().list){
            if(a.name.equals(name)){
                rt = a;
                break;
            }
        }
        return rt;
    }

    public void setModele(ActivityListFactory type){this.alf = type;}

    public void setIO(IOData io) {this.io = io;}

    public void setVue(ListActivityVue lav){this.lav = lav;}
}
