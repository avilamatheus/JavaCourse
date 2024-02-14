package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        // Sources:
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDateTime.html
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/Instant.html
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html

        // LocalDate parsed from a String in the format yyyy-MM-dd
        LocalDate parsedLocalDate = LocalDate.parse("2024-02-14");

        // LocalDateTime parsed from a String in the format yyyy-MM-ddTHH:mm:ss
        LocalDateTime parsedLocalDateTime = LocalDateTime.parse("2024-02-14T10:38:30");

        // Instant parsed from a String in the format yyyy-MM-ddTHH:mm:ssZ (UTC/Zulu time)
        Instant parsedInstantUsingZuluTime = Instant.parse("2024-02-14T12:30:00Z");

        // DateTimeFormatter using the pattern dd/MM/yyyy
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // DateTimeFormatter using the pattern dd/MM/yyyy HH:mm
        DateTimeFormatter fmt2 =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // DateTimeFormatter using the pattern dd/MM/yyyy HH:mm and the system default time zone, 
        // this is needed to format the Instant to a String.
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

        // DateTimeFormatter using the ISO_DATE_TIME pattern, 
        // such as '2011-12-03T10:15:30'
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;

        // DateTimeFormatter using the ISO_INSTANT pattern,
        // such as '2011-12-03T10:15:30Z'
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;

        // These are 3 ways to do the same thing:
        System.out.println("parsedLocalDate = " + parsedLocalDate.format(fmt1));
		System.out.println("parsedLocalDate = " + fmt1.format(parsedLocalDate));
		System.out.println("parsedLocalDate = " + parsedLocalDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        // Below we're formatting the parsedLocalDateTime using 
        // the DateTimeFormatter fmt1, fmt2 and fmt4.
        // In the fmt1 case, the result will be 14/02/2024
        // In the fmt2 case, the result will be 14/02/2024 10:38
        // In the fmt4 case, the result will be 2024-02-14T10:38:30
        System.out.println("parsedLocalDateTime = " + parsedLocalDateTime.format(fmt1));
        System.out.println("parsedLocalDateTime = " + parsedLocalDateTime.format(fmt2));
        System.out.println("parsedLocalDateTime = " + parsedLocalDateTime.format(fmt4));
        
        // Below we're formatting the parsedInstantUsingZuluTime using
        // the DateTimeFormatter fmt3 and fmt5.
        // In the fmt3 case, the result will be 14/02/2024 09:30
        // In the fmt5 case, the result will be 2024-02-14T12:30:00Z
        // The result of the fmt3 case is in the system default time zone, which is GMT-3,
        // so the result will be 3 hours behind the Zulu time (UTC).
        System.out.println("parsedInstantUsingZuluTime = " + fmt3.format(parsedInstantUsingZuluTime));
		System.out.println("parsedInstantUsingZuluTime = " + fmt5.format(parsedInstantUsingZuluTime));
		System.out.println("parsedInstantUsingZuluTime = " + parsedInstantUsingZuluTime);


    }
}