package com.friends.utils;


import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }

    public static String getRequestRefNumber() {
        long random = (long) (Math.random() * DIVIDER);
        int remainder = (int) random % DIVIDER;
        String reminderstr = String.format(FORMAT, remainder);
        return System.nanoTime() + "" + reminderstr;

    }

    public static String generateOtpValue() {
        long random = (long) (Math.random() * DIVIDER);
        int remainder = (int) random % DIVIDER;
        String reminderstr = String.format(FORMAT, remainder);
        return (System.nanoTime() + "" + reminderstr).substring(4, 10);

    }
}
