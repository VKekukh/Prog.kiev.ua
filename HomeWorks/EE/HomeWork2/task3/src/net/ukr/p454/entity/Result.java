package net.ukr.p454.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dalvik on 19.10.2016.
 */

@XmlRootElement (name = "results")
public class Result {

    private List<Rate> rates = new ArrayList<>();


    private String test;

    @XmlElement
    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    @XmlElement
    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Result{" +
                "rates=" + rates +
                ", test='" + test + '\'' +
                '}';
    }
}
