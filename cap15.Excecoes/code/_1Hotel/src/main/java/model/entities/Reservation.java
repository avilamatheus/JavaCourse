package model.entities;

import model.exceptions.ReservationException;
import utils.DateTimeBr;

import java.time.Duration;
import java.time.LocalDate;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws ReservationException {
        if(!checkOut.isAfter(checkIn)) {
            throw new ReservationException("Check-out date must be after check-in date");
        }

        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    Integer duration() {
        Duration t1 = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
        return Math.toIntExact(t1.toDays());
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) throws ReservationException {
        if(!checkOut.isAfter(checkIn)) {
            throw new ReservationException("Check-out date must be after check-in date");
        }

        if(!isFutureDates(checkIn, checkOut)) {
            throw new ReservationException("Reservation dates for update must be future dates");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    private boolean isFutureDates(LocalDate checkIn, LocalDate checkOut) {
        LocalDate now = LocalDate.now();
        return (checkIn.isAfter(now) && checkOut.isAfter(now));
    }

    @Override
    public String toString() {
        return "Reservation: Room " + roomNumber +
                ", check-in: " + checkIn.format(DateTimeBr.getLocalDateFormatter()) +
                ", check-out: " + checkOut.format(DateTimeBr.getLocalDateFormatter()) +
                ", " + duration() + " nights";
    }

}
