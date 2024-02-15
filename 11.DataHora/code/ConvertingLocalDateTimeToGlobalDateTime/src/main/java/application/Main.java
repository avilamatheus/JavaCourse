package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {

        // LocalDate given some text in the format yyyy-MM-dd
        LocalDate localDate = LocalDate.parse("2022-07-20");

        // LocalDateTime given some text in the format yyyy-MM-ddTHH:mm:ss
        LocalDateTime localDateTime = LocalDateTime.parse("2022-07-20T01:30:26");

        // Instant given some text in the format yyyy-MM-ddTHH:mm:ssZ (UTC/Zulu time)
        Instant instant = Instant.parse("2022-07-20T01:30:26Z");

        // Here we are converting the Instant to a LocalDate using the system default time zone.
        LocalDate localDateUsingSystemTZ = LocalDate.ofInstant(instant, ZoneId.systemDefault());

        // Here we are converting the Instant to a LocalDate using the Portugal time zone.
        LocalDate localDateUsingPortugalTZ = LocalDate.ofInstant(instant, ZoneId.of("Portugal"));

        // Here we are converting the Instant to a LocalDateTime using the system default time zone.
        LocalDateTime localDateTimeUsingSystemTZ = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // Here we are converting the Instant to a LocalDateTime using the Portugal time zone.
        LocalDateTime localDateTimeUsingPortugalTZ = LocalDateTime.ofInstant(instant, ZoneId.of("Portugal"));

        // Printing the results.
        System.out.println("localDateUsingSystemTZ = " + localDateUsingSystemTZ);
        System.out.println("localDateUsingPortugalTZ = " + localDateUsingPortugalTZ);
        System.out.println("localDateTimeUsingSystemTZ = " + localDateTimeUsingSystemTZ);
        System.out.println("localDateTimeUsingPortugalTZ = " + localDateTimeUsingPortugalTZ);

        // Below we are printing the localDate day, month and year values.
        System.out.println("localDate dia = " + localDate.getDayOfMonth());
        System.out.println("localDate mês = " + localDate.getMonthValue());
        System.out.println("localDate ano = " + localDate.getYear());

        // Below we are printing the localDateTime hour and minute values.
        System.out.println("localDateTime hora = " + localDateTime.getHour());
        System.out.println("localDateTime minutos = " + localDateTime.getMinute());
    }
}