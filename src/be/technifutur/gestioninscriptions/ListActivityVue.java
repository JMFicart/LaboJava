package be.technifutur.gestioninscriptions;

import java.util.Scanner;

public class ListActivityVue {
    static Scanner es = new Scanner(System.in);

    public static String getname(){
        System.out.print(ListeMessage.Msg005.getMsg());
        return es.nextLine();
    }

    public static Boolean getregistration(){
        Boolean rv ;
        String reponse = "";

        do {
            System.out.print(ListeMessage.Msg006.getMsg());
            reponse = es.nextLine().toUpperCase();
        }
        while (!reponse.matches("(Y|N)"));

        if (reponse.equals("Y")) {
            rv = true;
        } else {
            rv = false;
        }
        return rv;
    }

    public void displayinfo(ActivityType at){
        System.out.println(ListeMessage.Msg007.getMsg() + at.name);
        System.out.println(ListeMessage.Msg008.getMsg() + at.registration);
        System.out.println("");
    }

    public void displaymessage(ListeMessage msg,String name){
        String msgtodisplay;

        if (name.equals("")){
            msgtodisplay = msg.getMsg();
        }
        else {
            msgtodisplay = name + " " + msg.getMsg();
        }
        System.out.println(msgtodisplay);
        System.out.println("");
    }

public boolean getdeleteconfirmation(){
        Boolean response = false;
        String yn;
        Scanner sc = new Scanner(System.in);

        System.out.print(ListeMessage.Msg003.getMsg());
        yn = sc.nextLine();
        if(yn.matches("(y|Y|n|N)")) {
            if (yn.toUpperCase().equals("Y"))
                response = true;
            else
                response = false;
        }
        else
            System.out.println(ListeMessage.Msg004.getMsg());

        return response;
    }
}
