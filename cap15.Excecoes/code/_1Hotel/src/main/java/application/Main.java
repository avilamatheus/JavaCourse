package application;

import model.entities.Reservation;
import model.exceptions.ReservationException;
import utils.DateTimeBr;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Reservation reservation = new Reservation(
                    8021,
                    LocalDate.parse("05/03/2024", DateTimeBr.getLocalDateFormatter()),
                    LocalDate.parse("08/03/2024", DateTimeBr.getLocalDateFormatter())
            );

            System.out.println(reservation);

            reservation.updateDates(
                    LocalDate.parse("06/03/2024", DateTimeBr.getLocalDateFormatter()),
                    LocalDate.parse("09/03/2024", DateTimeBr.getLocalDateFormatter())
            );

            System.out.println(reservation);
        } catch (DateTimeException e) {
            System.out.println("Error: invalid date format");
        } catch (ReservationException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }



    }
}