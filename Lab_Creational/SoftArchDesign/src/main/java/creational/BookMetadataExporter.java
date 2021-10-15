package creational;

import java.io.PrintStream;


public abstract class BookMetadataExporter extends BookCollection {

    public void export(PrintStream stream) {
        BookMetadataFormatter exporter = createFormatter();
        exporter.reset();
        for (Book b : books) {
            exporter.append(b);
        }
        stream.println(exporter.getMetadataString());
    }

    protected abstract BookMetadataFormatter createFormatter() ;
   
}
