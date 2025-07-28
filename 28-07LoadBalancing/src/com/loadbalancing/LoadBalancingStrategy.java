package com.loadbalancing;
import java.util.List;

public interface LoadBalancingStrategy {
    Server selectServer(List<Server> servers);
}
