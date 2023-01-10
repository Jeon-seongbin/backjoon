package com.acmicpc.season1.company3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int step = Integer.parseInt(br.readLine());
        int inputSeishainCount = Integer.parseInt(br.readLine());
        Auth auth = new Auth();
        for (int i = 0; i < inputSeishainCount; i++) {
            String inputSeishain = br.readLine();
            auth.issueId(inputSeishain);
        }
        for (int i = 0; i < inputSeishainCount; i++) {
            String inputShori = br.readLine();
            String[] inputShoriArray = inputShori.split(" ");

            if(inputShoriArray[0].equals("enter")){
                if(step == 1){
                    auth.enter("","",inputShoriArray[3]);
                }else{
                    auth.enter(inputShoriArray[1],inputShoriArray[2],inputShoriArray[3]);
                }

            }else if(inputShoriArray[0].equals("disabled")){
                if(step == 1){
                    auth.disable(inputShoriArray[3]);
                }else{
                    auth.disable(inputShoriArray[1],inputShoriArray[2],inputShoriArray[3]);
                }
            }

        }

    }
}


class Auth {
    Auth() {
        this.isSeishainIdIssued = new HashMap<>();
//        this.isGuestIssued = new HashMap<>();
        this.guestIssuedWithTime = new HashMap<>();
    }

    private final HashMap<String, Boolean> isSeishainIdIssued;
    //    private final HashMap<String, Boolean> isGuestIssued;
    private final HashMap<String, ArrayList<String>> guestIssuedWithTime;

    public void issueId(String id) {
        this.isSeishainIdIssued.put(id, true);


    }

    public void issueId(String id, String date1, String time1, String date2, String time2) {
        ArrayList<String> guestInfo = new ArrayList<>();
        guestInfo.add(date1);
        guestInfo.add(time1);
        guestInfo.add(date2);
        guestInfo.add(time2);
        guestIssuedWithTime.put(id, guestInfo);
        System.out.println("successfully issued");
    }

    public void disable(String id) {
        if (id.length() == 10) {
            if (isSeishainIdIssued.containsKey(id)) {
                isSeishainIdIssued.put(id, false);
            }
        }


    }

    public void disable(String date, String time ,String id){
        ArrayList<String> disableTime = new ArrayList<>();
        disableTime.add(date);
        disableTime.add(time);
        guestIssuedWithTime.put(id, disableTime);
    }


    public void enter(String date, String time, String id) {
        if (id.length() == 10) {
            if (isSeishainIdIssued.containsKey(id)) {
                System.out.println("can");
            } else {
                System.out.println("cannot");
            }
            return;
        }


        if (guestIssuedWithTime.containsKey(id)) {

            ArrayList<String> guestInfo = guestIssuedWithTime.get(id);

            String[] dateArray = date.split("/");
            String[] timeArray = time.split(":");

            Date nowDate = new Date(
                    Integer.parseInt(dateArray[0]),
                    Integer.parseInt(dateArray[1]),
                    Integer.parseInt(dateArray[2]),
                    Integer.parseInt(timeArray[0]),
                    Integer.parseInt(timeArray[1]),
                    Integer.parseInt(timeArray[2]));


            Date userDate = new Date(
                    Integer.parseInt(guestInfo.get(0)),
                    Integer.parseInt(guestInfo.get(1)),
                    Integer.parseInt(guestInfo.get(2)),
                    Integer.parseInt(guestInfo.get(3)),
                    Integer.parseInt(guestInfo.get(4)),
                    Integer.parseInt(guestInfo.get(5)));


            if (nowDate.after(userDate) || nowDate.before(userDate)) {
                System.out.println("not applicable now");
            } else {
                System.out.println("can");
            }


        } else {
            System.out.println("unissued id");
        }


    }
}