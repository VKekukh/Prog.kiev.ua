package net.ukr.p454.entity;

import net.ukr.p454.formatters.DateFormatter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name = "rate")
public class Rate{

    private String id;
    private String name;
    private LocalDate date;
    private double ask;
    private double bid;

    public Rate() {
    }

    public Rate(String id, String name, LocalDate date, double ask, double bid) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.ask = ask;
        this.bid = bid;
    }
    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @XmlElement(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @XmlElement(name = "Date")
    @XmlJavaTypeAdapter(DateFormatter.class)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    @XmlElement(name = "Ask")
    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }
    @XmlElement (name = "Bid")
    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", ask=" + ask +
                ", bid=" + bid +
                '}';
    }
}
