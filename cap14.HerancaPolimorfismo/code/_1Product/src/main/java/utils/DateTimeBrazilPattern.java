package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeBrazilPattern {
    private static final DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formatLocalDate(LocalDate localDate) {
        return fmt1.format(localDate);
    }

    public static LocalDate parseLocalDate(String date) {
        return LocalDate.parse(date, fmt1);
    }
}
