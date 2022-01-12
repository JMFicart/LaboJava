package be.technifutur.gestioninscriptions;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Map;

public class ActivityControler {
    ActivityVue activityvue;
    ActivityModele activitymodele;
    IOData io;
    Activity activity;

    public Activity addnew(String name, ActivityType type, LocalDateTime start, LocalDateTime end){
        if (search(name) == null) {
            activity = new Activity(name, type, start, end);
            activitymodele.getDt().list.put(activity.name, activity);
            io.SaveDataActivity(activitymodele.getDt());
        }
        else {
            activityvue.displaymessage(ListeMessage.Msg001, name);
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
            activityvue.displaymessage(ListeMessage.Msg001, name);
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
            activityvue.displaymessage(ListeMessage.Msg002, name);
            activity = null;
        }
        return activity;
    }

    public void lister() {
        ActivityType activitytype;

        System.out.println(ListeMessage.Msg009.getMsg());
        for (Map.Entry s : activitymodele.getDt().list.entrySet()){
            activity = (Activity) s.getValue();
            activitytype = activity.type;
            System.out.println(activity.name + " " + activitytype.name + " " + activitytype.registration + " " +
                    convertDate(activity.start) + " " + convertTime(activity.start) + " " +
                    convertDate(activity.end) + " " + convertTime(activity.end));
        }
    }

    private static String convertDate(LocalDateTime e){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(java.sql.Timestamp.valueOf(e));
    }

    private static String convertTime(LocalDateTime e){
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleTimeFormat.format(java.sql.Timestamp.valueOf(e));
    }

    private Activity search(String name){
        Activity rt;

        rt = null;
        if (activitymodele.getDt().list.containsKey(name)){
            rt = activitymodele.getDt().list.get(name);
        }

        return rt;
    }

    public void setModele(ActivityModele type){this.activitymodele = type;}

    public void setIO(IOData io) {this.io = io;}

    public void setVue(ActivityVue activityvue){this.activityvue = activityvue;}
}
