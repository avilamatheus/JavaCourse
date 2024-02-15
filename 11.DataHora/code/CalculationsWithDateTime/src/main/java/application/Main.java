package application;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        

        // LocalDate given some text in the format yyyy-MM-dd
        LocalDate localDate = LocalDate.parse("2022-07-20");

        // LocalDateTime given some text in the format yyyy-MM-ddTHH:mm:ss
        LocalDateTime localDateTime = LocalDateTime.parse("2022-07-20T01:30:26");

        // Instant given some text in the format yyyy-MM-ddTHH:mm:ssZ (UTC/Zulu time)
        Instant instant = Instant.parse("2022-07-20T01:30:26Z");
		
        // Instantiating two LocalDate objects, one for the past week and another for the next week, 
        //using the minusDays and plusDays methods to the localDate object.
		LocalDate pastWeekDate = localDate.minusDays(7);
		LocalDate nextWeekDate = localDate.plusDays(7);
		
        // Instantiating two LocalDateTime objects, one for the past week and another for the next week,
        // using the minusDays and plusDays methods to the localDateTime object.
		LocalDateTime pastWeekLocalDate = localDateTime.minusDays(7);
		LocalDateTime nextWeekLocalDate = localDateTime.plusDays(7);
		
        // Instantiating two Instant objects, one for the past week and another for the next week,
        // using the minus and plus methods to the instant object. Here we are using the ChronoUnit 
        // enum to specify the time unit, in this case, days.
		Instant pastWeekInstant = instant.minus(7, ChronoUnit.DAYS);
		Instant nextWeekInstant = instant.plus(7, ChronoUnit.DAYS);
		
        // Printing the results.
		System.out.println("pastWeekDate = " + pastWeekDate);
		System.out.println("nextWeekDate = " + nextWeekDate);
		System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
		System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
		System.out.println("pastWeekInstant = " + pastWeekInstant);
		System.out.println("nextWeekInstant = " + nextWeekInstant);


		// Here we are calculating the difference between the past week and the current date,
        // using the Duration.between method to calculate the difference between two dates.

        // In this case, we are using the atStartOfDay method to convert the LocalDate object to a LocalDateTime object.
		Duration t1 = Duration.between(pastWeekDate.atStartOfDay(), localDate.atStartOfDay());

        Duration t2 = Duration.between(pastWeekLocalDate, localDateTime);
		Duration t3 = Duration.between(pastWeekInstant, instant);

        // In this case the result will be negative, because the pastWeekInstant is before the instant.
		Duration t4 = Duration.between(instant, pastWeekInstant);

		System.out.println("t1 dias = " + t1.toDays());
		System.out.println("t2 dias = " + t2.toDays());
		System.out.println("t3 dias = " + t3.toDays());
		System.out.println("t4 dias = " + t4.toDays());
    }
}