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

        File file  = new File("output.xml");
        try{

            JAXBContext jaxbContext = JAXBContext.newInstance(Train.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(train100,file);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            train101 = (Train) unmarshaller.unmarshal(file);

            System.out.println(train101);

        }catch(JAXBException e) {
            e.printStackTrace();
        }


    }
}
