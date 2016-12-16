package com.nekoscape.java.sample;

import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TimezoneConversionTest {

    private static final String DATE_FORMAT = "yyyy/MM/dd HH:mm";

    @BeforeClass
    public static void beforeClass() {
        TimeZone.setDefault(TimeZone.getTimeZone("Australia/Sydney"));
    }

    @Test
    public void convertWithDefaultTimezone_test_for_beforeJava7Method() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String dateStr = "2016/03/12 02:00";
        Date date = sdf.parse(dateStr);
        TimeZone timeZone = TimeZone.getDefault();

        Date converted = TimezoneConversion.convertWithBeforeJava7(date, timeZone);

        sdf.setTimeZone(timeZone);
        Date expected = sdf.parse(dateStr);
        assertThat("It would be same date", converted, is(expected));
    }

    @Test
    public void convertWithDefaultTimezone_test_for_Java8Method() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String dateStr = "2016/03/13 02:00";
        Date date = sdf.parse(dateStr);
        TimeZone timeZone = TimeZone.getDefault();

        Date converted = TimezoneConversion.convertWithJava8(date, timeZone);

        sdf.setTimeZone(timeZone);
        Date expected = sdf.parse(dateStr);
        assertThat("It would be same date", converted, is(expected));
    }

    @Test
    public void convertWithOtherTimezone_test_for_beforeJava7Method() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String dateStr = "2016/10/02 02:00";
        Date date = sdf.parse(dateStr);
        TimeZone timeZone = TimeZone.getTimeZone("America/Montreal");

        Date converted = TimezoneConversion.convertWithBeforeJava7(date, timeZone);

        sdf.setTimeZone(timeZone);
        Date expected = sdf.parse(dateStr);
        assertThat("It would be same date", converted, is(expected));
    }

    @Test
    public void convertWithOtherTimezone_test_for_Java8Method() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String dateStr = "2016/10/02 02:00";
        Date date = sdf.parse(dateStr);
        TimeZone timeZone = TimeZone.getTimeZone("America/Montreal");

        Date converted = TimezoneConversion.convertWithJava8(date, timeZone);

        sdf.setTimeZone(timeZone);
        Date expected = sdf.parse(dateStr);
        assertThat("It would be same date", converted, is(expected));
    }

}
