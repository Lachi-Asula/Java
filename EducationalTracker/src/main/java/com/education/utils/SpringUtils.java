package com.education.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SpringUtils {

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
}
