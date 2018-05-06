package by.it_academy.Menu.Operations;

import by.it_academy.CashBoxes.CashBoxBlockingQueue;

public class BlockingQueueOperation extends Operations implements Operation {
    @Override
    public void execute() throws Exception{
        cashBoxType = new CashBoxBlockingQueue(makingQueue.add().getList());
        cashBoxType.serve();
    }
}
