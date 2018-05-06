package by.it_academy.Menu.Operations;

public class ExitOperation implements Operation {
    @Override
    public void execute() throws Exception {
        System.exit(0);
    }
}
