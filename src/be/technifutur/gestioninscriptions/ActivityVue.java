package be.technifutur.gestioninscriptions;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ActivityVue {
    static Scanner es = new Scanner(System.in);

    public static String getname(){
        System.out.print("Saisir le nom de l'activité = ");
        return es.nextLine();
    }

    public static ActivityType gettype(){
        ActivityType type;

        type = new ActivityType("Test1", true);
        return type;
    }

    public static LocalDateTime getstart(){
        LocalDateTime dtstart;
        dtstart = LocalDateTime.now();
        return dtstart;
    }

    public static LocalDateTime getend(){
        LocalDateTime dtend;
        dtend = LocalDateTime.now();
        return dtend;
    }

    public void displayinfo(Activity at){
        System.out.println("Nom de l'activité = " + at.name);
        System.out.println("Type d'activité   = " + at.type);
        System.out.println("Date de début     = " + at.start);
        System.out.println("Date de fin       = " + at.end);
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
