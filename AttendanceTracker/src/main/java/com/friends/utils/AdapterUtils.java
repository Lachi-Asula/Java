package com.friends.utils;


import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdapterUtils {

    private static final Logger logger = Logger.getLogger(AdapterUtils.class.getName());
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

    public static List<String> getTimeStampsForStatus(List<String> formatDays){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
        List<String> days = new ArrayList<>();
        Date date = null;
        String finalDate = null;
        try {
            for (String day : formatDays) {
                day = dateModification(day);
                date = simpleDateFormat.parse(day);
                finalDate = simpleDateFormat2.format(date);
                days.add(finalDate);
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, getStackTrace(e));
        }
        return days;
    }

    public static String getTimeStampsForSingleStatus(String formatDays){
        String finalDate = null;
        try {
           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
           SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
           Date date = null;
           formatDays = dateModification(formatDays);
           date = simpleDateFormat.parse(formatDays);
           finalDate = simpleDateFormat2.format(date);
       }catch (Exception e){
           e.printStackTrace();
       }
        return finalDate;
    }

    private static String dateModification(String date){
        String modifiedDate = null;
        try{
            if(StringUtils.isNotBlank(date)){
                String[] dateSplit = date.split("\\.");
                String[] dateSplit2 = dateSplit[1].split(" ");
                modifiedDate = date.replaceAll(dateSplit2[0], "");
            }else {
                return date;
            }
        }catch (Exception e){
            return date;
        }

        return modifiedDate;
    }

    /*public static void main(String[] args) {
        System.out.println(getPresentYear());
        String date = "16-12-22 3:54:00.685000000 PM";
        System.out.println(compareDbDateWithCurrentDate(date));

        String date = "2022-12-17 11:45:14.523";
    }*/



}
