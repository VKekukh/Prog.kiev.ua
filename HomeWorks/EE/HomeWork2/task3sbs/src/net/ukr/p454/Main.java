package net.ukr.p454;


import net.ukr.p454.entity.Query;
import net.ukr.p454.entity.Rate;
import net.ukr.p454.parsers.XMLBuilder;
import net.ukr.p454.parsers.JAXBWorker;


/**
 * Created by vkekukh on 20.10.2016.
 */
public class Main {
    public static void main(String[] args) {

        String link = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\",%20\"EURUAH\")&env=store://datatables.org/alltableswithkeys";

        /*By default, Yahoo gives XML in one line. XMLBuilder make pretty format*/
        System.out.println(XMLBuilder.getXML(link));

        Query query = JAXBWorker.loadFromXml(XMLBuilder.getXML(link));

        for (Rate rate : query.getResults().getRates()) {
            if(rate.getName().contains("UAH")){
                System.out.println(rate.getDate() + " " + rate.getTime() );
                System.out.println(rate.getName() + " : " + rate.getRate());
                System.out.println();
            }
        }
    }
}
