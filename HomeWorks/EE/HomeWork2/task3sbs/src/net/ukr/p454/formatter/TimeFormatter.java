package net.ukr.p454.formatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/**
 * Created by vkekukh on 20.10.2016.
 */
public class TimeFormatter extends XmlAdapter<String,LocalTime
        > {
    @Override
    public LocalTime unmarshal(String v) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:mma");
        LocalTime time = LocalTime.parse(v.toUpperCase(),dtf );
        return time;
    }

    @Override
    public String marshal(LocalTime v) throws Exception {
        return v.toString();
    }
}
