package be.technifutur.gestioninscriptions;

import java.util.Scanner;

public class ListActivityVue {
    static Scanner es = new Scanner(System.in);

    public static String getname(){
        System.out.print("Saisir le nom de l'activité = ");
        return es.nextLine();
    }

    public static Boolean getregistration(){
        Boolean rv ;
        String reponse = "";

        System.out.print("Saisir la nécessité d'une registration (Y/N) = ");
        reponse = es.nextLine().toUpperCase();
        if (reponse.equals("Y")) {
            rv = true;
        }
        else {
            rv = false;
        }
        return rv;
    }

    public void displayinfo(ActivityType at){
        System.out.println("Type d'activité = " + at.name);
        System.out.println("Registration    = " + at.registration);
        System.out.println("");
    }

    public void displaymessagenotfound(String name){
        System.out.println(name + " pas trouvé !");
        System.out.println("");
    }

    public boolean getdeleteconfirmation(){
        Boolean response = false;
        String yn;
        Scanner sc = new Scanner(System.in);

        System.out.print("Confirmez-vous la suppression de cet enregistrement ? (Y/N) ");
        yn = sc.nextLine();
        if(yn.matches("(y|Y|n|N)")) {
            if (yn.toUpperCase().equals("Y"))
                response = true;
            else
                response = false;
        }
        else
            System.out.println("Ce n'est pas une option");

        return response;
    }
}
