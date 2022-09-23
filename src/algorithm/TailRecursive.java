package algorithm;

/**
 * Java 에서는 꼬리재귀 최적화를 하지 않음.
 * Stackoverflow 발생함
 */
public class TailRecursive {
  public static void main(String[] args){
    long num = 10;
    long result1 = new TailRecursive().factorial(num);
    long result2 = new TailRecursive().loopFactorial(num);
    long result3 = new TailRecursive().tailFactorial(num, 1);

    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);
  }

  private long factorial(long n){
    if(n == 1) return 1;
    return n * factorial(n-1);
  }

  private long tailFactorial(long n, long total){
    if(n == 1) return total;
    return tailFactorial(n-1, n * total);
  }

  private long loopFactorial(long n){
    long result = 1;
    for(int i=1; i<n+1; i++){
        result *= i;
    }

    return result;
  }

}
