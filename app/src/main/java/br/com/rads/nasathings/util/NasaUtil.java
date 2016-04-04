package br.com.rads.nasathings.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Rafael on 4/3/16.
 */
public class NasaUtil {

    public static String apodDateQueryString(Date date){
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
    }

}
