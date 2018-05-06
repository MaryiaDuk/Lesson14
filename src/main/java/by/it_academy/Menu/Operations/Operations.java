package by.it_academy.Menu.Operations;


import by.it_academy.CashBoxes.CashBox;
import by.it_academy.Customer.AddCustomerToQueue;

import java.util.HashMap;
import java.util.Map;

public class Operations {
    private Map<Integer, Operation> operationMap = new HashMap<>();
    AddCustomerToQueue makingQueue = new AddCustomerToQueue();
    CashBox cashBoxType;

    public void getOperationMap(int key) throws Exception {
        add();
        operationMap.get(key).execute();
    }

    private void add() {
        operationMap.put(1, new ReentrantLockOperation());
        operationMap.put(2, new SemaphoreOperation());
        operationMap.put(3, new BlockingQueueOperation());
        operationMap.put(4, new ExitOperation());
    }
}