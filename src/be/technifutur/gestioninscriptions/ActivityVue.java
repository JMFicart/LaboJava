package be.technifutur.gestioninscriptions;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ActivityVue {
    static Scanner es = new Scanner(System.in);

    public static String getname(){
        System.out.print(ListeMessage.Msg005);
        return es.nextLine();
    }

    public static ActivityType gettype(){
        ActivityType type;
        String activityname;

        System.out.println(ListeMessage.Msg012);
        activityname = es.nextLine();
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

    public void displayinfo(Activity activity){
        System.out.println(ListeMessage.Msg011.getMsg() + activity.name);
        System.out.println(ListeMessage.Msg012.getMsg() + activity.type);
        System.out.println(ListeMessage.Msg013.getMsg() + activity.start);
        System.out.println(ListeMessage.Msg014.getMsg() + activity.end);
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

        System.out.print(ListeMessage.Msg003);
        yn = sc.nextLine().toUpperCase();
        if(yn.matches("(Y|N)")) {
            if (yn.equals("Y"))
                response = true;
            else
                response = false;
        }
        else
            System.out.println(ListeMessage.Msg004);

        return response;
    }
}
