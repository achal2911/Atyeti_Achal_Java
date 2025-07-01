package ticketqueuesystem.service;

import ticketqueuesystem.module.Ticket;
import java.util.Queue;

public class TicketQueueService
{
    private Queue<Ticket> ticketQueue;

    public void addTicket(String name, int priority) {
        Ticket ticket = new Ticket(name, priority);
        boolean added = ticketQueue.offer(ticket);

        if (added) {
            System.out.println("Ticket added: " + ticket);
        } else {
            System.out.println("Failed to add ticket.");
        }
    }


    public void serveNextTicket() {
        Ticket next = ticketQueue.poll();
        if (next != null) {
            System.out.println("Serving: " + next);
        } else {
            System.out.println("No tickets to serve.");
        }
    }


    public void peekCurrentTicket() {
        Ticket peek = ticketQueue.peek();
        if (peek != null) {
            System.out.println("Current ticket: " + peek);
        } else {
            System.out.println("Queue is empty.");
        }
    }


    public void displayAllTickets() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            System.out.println("All pending tickets:");
            for (Ticket t : ticketQueue) {
                System.out.println("   ->" + t);
            }
        }
    }

}
