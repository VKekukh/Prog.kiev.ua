package net.ukr.p454;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by vkekukh on 19.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        TrainStation station = TrainStationXmlParser.load(new File("output.xml"));
        station.searchTrains(LocalDate.now(), LocalTime.of(15, 0), LocalTime.of(19, 0));
        station.searchTrains(LocalDate.now(), "krakow");

        station.add(new Train(102, "Kiev", "Rovno", LocalDate.now(), LocalTime.now()));

        TrainStationToXml.save(station, "output2.xml");
    }
}
