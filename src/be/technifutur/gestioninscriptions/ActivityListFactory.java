package be.technifutur.gestioninscriptions;

public class ActivityListFactory {
    IOData io;
    MyData dt;

    public ActivityListFactory(){
        if(io == null){
            io = new IOData();
            dt = io.LoadData();
        }
    }

    public MyData getDt() {
        return dt;
    }
}
