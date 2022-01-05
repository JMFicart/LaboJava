package be.technifutur.gestioninscriptions;

import java.util.Scanner;

public class MenuVue {
    private Scanner input = new Scanner(System.in);
    private String error = null;

    public void setError(String message){
        this.error = message;
    }

    public String saisirMenu(MenuModel model) {
        String choix;

        System.out.println(model.name);
        System.out.println("-".repeat(model.name.length()));
        for (int i = 0 ; i < model.size(); i++) {
            System.out.println((i + 1) + " " + model.getNode(i).getName());
        }
        if (this.error != null) {
            System.out.printf("Error : %s\n", error);
        }
        System.out.print("Choix : ");
        choix = input.nextLine();
        return choix;
    }
}
