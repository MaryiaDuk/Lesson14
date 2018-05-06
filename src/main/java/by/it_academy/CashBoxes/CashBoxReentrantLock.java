package by.it_academy.CashBoxes;

import by.it_academy.Customer.Customer;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class CashBoxReentrantLock implements CashBox {
    private final Queue<Customer> customerQueue;
    private ReentrantLock release = new ReentrantLock();

    public CashBoxReentrantLock(Queue<Customer> customerQueue) {
        this.customerQueue = customerQueue;
    }

    public void serve() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 1; i < 3; i++) {
            executorService.submit(new CashBoxRL());
        }
    }

    private class CashBoxRL implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    release.lock();
                    Customer customer = customerQueue.poll();
                    release.unlock();
                    if (customer != null)
                        System.out.println("LOCK "+customer + Thread.currentThread().getName());
                    else {
                        synchronized (customerQueue) {
                            customerQueue.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
