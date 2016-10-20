package net.ukr.p454.parsers;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;

import net.ukr.p454.entity.Query;
import net.ukr.p454.entity.Results;
import org.xml.sax.InputSource;


/**
 * Created by Dalvik on 19.10.2016.
 */
public class JAXBWorker {

    public  static Query loadFromXml(String xml) {

        Query query = null;

        try {
            JAXBContext context = JAXBContext.newInstance(Query.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            query = (Query) unmarshaller.unmarshal(new InputSource(new StringReader(xml)));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return query;
    }
}
