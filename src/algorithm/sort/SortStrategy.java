package algorithm.sort;


public interface SortStrategy {
  enum Type{
    Quick,
    Bubble,
    Selection
  }

//  static List<Integer> toList(int[] arr){
//    return Arrays.stream(arr).boxed().collect(Collectors.toList());
//  }
//
//  static int[] toArray(List<Integer> list){
//    return list.stream().mapToInt(i->i).toArray();
//  }


  public int[] doSort(int[] arr);
}
