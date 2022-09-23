package algorithm.search;

import java.util.Stack;

public class DFS_Stack {
  private static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
  static boolean[] visited = new boolean[graph.length];
  static Stack<Integer> stack = new Stack<>();

  public static void main(String[] args) throws Exception {
    // 첫번째 노드 방문 처리
    stack.push(1);
    visited[1] = true;

    new DFS_Stack().search();
  }

  private void search() {
    while(!stack.isEmpty()){
      int nodeIndex = stack.pop();
      System.out.printf("현재 방문 노드 -> {%d} \n", nodeIndex);

      for(int linkedNode: graph[nodeIndex]){
        if(!visited[linkedNode]){
          stack.push(linkedNode);
          visited[linkedNode] = true;
        }
      }
    }
  }
}
