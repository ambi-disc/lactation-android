package org.lactor.consultant.core.util;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Locale;

/**
 * @Author Matthew Page
 * @Date 11/18/17
 */

public class DateUtils {
    public static String timestampToString(long timestamp) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(timestamp);
        return DateFormat.format("dd-MM-yyyy hh:mm:ss", cal).toString();
    }
}
