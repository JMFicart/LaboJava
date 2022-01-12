package be.technifutur.gestioninscriptions;

import java.util.concurrent.Callable;

public class MenuFactory {
    ActivityListControler activitylistcontroler;
    ActivityListModele acticitylistmodele;
    ListActivityType listactivitytype;
    ListActivityVue listactivityvue;
    GetActivityType getactivitytype;
    IOData io;
    ActivityTypeCreation activitytypecreation;
    RemoveActivityType removeactivitytypt;

    ActivityControler activitycontroler;
    ActivityCreation activitycreation;
    ActivityModele activitymodele;
    ActivityRemove activityremove;
    ActivityUpdate activityupdate;
    ActivityVue activityvue;
    ActivityFileList activityfilelist;

    MenuFactory(){
        if (activitylistcontroler == null){
            activitylistcontroler = new ActivityListControler();
            listactivitytype = new ListActivityType();
            listactivityvue = new ListActivityVue();
            io = new IOData();
            getactivitytype = new GetActivityType();
            activitytypecreation = new ActivityTypeCreation();
            removeactivitytypt = new RemoveActivityType();
            acticitylistmodele = new ActivityListModele();

            activitylistcontroler.setModele(acticitylistmodele);
            activitylistcontroler.setIO(io);
            activitylistcontroler.setVue(listactivityvue);
            activitytypecreation.setVue(listactivityvue);
            activitytypecreation.setControler(activitylistcontroler);
            getactivitytype.setVue(listactivityvue);
            getactivitytype.setModele(activitylistcontroler);
            listactivitytype.setControler(activitylistcontroler);
            removeactivitytypt.setControler(activitylistcontroler);
            removeactivitytypt.setVue(listactivityvue);
            io.setModele(acticitylistmodele);
        }

        if (activitycontroler == null){
            activitycontroler = new ActivityControler();
            activitycreation = new ActivityCreation();
            activitymodele = new ActivityModele();
            activityremove = new ActivityRemove();
            activityupdate = new ActivityUpdate();
            activityvue = new ActivityVue();
            activityfilelist = new ActivityFileList();

            activitycontroler.setModele(activitymodele);
            activitycontroler.setVue(activityvue);
            activitycontroler.setIO(io);
            activitycontroler.setActivityTypeModele(acticitylistmodele);
            activitycreation.setControler(activitycontroler);
            activitycreation.setVue(activityvue);
            activityupdate.setControler(activitycontroler);
            activityupdate.setVue(activityvue);
            activityfilelist.setControler(activitycontroler);
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
        model1.addNode(addItemActivityType());
        model1.addNode(getItemActivityType());
        model1.addNode(removeItemActivityType());
        model1.addNode(listFileActivityType());
        model1.addNode(getItemQuitterActivityType());
        return model1;
    }

    private MenuModel getModelHoraire(){
        MenuModel model1 = new MenuModel(ListeMessage.Msg019.getMsg());
        model1.addNode(addItemHoraire());
        model1.addNode(updateItemHoraire());
        model1.addNode(removeItemHoraire());
        model1.addNode(listfileActivity());
        model1.addNode(getItemQuitterHoraire());
        return model1;
    }

    private Item getItemQuitter() {
        return createItem(ListeMessage.Msg020.getMsg(), null, null );
    }

    public Item addItemActivityType() {
        return createItem(ListeMessage.Msg021.getMsg(), activitytypecreation, null);
    }

    public Item getItemActivityType() {
        return createItem(ListeMessage.Msg022.getMsg(), getactivitytype, null);
    }

    public Item removeItemActivityType() {
        return createItem(ListeMessage.Msg023.getMsg(), removeactivitytypt, null);
    }

    public Item listFileActivityType() {
        return createItem(ListeMessage.Msg024.getMsg(), listactivitytype, null);
    }

    private Item getItemQuitterActivityType() {return createItem(ListeMessage.Msg020.getMsg(), null, null);    }

    public Item addItemHoraire() {
        return createItem(ListeMessage.Msg025.getMsg(), activitycreation, null);
    }

    public Item updateItemHoraire() {
        return createItem(ListeMessage.Msg026.getMsg(), activityupdate, null);
    }

    public Item removeItemHoraire() {
        return createItem(ListeMessage.Msg027.getMsg(), activityremove, null);
    }

    public Item listfileActivity() {
        return createItem(ListeMessage.Msg029.getMsg(), activityfilelist, null);
    }

    private Item getItemQuitterHoraire() {
        return createItem(ListeMessage.Msg020.getMsg(), null, null );
    }
}
