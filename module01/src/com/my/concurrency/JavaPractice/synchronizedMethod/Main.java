package com.my.concurrency.JavaPractice.synchronizedMethod;

/**
 * @auther Summerday
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        System.out.println("Profiler : Initial Balance: "+account.getBalance());

        companyThread.start();
        bankThread.start();

        try{
            companyThread.join();
            bankThread.join();
            System.out.println("Profiler : Final Balance: "+account.getBalance());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
