package deadlock;
class Resource{}
public class DeadlockDemo
{
    public static void main(String[] args)
    {
        final  Resource r1=new Resource();
        final  Resource r2=new Resource();

        Thread t1=new Thread(()->{
            synchronized (r1)
            {
                System.out.println("Thread 1 locked r1");
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                synchronized (r2){
                    System.out.println("Thread 1 locked r2");
                }
            }
        });

        Thread t2=new Thread(()->{
            synchronized (r2)
            {
                System.out.println("Thread 2 locked r2");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                synchronized (r1){
                    System.out.println("Thread 2 locked r1");
                }
            }
        });

        t1.start();
        t2.start();


    }
}
