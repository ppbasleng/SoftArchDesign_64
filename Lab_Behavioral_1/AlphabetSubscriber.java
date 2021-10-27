import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow.Subscription;

public class AlphabetSubscriber extends StringSubscriber {

    AlphabetSubscriber(long bufferSize, FileWriter writer) {
        super(bufferSize, writer);

    }

    @Override
    public void onSubscribe(Subscription subscription) {
        long initialRequestSize = bufferSize;
        count = bufferSize - bufferSize / 2; // re-request when half consumed
        (this.subscription = subscription).request(initialRequestSize);

    }

    @Override
    public void onNext(String item) {
        System.out.println("Alphabet Onnext Triggered");
        if (--count <= 0)
            subscription.request(count = bufferSize - bufferSize / 2);
        try {
            System.out.println(item);
            writer.write(item);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
