package modernjava.future2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * https://velog.io/@ehdrms2034/Java-8-%EC%95%88%EC%A0%95%EC%A0%81-%EB%B9%84%EB%8F%99%EA%B8%B0-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-Completable-Future#%EB%B9%84%EB%8F%99%EA%B8%B0-api-%EA%B5%AC%ED%98%84
 */
public class AppMain {
  private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"), new Shop("LetsSaveBig"), new Shop("MyFavoriteShop"), new Shop("BuyItAll"), new Shop("SuperShop"));
  private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), r -> {
    Thread t = new Thread(r);
    t.setDaemon(true);
    return t;
  });

  public static void main(String[] args) {
//    new AppMain().doProcess();
    System.out.println(Runtime.getRuntime().availableProcessors());
    new AppMain().doProcess2();
  }

//  private void doProcess() {
//    long start = System.nanoTime();
//    Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
//    long invocationTime = ((System.nanoTime() - start) / 1_000_000);
//    System.out.println("Invocation returned after " + invocationTime + "msecs");
//
//    doSomethingElse();
//
//    try {
//      double price = futurePrice.get();
//      System.out.printf("Price is %.2f%n", price);
//    } catch (Exception e) {
//      throw new RuntimeException(e);
//    }
//
//    long retreivalTime = ((System.nanoTime() - start) / 1_000_000);
//    System.out.println("Price returned after " + retreivalTime + " msecs");
//  }

  private void doProcess2() {
    long start = System.nanoTime();
//    System.out.println(findPrices("myPhone27S"));
//    System.out.println(findPricesFuture("myPhone27S"));
//    System.out.println(findPricesApplyDiscount("myPhone27S"));
    System.out.println(findPricesApplyDiscountFuture("myPhone27S"));

    long duration = (System.nanoTime() - start) / 1_000_000;
    System.out.println("Done in " + duration + " msecs");
  }

  public List<String> findPricesOld(String product) {
    return shops.parallelStream()
        .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
        .collect(Collectors.toList());
  }

  public List<String> findPricesFuture(String product) {
    List<CompletableFuture<String>> priceFutures = shops.stream()
        .map(shop ->
                CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product), executor)
        )
        .collect(Collectors.toList());

    return priceFutures.stream()
        .map(CompletableFuture::join)
        .collect(Collectors.toList());
  }

  public List<String> findPricesApplyDiscount(String product) {
    return shops.stream()
        .map(shop -> shop.getPrice(product))
        .map(Quote::parse)
        .map(Discount::applyDiscount)
        .collect(Collectors.toList());
  }

  public List<String> findPricesApplyDiscountFuture(String product) {
    List<CompletableFuture<String>> priceFutures =
        shops.stream()
            .map(shop -> CompletableFuture.supplyAsync(() ->
                shop.getPrice(product), executor))
            .map(future -> future.thenApply(Quote::parse))
            .map(future -> future.thenCompose(quote ->
                CompletableFuture.supplyAsync(() ->
                    Discount.applyDiscount(quote), executor))
            )
            .collect(Collectors.toList());

    return priceFutures.stream()
        .map(CompletableFuture::join)
        .collect(Collectors.toList());
}

  private void doSomethingElse() {
    System.out.println("Blah~ Blah~");
  }
}
