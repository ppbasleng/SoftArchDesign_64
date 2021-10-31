import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow.Subscription;

public class SymbolSubscriber extends StringSubscriber{

    SymbolSubscriber(long bufferSize, FileWriter writer) {
        super(bufferSize, writer);
        System.out.println("symbol subscriber:"+bufferSize);
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        long initialRequestSize = bufferSize;
        count = bufferSize - bufferSize / 2; // re-request when half consumed
        (this.subscription = subscription).request(initialRequestSize);

    }

    @Override
    public void onNext(String item) {
        System.out.println("Symbol onNext() Triggered: count="+count);
        if (--count <= 0)
            subscription.request(count = bufferSize - bufferSize / 2);
        try {
            if(item.matches(".*[^a-zA-Z 0-9].*")){
                System.out.println("writing symbol.txt:"+item);
                writer.write(item+"\n");
            }else{
                System.out.println("symbol.txt is not written");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
