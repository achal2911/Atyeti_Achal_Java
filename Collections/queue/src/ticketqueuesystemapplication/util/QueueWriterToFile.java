package ticketqueuesystemapplication.util;

import ticketqueuesystemapplication.module.Ticket;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.PriorityQueue;

public class QueueWriterToFile {
    public static void writeQueueToFile(PriorityQueue<Ticket> queue, String filepath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath,true))) {
            oos.writeObject(queue);
            System.out.println("Queue saved to file.");


        } catch (Exception e) {
            System.out.println("Failed to save queue to file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
