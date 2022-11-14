package com.workers.helper;

import org.springframework.util.StringUtils;

import java.util.Date;

public class DateHelper {

    public static final Date convertStringToDate(String dateString) throws Exception {

        if (!StringUtils.hasText(dateString)) {
            return null;
        }

        Date date = org.apache.commons.lang3.time.DateUtils.parseDate(dateString,
                new String[] { "yyyy-MM-dd HH:mm:ss", "dd/MM-yyyy", "yyyy-MM-dd" });
        return date;
    }

    public static final String convertDateToString(Date date) {

        if (date == null) {
            return null;
        }

        return  org.apache.commons.lang3.time.DateFormatUtils.format(date, "yyyy-MM-dd");

    }

}