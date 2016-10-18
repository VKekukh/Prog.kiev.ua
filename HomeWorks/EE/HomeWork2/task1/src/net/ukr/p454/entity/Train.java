package net.ukr.p454.entity;

import net.ukr.p454.formatters.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Dalvik on 18.10.2016.
 */
@XmlType (propOrder = {"id","from","to","date","departure"})
@XmlRootElement
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
    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    @XmlElement
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    @XmlElement
    @XmlJavaTypeAdapter(DateFormatter.class)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    @XmlElement
    @XmlJavaTypeAdapter(TimeFormatter.class)
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
