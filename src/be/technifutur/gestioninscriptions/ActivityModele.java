package be.technifutur.gestioninscriptions;

public class ActivityModele {
    IOData io;
    DataActivity dt;

    public ActivityModele(){
        if(io == null){
            io = new IOData();
            dt = io.LoadDataActivity();
        }
    }

    public DataActivity getDt() {
        return dt;
    }
}
