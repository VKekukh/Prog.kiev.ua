package net.ukr.p454.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vkekukh on 20.10.2016.
 */
@XmlRootElement(name = "query")
public class Query {

    private Results results;

    public Query(Results results) {
        this.results = results;
    }

    public Query() {
    }
    @XmlElement (name = "results")
    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Query{" +
                "results=" + results +
                '}';
    }
}
