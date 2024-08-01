package com.casestudy.cs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String dateToString(Date d, String pattern){
        String strDate = null;

        Date dd = null;
        if(d == null) {
            dd = new Date();
        }else{
            dd = d;
        }
        if(pattern == null || "".equals(pattern)){
            pattern = "yyyyMMdd-HHmmss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        strDate = simpleDateFormat.format(new Date());

        return strDate;
    }
}
