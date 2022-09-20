package algorithm.sort.strategy;

import algorithm.sort.SortStrategy;

import java.util.Arrays;

public class SelectionSort implements SortStrategy {
  @Override
  public int[] doSort(int[] arr) {
    int[] result = Arrays.stream(arr).toArray();

    int minIndex;
    int index = 0;
    while(index < result.length) {
      minIndex = index;
      for(int i=index; i<result.length; i++){
        if(result[i] < result[minIndex]) { minIndex = i; }
      }

      swap(result, minIndex, index);
    }
    return result;
  }

  private void swap(int[] arr, int a, int b){
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
