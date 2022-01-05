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

        vue.setError(null);
        do {
            String reponse = vue.saisirMenu(model);
            try {
                choix = Integer.parseInt(reponse) - 1;
                if (choix >= 0 && choix < model.size()) {
                    saisieok = true;
                    MenuNode menuNode = model.getNode(choix);
                    result = menuNode.getAction();
                }
                else {
                    vue.setError("Il n'y a pas d'option = " + (choix + 1));
                }
            } catch(NumberFormatException e)
            {
                vue.setError(reponse + " n'est pas numérique !");
            }
        } while (saisieok == false);
        vue.setError(null);
        return result;
    }
}
