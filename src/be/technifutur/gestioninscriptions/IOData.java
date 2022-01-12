package be.technifutur.gestioninscriptions;

import java.util.ArrayList;

public class IOData {
//    DataStore<MyData> myDataDataStore = new DataStore<>("Activity.txt", MyData::new);
    DataStore <DataActivityType> dsActivityType;
    DataStore<DataActivity> dsActivity;
    DataActivityType dt;
    DataActivity dataactivity;
    ActivityListFactory alf;

    public DataActivityType LoadDataActivityType(){
//        DataStore<MyData> myDataDataStore = new DataStore<>("ActivityType.txt", MyData::new);
        dsActivityType = new DataStore<>("ActivityType.txt", DataActivityType::new);

        dt= dsActivityType.getData();
        return dt;
    }

    public DataActivity LoadDataActivity(){
//        DataStore<DataActivity> dsActicity = new DataStore<>("Activity.txt", DataActivity::new);
        dsActivity = new DataStore<>("Activity.txt", DataActivity::new);

        dataactivity= dsActivity.getData();
        return dataactivity;
    }

    public void SaveDataActivityType(DataActivityType l){
//        dt = new MyData();
        //DataStore<MyData> myDataDataStore = new DataStore<>("ActivityType.txt", MyData::new);
        dsActivityType = new DataStore<>("ActivityType.txt", DataActivityType::new);
        dsActivityType.save1(l);
    }

    public void SaveDataActivity(DataActivity l){
//        dt = new MyData();
        //DataStore<MyData> myDataDataStore = new DataStore<>("Activity.txt", MyData::new);
        dsActivity.save();
    }

    public void setModele(ActivityListFactory type){this.alf = type;}
}
