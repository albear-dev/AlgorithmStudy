package algorithm.sort.strategy;

import algorithm.sort.SortStrategy;

import java.util.Arrays;

public class BubbleSort implements SortStrategy {

  @Override
  public int[] doSort(int[] arr) {
    int[] result = Arrays.copyOf(arr, arr.length);

    int maxIndex = arr.length;
    while(maxIndex > 1) {
      for (int i=0; i<maxIndex-1; i++) {
        int a = result[i];
        int b = result[i+1];
//        System.out.println("compare a["+a+"] b["+b+"]");
        if (a > b) {
          result[i] = b;
          result[i+1] = a;
        }
      }
      maxIndex--;
    }

    return result;
  }
}
