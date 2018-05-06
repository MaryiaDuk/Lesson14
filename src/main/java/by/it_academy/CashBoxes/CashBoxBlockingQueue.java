package by.it_academy.CashBoxes;

import by.it_academy.Customer.Customer;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class CashBoxBlockingQueue implements CashBox {
    private BlockingQueue<Customer> customerQueue;

    public CashBoxBlockingQueue(Queue<Customer> customer) {
        customerQueue = new LinkedBlockingQueue<>(customer);
    }

    @Override
    public void serve() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 1; i < 3; i++) {
            executorService.submit(new CashBoxBQ());
        }
    }

    private class CashBoxBQ implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    Customer customer = customerQueue.poll();
                    if (customer != null) {
                        System.out.println("BlockQueue " + customer + Thread.currentThread().getName());
                    } else {
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
