package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HourContract {
    private double valuePerHour;
    private int hours;
    private LocalDate date;
    private DateTimeFormatter dateTimeBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public HourContract(double valuePerHour, int hours, String date) {
        this.valuePerHour = valuePerHour;
        this.hours = hours;
        this.date = LocalDate.parse(date, dateTimeBr);
    }

    double totalValue() {
        return valuePerHour * hours;
    }

    public LocalDate getDate() {
        return date;
    }
}
