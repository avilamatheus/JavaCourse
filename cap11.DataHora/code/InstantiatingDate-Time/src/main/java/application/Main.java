package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        // Sources:
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDateTime.html
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/Instant.html
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html


        // LocalDate is a Date without a time-zone
        // in the ISO-8601 calendar system, such as 2024-02-14
        // (yyyy-MM-dd).
        LocalDate localDateNow = LocalDate.now();

        // LocalDateTime is a date-time without a time-zone in
        // the ISO-8601 calendar system,
        // such as 2007-12-03T10:15:30.904693487
        LocalDateTime localDateTimeNow = LocalDateTime.now();

        // Instant is an instantaneous point on the time-line.
        // This might be used to record event time-stamps in the application.
        // This class uses by default the UTC time zone (Or zulu time, Z).
        // Example: 2024-02-14T13:30:13.904724496Z
        Instant instantNow = Instant.now();

        // LocalDate given some text in the format yyyy-MM-dd
        LocalDate localDateParsed = LocalDate.parse("2024-02-14");

        // LocalDateTime given some text in the format yyyy-MM-ddTHH:mm:ss
        LocalDateTime localDateTimeParsed = LocalDateTime.parse("2024-02-14T10:38:30");

        // Instant given some text in the format yyyy-MM-ddTHH:mm:ssZ (UTC/Zulu time)
        Instant instantParsedUsingZuluTime = Instant.parse("2024-02-14T12:30:00Z");

        // Instant given some text in the format yyyy-MM-ddTHH:mm-HH:mm,
        // in this case, we are specifying the instant to use
        // GMT-03:00 (São Paulo Timezone).
        // However, the printed result below will be in the UTC timezone,
        // converted automatically by the class.
        Instant instantParsedUsingSaoPauloTZ = Instant.parse("2024-02-14T12:30:00-03:00");

        System.out.println("localDateNow: " + localDateNow);
        System.out.println("localDateTimeNow: " + localDateTimeNow);
        System.out.println("instantNow: " + instantNow);
        System.out.println("localDateParsed: " + localDateParsed);
        System.out.println("localDateTimeParsed: " + localDateTimeParsed);
        System.out.println("instantParsedUsingZuluTime: " + instantParsedUsingZuluTime);
        System.out.println("instantParsedUsingSaoPauloTZ: " + instantParsedUsingSaoPauloTZ);

        // DateTimeFormatter is a Formatter for printing and parsing date-time objects.

        // Is this case we're creating an DateTimeFormatter in the format dd/MM/yyyy.
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Is this case we're creating an DateTimeFormatter in the format dd/MM/yyyy HH:mm.
        DateTimeFormatter fmt2 =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // instantiating an localDate using the DateTimeFormatter fmt1
        LocalDate localDateUsingFormatter = LocalDate.parse("14/02/2024", fmt1);

        // instantiating an localDate using the DateTimeFormatter fmt1
        LocalDateTime localDateTimeUsingFormatter = LocalDateTime.parse("14/02/2024 10:52", fmt2);

        System.out.println("localDateUsingFormatter: " + localDateUsingFormatter);
        System.out.println("localDateTimeUsingFormatter: " + localDateTimeUsingFormatter);

        // Another way to instantiate a LocalDate is using the method below
        LocalDate localDateOf = LocalDate.of(2024, 02, 14);

        // Another way to instantiate a localDateTime is using the method below
        LocalDateTime localDateTimeOf = LocalDateTime.of(2022, 07, 20, 1, 30);

        System.out.println("localDateOf: " + localDateOf);
        System.out.println("localDateTimeOf: " + localDateTimeOf);
        

        // This removes the nanoseconds from an Instant.
        // In this case, ChronoUnit.SECONDS is used to truncate the Instant to seconds,
        // removing the nano-seconds.
        Instant instant = Instant.now();
        Instant truncatedInstant = instant.truncatedTo(ChronoUnit.SECONDS);

        System.out.println("Instant original: " + instant);
        System.out.println("Instant truncado: " + truncatedInstant);

    }
}