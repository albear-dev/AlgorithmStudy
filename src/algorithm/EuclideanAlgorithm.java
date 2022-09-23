package algorithm;

public class EuclideanAlgorithm {
  public static void main(String[] args){
    int result = new EuclideanAlgorithm().gcd(1071, 1029);
    System.out.println(result);
  }

  private int gcd(int a, int b){
    if(b == 0) return a;
    return gcd(b, a%b);
  }
}
