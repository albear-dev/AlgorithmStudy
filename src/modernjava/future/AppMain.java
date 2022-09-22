package modernjava.future;

import java.util.concurrent.*;

public class AppMain {
  public static void main(String[] args) throws Exception {
    new AppMain().doProcess();
  }

  private void doProcess() {
    ExecutorService executor = Executors.newCachedThreadPool();
    Future<Double> future = executor.submit(() -> doSumeLongComputation());
    Double elseValue = doSomethingElse();
    System.out.println(elseValue);

    try {
      System.out.println("Block??");
      Double result = future.get(10, TimeUnit.SECONDS);
      System.out.println("End??");
      System.out.println(result);
    } catch (ExecutionException ee) {
      // 계산 중 예외 발생
    } catch (InterruptedException ie) {
      // 현재 스레드에서 대기 중 인터럽트 발생
    } catch (TimeoutException te) {
      // Future가 완료되기 전에 타임아웃 발생
    }

    executor.shutdown();
  }

  private Double doSumeLongComputation() throws InterruptedException {
    Thread.sleep(5000);
    return 100d;
  }

  private Double doSomethingElse() {
    return 999d;
  }
}
