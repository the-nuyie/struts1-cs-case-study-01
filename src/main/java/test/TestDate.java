package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        String pattern = "yyyyMMdd-HHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String strDate = simpleDateFormat.format(new Date());
        System.out.println(strDate);
    }
}
