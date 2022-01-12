package be.technifutur.gestioninscriptions;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ActivityVue {
    static Scanner es = new Scanner(System.in);

    public static String getname(){
        System.out.print(ListeMessage.Msg032.getMsg());
        return es.nextLine();
    }

    public static String gettype(){
        String name;

        System.out.print(ListeMessage.Msg012.getMsg());
        name = es.nextLine();
        return name;
    }

    public static LocalDateTime getstart(){
        String dtstart;
        LocalDateTime rt = null;

        System.out.print(ListeMessage.Msg034.getMsg());
        dtstart = es.nextLine();
//        if(dtstart.matches("([1-2][0-9]?|3[01]?|[4-9])\\/(1[0-2]?|[2-9])\\/([1-9]\\d{3})\\ ([0-1][0-9]|2[0-3]):([0-5][0-9])")) {
        if(dtstart.matches("([1-2][0-9]?|3[01]?|[4-9])\\/(1[0-2]?|0[1-9])\\/([1-9]\\d{3})")) {
//            rt = (LocalDateTime) dtstart;
            System.out.println("t3");
            rt = null;
        }
        else
            System.out.println(ListeMessage.Msg035.getMsg());
        return rt;
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
            if (yn.equals("Y")) {response = true;};
        }
        else
            System.out.println(ListeMessage.Msg004);

        return response;
    }
}
