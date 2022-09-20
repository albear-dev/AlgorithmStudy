package algorithm.sort.strategy;

import algorithm.sort.SortStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class QuickSort implements SortStrategy {

  @Override
  public int[] doSort(int[] arr) {
    if(arr.length <= 1){ return arr; }
    int pivot = arr[arr.length/2];

    final List<Integer> lowers = new ArrayList<>();
    final List<Integer> highers = new ArrayList<>();
    final List<Integer> pivots = new ArrayList<>();

    for (int v : arr) {
      if (pivot > v) {
        lowers.add(v);
      } else if (pivot < v) {
        highers.add(v);
      } else {
        pivots.add(v);
      }
    }

    return mergeArray(doSort(lowers), toIntArray(pivots), doSort(highers));
  }

  public int[] doSort(List<Integer> list) {
    return doSort(toIntArray(list));
  }

  private int[] toIntArray(List<Integer> list){
    return list.stream().mapToInt(Integer::intValue).toArray();
  }

  private int[] mergeArray(int[]... arr){
    return Stream.of(arr).flatMapToInt(Arrays::stream).toArray();
  }

}

