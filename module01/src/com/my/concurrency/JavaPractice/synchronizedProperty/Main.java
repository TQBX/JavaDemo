package com.my.concurrency.JavaPractice.synchronizedProperty;

/**
 * @auther Summerday
 */
public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(20,20);

        TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
        TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);

        Thread t1 = new Thread(ticketOffice1);
        Thread t2 = new Thread(ticketOffice2);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("room 1 vacancies: "+cinema.getVacanciesCinema1());
        System.out.println("room 2 vacancies: "+cinema.getVacanciesCinema2());
    }
}
