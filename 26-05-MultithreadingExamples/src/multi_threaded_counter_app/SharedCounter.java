package multi_threaded_counter_app;
import java.util.concurrent.atomic.AtomicInteger;
public class SharedCounter {

    private static final AtomicInteger count = new AtomicInteger(0);

    public void increment()
    {
        count.getAndIncrement();
    }

    public int getCount()
    {
        return count.get();
    }
}
