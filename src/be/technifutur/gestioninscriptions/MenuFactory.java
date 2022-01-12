package be.technifutur.gestioninscriptions;

import java.util.concurrent.Callable;

public class MenuFactory {
    ActivityListControler alc;
    ActivityListFactory alf;
    ListActivityType lat;
//    ListActivityType lfa;
    ListActivityVue lav;
    GetActivityType gat;
    IOData io;
    ActivityTypeCreation atc;
    RemoveActivityType rat;

    ActivityControler activitycontroler;
    ActivityCreation activitycreation;
    ActivityModele activitymodele;
    ActivityRemove activityremove;
    ActivityUpdate activityupdate;
    ActivityVue activityvue;

    MenuFactory(){
        if (alc == null){
            alc = new ActivityListControler();
            lat = new ListActivityType();
            lav = new ListActivityVue();
            io = new IOData();
            gat = new GetActivityType();
            atc = new ActivityTypeCreation();
            rat = new RemoveActivityType();
            alf = new ActivityListFactory();

            alc.setModele(alf);
            alc.setIO(io);
            alc.setVue(lav);
            atc.setVue(lav);
            atc.setControler(alc);
            gat.setVue(lav);
            gat.setModele(alc);
            lat.setControler(alc);
            rat.setControler(alc);
            rat.setVue(lav);
            io.setModele(alf);
        }

        if (activitycontroler == null){
            activitycontroler = new ActivityControler();
            activitycreation = new ActivityCreation();
            activitymodele = new ActivityModele();
            activityremove = new ActivityRemove();
            activityupdate = new ActivityUpdate();
            activityvue = new ActivityVue();

            activitycontroler.setModele(activitymodele);
            activitycontroler.setVue(activityvue);
            activitycontroler.setIO(io);
            activitycreation.setControler(activitycontroler);
            activitycreation.setVue(activityvue);
            activityupdate.setControler(activitycontroler);
            activityupdate.setVue(activityvue);
        }
    }

    private Item createItem(String itemname, Callable itemaction, Callable itemparent) {
        Item wItem;

        wItem = new Item();
        wItem.setName(itemname);
        wItem.setAction(itemaction);
        wItem.setActionParent(itemparent);
        return wItem;
    }

    public MenuControler getMenu() {
        return CreateMenu(getModelPrincipal());
    }

    private MenuControler CreateMenu(MenuModel model) {
        MenuControler menu = new MenuControler();
        menu.setVue(new MenuVue());
        menu.setModel(model);
        return menu;
    }

    private MenuModel getModelPrincipal(){
        MenuModel model = new MenuModel(ListeMessage.Msg017.getMsg());
        MenuNode sousmenu = CreateMenu(getModelActivity());
        model.addNode(sousmenu);
        sousmenu = CreateMenu(getModelHoraire());
        model.addNode(sousmenu);
        model.addNode(getItemQuitter());
        return model;
    }

    private MenuModel getModelActivity(){
        MenuModel model1 = new MenuModel(ListeMessage.Msg018.getMsg());
        model1.addNode(addItemActivityList());
        model1.addNode(getItemActivityList());
        model1.addNode(removeItemActivityList());
        model1.addNode(listFileActivity());
        model1.addNode(getItemQuitterActivity());
        return model1;
    }

    private MenuModel getModelHoraire(){
        MenuModel model1 = new MenuModel(ListeMessage.Msg019.getMsg());
        model1.addNode(addItemHoraire());
        model1.addNode(updateItemHoraire());
        model1.addNode(removeItemHoraire());
        model1.addNode(getItemQuitterHoraire());
        return model1;
    }

    private Item getItemQuitter() {
        return createItem(ListeMessage.Msg020.getMsg(), null, null );
    }

    public Item addItemActivityList() {
        return createItem(ListeMessage.Msg021.getMsg(), atc, null);
    }

    public Item getItemActivityList() {
        return createItem(ListeMessage.Msg022.getMsg(), gat, null);
    }

    public Item removeItemActivityList() {
        return createItem(ListeMessage.Msg023.getMsg(), rat, null);
    }

    public Item listFileActivity() {
        return createItem(ListeMessage.Msg024.getMsg(), lat, null);
    }

    private Item getItemQuitterActivity() {return createItem(ListeMessage.Msg020.getMsg(), null, null);    }

    public Item addItemHoraire() {
        return createItem(ListeMessage.Msg025.getMsg(), activitycreation, null);
    }

    public Item updateItemHoraire() {
        return createItem(ListeMessage.Msg026.getMsg(), activityupdate, null);
    }

    public Item removeItemHoraire() {
        return createItem(ListeMessage.Msg027.getMsg(), activityremove, null);
    }

    private Item getItemQuitterHoraire() {
        return createItem(ListeMessage.Msg020.getMsg(), null, null );
    }
}
