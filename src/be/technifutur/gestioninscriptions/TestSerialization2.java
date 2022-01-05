package be.technifutur.gestioninscriptions;

import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSerialization2 {
    public static void main(String[] args) {
        DataStore<DataActivity> myDataDataStore1 = new DataStore<>("activity.txt", DataActivity::new);
        Integer ds;
        ActivityType d;
        Activity e;

        DataActivity da= myDataDataStore1.getData();

//        ds = da.list.size();
//        for(Integer i = ds; i < (ds + 5); i++){
//            d = new ActivityType("Test" + i, true);
//            e = new Activity("ABCD" + i, d, LocalDateTime.now(), LocalDateTime.now());
//            System.out.println(i + " " + e.name + " " + d.name + " " + d.registration + " " + e.start + " " + e.end);
//            da.list.add(e);
//        }
//
//        myDataDataStore1.save();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateStr = simpleDateFormat.format(LocalDateTime.now().toLocalDate());
        System.out.println(dateStr);

//        System.out.println("");
//        System.out.println("Données présentes");
//        for (Activity s : da.list){
//            d = s.type;
//            System.out.println(s.name + " " + d.name + " " + d.registration + " " + simpleDateFormat.format(s.start) + " " + simpleDateFormat.format(s.end));
//        }
    }
}
