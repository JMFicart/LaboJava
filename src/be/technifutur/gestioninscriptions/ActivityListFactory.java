package be.technifutur.gestioninscriptions;

public class ActivityListFactory {
    IOData io;
    DataActivityType dt;

    public ActivityListFactory(){
        if(io == null){
            io = new IOData();
            dt = io.LoadDataActivityType();
        }
    }

    public DataActivityType getDt() {
        return dt;
    }
}
