package ticketqueuesystem;

import ticketqueuesystem.module.Ticket;
import ticketqueuesystem.service.TicketPriorityComparator;
import ticketqueuesystem.util.QueueReaderFromFile;
import ticketqueuesystem.util.QueueWriterToFile;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class TicketQueueSystemApplication
{
    public static void main(String[] args)
    {
        PriorityQueue<Ticket> ticketQueue = new PriorityQueue<>(new TicketPriorityComparator());
        Scanner scanner = new Scanner(System.in);

        String filepath="C:\\Users\\AchalTikale\\IdeaProjects\\Atyeti_Achal_Java\\Collections\\queue\\src\\ticketqueuesystem\\util\\queuedemo.dat";

        while (true) {
            System.out.println("\n===== Customer Ticket Queue =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Next Customer");
            System.out.println("3. View Waiting Queue");
            System.out.println("4. Save Ticket Queue to File");
            System.out.println("5. Load Ticket Queue from File");
            System.out.println("6. Exit");
            System.out.print(" Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Priority? (1 = VIP, 2 = Regular): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();

                    Ticket ticket = new Ticket(name, priority);
                    ticketQueue.offer(ticket);
                    System.out.println(" Ticket created: " + ticket);
                    break;

                case 2:
                    if (!ticketQueue.isEmpty()) {
                        Ticket servedTicket = ticketQueue.poll();
                        System.out.println(" Serving: " + servedTicket);
                    } else {
                        System.out.println(" No customers in the queue.");
                    }
                    break;

                case 3:
                    if (ticketQueue.isEmpty()) {
                        System.out.println(" Queue is empty.");
                    } else {
                        System.out.println(" Current Queue:");
                        for (Ticket t : ticketQueue) {
                            System.out.println("    " + t);
                        }
                    }
                    break;
                case 4: QueueWriterToFile.writeQueueToFile(ticketQueue,filepath);
                    break;
                case 5:
                    Queue<Ticket> tickets = QueueReaderFromFile.readQueueFromFile(filepath);
                    for(Ticket ticket1 : tickets)
                    {
                        System.out.println(ticket1);
                    }
                    break;
                case 6:
                    System.out.println(" Exiting... Have a great day!");
                    return;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        }

    }
}
