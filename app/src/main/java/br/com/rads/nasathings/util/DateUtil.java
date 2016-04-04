package br.com.rads.nasathings.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Rafael on 4/3/16.
 */
public class DateUtil {

    public static boolean sameMonth(Date date1, Date date2){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
    }

    public static boolean afterDay(Date date1, Date date2) {

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.DAY_OF_YEAR) < cal2.get(Calendar.DAY_OF_YEAR) &&
                cal1.get(Calendar.YEAR) < cal2.get(Calendar.YEAR);

    }
}
