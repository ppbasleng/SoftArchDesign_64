import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class StringSubscription implements Subscription {
    private final Subscriber<? super String> subscriber;
    private final ExecutorService executor;
    private Future<?> future; // to allow cancellation
    private boolean completed;
    private String message;

    StringSubscription(Subscriber<? super String> subscriber, ExecutorService executor) {
        // System.out.println(subscriber+"\n"+executor);
        this.subscriber = subscriber;
        this.executor = executor;
    }

    @Override
    public void request(long n) {
        if (n != 0 && !completed) {
            completed = true;
            if (n < 0) {
                IllegalArgumentException ex = new IllegalArgumentException();
                executor.execute(() -> subscriber.onError(ex));
                
            } else {
                future = executor.submit(() -> {
                    subscriber.onNext(message);
                    subscriber.onComplete();
                });
                
            }
        }

    }

    @Override
    public void cancel() {
        completed = true;
        if (future != null)
            future.cancel(false);

    }

    public void publish(String text){
        message = text;
    }

}
