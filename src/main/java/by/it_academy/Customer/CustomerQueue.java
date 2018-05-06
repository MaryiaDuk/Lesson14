package by.it_academy.Customer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class CustomerQueue {
    private Queue<Customer> list = new LinkedList<>();
    private BlockingQueue<CustomerQueue> blockingQueue = new LinkedBlockingDeque<>();

    public CustomerQueue addCustomer(Customer customer) {
        list.add(customer);
        return this;
    }

    public Queue<Customer> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "CustomerQueue{" +
                "list=" + list +
                '}';
    }
}
