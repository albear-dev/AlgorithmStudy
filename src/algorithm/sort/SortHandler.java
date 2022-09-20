package algorithm.sort;

public class SortHandler {
  private final SortStrategy strategy;

  public SortHandler(SortStrategy strategy){
    this.strategy = strategy;
  }

  public int[] doSort(int[] arr){
    return strategy.doSort(arr);
  }
}
