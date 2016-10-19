package net.ukr.p454;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by VKekukh on 18.10.2016.
 */
@XmlRootElement(name = "train")
public class Train {
    private int id;
    private String from;
    private String to;
    private LocalDate date;
    private LocalTime time;

    public Train() {
    }

    public Train(int id, String from, String to, LocalDate date, LocalTime time) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }
    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }
    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }

    public LocalDate getDate() {
        return date;
    }

    @XmlElement
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }
    @XmlElement
    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
