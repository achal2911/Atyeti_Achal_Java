package com.loadbalancing;

import java.util.logging.Logger;

public class Server {
    private String name;
    private int activeConnections = 0;

    public Server(String name) {
        this.name = name;
    }


    public int getActiveConnections() {
        return activeConnections;
    }

    public void handleRequest(int requestId) {
        new Thread(() -> {
            incrementConnections();

            System.out.println("Server-" + name + " handling request ID: " + requestId + " | Active: " + activeConnections);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            decrementConnections();
            System.out.println("Server-" + name + " finished request ID: " + requestId + " | Active: " + activeConnections);
        }).start();
    }

    private synchronized void incrementConnections() {
        activeConnections++;
    }

    private synchronized void decrementConnections() {
        activeConnections--;
    }
}

