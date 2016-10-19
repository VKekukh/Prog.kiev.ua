package net.ukr.p454;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by vkekukh on 19.10.2016.
 */
public class TrainStationXmlParser {
    public static TrainStation load(File file) {
        TrainStation trainStation = new TrainStation();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(file);

            Element root = document.getDocumentElement();

            String nameStation = root.getElementsByTagName("name").item(0).getTextContent();
            trainStation.setName(nameStation);

            NodeList nodeList = root.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    Train train = getTrainFromNode(element);

                    if(element != null){
                        trainStation.add(train);
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        return trainStation;
    }

    public static Train getTrainFromNode(Element trainNode) {
        if (!trainNode.getTagName().equalsIgnoreCase("train")) {
            return null;
        }
        int id = Integer.valueOf(trainNode.getAttribute("id"));
        String from = trainNode.getElementsByTagName("from").item(0).getTextContent();
        String to = trainNode.getElementsByTagName("to").item(0).getTextContent();
        String dateText = trainNode.getElementsByTagName("date").item(0).getTextContent();
        String departureText = trainNode.getElementsByTagName("departure").item(0).getTextContent();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateText, dtf);

        dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime departure = LocalTime.parse(departureText, dtf);

        Train train = new Train(id, from, to, date, departure);
        return train;
    }
}
