package be.technifutur.gestioninscriptions;

import java.util.ArrayList;

public class IOData {
//    DataStore<MyData> myDataDataStore = new DataStore<>("Activity.txt", MyData::new);
    MyData dt;
    DataActivity dataactivity;
    ActivityListFactory alf;

    public MyData LoadData(){
        DataStore<MyData> myDataDataStore = new DataStore<>("ActivityType.txt", MyData::new);

        dt= myDataDataStore.getData();
        return dt;
    }

    public DataActivity LoadDataActivity(){
        DataStore<DataActivity> myDataDataStore = new DataStore<>("Activity.txt", DataActivity::new);

        dataactivity= myDataDataStore.getData();
        return dataactivity;
    }

    public void SaveData(MyData l){
//        dt = new MyData();
        DataStore<MyData> myDataDataStore = new DataStore<>("ActivityType.txt", MyData::new);
    }

    public void SaveDataActivity(DataActivity l){
//        dt = new MyData();
        DataStore<MyData> myDataDataStore = new DataStore<>("Activity.txt", MyData::new);
    }

    public void setModele(ActivityListFactory type){this.alf = type;}
}
