package net.ukr.p454;

import net.ukr.p454.entity.Query;
import net.ukr.p454.entity.Rate;
import net.ukr.p454.entity.Result;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * Created by Dalvik on 19.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        String link = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

        System.out.println(XMLBuilder.getXML(link));
        Result query = JAXBWorker.loadFromXml(new File("out.xml"));
        System.out.println(query.toString());


    }

}
