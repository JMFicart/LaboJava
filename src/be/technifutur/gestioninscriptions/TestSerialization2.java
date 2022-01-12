package be.technifutur.gestioninscriptions;

import java.sql.Time;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Map;

//enum Level {
//    LOW,
//    MEDIUM,
//    HIGH
//}

public class TestSerialization2 {
    public static void main(String[] args) {
        DataStore<DataActivity1> myDataDataStore1 = new DataStore<>("activity.txt", DataActivity1::new);
        Integer ds;
        ActivityType activitytype;
        Activity activity;

        DataActivity1 dataactivity = myDataDataStore1.getData();

        ds = dataactivity.list.size();
        System.out.println("Taille = " + ds);
        for (Integer i = ds; i < (ds + 10); i++) {
            activitytype = new ActivityType("Test" + i, true);
            activity = new Activity("ABCD" + i, activitytype, LocalDateTime.now(), LocalDateTime.now());
            System.out.println(i + " " + activity.name + " " + activitytype.name + " " + activitytype.registration + " " + activity.start + " " + activity.end);
            dataactivity.list.put(activity.name, activity);
        }

        myDataDataStore1.save();

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
//
//        System.out.println("");
//        System.out.println("Données présentes");
//        for (Map.Entry s : dataactivity.list.entrySet()){
//            activity = (Activity) s.getValue();
//            activitytype = activity.type;
//            System.out.println(activity.name + " " + activitytype.name + " " + activitytype.registration + " " +
//                    convertDate(activity.start) + " " + convertTime(activity.start) + " " +
//                    convertDate(activity.end) + " " + convertTime(activity.end));
//        }
    }

    private static String convertDate(LocalDateTime e){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(java.sql.Timestamp.valueOf(e));
    }

    private static String convertTime(LocalDateTime e){
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleTimeFormat.format(java.sql.Timestamp.valueOf(e));
    }
}