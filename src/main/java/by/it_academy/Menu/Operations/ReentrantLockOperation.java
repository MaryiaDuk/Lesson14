package by.it_academy.Menu.Operations;


import by.it_academy.CashBoxes.CashBoxReentrantLock;

public class ReentrantLockOperation extends Operations implements Operation {
    @Override
    public void execute() throws Exception{
        cashBoxType = new CashBoxReentrantLock(makingQueue.add().getList());
        cashBoxType.serve();
    }
}
