package algorithm.sort;

import java.util.Arrays;

public class SortMain {
  public static void main(String[] args) throws Exception {
    int[] arr = {11,7,4,8,2,9,3,77,5,341,42,782,2};
    new SortMain().doProcess(arr);
  }

  public void doProcess(int[] arr) throws Exception {
    bubbleSort(arr);
    quickSort(arr);
    selectionSort(arr);
  }

  private void bubbleSort(int[] arr) throws Exception {
    SortHandler handler = new SortHandler(SortFactory.create(SortStrategy.Type.Bubble));
    int[] result = handler.doSort(arr);

    System.out.println(Arrays.toString(result));
  }

  private void quickSort(int[] arr) throws Exception {
    SortHandler handler = new SortHandler(SortFactory.create(SortStrategy.Type.Quick));
    int[] result = handler.doSort(arr);

    System.out.println(Arrays.toString(result));
  }

  private void selectionSort(int[] arr) throws Exception {
    SortHandler handler = new SortHandler(SortFactory.create(SortStrategy.Type.Quick));
    int[] result = handler.doSort(arr);

    System.out.println(Arrays.toString(result));
  }
}
