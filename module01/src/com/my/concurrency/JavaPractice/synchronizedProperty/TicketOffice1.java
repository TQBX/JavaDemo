package com.my.concurrency.JavaPractice.synchronizedProperty;

/**
 * @auther Summerday
 */
public class TicketOffice1 implements Runnable{

    private Cinema cinema;
    public TicketOffice1(Cinema cinema){
        this.cinema = cinema;
    }
    @Override
    public void run() {
        cinema.sellTickets1(3);
        cinema.sellTickets1(3);
        cinema.sellTickets1(3);
        cinema.sellTickets2(2);
        cinema.sellTickets2(5);
        cinema.sellTickets1(3);
        cinema.returnTickets1(3);
    }
}
