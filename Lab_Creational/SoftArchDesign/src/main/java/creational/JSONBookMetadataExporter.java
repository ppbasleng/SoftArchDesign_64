package creational;


public class JSONBookMetadataExporter extends BookMetadataExporter {
    protected BookMetadataFormatter createFormatter(){
        return new JSONBookMetadataFormatter();
    }
}
