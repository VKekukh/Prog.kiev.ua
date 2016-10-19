package net.ukr.p454.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkekukh on 19.10.2016.
 */
@XmlRootElement
public class TrainStation {

    private String name;
    private List<Train> trains = new ArrayList<>();

    public TrainStation() {
    }

    public TrainStation(String name, List<Train> trains) {
        this.name = name;
        this.trains = trains;
    }

    public TrainStation(String name) {
        this.name = name;
    }
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public void add(Train train) {
        if (train != null) {
            trains.add(train);
        }
    }

    public void searchTrains(LocalDate date, LocalTime from, LocalTime to){
        for (Train train : trains) {
            if(train.getDeparture().isAfter(from) && train.getDeparture().isBefore(to)&&train.getDate().isEqual(date)){
                System.out.println(train.toString());
            }
        }
    }

    public void searchTrains(LocalDate date, String to){
        for (Train train : trains) {
            if(train.getDate().isEqual(date) && train.getTo().equalsIgnoreCase(to)){
                System.out.println(train.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "TrainStation{" +
                "name='" + name + '\'' +
                ", trains=" + trains +
                '}';
    }
}
