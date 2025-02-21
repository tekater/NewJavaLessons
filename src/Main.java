import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Stock> stocks = new ArrayList<>();

        System.out.print("Введите количество акций: ");

        int stockCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < stockCount; i++) {
            System.out.print("Введите тикер акции: ");
            String ticker = scanner.nextLine();

            System.out.print("Введите начальную цену акции: ");
            double price = scanner.nextDouble();

            System.out.print("Введите волатильность акции: ");
            double volotility = scanner.nextDouble();

            scanner.nextLine();

            stocks.add(new Stock(ticker,price,volotility));

        }
        ExecutorService executor = Executors.newFixedThreadPool(stocks.size() + 1);
        for (Stock stock:stocks) {
            executor.execute(new Trader(stock));
        }
        executor.execute(new NewsGenerator(stocks));
        System.out.println("Нажмите Enter для выключения компьютера....");

        scanner.nextLine();
        executor.shutdownNow();

        System.out.println("Симуляция завершена");

    }
}
