import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow.Subscription;

public class AlphabetSubscriber extends StringSubscriber {

    AlphabetSubscriber(long bufferSize, FileWriter writer) {
        super(bufferSize, writer);
        System.out.println("alphabet subscriber:"+bufferSize);
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        long initialRequestSize = bufferSize;
        count = bufferSize - bufferSize / 2; // re-request when half consumed
        (this.subscription = subscription).request(initialRequestSize);

    }

    @Override
    public void onNext(String item) {
        System.out.println("Alphabet onNext() Triggered: count="+count);
        if (--count <= 0)
            subscription.request(count = bufferSize - bufferSize / 2);
        try {
            
            if(item.matches(".*[a-zA-Z].*")){
                System.out.println("writing alphabet.txt:"+item);
                writer.write(item+"\n");
            }else{
                System.out.println("alphabet.txt is not written");
            }
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }

    }

}
