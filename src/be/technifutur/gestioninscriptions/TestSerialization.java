package be.technifutur.gestioninscriptions;

public class TestSerialization {
    public static void main(String[] args) {
        DataStore<MyData> myDataDataStore = new DataStore<>("testdata.txt", MyData::new);
        Integer ds;
        ActivityType d;
        Activity e;

        MyData dt= myDataDataStore.getData();

        ds = dt.list.size();
        for(Integer i = ds; i < (ds + 10); i++){
            d = new ActivityType("Test" + i, true);
            System.out.println(i + " " + d.name + " " + d.registration);
            dt.list.add(d);
        }

//        dt.list.remove(5);
        myDataDataStore.save();

        System.out.println("");
        System.out.println("Données présentes");
        for (ActivityType s : dt.list){
            System.out.println(s.name + " " + s.registration);
        }
    }
}
