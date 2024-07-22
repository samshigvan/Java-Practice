package com.company.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    {
        System.out.println("init block called.");
    }

    static {
        System.out.println("static block called.");
    }

    public Main(String name) {
        System.out.println("Constructor called");
        this.name = name;
    }

    public Main() {

    }

    public static void main(String[] args) throws Exception {

//        checkThrowWithCatch
        Main m = new Main();
        System.out.println(m.checkThrowWithCatch());


//        Main m = new Main();
////        m.checkSwitch();
////        m.checkDateLongConvert();
//
//        String s = "abcd";
//        Object obj = new Object();
//
//        m.checkStringObj(s.getClass());
//        m.checkStringObj(m.getClass());

    }

    public void checkStringObj(Class<?> type) {

        if(type == Object.class) {
            System.out.println("is object..");
        } if (type == String.class) {
            System.out.println("is String..");
        }
    }

    public void checkSwitch(){
        String s1= "abc";

        switch (s1){
            case "pqrs":
                System.out.println("pqrs");
            case "abc":
                if (s1.equals("abc")) {
                    System.out.println("abc");
                    break;
                }
            default:
                System.out.println("default");
        }
    }

    public void checkDateLongConvert() {


        try {
            String endDateString = "Tue Mar 14 07:22:06 UTC 2023";
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            Date endDate = null;
            endDate = sdf.parse(endDateString);
            long  endMilis = endDate.getTime();

            Long startMilis = new Long("1678778462079");
            Date startDate = new Date(startMilis);

            System.out.println(" start time:" + sdf.format(startDate));
            System.out.println(" End time  :" + sdf.format(endDate));


            Long currentDateMilis = System.currentTimeMillis();
            Date currentDateTime = new Date(currentDateMilis);

            Long halfHourBefore = currentDateMilis - TimeUnit.MINUTES.toMillis(30);
            Date halfHourBeforeDateTime = new Date(halfHourBefore);

            System.out.println(" current date time: "+ sdf.format(currentDateTime));
            System.out.println(" halfHrBefore date time: " + sdf.format(halfHourBeforeDateTime));

            System.out.println(" current minute is: "+ currentDateTime.getMinutes());
            long sec = TimeUnit.HOURS.toMillis(currentDateTime.getHours()) + TimeUnit.MINUTES.toMillis(currentDateTime.getMinutes()) + TimeUnit.SECONDS.toMillis(currentDateTime.getSeconds());
            System.out.println(" current time is: " + sec );

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String checkThrowWithCatch() throws Exception {
        try {
            System.out.println("In try block");
            throw new Exception();
        } catch (Exception ex) {
            System.out.println("In catch block");
            throw new Exception();
        } finally {
            System.out.println("In finally block");
            return "return from finally";
        }
    }

}
