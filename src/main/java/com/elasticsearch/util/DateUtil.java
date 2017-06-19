package com.elasticsearch.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
    public static final String SHORT_MONTH_FORMAT = "yyyyMM";
    public static final String SHORT_DATE_FORMAT = "yyyyMMdd";

    /**
     * 将日期变为当天0点
     *
     * @param date
     * @return
     */
    public Date delTime(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(df.format(date));
        } catch (ParseException e) {
            return date;
        }
    }

    /**
     * 日期格式化
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        try {
            DateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }

    /**
     * 字符串转Date
     *
     * @param date
     * @param format
     * @return
     */
    public static Date parse2Date(String date, String format) {
        try {
            DateFormat df = new SimpleDateFormat(format);
            return df.parse(date);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * 自动格式化,默认格式"yyyy-MM-dd HH:mm:ss"
     *
     * @param date
     * @return
     */
    public static String autoFormat(Date date) {
        return format(date, DATE_TIME_FORMAT);
    }

    public static Date parseAuto2Date(String str) {
        DateFormat df = null;
        if (str == null) {
            return null;
        }
        String s = str.replaceAll("/", "-");
        Date d = null;

        if (s.contains(":")) {
            if (s.length() == DATE_TIME_FORMAT.length())
                df = new SimpleDateFormat(DATE_TIME_FORMAT);
            else if (s.length() == TIME_FORMAT.length())
                df = new SimpleDateFormat(TIME_FORMAT);
            else if (s.length() == TIMESTAMP_FORMAT.length())
                df = new SimpleDateFormat(TIMESTAMP_FORMAT);
        } else if (s.contains("-")) {
            if (s.length() == DATE_FORMAT.length()) {
                df = new SimpleDateFormat(DATE_FORMAT);
            }
        } else {
            if (s.length() == SHORT_DATE_FORMAT.length())
                df = new SimpleDateFormat(SHORT_DATE_FORMAT);
            else if (s.length() == SHORT_MONTH_FORMAT.length())
                df = new SimpleDateFormat(SHORT_MONTH_FORMAT);
            else
                df = new SimpleDateFormat(DATE_FORMAT); // 默认值
        }
        try {
            d = df.parse(s);
        } catch (ParseException e) {
            logger.error("ParseException:  " + str + " ,  Exception:" + e);
        }
        return d;
    }
}
