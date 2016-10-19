package net.ukr.p454;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VKekukh on 18.10.2016.
 */
@XmlRootElement(name = "trains")
public class Trains {

    private List<Train> trains = new ArrayList<>();

    public Trains() {
    }

    public List<Train> getTrains() {
        return trains;
    }

    @XmlElement
    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public void add(Train train){
        trains.add(train);
    }

    @Override
    public String toString() {
        return "Trains{" +
                "trains=" + trains +
                '}';
    }
}
