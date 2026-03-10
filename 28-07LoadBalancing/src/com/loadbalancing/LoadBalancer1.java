package com.loadbalancing;

import java.util.List;

public class LoadBalancer1 {
    private final List<Server> servers;
    private final LoadBalancingStrategy strategy;

    public LoadBalancer1(List<Server> servers, LoadBalancingStrategy strategy) {
        this.servers = servers;
        this.strategy = strategy;
    }

    public void handleRequest(int requestId) {
        Server server = strategy.selectServer(servers);
        server.handleRequest(requestId);
    }
}
