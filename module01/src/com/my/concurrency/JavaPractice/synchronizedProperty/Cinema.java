package com.my.concurrency.JavaPractice.synchronizedProperty;

/**
 * @auther Summerday
 */
public class Cinema {
    private long vacanciesCinema1;
    private long vacanciesCinema2;
    private final Object controlCinema1,controlCinema2;

    //initialize all properties
    public Cinema(long vacanciesCinema1, long vacanciesCinema2) {
        this.vacanciesCinema1 = vacanciesCinema1;
        this.vacanciesCinema2 = vacanciesCinema2;
        this.controlCinema1 = new Object();
        this.controlCinema2 = new Object();
    }

    public boolean sellTickets1 (int number){
        synchronized (controlCinema1) {
            if (number < vacanciesCinema1) {
                vacanciesCinema1 -= number;
                return true;
            } else {
                return false;
            }
        }
    }
    public boolean sellTickets2 (int number){
        synchronized (controlCinema2) {
            if (number < vacanciesCinema2) {
                vacanciesCinema2 -= number;
                return true;
            } else {
                return false;
            }
        }
    }
    public boolean returnTickets1(int number){
        synchronized (controlCinema1){
            vacanciesCinema1+=number;
            return true;
        }
    }
    public boolean returnTickets2(int number){
        synchronized (controlCinema2){
            vacanciesCinema2+=number;
            return true;
        }
    }


    public long getVacanciesCinema1(){
        return vacanciesCinema1;
    }
    public long getVacanciesCinema2(){
        return vacanciesCinema2;
    }


}
