package net.ukr.p454;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.time.format.DateTimeFormatter;

/**
 * Created by vkekukh on 19.10.2016.
 */
public class TrainStationToXml {
    public static void save(TrainStation station, String filename) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("trainStation");
            document.appendChild(root);

            Element name = document.createElement("name");
            name.setTextContent(station.getName());
            root.appendChild(name);

            for (Train train : station.getTrains()){
                root.appendChild(getTrainElement(train,document));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult stRes = new StreamResult(filename);

            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");


            transformer.transform(source, stRes);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static Element getTrainElement(Train train, Document document){
        Element trainElement = document.createElement("train");
        trainElement.setAttribute("id", String.valueOf(train.getId()));

        Element from = document.createElement("from");
        from.setTextContent(train.getFrom());
        trainElement.appendChild(from);

        Element to = document.createElement("to");
        to.setTextContent(train.getTo());
        trainElement.appendChild(to);

        Element date = document.createElement("date");
        date.setTextContent(train.getDate().toString());
        trainElement.appendChild(date);

        Element departure = document.createElement("departure");
        departure.setTextContent(train.getDeparture().format(DateTimeFormatter.ofPattern("HH:mm")));
        trainElement.appendChild(departure);


        return trainElement;
    }
}
