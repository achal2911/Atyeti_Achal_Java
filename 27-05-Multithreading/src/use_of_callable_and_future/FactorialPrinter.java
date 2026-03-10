package use_of_callable_and_future;

import java.util.concurrent.Callable;

public class FactorialPrinter implements Callable<Long> {

    private long number;

    public FactorialPrinter(long number) {
        this.number = number;
    }

    @Override
    public Long call() throws Exception {
        long fact=1;
        for(int i=1;i<=number;i++)
        {
            fact=fact*i;
        }

        System.out.println("factorial of " + number + "is in "+ Thread.currentThread().getName());
        return fact;
    }
}
