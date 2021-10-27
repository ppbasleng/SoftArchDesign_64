import java.io.FileWriter;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public abstract class StringSubscriber implements Subscriber<String> {
    FileWriter writer;
    Subscription subscription;
    final long bufferSize;
    long count;
    StringSubscriber(long bufferSize, FileWriter writer){
        this.bufferSize = bufferSize;
        this.writer = writer;
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();

    }

    @Override
    public void onComplete() {
        // TODO Auto-generated method stub

    }

}
