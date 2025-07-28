import com.loadbalancing.LeastConnectionsStrategy;
import com.loadbalancing.LoadBalancer1;
import com.loadbalancing.RoundRobinStrategy;
import com.loadbalancing.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EcommerceLoadBalancer {


    private static final Logger logger = Logger.getLogger(EcommerceLoadBalancer.class.getName());

    public static void main(String[] args) throws InterruptedException {
        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server("A"));
        serverList.add(new Server("B"));
        serverList.add(new Server("C"));

        logger.info("Round Robin Strategy:");
        LoadBalancer1 roundRobinLB = new LoadBalancer1(serverList, new RoundRobinStrategy());
        for (int i = 1; i <= 5; i++) {
            roundRobinLB.handleRequest(i);
            Thread.sleep(300);
        }

        Thread.sleep(2000);

        logger.info("Least Connections Strategy:");
        LoadBalancer1 leastConnLB = new LoadBalancer1(serverList, new LeastConnectionsStrategy());
        for (int i = 6; i <= 10; i++) {
            leastConnLB.handleRequest(i);
            Thread.sleep(300);
        }
    }
}
