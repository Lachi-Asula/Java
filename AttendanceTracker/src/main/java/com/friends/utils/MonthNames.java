package com.friends.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MonthNames {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;

    public static List<String> getMonthNames(){
        return Arrays.stream(MonthNames.values())
                . map(MonthNames::name)
                .collect(Collectors.toList());

    }
}
