package ticketqueuesystem.service;

import ticketqueuesystem.module.Ticket;

import java.io.Serializable;
import java.util.Comparator;

public class TicketPriorityComparator implements Comparator<Ticket>, Serializable {


    @Override
    public int compare(Ticket t1, Ticket t2) {
        return Integer.compare(t1.getPriority(),t2.getPriority());
    }
}
