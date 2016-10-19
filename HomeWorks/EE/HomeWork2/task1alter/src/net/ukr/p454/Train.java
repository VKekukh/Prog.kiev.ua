package net.ukr.p454;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 * Created by Dalvik on 18.10.2016.
 */

public class Train {

    private int id;
    private String from;
    private String to;
    private LocalDate date;
    private LocalTime departure;

    public Train() {
    }

    public Train(int id, String from, String to, LocalDate date, LocalTime departure) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                ", departure=" + departure +
                '}';
    }
}
