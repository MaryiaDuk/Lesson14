package by.it_academy.CashBoxes;

import by.it_academy.Customer.Customer;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class CashBoxSemaphore implements CashBox {
    private Semaphore semaphore = new Semaphore(1);
    private final Queue<Customer> customerQueue;

    public CashBoxSemaphore(Queue<Customer> customerQueue) {
        this.customerQueue = customerQueue;
    }

    @Override
    public void serve() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 1; i < 3; i++) {
            executorService.submit(new CashBoxSemaphoreRun());
        }
    }

    private class CashBoxSemaphoreRun implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    semaphore.acquire();
                    Customer customer = customerQueue.poll();
                    semaphore.release();
                    if (customer != null)
                        System.out.println(customer + Thread.currentThread().getName());
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
