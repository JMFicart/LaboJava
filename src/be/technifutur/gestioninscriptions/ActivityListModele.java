package be.technifutur.gestioninscriptions;

public class ActivityListModele {
    IOData io;
    DataActivityType dt;

    public ActivityListModele(){
        if(io == null){
            io = new IOData();
            dt = io.LoadDataActivityType();
        }
    }

    public DataActivityType getDt() {
        return dt;
    }
}
