import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow.Subscription;

public class NumberSubscriber extends StringSubscriber {

    NumberSubscriber(long bufferSize, FileWriter writer) {
        super(bufferSize, writer);
        System.out.println("number:"+bufferSize);
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        long initialRequestSize = bufferSize;
        count = bufferSize - bufferSize / 2; // re-request when half consumed
        (this.subscription = subscription).request(initialRequestSize);


    }

    @Override
    public void onNext(String item) {
        System.out.println("Number Onnext Triggered: count="+count);
        if (--count <= 0)
            subscription.request(count = bufferSize - bufferSize / 2);
        try {
            if(item.matches(".*\\d.*")){
                System.out.println("number:"+item);
                writer.write(item);
            }else{
                System.out.println("number is not written");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
