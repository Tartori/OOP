

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RSSFeedParser {
	private URL url;
	
	private static final String titleElement = "title";
	private static final String linkElement = "link";
	private static final String descriptionElement = "description";
	private static final String languageElement = "language";
	private static final String copyrightElement = "copyright";
	private static final String pubDateElement = "pubDate";
	private static final String itemElement = "item";
		
	// Read from URL. Note: String gets converted to URL automagically!
	public RSSFeedParser(URL url){
		this.url = url;
	}
	
	public Feed readFeed() throws IOException, XMLStreamException {
		try(InputStream inputStream = this.url.openStream()){
			XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
			XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);
			
			String            feedTitle;
			String            feedLink;
			String            feedDescription;
			String            feedLanguage;
			String            feedCopyright;
			String            feedPubDate;
			List<FeedMessage> feedMessages = new ArrayList<FeedMessage>();
			
			// Read Feed from XML
			while(xmlEventReader.hasNext()){
				XMLEvent nextEvent = xmlEventReader.nextEvent();
				if(nextEvent.isStartElement()){
					StartElement startElement = nextEvent.asStartElement();
					String localPart = startElement.getName().getLocalPart();
					switch (localPart){
						case titleElement:
							feedTitle = xmlEventReader.nextEvent().asCharacters().getData();
							break;
						case linkElement:
							feedLink = xmlEventReader.nextEvent().asCharacters().getData();
							break;
						case descriptionElement:
							feedDescription = xmlEventReader.nextEvent().asCharacters().getData();
							break;
						case languageElement:
							feedLanguage = xmlEventReader.nextEvent().asCharacters().getData();
							break;
						case copyrightElement:
							feedCopyright = xmlEventReader.nextEvent().asCharacters().getData();
							break;
						case pubDateElement:
							feedPubDate = xmlEventReader.nextEvent().asCharacters().getData();
							break;
						case itemElement:
							FeedMessage feedMessage = new FeedMessage();
							while(xmlEventReader.hasNext()){
								XMLEvent feedMessageEvent = xmlEventReader.nextEvent();
								if(feedMessageEvent.isStartElement()){
									StartElement feedMessageStartElement = feedMessageEvent.asStartElement();
									localPart = feedMessageStartElement.getName().getLocalPart();
									switch (localPart){
										case titleElement:
											feedMessage.setTitle(xmlEventReader.nextEvent().asCharacters().getData());
											break;
										case descriptionElement:
											feedMessage.setDescription(xmlEventReader.nextEvent().asCharacters().getData());
											break;
										case linkElement:
											feedMessage.setLink(xmlEventReader.nextEvent().asCharacters().getData());
											break;
										default:
											break;
									}
								}
							}
							feedMessages.add(feedMessage);
							break;
						default:
							break;
					}
				}
			}
			
			return new Feed(feedTitle, feedLink, feedDescription, feedLanguage, feedCopyright, feedPubDate, feedMessages);
			
		} catch(Exception e){
			throw e;
		}
	}
}
