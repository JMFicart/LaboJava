package be.technifutur.gestioninscriptions;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Item implements MenuNode {
    private String itemname;
    private Callable itemparent;
    private Callable itemaction;
    private ArrayList<Item> itemList = new ArrayList<>();

    @Override
    public String getName() {
        return itemname;
    }

    @Override
    public Callable getAction() {
        return itemaction;
    }

    public void setName(String iName) {
        itemname = iName;
    }

    public void setAction(Callable action) {
        itemaction = action;
    }

    public Callable getActionParent() {
        return itemparent;
    }

    public void setActionParent(Callable action) {
        itemparent = action;
    }
}
