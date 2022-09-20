package algorithm.sort;

import algorithm.sort.strategy.BubbleSort;
import algorithm.sort.strategy.QuickSort2;
import algorithm.sort.strategy.SelectionSort;

public class SortFactory {

  public static SortStrategy create(SortStrategy.Type strategy) throws Exception {
    return switch (strategy){
      case Quick -> new QuickSort2();
      case Bubble -> new BubbleSort();
      case Selection -> new SelectionSort();
      default -> throw new Exception();
    };
  }

}
