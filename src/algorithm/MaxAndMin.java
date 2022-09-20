package algorithm;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxAndMin {
  public static void main(String[] args){
    String test = "1 -4 5 9 -9";
    String result = new MaxAndMin().solution(test);

    System.out.println(result);
  }

    public String solution(String s) {
      int min = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).min().orElseThrow(NoSuchElementException::new);
      int max = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).max().orElseThrow(NoSuchElementException::new);

     return min + " " + max ;
  }

}
