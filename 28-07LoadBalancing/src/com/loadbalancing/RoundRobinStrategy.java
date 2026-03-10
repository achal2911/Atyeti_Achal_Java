package com.loadbalancing;

import java.util.List;

public class RoundRobinStrategy implements LoadBalancingStrategy {
    private int index = 0;

    @Override
    public synchronized Server selectServer(List<Server> servers) {
        Server server = servers.get(index);
        index = (index + 1) % servers.size();
        return server;
    }
}

