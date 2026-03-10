package interthreadcommunnication;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ITCWithBlockingQueue
{

    public static void main(String[] args) {
        BlockingQueue<Integer>queue=new ArrayBlockingQueue<>(3);

        new Thread(()->{
            for(int i=0;i<=5;i++){

                try {
                    queue.put(i);
                    System.out.println("Produced:"+i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();
        new Thread(()->{
           while (true){
               try {
                   int val=queue.take();
                   System.out.println("Consumed:"+val);
               } catch (InterruptedException e) {

               }
           }
        }).start();

    }
}
