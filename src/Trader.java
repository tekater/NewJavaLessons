public class Trader implements Runnable{

    private final Stock stock;
    public Trader(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        while (true) {
            stock.updatePrice();
            System.out.println("Цена акции " + stock.getTicket() + ": " + stock.getPrice());

        }
    }
}
