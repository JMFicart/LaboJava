package be.technifutur.gestioninscriptions;

import java.util.Map;

public class ActivityListControler {
    ListActivityVue listactivityvue;
    ActivityListFactory activitylistfactory;
    IOData io;
    ActivityType activitytype;

    public ActivityType addnew(String name, boolean registrationRequired){
        if (search(name) == null) {
            activitytype = new ActivityType(name, registrationRequired);
            activitylistfactory.getDt().list.put(activitytype.name, activitytype);
            io.SaveDataActivityType(activitylistfactory.getDt());
        }
        else {
            listactivityvue.displaymessage(ListeMessage.Msg001, name);
            activitytype = null;
        }
        return activitytype;
    }

    public ActivityType afficher(String name){
        activitytype = search(name);
        if (activitytype != null) {
            listactivityvue.displayinfo(activitytype);
        }
        else {
            listactivityvue.displaymessage(ListeMessage.Msg002, name);
            activitytype = null;
        }
        return activitytype;
    }

    public ActivityType remove(String name){
        activitytype = search(name);
        if (activitytype != null) {
            listactivityvue.displayinfo(activitytype);
            if (listactivityvue.getdeleteconfirmation() == true){
                activitylistfactory.getDt().list.remove(name);
                io.SaveDataActivityType(activitylistfactory.getDt());
            }
        }
        else {
            listactivityvue.displaymessage(ListeMessage.Msg002, name);
            activitytype = null;
        }
        return activitytype;
    }

    public void lister() {
        ActivityType activityType;

        System.out.println(ListeMessage.Msg010.getMsg());
        for (Map.Entry s : activitylistfactory.getDt().list.entrySet()){
            activitytype = (ActivityType) s.getValue();
            System.out.println(activitytype.name + ", " + activitytype.registration);
        }
    }

    private ActivityType search(String name){
        ActivityType rt;

        rt = null;
        if (activitylistfactory.getDt().list.containsKey(name)){
            rt = activitylistfactory.getDt().list.get(name);
        }

        return rt;
    }

    public void setModele(ActivityListFactory type){this.activitylistfactory = type;}

    public void setIO(IOData io) {this.io = io;}

    public void setVue(ListActivityVue listactivityvue){this.listactivityvue = listactivityvue;}
}
