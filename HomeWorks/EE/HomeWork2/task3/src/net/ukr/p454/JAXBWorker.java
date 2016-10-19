package net.ukr.p454;

import net.ukr.p454.entity.Query;
import net.ukr.p454.entity.Rate;
import net.ukr.p454.entity.Result;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by Dalvik on 19.10.2016.
 */
public class JAXBWorker {

    public  static Result loadFromXml(File xml) {

        Result query = null;

        try {
            JAXBContext context = JAXBContext.newInstance(Result.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            //query = (Query) unmarshaller.unmarshal(new InputSource(new StringReader(xml)));
            query = (Result) unmarshaller.unmarshal(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return query;
    }
}
