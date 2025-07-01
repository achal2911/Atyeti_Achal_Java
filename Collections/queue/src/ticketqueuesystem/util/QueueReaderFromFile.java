package ticketqueuesystem.util;

import ticketqueuesystem.module.Ticket;
import ticketqueuesystem.service.TicketPriorityComparator;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueReaderFromFile {
    public static Queue<Ticket> readQueueFromFile(String filepath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            PriorityQueue<Ticket> queue = (PriorityQueue<Ticket>) ois.readObject();
            PriorityQueue<Ticket> reconstructedQueue = new PriorityQueue<>(new TicketPriorityComparator());
            reconstructedQueue.addAll(queue);
            System.out.println("Queue loaded from file.");
            return reconstructedQueue;
        } catch (Exception e) {
            System.out.println("No existing queue found at " + filepath + ". Starting fresh.");
            return new PriorityQueue<>(new TicketPriorityComparator());
        }
    }
}
