package com.nekoscape.java.sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

class TimezoneConversion {

    static Date convertWithBeforeJava7(Date dateTime, TimeZone timeZone) throws ParseException {
        String format = "yyyy/MM/dd HH:mm:ss.SSS";
        SimpleDateFormat local = new SimpleDateFormat(format);
        SimpleDateFormat convert = new SimpleDateFormat(format);
        convert.setTimeZone(timeZone);
        return convert.parse(local.format(dateTime));
    }

    static Date convertWithJava8(Date dateTime, TimeZone timeZone) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(dateTime.toInstant(), ZoneId.systemDefault());
        return Date.from(localDateTime.atZone(timeZone.toZoneId()).toInstant());
    }
}
