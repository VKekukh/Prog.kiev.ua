package net.ukr.p454.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Dalvik on 19.10.2016.
 */
@XmlRootElement
public class Query {


    private int count;

    private String created;

    private String lang;


    private Result result;

    public Query(Result result) {
        this.result = result;
    }

    public Query() {
    }

    @XmlElement
    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Query{" +
                "result=" + result +
                '}';
    }
}
