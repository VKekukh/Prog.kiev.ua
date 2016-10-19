package net.ukr.p454.formatters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Dalvik on 18.10.2016.
 */
public class DateFormatter extends XmlAdapter<String,LocalDate>{
    @Override
    public LocalDate unmarshal(String v) throws Exception {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(v, dtf);
        return date;
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}
