package be.technifutur.gestioninscriptions;

import java.util.concurrent.Callable;

public class MenuControler implements MenuNode{
    private MenuModel model;
    private MenuVue vue;

    public void setModel(MenuModel model){
        this.model = model;
    }

    public void setVue(MenuVue vue) {
        this.vue = vue;
    }

    @Override
    public String getName() {
        return model.getName();
    }

    @Override
    public Callable getAction() {
        Callable result = null;
        int choix = 0;
        boolean saisieok = false;

//        Callable action = menu.getAction();
//        while(action != null){
//            action.call();
//            action = menu.getAction();
//        }

        vue.setError(null);
        do {
            String reponse = vue.saisirMenu(model);
            try {
                choix = Integer.parseInt(reponse) - 1;
                if (choix >= 0 && choix < model.size()) {
                    saisieok = true;
                    MenuNode menuNode = model.getNode(choix);
                    result = menuNode.getAction();
//                    if(result==null){
//                        if (model.name.equals("Menu principal")){
//                            saisieok = false;
//                            model =
//                        }
//                    }
                }
                else {
                    vue.setError(ListeMessage.Msg015.getMsg() + (choix + 1));
                }
            } catch(NumberFormatException e)
            {
                vue.setError(reponse + ListeMessage.Msg016.getMsg());
            }
        } while (saisieok == false);
        vue.setError(null);
        return result;
    }
}
