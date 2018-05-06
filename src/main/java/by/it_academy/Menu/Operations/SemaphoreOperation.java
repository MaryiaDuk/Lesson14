package by.it_academy.Menu.Operations;


import by.it_academy.CashBoxes.CashBoxSemaphore;

public class SemaphoreOperation extends Operations implements Operation {
    @Override
    public void  execute() throws Exception{
        cashBoxType = new CashBoxSemaphore(makingQueue.add().getList());
        cashBoxType.serve();
    }
}
