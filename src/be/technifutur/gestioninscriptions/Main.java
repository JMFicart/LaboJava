package be.technifutur.gestioninscriptions;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {
        MenuFactory menufactory = new MenuFactory();
//        IOData io = new IOData();
        boolean flag = true;
        Callable action;

//        Callable action = menu.getAction();
//        while(action != null){
//            action.call();
//            action = menu.getAction();
//        }

        while (flag) {
            action = menufactory.getMenu().getAction();
            if (action != null) {
                action.call();
            }
            else
            {
                flag = false;
            }
        }
    }
}
