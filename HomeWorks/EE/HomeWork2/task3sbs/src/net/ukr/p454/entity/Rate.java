package net.ukr.p454.entity;

import net.ukr.p454.formatter.DateFormatter;
import net.ukr.p454.formatter.TimeFormatter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 * Created by vkekukh on 20.10.2016.
 */
@XmlRootElement (name = "rate")
public class Rate {

    private String id;
    private String name;
    private double rate;
    private LocalDate date;
    private LocalTime time;
    private double ask;
    private double bid;

    public Rate() {
    }


    public Rate(String id, String name, double rate, LocalDate date, LocalTime time, double ask, double bid) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.date = date;
        this.time = time;
        this.ask = ask;
        this.bid = bid;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }
    @XmlElement (name = "Name")
    public String getName() {
        return name;
    }
    @XmlElement(name = "Rate")
    public double getRate() {
        return rate;
    }

    @XmlElement (name = "Date")
    @XmlJavaTypeAdapter(DateFormatter.class)
    public LocalDate getDate() {
        return date;
    }
    @XmlElement (name = "Time")
    @XmlJavaTypeAdapter(TimeFormatter.class)
    public LocalTime getTime() {
        return time;
    }

    @XmlElement (name = "Ask")
    public double getAsk() {
        return ask;
    }
    @XmlElement (name = "Bid")
    public double getBid() {
        return bid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", date=" + date +
                ", time=" + time +
                ", ask=" + ask +
                ", bid=" + bid +
                '}';
    }
}
