package by.it_academy.Menu;

import by.it_academy.CashBoxes.CashBoxSemaphore;
import by.it_academy.Customer.AddCustomerToQueue;
import by.it_academy.Menu.Operations.Operations;

import java.util.Scanner;

public class Menu implements Skin {
    private int choice;
    private Operations operations = new Operations();

    @Override
    public int skin() {
        System.out.println("1 - ReentrantLock\n" + "2 - Semaphore\n" + "3 - BlockingQueue\n" + "4 - Выход");
        Scanner scanner = new Scanner(System.in);
        choice=scanner.nextInt();
        return choice;
    }

    public void start() throws Exception {
        while (true)
            operations.getOperationMap(skin());
    }
}

