package com.jeffrychristian.app.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created by jeffry.christian on 4/29/2017.
 */
public class DateUtil {

    /**
     * dd ==> day
     * MM ==> month
     * yyyy ==> years
     * HH ==> hours 0-23
     * mm ==> minutes 1-59
     * ss ==> seconds 1-59
     */

//    public final static String TIMEZONE = "GMT+7:00";
    private final static String ddMMMyyyy = "dd-MMM-yyyy";

    /**
     * Format => "dd-MM-yyyy" or "HH : mm" or others
     *
     * @param date
     * @param format
     * @param locale
     * @return
     */
    public static String dateToString(Date date, String format, Locale locale) {
        if (date == null) {
            return "-";
        }
        return new SimpleDateFormat(format, locale).format(date);
    }

    public static String dateToString(Date date, String format) {
        return dateToString(date, format, Locale.US);
    }

    public static String dateToString(Date date) {
        return dateToString(date, ddMMMyyyy);
    }

    /**
     * Format => "dd-MM-yyyy" or "HH : mm" or others
     *
     * @param dateString
     * @param format
     * @param locale
     * @return
     */
    public static Date stringToDate(String dateString, String format, Locale locale) {
        try {
            return (new SimpleDateFormat(format, locale)).parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date stringToDate(String dateString, String format) {
        return stringToDate(dateString, format, Locale.US);
    }

    public static Date stringToDate(String dateString) {
        return stringToDate(dateString, ddMMMyyyy);
    }

    /**
     * DatewithoutTime => "21-Oct-2015 12:34:12" => "21-Oct-2015 00:00:00"
     *
     * @param date
     * @return
     */
    public static Date getDateWithoutTime(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * EndOfDay => "21-Oct-2015 23:59:59"
     *
     * @param date
     * @return
     */
    public static Date getEndOfDay(Date date) {
        if (date == null) {
            return null;
        }

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DATE, 1);
        cal.add(Calendar.MILLISECOND, -1);

        return cal.getTime();
    }

    /**
     * addDay (1) => "31-Oct-2015 12:34:12" => "01-Nov-2015 12:34:12" minusDay
     * (-1) => "01-Oct-2015 12:34:12" => "30-Sep-2015 12:34:12"
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    /**
     * @param date
     * @param months
     * @return
     */
    public static Date addMonths(Date date, int months) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months); //minus number would decrement the days
        return cal.getTime();
    }

    /**
     * @param date
     * @param years
     * @return
     */
    public static Date addYears(Date date, int years) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years); //minus number would decrement the days
        return cal.getTime();
    }

    public static Date add(Date date, int add, int calendarType) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(calendarType, add);
        return cal.getTime();
    }

    /**
     * different between two Date/Time
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getDays(Date startDate, Date endDate) {
        int diff = (int) ((DateUtil.getDateWithoutTime(endDate).getTime() - DateUtil.getDateWithoutTime(startDate).getTime()) / (1000 * 60 * 60 * 24));
        return diff;
    }

    public static int getMonths(Date startDate, Date endDate) {
        Calendar start = GregorianCalendar.getInstance();
        start.setTime(startDate);
        Calendar end = GregorianCalendar.getInstance();
        end.setTime(endDate);
        int diff = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR))*12 + end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
        return diff;
    }

    /**
     * get date difference between two dates use TimeUnit.SECONDS in timeUnit
     * param to get difference in seconds, use TimeUnit.HOURS in timeUnit param
     * to get difference in hours, use TimeUnit.DAYS in timeUnit param to get
     * difference in days,
     *
     * @param date1
     * @param date2
     * @param timeUnit
     * @return
     */
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}
