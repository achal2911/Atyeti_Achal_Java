package multi_threaded_counter_app;

public class IncrementTask implements Runnable{

    private final SharedCounter counter;
    public IncrementTask( SharedCounter counter)
    {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++)
        {
           counter.increment();
        }
    }
}
