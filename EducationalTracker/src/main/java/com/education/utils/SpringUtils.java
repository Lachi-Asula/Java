package com.education.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpringUtils {
    private static final Logger logger = Logger.getLogger(SpringUtils.class.getName());

    public static int DIVIDER = 10000;
    public static int LENGTH = ((DIVIDER + "").length() - 1);
    public static String FORMAT = "%0" + LENGTH + "d";

    private SpringUtils(){

    }

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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a z");
        return simpleDateFormat.format(new Date());
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

    public static Integer getHoursDiffFromDates(Date startDate, Date stopDate) {
        Integer diffHr = 0;
        try {
            long diff = startDate.getTime() - stopDate.getTime();
            long diffHours = diff / (60 * 60 * 1000);
            diffHr = (int) diffHours;
        } catch (Exception e) {
            logger.log(Level.SEVERE, getStackTrace(e));
        }
        return diffHr;
    }

    public static Integer getMinutesDiffFromDates(Date startDate, Date stopDate) {
        Integer diffHr = 0;
        try {
            long diff = startDate.getTime() - stopDate.getTime();
            long diffHours = diff / (60 * 1000);
            diffHr = (int) diffHours;
        } catch (Exception e) {
            logger.log(Level.SEVERE, getStackTrace(e));
        }
        return diffHr;
    }

    public static Integer getDaysDiffFromDates(Date startDate, Date stopDate) {
        Integer diffHr = 0;
        try {
            long diffOfDates = startDate.getTime() - stopDate.getTime();
            long numberOfDays = (diffOfDates / (60 * 60 * 1000)) / 24;
            diffHr = (int) numberOfDays;
        } catch (Exception e) {
            logger.log(Level.SEVERE, getStackTrace(e));
        }
        return diffHr;
    }

}
