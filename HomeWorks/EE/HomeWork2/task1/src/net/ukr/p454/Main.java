package net.ukr.p454;


import javax.xml.bind.JAXBContext;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by VKekukh on 18.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Trains trains = new Trains();
        trains.add(new Train(1,"Kiev","Lvov", LocalDate.of(2016,10,19), LocalTime.of(9,00)));
        trains.add(new Train(2,"Kiev","Vinnica", LocalDate.of(2016,10,19), LocalTime.of(10,00)));

        System.out.println(trains.toString());

        File file  = new File("trains.xml");
        JAXBContext jaxbContext = new  JAXBContext.newInstance(Trains.class);
    }
}
