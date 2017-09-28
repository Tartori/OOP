package Exam2;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by julian on 05-Apr-17.
 */
public class CDParser {


    // These are labels for our elements
    static final String TITLE = "title";
    static final String ARTIST = "artist";
    static final String COUNTRY = "country";
    static final String COMPANY = "company";
    static final String PRICE = "price";
    static final String YEAR = "year";
    static final String CD = "cd";

    final URL url;

    public CDParser(String feedUrl) {
        try {this.url = new URL(feedUrl);}
        catch (MalformedURLException e) {throw new RuntimeException(e);}
    }

    public CDParser(URL url) {this.url = url;}

    public ArrayList<CD> readCDS() {
        ArrayList<CD> cds = new ArrayList<CD>();
        try {

            // Set header values initially to the empty string
            String title = "";
            String artist = "";
            String country = "";
            String company = "";
            double price = 0.0;
            int year=0;

            // First create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();

            // Setup a new eventReader
            InputStream in = initInputStream();
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

            // read the XML document
            while (eventReader.hasNext()) {

                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    String localPart = event.asStartElement().getName().getLocalPart();

                    switch (localPart) {
                        case TITLE:
                            title = getCharacterData(event, eventReader);
                            break;
                        case ARTIST:
                            artist = getCharacterData(event, eventReader);
                            break;
                        case COUNTRY:
                            country = getCharacterData(event, eventReader);
                            break;
                        case COMPANY:
                            company = getCharacterData(event, eventReader);
                            break;
                        case PRICE:
                            String tmpPrice = getCharacterData(event, eventReader);
                            try {
                                price= Double.parseDouble(tmpPrice);
                            }
                            catch (Exception ex){
                                System.out.print("Can't handle price from cd " +title+" \n" +  ex.getStackTrace());
                                price=0.0;
                            }
                            break;
                        case YEAR:
                            String tmpYear = getCharacterData(event, eventReader);
                            try {
                                year= Integer.parseInt(tmpYear);
                            }
                            catch (Exception ex){
                                System.out.print("Can't handle year from cd " +title+" \n" +  ex.getStackTrace());
                                year=0;
                            }

                            break;
                    }
                } else if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart() == (CD)) {
                        cds.add(new CD(title,artist,country,company, price, year));
                        event = eventReader.nextEvent();
                        continue;
                    }
                }
            }
        }
        catch (XMLStreamException e) {throw new RuntimeException(e);}
        return cds;
    }

    private String getCharacterData(XMLEvent event, XMLEventReader eventReader)
            throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) result = event.asCharacters().getData();
        return result;
    }

    private InputStream initInputStream() {
        try{return url.openStream();}
        catch (IOException e) {throw new RuntimeException(e);}
    }
}