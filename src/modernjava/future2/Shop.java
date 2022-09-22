package modernjava.future2;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public class Shop {
  private String name;
  private ExchangeService exchangeService;
  private static final Random random = new Random();

  public Shop(String name) {
    this.name = name;
    this.exchangeService = new ExchangeService();
  }

  public String getPrice(String product) {
    double price = calculatePrice(product);
    Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
    return String.format("%s:%.2f:%s", name, price, code);
  }


  public String getName() {
    return this.name;
  }

  /**
   * CompletableFuture 직접 사용 및 Exception 처리
   *
   * @param product
   * @return
   */
//  public Future<Double> getPriceAsync(String product) {
//    CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//    new Thread(() -> {
//      try {
//        double price = calculatePrice(product);
//        futurePrice.complete(price);
//      } catch (Exception ex) {
//        futurePrice.completeExceptionally(ex);
//      }
//    }).start();
//    return futurePrice;
//  }

  /**
   * 팩토리 메서드 supplyAsync 로 만들기
   *
   * @param product
   * @return
   */
  public Future<Double> getPriceAsync(String product, Executor executor) {
    return CompletableFuture.supplyAsync(() -> calculatePrice(product), executor);
  }

  private double calculatePrice(String product) {
    delay();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }

  public static void delay() {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException();
    }
  }
}
