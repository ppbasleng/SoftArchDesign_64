
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

public class StringPublisher implements Publisher<String>{
    private final ExecutorService executor = ForkJoinPool.commonPool();
    private boolean subscribed;

    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        if(subscribed) {
            subscriber.onError(new IllegalStateException("Subscriber is already subscribed"));
        }else{
            subscribed = true;
            subscriber.onSubscribe(new StringSubscription(subscriber,executor));
        }
        
    }

    
    
}
