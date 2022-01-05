package be.technifutur.gestioninscriptions;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Item implements MenuNode {
    private String itemname;
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
}
