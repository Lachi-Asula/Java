package com.friends.utils;


import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterUtils {
    public static int DIVIDER = 10000;
    public static int LENGTH = ((DIVIDER + "").length() - 1);
    public static String FORMAT = "%0" + LENGTH + "d";

    public static String trimStr(String value){
        if(StringUtils.isNotBlank(value)){
            return value.trim();
        }else {
            return "";
        }
    }

    public static String getStackTrace(Throwable e) {
        String stackTrace = null;
        try {
            java.io.StringWriter sw = new java.io.StringWriter();
            java.io.PrintWriter pw = new java.io.PrintWriter(sw);
            e.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch(Exception ex) {
            // ignore
        }
        return stackTrace;
    }

    public static String getTimeStamp(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a").format(LocalDateTime.now());
    }

    public static String getTimeStamp1(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a z");
        return simpleDateFormat.format(new Date());
    }

    public static String getTimeStamp2(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
    }

    public static String getRequestRefNumber() {
        long random = (long) (Math.random() * DIVIDER);
        int remainder = (int) random % DIVIDER;
        String reminderstr = String.format(FORMAT, remainder);
        return System.nanoTime() + "" + reminderstr;

    }

    public static String generateOtpValue() {
        return getRequestRefNumber().substring(4, 10);
    }

    public static List<Integer> getYears(){
        List<Integer> yearList = new ArrayList<>();
        int currentYear = 2022;
        for(int i = 0; i < 150; i++){
            yearList.add(currentYear++);
        }

        return yearList;
    }

    public static List<String> getMonths(){
        return MonthNames.getMonthNames();
    }

    public static String getPresentYear(){
        String[] currentDate = AdapterUtils.getTimeStamp1().split(" ");
        String[] splitDate = currentDate[0].split("-");
        return splitDate[2];
    }

    public static String getPresentMonth(){
        String[] currentDate = AdapterUtils.getTimeStamp1().split(" ");
        String[] splitDate = currentDate[0].split("-");
        return splitDate[1].toUpperCase();
    }

    public static boolean compareDbDateWithCurrentDate(String dbDate){
        System.out.println("DbDate :: " + dbDate);
        String sysDate = getTimeStamp2();
        if(dbDate != null){
            String[] dbDateSplit = dbDate.split(" ");
            if(dbDateSplit[0] != null && sysDate.equalsIgnoreCase(dbDateSplit[0])){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
       // System.out.println(getPresentYear());
        String date = "16-12-22 3:54:00.685000000 PM";
        System.out.println(compareDbDateWithCurrentDate(date));
    }



}
