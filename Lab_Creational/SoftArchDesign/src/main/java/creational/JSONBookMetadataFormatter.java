package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JSONBookMetadataFormatter implements BookMetadataFormatter {
    private JSONObject json;
    private JSONArray array;
    

    public JSONBookMetadataFormatter() {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        // Please implement this method. You may create additional methods as you see fit.
        json = new JSONObject();
        array = new JSONArray();
        json.put(Book.class.getSimpleName() + "s",array);
        
        
        
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.
        JSONObject data = new JSONObject();
        data.put(Book.Metadata.ISBN.value, b.getISBN());
        data.put(Book.Metadata.TITLE.value, b.getTitle());
        data.put(Book.Metadata.PUBLISHER.value, b.getPublisher());
        JSONArray authors = new JSONArray();
        for (String author : b.getAuthors()) {
            authors.add(author);
        }
        data.put(Book.Metadata.AUTHORS.value, authors);
        array.add(data);

        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return json.toString();
    }
}
