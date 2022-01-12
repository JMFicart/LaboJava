package be.technifutur.gestioninscriptions;

import java.util.Map;

public class TestSerialization {
    public static void main(String[] args) {
        DataStore<DataActivityType> myDataDataStore = new DataStore<>("activitytype.txt", DataActivityType::new);
        Integer ds;
        ActivityType d;
        Activity e;

        DataActivityType dt= myDataDataStore.getData();

        ds = dt.list.size();
        for(Integer i = ds; i < (ds + 10); i++){
            d = new ActivityType("Test" + i, true);
            System.out.println(i + " " + d.name + " " + d.registration);
            dt.list.put(d.name,d);
        }

//        dt.list.remove(5);
        myDataDataStore.save();

        System.out.println("");
        System.out.println("Données présentes");
        for (Map.Entry s : dt.list.entrySet()){
            d = (ActivityType) s.getValue();
            System.out.println(d.name + " " + d.registration);
        }
    }
}
