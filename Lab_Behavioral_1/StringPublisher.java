
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

public class StringPublisher implements Publisher<String>{
    // private final ExecutorService executor = ForkJoinPool.commonPool();
    private final ExecutorService executor = Executors.newFixedThreadPool(3);
    private List<StringSubscription> subscriptions = Collections.synchronizedList(new ArrayList<StringSubscription>());
    // private boolean subscribed;

    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
       
        StringSubscription subscription = new StringSubscription(subscriber,executor);
        subscriptions.add(subscription);
        subscriber.onSubscribe(subscription);
        
        
    }

    public void publish(String text){
        for(StringSubscription subscription : subscriptions){
            subscription.publish(text);
        }
        System.out.println("executor is shutting down");
        executor.shutdown();
        System.out.println("executor is shut down");
    }
    
    
}
