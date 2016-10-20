package net.ukr.p454.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by vkekukh on 20.10.2016.
 */
@XmlRootElement(name = "results")
public class Results {

    private List<Rate> rates = new ArrayList<>();

    public Results(List<Rate> rates) {
        this.rates = rates;
    }

    public Results() {
    }

    @XmlElement(name = "rate")
    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Results{" +
                "rates=" + rates +
                '}';
    }
}
