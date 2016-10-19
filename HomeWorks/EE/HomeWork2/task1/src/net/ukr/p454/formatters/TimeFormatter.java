package net.ukr.p454.formatters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Dalvik on 18.10.2016.
 */
public class TimeFormatter extends XmlAdapter<String,LocalTime> {
    @Override
    public LocalTime unmarshal(String v) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(v,dtf );
        return time;
    }

    @Override
    public String marshal(LocalTime v) throws Exception {
        return v.toString();
    }
}
