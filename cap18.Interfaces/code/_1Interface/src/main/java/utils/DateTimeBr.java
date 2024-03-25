package utils;

import java.time.format.DateTimeFormatter;

public class DateTimeBr {
    public static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static DateTimeFormatter getLocalDateFormatter() {
        return LOCAL_DATE_FORMATTER;
    }
}
