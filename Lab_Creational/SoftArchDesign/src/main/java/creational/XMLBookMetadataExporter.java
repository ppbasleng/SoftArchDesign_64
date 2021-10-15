package creational;

import javax.xml.parsers.ParserConfigurationException;



public class XMLBookMetadataExporter extends BookMetadataExporter {
    protected BookMetadataFormatter createFormatter() {
        
        try {
            return new XMLBookMetadataFormatter();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
