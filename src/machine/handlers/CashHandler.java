package machine.handlers;

public class CashHandler {
    private int totalCash;

    public int getTotalCash() {
        return totalCash;
    }

    public void addCash(int cash) {
        totalCash += cash;
    }

    public void reduceCash(int cash) {
        totalCash -= cash;
    }
}
