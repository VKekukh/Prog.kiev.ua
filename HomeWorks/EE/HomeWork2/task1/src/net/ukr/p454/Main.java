package net.ukr.p454;

import net.ukr.p454.entity.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Dalvik on 18.10.2016.
 */
public class Main {
    public static void main(String[] args) {

        Train train100 = new Train(100,"Kiev","Lviv", LocalDate.of(2016,10,19), LocalTime.of(9,0,0));
        Train train101 = new Train(101,"Kiev","Odesa", LocalDate.of(2016,10,19), LocalTime.of(9,30,0));

        TrainStation station = new TrainStation("Kiev");
        station.add(train100);
        station.add(train101);

        TrainStation newStation;

        File file  = new File("output.xml");
        try{

            JAXBContext jaxbContext = JAXBContext.newInstance(TrainStation.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(station,file);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            newStation = (TrainStation) unmarshaller.unmarshal(file);

            newStation.add(new Train(103,"Kiev","Prague",LocalDate.of(2016,10,19), LocalTime.of(16,30)));
            newStation.add(new Train(104,"Kiev","Krakow",LocalDate.of(2016,10,19), LocalTime.of(17,28)));

            newStation.searchTrains(LocalDate.now(), LocalTime.of(15, 0), LocalTime.of(19, 0));
            newStation.searchTrains(LocalDate.now(), "krakow");

            marshaller.marshal(newStation,file);
        }catch(JAXBException e) {
            e.printStackTrace();
        }


    }
}
